//Generated on Mon Nov 07 17:44:35 CET 2011 with EGF 0.6.1.qualifier
package org.eclipse.egf.emf.pattern.base;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;

public class HeaderXml extends org.eclipse.egf.emf.pattern.base.HeaderAbstract {
	protected static String nl;

	public static synchronized HeaderXml create(String lineSeparator) {
		nl = lineSeparator;
		HeaderXml result = new HeaderXml();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "<!--";
	protected final String TEXT_2 = NL + " ";
	protected final String TEXT_3 = NL + " <copyright>" + NL + " </copyright>";
	protected final String TEXT_4 = NL;
	protected final String TEXT_5 = NL + " ";
	protected final String TEXT_6 = "Id";
	protected final String TEXT_7 = NL + "-->" + NL;
	protected final String TEXT_8 = NL;
	protected final String TEXT_9 = NL;

	public HeaderXml() {
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

		List<Object> argumentList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object argumentParameter : argumentList) {

			this.argument = (java.lang.Object) argumentParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.getOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_8);
		stringBuffer.append(TEXT_9);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		String loop = OutputManager.getOutputWithoutCallback(ictx);
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("argument", this.argument);
			String outputWithCallBack = OutputManager.getOutput(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			;
		}
		return loop;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("argument", this.argument);
		return parameters;
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		{
			GenBase copyrightHolder = argument instanceof GenBase ? (GenBase) argument : argument instanceof Object[] && ((Object[]) argument)[0] instanceof GenBase ? (GenBase) ((Object[]) argument)[0] : null;
			if (copyrightHolder != null && copyrightHolder.hasCopyright()) {
				stringBuffer.append(TEXT_2);
				stringBuffer.append(copyrightHolder.getCopyright(copyrightHolder.getGenModel().getIndentation(stringBuffer)));
			} else {
				stringBuffer.append(TEXT_3);
			}
		}
		stringBuffer.append(TEXT_4);
		stringBuffer.append(TEXT_5);
		stringBuffer.append("$");
		stringBuffer.append(TEXT_6);
		stringBuffer.append("$");
		stringBuffer.append(TEXT_7);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition() {
		return true;
	}
}