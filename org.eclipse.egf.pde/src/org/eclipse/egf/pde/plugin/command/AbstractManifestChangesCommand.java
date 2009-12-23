/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.pde.plugin.command;

import org.eclipse.egf.console.EGFConsolePlugin;
import org.eclipse.egf.pde.EGFPDEPlugin;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.internal.core.ibundle.IBundlePluginModel;

/**
 * Base class to implement a command that performs plug-in changes in the manifest file.
 * @author Guillaume Brocard
 */
public class AbstractManifestChangesCommand extends AbstractChangesCommand {
  
  /**
   * Get the bundle plugin model that this command is performed against.
   * @return <code>null</code> if the underlying {@link IPluginModelBase} instance is not an {@link IBundlePluginModel}.
   */
  protected IBundlePluginModel getBundlePluginModel() {
    IBundlePluginModel result = null;
    // Get the plugin model base.
    IPluginModelBase pluginModelBase = getPluginModelBase();
    // Is the plugin model base an IBundlePluginModel ?
    if (pluginModelBase instanceof IBundlePluginModel) {
      result = (IBundlePluginModel) pluginModelBase;
    }
    return result;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    if (getBundlePluginModel() == null) {
      StringBuilder msg = new StringBuilder("AbstractManifestChangesCommand.execute(..) _ "); //$NON-NLS-1$
      msg.append("BundlePluginModel object must not be null"); //$NON-NLS-1$
      EGFPDEPlugin.getDefault().log(msg.toString());
      if (EGFPDEPlugin.getDefault().isDebugging()) {
        EGFConsolePlugin.getConsole().logError(msg.toString());
      }
    }
  }
  
}
