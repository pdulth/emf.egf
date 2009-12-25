/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.query;

import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointFactory;
import org.eclipse.egf.core.platform.pde.PlatformExtensionPointURI;
import org.eclipse.pde.core.plugin.IPluginAttribute;
import org.eclipse.pde.core.plugin.IPluginElement;

/**
 * @author Thomas Guiu
 * 
 */
public class QueryFactory implements IPlatformExtensionPointFactory<QueryKind> {

    private static final String ID_ATTR = "id";
    private static final String CLASS_ATTR = "class";

    public QueryKind createExtensionPoint(IPlatformBundle platformBundle, IPluginElement pluginElement) {

        IPluginAttribute idAttr = pluginElement.getAttribute(ID_ATTR);
        IPluginAttribute classAttr = pluginElement.getAttribute(CLASS_ATTR);
        return new QueryKindImpl(platformBundle, pluginElement, idAttr.getValue(), classAttr.getValue());
    }

    private static class QueryKindImpl extends PlatformExtensionPointURI implements QueryKind {

        private final String className;

        public QueryKindImpl(IPlatformBundle bundle, IPluginElement element, String id, String className) {
            super(bundle, element, id);
            this.className = className;
        }

        public String getClassName() {

            return className;
        }

    }
}
