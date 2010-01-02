/*******************************************************************************
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.producer.ui.internal.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.common.l10n.EGFCommonMessages;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.preferences.IEGFModelConstants;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.MissingExtensionException;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.diagnostic.EGFValidator;
import org.eclipse.egf.model.editor.dialogs.ActivitySelectionDialog;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.manager.ActivityManagerProducer;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.egf.producer.ui.EGFProducerUIPlugin;
import org.eclipse.egf.producer.ui.internal.dialogs.ActivityValidationSelectionDialog;
import org.eclipse.egf.producer.ui.internal.ui.ProducerUIImages;
import org.eclipse.egf.producer.ui.l10n.ProducerUIMessages;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IActionDelegate2;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.progress.IProgressConstants;
import org.eclipse.ui.statushandlers.StatusManager;

public class GlobalRunActivityAction extends Action implements IWorkbenchWindowActionDelegate, IActionDelegate2 {

  /**
   * Activities to validate (if any)
   */
  private List<Activity> _validates = null;

  public GlobalRunActivityAction() {
    super();
    setText(ProducerUIMessages.GlobalRunActivityAction_label);
    setDescription(ProducerUIMessages.GlobalRunActivityAction_description);
    setToolTipText(ProducerUIMessages.GlobalRunActivityAction_tooltip);
    setImageDescriptor(ProducerUIImages.EGF_RUN_ACTIVITY);
  }

  @Override
  public void run() {
    runWithEvent(null);
  }

  @Override
  public void runWithEvent(Event event) {

    _validates = null;

    // 1 - Activity Selection
    ActivitySelectionDialog activityDialog = new ActivitySelectionDialog(EGFProducerUIPlugin.getActiveWorkbenchShell(), false);
    activityDialog.setTitle(ProducerUIMessages.GlobalRunActivityAction_dialogTitle);
    int result = activityDialog.open();
    if (result != IDialogConstants.OK_ID) {
      return;
    }
    final Object[] activities = activityDialog.getResult();
    if (activities == null || activities.length != 1) {
      return;
    }

    final Activity[] activity = new Activity[] { (Activity) activities[0] };
    final Throwable[] throwable = new Throwable[1];
    final IActivityManager[] activityManager = new IActivityManager[1];
    final int[] ticks = new int[1];

    // 2 - Locate a Manager Producer
    if (throwable[0] == null) {
      try {
        ActivityManagerProducer producer = null;
        try {
          producer = EGFProducerPlugin.getActivityManagerProducer(activity[0]);
        } catch (MissingExtensionException mee) {
          throw new InvocationException(mee);
        }
        // Create a Manager
        activityManager[0] = producer.createActivityManager(activity[0]);
        ticks[0] = activityManager[0].getSteps();
      } catch (Throwable t) {
        throwable[0] = t;
      }
    }

    // 3 - Validation
    if (throwable[0] == null) {
      try {
        IPreferenceStore store = EGFCoreUIPlugin.getDefault().getPreferenceStore();
        String validate = store.getString(IEGFModelConstants.VALIDATE_MODEL_INSTANCES_BEFORE_LAUNCH);
        int status = showValidateDialog(activityManager[0].getActivities(), validate.equals(MessageDialogWithToggle.NEVER) == false, validate.equals(MessageDialogWithToggle.PROMPT));
        if (status != IDialogConstants.OK_ID) {
          return;
        }
        if (_validates != null && _validates.size() != 0) {
          EGFValidator validator = new EGFValidator(activityManager[0].getActivities());
          Diagnostic validationDiag = validator.validate();
          if (validationDiag.getSeverity() != Diagnostic.OK) {
            return;
          }
        }
      } catch (InvocationException ie) {
        throwable[0] = ie;
      }
    }

    // 4 - canInvoke
    if (throwable[0] == null) {
      try {
        final Diagnostic preInvokeDiag = activityManager[0].canInvoke();
        if (preInvokeDiag.getSeverity() != Diagnostic.OK) {
          if (EGFProducerUIPlugin.getWorkbenchDisplay() != null) {
            EGFProducerUIPlugin.getWorkbenchDisplay().asyncExec(new Runnable() {
              public void run() {
                EGFValidator.handleDiagnostic(ProducerUIMessages._UI_CantInvokeProblems_title, ProducerUIMessages._UI_CantInvokeProblems_message, preInvokeDiag);
              }
            });
          }
          if (preInvokeDiag.getSeverity() == Diagnostic.ERROR) {
            return;
          }
        }
      } catch (InvocationException ie) {
        throwable[0] = ie;
      }
    }

    final Diagnostic[] invokeDiag = new Diagnostic[1];

    // 5 - Run activity
    if (throwable[0] == null) {

      WorkspaceJob activityJob = new WorkspaceJob(ProducerUIMessages.GlobalRunActivityAction_label) {

        @Override
        public boolean belongsTo(Object family) {
          return EGFCorePlugin.FAMILY_MANUAL_BUILD.equals(family);
        }

        @Override
        public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
          // Invoke
          SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(EGFCoreMessages.Production_Invoke, activityManager[0].getName()), (1000 * ticks[0]));
          try {
            try {
              if (EGFProducerUIPlugin.getDefault().isDebugging()) {
                EGFProducerUIPlugin.getDefault().logInfo(NLS.bind("Activity ''{0}'' will invoke ''{1}'' step(s).", EMFHelper.getText(activity), ticks)); //$NON-NLS-1$
              }
              activityManager[0].initializeContext();
              invokeDiag[0] = activityManager[0].invoke(subMonitor.newChild(1000 * ticks[0], SubMonitor.SUPPRESS_NONE));
              if (monitor.isCanceled()) {
                throw new OperationCanceledException();
              }
            } catch (InvocationException ie) {
              if (ie.getCause() != null && ie.getCause() instanceof CoreException) {
                throw (CoreException) ie.getCause();
              }
              throwable[0] = ie;
            } catch (Throwable t) {
              throw new CoreException(EGFProducerUIPlugin.getDefault().newStatus(IStatus.ERROR, EGFCommonMessages.Exception_unexpectedException, t));
            } finally {
              try {
                activityManager[0].dispose();
              } catch (InvocationException ie) {
                if (ie.getCause() != null && ie.getCause() instanceof CoreException) {
                  throw (CoreException) ie.getCause();
                }
                throwable[0] = ie;
              } catch (Throwable t) {
                throw new CoreException(EGFProducerUIPlugin.getDefault().newStatus(IStatus.ERROR, EGFCommonMessages.Exception_unexpectedException, t));
              }
            }
          } finally {
            subMonitor.done();
          }
          return Status.OK_STATUS;
        }
      };
      activityJob.setRule(ResourcesPlugin.getWorkspace().getRuleFactory().buildRule());
      activityJob.setProperty(IProgressConstants.ICON_PROPERTY, ProducerUIImages.EGF_RUN_ACTIVITY);
      activityJob.setUser(true);
      activityJob.schedule();

      try {// block
        activityJob.join();
      } catch (InterruptedException ie) {
        // Do nothing
      }

    }

    if (throwable[0] != null) {
      IStatus status = null;
      if (throwable[0] instanceof CoreException) {
        status = ((CoreException) throwable[0]).getStatus();
      } else if (throwable[0] instanceof InvocationException) {
        status = EGFProducerUIPlugin.getDefault().newStatus(IStatus.ERROR, InvocationException.class.getSimpleName(), throwable[0]);
      } else {
        status = EGFProducerUIPlugin.getDefault().newStatus(IStatus.ERROR, EGFCommonMessages.Exception_unexpectedException, throwable[0]);
      }
      StatusManager.getManager().handle(status, StatusManager.SHOW);
    } else if (invokeDiag[0] != null && invokeDiag[0].getSeverity() != Diagnostic.OK) {
      if (EGFProducerUIPlugin.getWorkbenchDisplay() != null) {
        EGFProducerUIPlugin.getWorkbenchDisplay().asyncExec(new Runnable() {
          public void run() {
            EGFValidator.handleDiagnostic(ProducerUIMessages._UI_CantInvokeProblems_title, ProducerUIMessages._UI_CantInvokeProblems_message, invokeDiag[0]);
          }
        });
      }
    }

    return;

  }

  private int showValidateDialog(List<Activity> activities, boolean validate, boolean prompt) {
    if (validate) {
      if (prompt && activities != null && activities.size() > 0) {
        ActivityValidationSelectionDialog dialog = new ActivityValidationSelectionDialog(EGFProducerUIPlugin.getActiveWorkbenchShell(), activities);
        if (dialog.open() == IDialogConstants.CANCEL_ID) {
          return IDialogConstants.CANCEL_ID;
        }
        Object[] objects = dialog.getResult();
        _validates = new ArrayList<Activity>(objects.length);
        for (int i = 0; i < objects.length; i++) {
          _validates.add((Activity) objects[i]);
        }
      } else {
        _validates = activities;
      }
    }
    return IDialogConstants.OK_ID;
  }

  // ---- IWorkbenchWindowActionDelegate
  // ------------------------------------------------

  public void run(IAction action) {
    run();
  }

  public void dispose() {
    // do nothing.
  }

  public void init(IWorkbenchWindow window) {
    // do nothing.
  }

  public void selectionChanged(IAction action, ISelection selection) {
    // do nothing. Action doesn't depend on selection.
  }

  // ---- IActionDelegate2
  // ------------------------------------------------

  public void runWithEvent(IAction action, Event event) {
    runWithEvent(event);
  }

  public void init(IAction action) {
    // do nothing.
  }

}
