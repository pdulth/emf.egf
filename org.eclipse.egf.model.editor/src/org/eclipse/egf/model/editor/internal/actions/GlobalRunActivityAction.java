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
package org.eclipse.egf.model.editor.internal.actions;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.helper.ResourceHelper;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.model.EGFModelsPlugin;
import org.eclipse.egf.model.InvocationException;
import org.eclipse.egf.model.editor.EGFModelsEditorPlugin;
import org.eclipse.egf.model.editor.internal.dialogs.FcoreSelectionDialog;
import org.eclipse.egf.model.editor.internal.ui.EGFModelsEditorImages;
import org.eclipse.egf.model.editor.l10n.EGFModelsEditorMessages;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IActionDelegate2;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

public class GlobalRunActivityAction extends Action implements IWorkbenchWindowActionDelegate, IActionDelegate2 {

  public GlobalRunActivityAction() {
    super();
    setText(EGFModelsEditorMessages.GlobalRunActivityAction_label);
    setDescription(EGFModelsEditorMessages.GlobalRunActivityAction_description);
    setToolTipText(EGFModelsEditorMessages.GlobalRunActivityAction_tooltip);
    setImageDescriptor(EGFModelsEditorImages.EGF_RUN_ACTIVITY);
  }

  @Override
  public void run() {
    runWithEvent(null);
  }

  @Override
  public void runWithEvent(Event e) {

    FcoreSelectionDialog dialog = new FcoreSelectionDialog(EGFModelsEditorPlugin.getActiveWorkbenchShell(), false);
    dialog.setTitle(EGFModelsEditorMessages.GlobalRunActivityAction_dialogTitle);
    dialog.setMessage(EGFModelsEditorMessages.GlobalRunActivityAction_dialogMessage);

    int result = dialog.open();
    if (result != IDialogConstants.OK_ID) {
      return;
    }

    final Object[] fcores = dialog.getResult();
    if (fcores == null || fcores.length != 1) {
      return;
    }

    // batching changes
    WorkspaceJob activityJob = new WorkspaceJob(EGFModelsEditorMessages.GlobalRunActivityAction_label) {

      @Override
      public boolean belongsTo(Object family) {
        return EGFCorePlugin.FAMILY_MANUAL_BUILD.equals(family);
      }

      @Override
      public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
        Activity activity = null;
        // Load Resource
        try {
          Resource resource = ResourceHelper.loadResource(new ResourceSetImpl(), ((IPlatformFcore) fcores[0]).getURI());
          EObject eObject = resource.getContents().get(0);
          if (eObject instanceof Activity == false) {
            return Status.OK_STATUS;
          }
          activity = (Activity) eObject;
        } catch (Throwable t) {
          throw new CoreException(EGFModelsEditorPlugin.getPlugin().newStatus(IStatus.ERROR, "GlobalRunActivityAction.runWithEvent(..) _", t)); //$NON-NLS-1$
        }
        IProductionContext rootContext = EGFModelsPlugin.getModelProductionContextFactory().createModelProductionContext(activity);
        int steps = activity.getSteps();
        SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(EGFCoreMessages.Production_Invoke, rootContext.getName()), (900 * steps) + 100);
        try {
          try {
            if (EGFModelsEditorPlugin.getPlugin().isDebugging()) {
              EGFModelsEditorPlugin.getPlugin().logInfo(NLS.bind("Activity ''{0}'' will invoke ''{1}'' step(s).", EcoreUtil.getURI(activity).toString(), activity.getSteps())); //$NON-NLS-1$
            }
            activity.invoke(rootContext, subMonitor.newChild(900 * steps, SubMonitor.SUPPRESS_NONE));
            if (monitor.isCanceled()) {
              throw new OperationCanceledException();
            }
          } catch (InvocationException ie) {
            if (ie.getCause() instanceof CoreException) {
              throw (CoreException) ie.getCause();
            }
            throw new CoreException(EGFModelsEditorPlugin.getPlugin().newStatus(IStatus.ERROR, "RunActivityAction.run(..) _", ie.getCause())); //$NON-NLS-1$
          }
        } finally {
          rootContext.dispose();
          subMonitor.done();
        }
        return Status.OK_STATUS;
      }
    };
    activityJob.setRule(ResourcesPlugin.getWorkspace().getRuleFactory().buildRule());
    activityJob.setUser(true);
    activityJob.schedule();

    return;

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
