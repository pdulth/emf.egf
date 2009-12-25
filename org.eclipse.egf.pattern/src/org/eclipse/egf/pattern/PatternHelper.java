/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.egf.common.constant.CharacterConstants;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.helper.ResourceHelper;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternElement;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternViewpoint;
import org.eclipse.egf.model.pattern.util.PatternSwitch;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * @author Thomas Guiu
 * 
 */
public class PatternHelper {

    /**
     * This method returns a string from the libraries who contain the pattern.
     * For example: myLib.mySubLib
     */
    public static String getFullLibraryName(Pattern pattern) {
        List<PatternLibrary> libs = new ArrayList<PatternLibrary>();
        PatternLibrary lib = pattern.getContainer();
        while (lib != null) {
            libs.add(lib);
            lib = lib.getContainer();
        }
        if (libs.isEmpty())
            return CharacterConstants.EMPTY_STRING;
        if (libs.size() == 1)
            return libs.get(0).getName();
        StringBuffer buf = new StringBuffer();
        for (PatternLibrary mylib : libs) {
            buf.append(mylib.getName()).append('.');
        }
        return buf.deleteCharAt(buf.length() - 1).toString();
    }

    public static IPlatformFcore getPlatformFcore(Pattern pattern) {
        return EGFCorePlugin.getPlatformFcore(pattern.eResource());
    }

    /**
     * Return the IProject object who contains the pattern.
     * 
     * @return null if the FC is deployed in the runtime environment.
     */
    public static IProject getProject(Pattern pattern) {
        IPlatformFcore fcore = getPlatformFcore(pattern);
        return fcore.getPlatformBundle().getProject();
    }

    /**
     * Reads FC models from the given project and return the pattern with the
     * given id if any. <br/>
     * TODO à supprimer car inutilisé
     */
    public static Set<Pattern> getPatterns(IProject project, String id) {
        if (id == null)
            throw new IllegalArgumentException();
        HashSet<String> ids = new HashSet<String>();
        ids.add(id);
        return getPatterns(project, ids);
    }

    /**
     * Reads FC models from the given project and return the patterns with the
     * given ids if any. If the ids set is null all patterns are returned.
     */
    public static Set<Pattern> getPatterns(URI uri) {
        Set<Pattern> result = new HashSet<Pattern>();
        collectPatterns(new ResourceSetImpl(), uri, null, result);
        return result;
    }

    /**
     * Reads FC models from the given project and return the patterns with the
     * given ids if any. If the ids set is null all patterns are returned.
     */
    public static Set<Pattern> getPatterns(IProject project, Set<String> ids) {
        ResourceSet set = new ResourceSetImpl();
        Set<Pattern> result = new HashSet<Pattern>();
        IPlatformFcore[] platformFcores = EGFCorePlugin.getPlatformFcores(project);
        for (IPlatformFcore platformFcore : platformFcores) {
            collectPatterns(set, platformFcore.getURI(), ids, result);
        }
        return result;
    }

    private static void collectPatterns(ResourceSet set, URI uri, Set<String> ids, Set<Pattern> collector) {
        Resource res = ResourceHelper.loadResource(set, uri);
        FCVisitor fcVisitor = new FCVisitor();
        for (EObject obj : res.getContents())
            fcVisitor.collect((FactoryComponent) obj, ids, collector);
    }

    public static String dropNonWordCharacter(String value) {
        return value.replaceAll("\\W", "");
    }

    public static String uniqueName(ModelElement parameter) {
        return parameter.getName().replaceAll("\\W", "") + "_" + parameter.getID().replaceAll("\\W", "");
    }

    public static String localizeName(org.eclipse.egf.model.pattern.PatternParameter parameter) {
        return parameter.getName() + "Parameter";
    }

    private PatternHelper() {
    }

    /**
     * TODO ça serait bien d'avoir une switch unifié sur tous les modèles de
     * base...
     * 
     * @author Thomas Guiu
     * 
     */
    private static class FCVisitor {
        public void collect(FactoryComponent fc, final Set<String> ids, final Set<Pattern> collector) {
            PatternViewpoint pvp = (PatternViewpoint) fc.getViewpointContainer().getViewpoints().get(0);
            new PatternSwitch<String>() {

                @Override
                public String casePattern(Pattern object) {
                    if (ids == null || ids.contains(object.getID()))
                        collector.add(object);
                    return null;
                }

                @Override
                public String casePatternLibrary(PatternLibrary object) {
                    for (PatternElement elemn : object.getElements())
                        doSwitch(elemn);
                    return null;
                }

                @Override
                public String casePatternViewpoint(PatternViewpoint object) {
                    for (PatternLibrary lib : object.getLibraries())
                        casePatternLibrary(lib);
                    return CharacterConstants.EMPTY_STRING;
                }
            }.doSwitch(pvp);

        }
    }

    public static class FilenameFormatException extends Exception {

        private static final long serialVersionUID = 1L;

        private FilenameFormatException(String message) {
            super(message);

        }

    }

    /**
     * This class manage the relationship between pt file paths and patterns.
     * 
     * @author Thomas Guiu
     * 
     */

    public static class Filename {
        private static final String PATTERN_TOKEN = "pattern.";
        private static final String METHOD_TOKEN = "method.";

        public static URI computeFileURI(PatternMethod method) {
            return URI.createFileURI(PatternPreferences.getTemplatesFolderName() + CharacterConstants.SLASH_CHARACTER + PATTERN_TOKEN + method.getPattern().getID() + CharacterConstants.SLASH_CHARACTER + METHOD_TOKEN + method.getID() + CharacterConstants.DOT_CHARACTER + PatternConstants.PATTERN_UNIT_FILE_EXTENSION);
        }

        public static String extractPatternId(IPath patternMethodPath) throws FilenameFormatException {
            if (patternMethodPath == null)
                throw new FilenameFormatException(Messages.PatternFilename_error1);

            int segmentCount = patternMethodPath.segmentCount();
            if (segmentCount < 3)
                throw new FilenameFormatException(Messages.bind(Messages.PatternFilename_error2, patternMethodPath));
            String segment = patternMethodPath.segment(segmentCount - 2);
            if (segment == null || "".equals(segment) || !segment.startsWith(PATTERN_TOKEN) || PATTERN_TOKEN.length() == segment.length())
                throw new FilenameFormatException(Messages.bind(Messages.PatternFilename_error3, segment, PATTERN_TOKEN));
            return segment.substring(PATTERN_TOKEN.length());
        }

        private Filename() {
        }
    }
}
