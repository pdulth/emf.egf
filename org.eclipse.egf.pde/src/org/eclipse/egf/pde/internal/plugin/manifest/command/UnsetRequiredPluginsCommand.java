/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.pde.internal.plugin.manifest.command;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.console.EGFConsolePlugin;
import org.eclipse.egf.pde.EGFPDEPlugin;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginImport;
import org.eclipse.pde.internal.core.ibundle.IBundlePluginModel;

/**
 * Implement a command that removes required plug-ins from the <code>Require-Bundle</code> property of the manifest file.
 * @author Guillaume Brocard
 */
public class UnsetRequiredPluginsCommand extends AbstractRequiredPluginsCommand {

  /**
   * Constructor.
   * @param requiredPlugins_p
   */
  public UnsetRequiredPluginsCommand(String[] requiredPlugins_p) {
    super(requiredPlugins_p);
  }

  /**
   * @see org.eclipse.egf.pde.internal.plugin.manifest.command.AbstractRequiredPluginsCommand#handleRequiredPlugin(java.lang.String,
   *      org.eclipse.pde.internal.core.ibundle.IBundlePluginModel, java.util.List)
   */
  @Override
  protected void handleRequiredPlugin(String requiredPlugin_p, IBundlePluginModel bundlePluginModel_p, List<IPluginImport> existingPluginImports_p) {
    // Get the plug-in base.
    IPluginBase pluginBase = bundlePluginModel_p.getPluginBase();
    // Get the required plug-in in existing ones.
    IPluginImport removedPluginImport = pluginImportExists(requiredPlugin_p, existingPluginImports_p);
    // If found, remove it from the plug-in base.
    if (removedPluginImport != null) {
      try {
        // Remove the import in the manifest.
        pluginBase.remove(removedPluginImport);
      } catch (CoreException ce) {
        StringBuilder msg = new StringBuilder("UnsetRequiredPluginsCommand.execute(..) _ "); //$NON-NLS-1$
        EGFPDEPlugin.getDefault().log(msg.toString(), ce);
        if (EGFPDEPlugin.getDefault().isDebugging()) {
          EGFConsolePlugin.getConsole().logThrowable(msg.toString(), ce);
        }
      }
    }
  }
  
}