/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.internal.task;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.core.context.IProductionContext;
import org.eclipse.egf.core.l10n.CoreMessages;
import org.eclipse.egf.core.task.IPlatformTask;
import org.eclipse.egf.core.task.IProductionTask;
import org.eclipse.osgi.util.NLS;

/**
 * This class is responsible to process user defined
 * {@link org.eclipse.egf.core.task.IProductionTask}.
 * 
 * @author Xavier Maysonnave
 */
public class TaskRunner {

  /**
   * IProductionContext
   */
  private IProductionContext _productionContext;

  /**
   * IPlatformTask
   */
  private IPlatformTask _platformTask;

  public TaskRunner(IProductionContext productionContext, IPlatformTask platformTask) {
    Assert.isNotNull(productionContext);
    Assert.isNotNull(platformTask);
    _productionContext = productionContext;
    _platformTask = platformTask;
  }

  /**
   * instantiate a Task
   * 
   * @param monitor_p
   * @return the instantiated object or null
   */
  protected IProductionTask createTaskInstance() {
    if (_platformTask.getPlatformBundle().isTarget() == false) {
      return null;
    }
    return null;
  }

  /**
   * Execute this task.
   * 
   * @param monitor
   * @return true if the execution was successful, false otherwise.
   */
  protected boolean execute(final IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
    SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(CoreMessages.AbstractTask_Execute, getPlatformTask().getId()), 40);
    try {
      // Instantiate an ITask object
      IProductionTask task = createTaskInstance();
      subMonitor.worked(10);
      if (subMonitor.isCanceled()) {
        throw new InterruptedException();
      }
      // PreExecute
      if (preExecute(task, subMonitor.newChild(10)) == false) {
        return false;
      }
      subMonitor.worked(10);
      if (subMonitor.isCanceled()) {
        throw new InterruptedException();
      }
      // DoExecute
      if (doExecute(task, subMonitor.newChild(10)) == false) {
        return false;
      }
      subMonitor.worked(10);
      if (subMonitor.isCanceled()) {
        throw new InterruptedException();
      }
      // PostExecute
      if (postExecute(task, subMonitor.newChild(10)) == false) {
        return false;
      }
      subMonitor.worked(10);
      if (subMonitor.isCanceled()) {
        throw new InterruptedException();
      }
    } finally {
      subMonitor.setWorkRemaining(0);
    }
    return true;
  }

  /**
   * Pre execute this task.
   * 
   * @param monitor
   * @return true if the execution was successful, false otherwise.
   */
  public boolean preExecute(final IProductionTask task, final IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
    SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(CoreMessages.AbstractTask_preExecute, getPlatformTask().getId()), 10);
    try {
      if (task != null && task.preExecute(_productionContext, subMonitor.newChild(10)) == false) {
        return false;
      }
      subMonitor.worked(10);
      if (subMonitor.isCanceled()) {
        throw new InterruptedException();
      }
    } finally {
      subMonitor.setWorkRemaining(0);
    }
    return true;
  }

  /**
   * Do execute this task.
   * 
   * @param monitor
   * @return true if the execution was successful, false otherwise.
   */
  public boolean doExecute(final IProductionTask task_p, final IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
    SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(CoreMessages.AbstractTask_doExecute, getPlatformTask().getId()), 10);
    try {
      if (task_p != null && task_p.doExecute(_productionContext, subMonitor.newChild(10)) == false) {
        return false;
      }
      subMonitor.worked(10);
      if (subMonitor.isCanceled()) {
        throw new InterruptedException();
      }
    } finally {
      subMonitor.setWorkRemaining(0);
    }
    return true;
  }

  /**
   * Post execute this task.
   * 
   * @param monitor
   * @return true if the execution was successful, false otherwise.
   */
  public boolean postExecute(final IProductionTask task_p, final IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
    SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(CoreMessages.AbstractTask_postExecute, getPlatformTask().getId()), 10);
    try {
      if (task_p != null && task_p.postExecute(_productionContext, subMonitor.newChild(10)) == false) {
        return false;
      }
      subMonitor.worked(10);
      if (subMonitor.isCanceled()) {
        throw new InterruptedException();
      }
    } finally {
      subMonitor.setWorkRemaining(0);
    }
    return true;
  }

  /**
   * @return the task
   */
  public IPlatformTask getPlatformTask() {
    return _platformTask;
  }

}
