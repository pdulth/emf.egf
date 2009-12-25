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
package org.eclipse.egf.fprod.producer.internal.task;

import org.eclipse.egf.core.producer.context.IProductionContext;
import org.eclipse.egf.fprod.producer.internal.invocation.ProductionTaskInvocation;
import org.eclipse.egf.fprod.producer.invocation.IProductionTaskInvocation;
import org.eclipse.egf.fprod.producer.task.IProductionPlanTaskInvocationFactory;
import org.eclipse.egf.model.fprod.Task;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProductionPlanTaskInvocationFactory implements IProductionPlanTaskInvocationFactory {

  public IProductionTaskInvocation createInvocation(Bundle bundle, IProductionContext<Task> context, String value) {
    return new ProductionTaskInvocation(bundle, context, value);
  }

}
