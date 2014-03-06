/**
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.pattern;

import java.util.List;

/**
 * @author Thomas Guiu
 * 
 */
public interface DomainVisitor {

    Object[] getChildren(Object model);

    void setPatterns(List<Pattern> patterns) throws PatternException;

    void visit(PatternContext context, Object model) throws PatternException;

    void dispose();

}
