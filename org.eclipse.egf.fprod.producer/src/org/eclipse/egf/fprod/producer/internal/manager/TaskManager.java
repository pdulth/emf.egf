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
package org.eclipse.egf.fprod.producer.internal.manager;

import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.fprod.producer.EGFFprodProducerPlugin;
import org.eclipse.egf.fprod.producer.context.ITaskProductionContext;
import org.eclipse.egf.fprod.producer.internal.context.FprodProducerContextFactory;
import org.eclipse.egf.fprod.producer.internal.context.TaskProductionContext;
import org.eclipse.egf.fprod.producer.manager.ITaskManager;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fprod.Task;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.context.ActivityProductionContextProducer;
import org.eclipse.egf.producer.internal.manager.ActivityManager;
import org.eclipse.egf.producer.internal.manager.InvocationManager;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.UniqueEList;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskManager extends ActivityManager implements ITaskManager {

  public TaskManager(Task task) throws InvocationException {
    super(task);
    Assert.isNotNull(task.getValue());
  }

  public TaskManager(Bundle bundle, Task task) {
    super(bundle, task);
    Assert.isNotNull(task.getValue());
  }

  public TaskManager(InvocationManager parent, Task task) throws InvocationException {
    super(parent, task);
    Assert.isNotNull(task.getValue());
  }

  @Override
  public Task getElement() {
    return (Task) super.getElement();
  }

  @Override
  public ITaskProductionContext getProductionContext() {
    return (ITaskProductionContext) super.getProductionContext();
  }

  @Override
  public TaskProductionContext getInternalProductionContext() throws InvocationException {
    if (_productionContext == null) {
      if (getParent() != null) {
        ActivityProductionContextProducer producer = null;
        try {
          producer = EGFProducerPlugin.getActivityProductionContextProducer(getParent().getProductionContext());
        } catch (Exception e) {
          throw new InvocationException(e);
        }
        _productionContext = producer.createActivityProductionContext(getParent().getProductionContext(), getElement(), getProjectBundleSession());
      } else {
        _productionContext = FprodProducerContextFactory.createContext(getElement(), getProjectBundleSession());
      }
    }
    return (TaskProductionContext) _productionContext;
  }

  @Override
  public void dispose() throws InvocationException {
    super.dispose();
  }

  @Override
  public Diagnostic canInvoke() throws InvocationException {
    BasicDiagnostic diagnostic = (BasicDiagnostic) super.canInvoke();
    return diagnostic;
  }

  @Override
  public void initializeContext() throws InvocationException {
    super.initializeContext();
  }

  public int getSteps() throws InvocationException {
    if (getElement().getValue() != null) {
      return 1;
    }
    return 0;
  }

  public List<Activity> getActivities() throws InvocationException {
    List<Activity> activities = new UniqueEList<Activity>();
    activities.add(getElement());
    return activities;
  }

  public void invoke(IProgressMonitor monitor) throws InvocationException {
    // Invoke
    TaskProductionContext taskProductionContext = getInternalProductionContext();
    EGFFprodProducerPlugin.getProductionPlanTaskInvocationFactory().createInvocation(getBundle(), taskProductionContext, getElement().getValue()).invoke(monitor);
    if (monitor.isCanceled()) {
      throw new OperationCanceledException();
    }
  }

}
