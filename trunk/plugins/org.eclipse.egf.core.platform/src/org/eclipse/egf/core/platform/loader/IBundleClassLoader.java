/**
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.platform.loader;

import org.eclipse.core.resources.IProject;
import org.eclipse.egf.common.loader.IClassLoader;
import org.eclipse.pde.core.plugin.IPluginModelBase;

/**
 * @author Xavier Maysonnave
 *
 */
public interface IBundleClassLoader extends IClassLoader {

    public static String DEFAULT_BUNDLE_CLASS_LOADER = "org.eclipse.egf.core.platform.default.bundle.class.loader.session"; //$NON-NLS-1$    

    public static String BUNDLE_CLASS_LOADER_MAP = "org.eclipse.egf.core.platform.bundle.class.loader.map"; //$NON-NLS-1$

    public IPluginModelBase getPluginModelBase();

    public IProject[] getWorkspaceDependencies();

}
