package org.eclipse.egf.emf.pattern.edit.call.ItemProvider;

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

public class ItemProvidernewChildDescriptorsCrossPackageFeatureinsert {
	protected static String nl;

	public static synchronized ItemProvidernewChildDescriptorsCrossPackageFeatureinsert create(String lineSeparator) {
		nl = lineSeparator;
		ItemProvidernewChildDescriptorsCrossPackageFeatureinsert result = new ItemProvidernewChildDescriptorsCrossPackageFeatureinsert();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL;

	public ItemProvidernewChildDescriptorsCrossPackageFeatureinsert() {
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

		List<Object> createClassList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> createFeatureList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> genClassList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> genPackageList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> genModelList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> _ListList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object createClassParameter : createClassList) {
			for (Object createFeatureParameter : createFeatureList) {
				for (Object genClassParameter : genClassList) {
					for (Object genPackageParameter : genPackageList) {
						for (Object genModelParameter : genModelList) {
							for (Object _ListParameter : _ListList) {

								this.createClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) createClassParameter;
								this.createFeature = (org.eclipse.emf.codegen.ecore.genmodel.GenFeature) createFeatureParameter;
								this.genClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) genClassParameter;
								this.genPackage = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) genPackageParameter;
								this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) genModelParameter;
								this._List = (java.lang.String) _ListParameter;

								if (preCondition()) {
									ctx.setNode(new Node.Container(currentNode, getClass()));
									orchestration(ctx);
								}

							}
						}
					}
				}
			}
		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
		}

		stringBuffer.append(TEXT_1);
		stringBuffer.append(TEXT_2);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_doGenerate(new StringBuffer(), ictx);

		String loop = Node.flattenWithoutCallback(ictx.getNode());
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("createClass", this.createClass);
			parameterValues.put("createFeature", this.createFeature);
			parameterValues.put("genClass", this.genClass);
			parameterValues.put("genPackage", this.genPackage);
			parameterValues.put("genModel", this.genModel);
			parameterValues.put("_List", this._List);
			String outputWithCallBack = Node.flatten(ictx.getNode());
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			;
		}
		return loop;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenClass createClass = null;

	public void set_createClass(org.eclipse.emf.codegen.ecore.genmodel.GenClass object) {
		this.createClass = object;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenFeature createFeature = null;

	public void set_createFeature(org.eclipse.emf.codegen.ecore.genmodel.GenFeature object) {
		this.createFeature = object;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenClass genClass = null;

	public void set_genClass(org.eclipse.emf.codegen.ecore.genmodel.GenClass object) {
		this.genClass = object;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenPackage genPackage = null;

	public void set_genPackage(org.eclipse.emf.codegen.ecore.genmodel.GenPackage object) {
		this.genPackage = object;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenModel genModel = null;

	public void set_genModel(org.eclipse.emf.codegen.ecore.genmodel.GenModel object) {
		this.genModel = object;
	}

	protected java.lang.String _List = null;

	public void set__List(java.lang.String object) {
		this._List = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("createClass", this.createClass);
		parameters.put("createFeature", this.createFeature);
		parameters.put("genClass", this.genClass);
		parameters.put("genPackage", this.genPackage);
		parameters.put("genModel", this.genModel);
		parameters.put("_List", this._List);
		return parameters;
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
	}

	public boolean preCondition() throws Exception {
		return true;
	}
}