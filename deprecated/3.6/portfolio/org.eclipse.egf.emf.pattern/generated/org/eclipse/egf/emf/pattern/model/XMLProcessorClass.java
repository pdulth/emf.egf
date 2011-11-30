//Generated on Mon Nov 07 17:44:47 CET 2011 with EGF 0.6.1.qualifier
package org.eclipse.egf.emf.pattern.model;

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

public class XMLProcessorClass extends org.eclipse.egf.emf.pattern.base.GenPackageJava {
	protected static String nl;

	public static synchronized XMLProcessorClass create(String lineSeparator) {
		nl = lineSeparator;
		XMLProcessorClass result = new XMLProcessorClass();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL + "package ";
	protected final String TEXT_3 = ";" + NL;
	protected final String TEXT_4 = NL + NL + "/**" + NL + " * This class contains helper methods to serialize and deserialize XML documents" + NL + " * <!-- begin-user-doc -->" + NL + " * <!-- end-user-doc -->" + NL + " * @generated" + NL + " */" + NL + "public class ";
	protected final String TEXT_5 = " extends ";
	protected final String TEXT_6 = NL + "{";
	protected final String TEXT_7 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
	protected final String TEXT_8 = " copyright = ";
	protected final String TEXT_9 = ";";
	protected final String TEXT_10 = NL;
	protected final String TEXT_11 = NL + NL + "\t/**" + NL + "\t * Public constructor to instantiate the helper." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
	protected final String TEXT_12 = "()" + NL + "\t{";
	protected final String TEXT_13 = NL + "\t\tsuper(new ";
	protected final String TEXT_14 = "(";
	protected final String TEXT_15 = ".Registry.INSTANCE));" + NL + "\t\textendedMetaData.putPackage(null, ";
	protected final String TEXT_16 = ".eINSTANCE);";
	protected final String TEXT_17 = NL + "\t\tsuper((";
	protected final String TEXT_18 = ".Registry.INSTANCE));" + NL + "\t\t";
	protected final String TEXT_19 = ".eINSTANCE.eClass();";
	protected final String TEXT_20 = NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Register for \"*\" and \"xml\" file extensions the ";
	protected final String TEXT_21 = " factory." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_22 = NL + "\t@Override";
	protected final String TEXT_23 = NL + "\tprotected Map";
	protected final String TEXT_24 = "<";
	protected final String TEXT_25 = ", ";
	protected final String TEXT_26 = ".Factory>";
	protected final String TEXT_27 = " getRegistrations()" + NL + "\t{" + NL + "\t\tif (registrations == null)" + NL + "\t\t{" + NL + "\t\t\tsuper.getRegistrations();" + NL + "\t\t\tregistrations.put(XML_EXTENSION, new ";
	protected final String TEXT_28 = "());" + NL + "\t\t\tregistrations.put(STAR_EXTENSION, new ";
	protected final String TEXT_29 = "());" + NL + "\t\t}" + NL + "\t\treturn registrations;" + NL + "\t}" + NL + "" + NL + "} //";
	protected final String TEXT_30 = NL;
	protected final String TEXT_31 = NL;
	protected final String TEXT_32 = NL;

	public XMLProcessorClass() {
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

			this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.getOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_31);
		stringBuffer.append(TEXT_32);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		method_preGenerate(new StringBuffer(), ictx);

		method_doGenerate(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = getParameters();
			CallbackContext ctx_callback = new CallbackContext(ictx);
			CallHelper.callBack(ctx_callback, parameters);
		}

		method_postGenerate(new StringBuffer(), ictx);

		String loop = OutputManager.getOutputWithoutCallback(ictx);
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.getOutput(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			;
		}
		return loop;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_setReporterVariables(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		GenPackage genPackage = parameter;
		targetPath = genPackage.getGenModel().getModelDirectory();
		packageName = genPackage.getUtilitiesPackageName();
		className = genPackage.getXMLProcessorClassName();

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setReporterVariables", stringBuffer.toString());
	}

	protected void method_setArgument(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		GenPackage genPackage = parameter;
		argument = parameter;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setArgument", stringBuffer.toString());
	}

	protected void method_ensureProjectExists(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getModelDirectory(), genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "ensureProjectExists", stringBuffer.toString());
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		/**
		 * <copyright>
		 *
		 * Copyright (c) 2005-2006 IBM Corporation and others. 
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

		GenPackage genPackage = (GenPackage) argument;
		GenModel genModel = genPackage.getGenModel();
		stringBuffer.append(TEXT_1);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#LogicalName=org.eclipse.egf.emf.pattern.base.HeaderJava" args="parameter:argument"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("argument", parameter);
			CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#_XHLrsCwtEd-jc5T-XaRJlg", new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		stringBuffer.append(TEXT_2);
		stringBuffer.append(genPackage.getUtilitiesPackageName());
		stringBuffer.append(TEXT_3);
		genModel.getImportedName("java.util.Map");
		genModel.markImportLocation(stringBuffer);
		stringBuffer.append(TEXT_4);
		stringBuffer.append(genPackage.getXMLProcessorClassName());
		stringBuffer.append(TEXT_5);
		stringBuffer.append(genPackage.getImportedXMLProcessorBaseClassName());
		stringBuffer.append(TEXT_6);
		if (genModel.hasCopyrightField()) {
			stringBuffer.append(TEXT_7);
			stringBuffer.append(genModel.getImportedName("java.lang.String"));
			stringBuffer.append(TEXT_8);
			stringBuffer.append(genModel.getCopyrightFieldLiteral());
			stringBuffer.append(TEXT_9);
			stringBuffer.append(genModel.getNonNLS());
			stringBuffer.append(TEXT_10);
		}
		stringBuffer.append(TEXT_11);
		stringBuffer.append(genPackage.getXMLProcessorClassName());
		stringBuffer.append(TEXT_12);
		if (genPackage.hasExtendedMetaData() && !genPackage.hasTargetNamespace()) {
			stringBuffer.append(TEXT_13);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.EPackageRegistryImpl"));
			stringBuffer.append(TEXT_14);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EPackage"));
			stringBuffer.append(TEXT_15);
			stringBuffer.append(genPackage.getImportedPackageInterfaceName());
			stringBuffer.append(TEXT_16);
		} else {
			stringBuffer.append(TEXT_17);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EPackage"));
			stringBuffer.append(TEXT_18);
			stringBuffer.append(genPackage.getImportedPackageInterfaceName());
			stringBuffer.append(TEXT_19);
		}
		stringBuffer.append(TEXT_20);
		stringBuffer.append(genPackage.getResourceFactoryClassName());
		stringBuffer.append(TEXT_21);
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_22);
		}
		stringBuffer.append(TEXT_23);
		if (genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50) {
			stringBuffer.append(TEXT_24);
			stringBuffer.append(genModel.getImportedName("java.lang.String"));
			stringBuffer.append(TEXT_25);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
			stringBuffer.append(TEXT_26);
		}
		stringBuffer.append(TEXT_27);
		stringBuffer.append(genPackage.getResourceFactoryClassName());
		stringBuffer.append(TEXT_28);
		stringBuffer.append(genPackage.getResourceFactoryClassName());
		stringBuffer.append(TEXT_29);
		stringBuffer.append(genPackage.getXMLProcessorClassName());
		genModel.emitSortedImports();
		stringBuffer.append(TEXT_30);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		GenPackage genPackage = parameter;
		genModel = parameter.getGenModel();
		boolean canGenerate = new CodegenGeneratorAdapter(parameter).canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.ModelProject");
		canGenerate = canGenerate && (genPackage.hasClassifiers() && genPackage.getResource().getValue() == GenResourceKind.XML);
		return canGenerate;
	}

	public boolean preCondition() {
		return true;
	}
}