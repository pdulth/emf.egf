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

package org.eclipse.egf.pattern.java;

import org.eclipse.core.resources.IProject;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.extension.PatternInitializer;

/**
 * @author Guiu
 * 
 */
public class JavaPatternInitializer extends PatternInitializer {

    public static final String classname = "class";
    public static final String packagename = "package";
    public static final String imports = "imports";

    public JavaPatternInitializer(IProject project, Pattern pattern) {
        super(project, pattern);

    }

    @Override
    protected String getDefaultContent(PatternMethod method) {

        return null;
    }

    @Override
    protected String getFooterContent(PatternMethod method) {

        return null;
    }

    @Override
    protected String getHeaderContent(PatternMethod method) {

        return null;
    }

}
