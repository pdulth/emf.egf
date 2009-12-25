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
package org.eclipse.egf.core.test.model;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.egf.core.model.fcore.FcoreContractValidation;
import org.eclipse.egf.core.model.productionplan.ProductionPlanContextValidation;

public class ModelValidation extends TestCase {

  public static Test suite() {
    TestSuite suite = new TestSuite("EGF Model Test Suite"); //$NON-NLS-1$
    suite.addTest(FcoreContractValidation.suite());
    suite.addTest(ProductionPlanContextValidation.suite());
    return suite;
  }

}
