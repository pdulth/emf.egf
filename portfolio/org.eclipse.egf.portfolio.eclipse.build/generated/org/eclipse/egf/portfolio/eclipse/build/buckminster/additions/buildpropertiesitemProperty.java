//Generated with EGF 1.2.0.v20140805-0858
package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class buildpropertiesitemProperty extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildpropertiesadd {
	protected static String nl;

	public static synchronized buildpropertiesitemProperty create(String lineSeparator) {
		nl = lineSeparator;
		buildpropertiesitemProperty result = new buildpropertiesitemProperty();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "=";
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL;
	protected final String TEXT_4 = NL;

	public buildpropertiesitemProperty() {
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

		paramDesc = new IQuery.ParameterDescription("propertyWrapper", "org.eclipse.egf.portfolio.eclipse.build.PropertyWrapper");
		queryCtx = new HashMap<String, String>();
		List<Object> propertyWrapperList = QueryHelper.load(ctx, "org.eclipse.egf.portfolio.eclipse.build.ItemPropertiesQuery").execute(paramDesc, queryCtx, ctx);

		for (Object propertyWrapperParameter : propertyWrapperList) {

			this.propertyWrapper = (org.eclipse.egf.portfolio.eclipse.build.PropertyWrapper) propertyWrapperParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_3);
		stringBuffer.append(TEXT_4);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("propertyWrapper", this.propertyWrapper);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.eclipse.egf.portfolio.eclipse.build.PropertyWrapper propertyWrapper = null;

	public void set_propertyWrapper(org.eclipse.egf.portfolio.eclipse.build.PropertyWrapper object) {
		this.propertyWrapper = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("propertyWrapper", this.propertyWrapper);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(propertyWrapper.getKey());
		stringBuffer.append(TEXT_1);
		stringBuffer.append(propertyWrapper.getValue());
		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}
}