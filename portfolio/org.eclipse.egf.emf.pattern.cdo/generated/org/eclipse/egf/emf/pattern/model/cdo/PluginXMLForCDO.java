//Generated on Wed Aug 08 16:44:34 CEST 2012 with EGF 1.0.0.qualifier
package org.eclipse.egf.emf.pattern.model.cdo;

import org.eclipse.egf.emf.pattern.base.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.emf.codegen.ecore.genmodel.impl.*;
import org.eclipse.emf.codegen.ecore.genmodel.generator.*;
import org.eclipse.emf.codegen.util.*;
import org.eclipse.emf.ecore.util.*;
import org.eclipse.emf.common.util.*;
import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class PluginXMLForCDO extends org.eclipse.egf.emf.pattern.model.PluginXML {
    protected static String nl;

    public static synchronized PluginXMLForCDO create(String lineSeparator) {
        nl = lineSeparator;
        PluginXMLForCDO result = new PluginXMLForCDO();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<?eclipse version=\"3.0\"?>" + NL;
    protected final String TEXT_2 = NL;
    protected final String TEXT_3 = NL;
    protected final String TEXT_4 = NL + "<plugin>";
    protected final String TEXT_5 = NL + "<plugin" + NL + "      name=\"%pluginName\"" + NL + "      id=\"";
    protected final String TEXT_6 = "\"" + NL + "      version=\"1.0.0\"";
    protected final String TEXT_7 = NL + "      provider-name=\"%providerName\"" + NL + "      class=\"";
    protected final String TEXT_8 = "$Implementation\">";
    protected final String TEXT_9 = NL + "      provider-name=\"%providerName\">";
    protected final String TEXT_10 = NL + NL + "   <requires>";
    protected final String TEXT_11 = NL + "      <import plugin=\"";
    protected final String TEXT_12 = "\"";
    protected final String TEXT_13 = " export=\"true\"";
    protected final String TEXT_14 = "/>";
    protected final String TEXT_15 = NL + "   </requires>" + NL + "" + NL + "   <runtime>";
    protected final String TEXT_16 = NL + "      <library name=\"";
    protected final String TEXT_17 = ".jar\">";
    protected final String TEXT_18 = NL + "      <library name=\".\">";
    protected final String TEXT_19 = NL + "         <export name=\"*\"/>" + NL + "      </library>" + NL + "   </runtime>";
    protected final String TEXT_20 = NL + NL + "   <extension point=\"org.eclipse.emf.ecore.factory_override\">" + NL + "      <factory" + NL + "            uri=\"";
    protected final String TEXT_21 = "\"" + NL + "            class=\"";
    protected final String TEXT_22 = "\"" + NL + "      />" + NL + "   </extension>";
    protected final String TEXT_23 = NL + NL + "</plugin>" + NL;
    protected final String TEXT_24 = NL;
    protected final String TEXT_25 = NL;

    public PluginXMLForCDO() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;
        Node.Container currentNode = ctx.getNode();

        List<Object> parameterList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object parameterParameter : parameterList) {

            this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) parameterParameter;

            if (preCondition(ctx)) {
                ctx.setNode(new Node.Container(currentNode, getClass()));
                orchestration(ctx);
            }

        }
        ctx.setNode(currentNode);
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
        }

        stringBuffer.append(TEXT_24);
        stringBuffer.append(TEXT_25);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;

        super.orchestration(new SuperOrchestrationContext(ictx));

        if (ictx.useReporter()) {
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("parameter", this.parameter);
            String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
            String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
        }
        return null;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("parameter", this.parameter);
        return parameters;
    }

    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        /**
         * <copyright>
         *
         * Copyright (c) 2002-2005 IBM Corporation and others.
         * All rights reserved.   This program and the accompanying materials
         * are made available under the terms of the Eclipse Public License v1.0
         * which accompanies this distribution, and is available at
         * http://www.eclipse.org/legal/epl-v10.html
         * 
         * Contributors: 
         *   IBM - Initial API and implementation
         *
         * </copyright>
         */

        GenModel genModel = (GenModel) argument; /* Trick to import java.util.* without warnings */
        Iterator.class.getName();
        stringBuffer.append(TEXT_1);
        stringBuffer.append(TEXT_2);
        {
            //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#LogicalName=org.eclipse.egf.emf.pattern.base.HeaderXml" args="parameter:argument"%>

            InternalPatternContext ictx = (InternalPatternContext) ctx;
            new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
            stringBuffer.setLength(0);

            final Map<String, Object> callParameters = new HashMap<String, Object>();
            callParameters.put("argument", parameter);
            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#__h1VkCwtEd-jc5T-XaRJlg", new ExecutionContext((InternalPatternContext) ctx), callParameters);
            stringBuffer.setLength(0);
        }

        stringBuffer.append(TEXT_3);
        if (genModel.isBundleManifest()) {
            stringBuffer.append(TEXT_4);
        } else {
            stringBuffer.append(TEXT_5);
            stringBuffer.append(genModel.getModelPluginID());
            stringBuffer.append(TEXT_6);
            if (genModel.hasModelPluginClass()) {
                stringBuffer.append(TEXT_7);
                stringBuffer.append(genModel.getQualifiedModelPluginClassName());
                stringBuffer.append(TEXT_8);
            } else {
                stringBuffer.append(TEXT_9);
            }
            stringBuffer.append(TEXT_10);
            for (String pluginID : genModel.getModelRequiredPlugins()) {
                stringBuffer.append(TEXT_11);
                stringBuffer.append(pluginID);
                stringBuffer.append(TEXT_12);
                if (!pluginID.startsWith("org.eclipse.core.runtime")) {
                    stringBuffer.append(TEXT_13);
                }
                stringBuffer.append(TEXT_14);
            }
            stringBuffer.append(TEXT_15);
            if (genModel.isRuntimeJar()) {
                stringBuffer.append(TEXT_16);
                stringBuffer.append(genModel.getModelPluginID());
                stringBuffer.append(TEXT_17);
            } else {
                stringBuffer.append(TEXT_18);
            }
            stringBuffer.append(TEXT_19);
        }
        for (GenPackage genPackage : genModel.getAllGenPackagesWithClassifiers()) {
            stringBuffer.append(TEXT_20);
            stringBuffer.append(genPackage.getNSURI());
            stringBuffer.append(TEXT_21);
            stringBuffer.append(genPackage.getQualifiedFactoryClassName());
            stringBuffer.append(TEXT_22);
        }
        stringBuffer.append(TEXT_23);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
    }

    public boolean preCondition(PatternContext ctx) throws Exception {
        GenModel genModel = parameter;
        genModel = parameter.getGenModel();
        boolean canGenerate = new CodegenGeneratorAdapter(parameter).canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.ModelProject");
        canGenerate = canGenerate && (genModel.getRuntimePlatform() != GenRuntimePlatform.GWT) && (genModel.hasPluginSupport() && !genModel.sameModelEditProject() && !genModel.sameModelEditorProject());
        return canGenerate;
    }
}