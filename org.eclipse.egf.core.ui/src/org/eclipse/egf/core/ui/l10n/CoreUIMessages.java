/**
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 * Thales Corporate Services S.A.S
 */

package org.eclipse.egf.core.ui.l10n;

import org.eclipse.osgi.util.NLS;

public class CoreUIMessages {

  private static final String BUNDLE_NAME = "org.eclipse.egf.core.ui.l10n.messages"; //$NON-NLS-1$

  private CoreUIMessages() {
    // Do not instantiate
  }

  static {
    // load message values from bundle file
    NLS.initializeMessages(BUNDLE_NAME, CoreUIMessages.class);
  }

  public static String ExceptionDialog_seeErrorLogMessage;

}
