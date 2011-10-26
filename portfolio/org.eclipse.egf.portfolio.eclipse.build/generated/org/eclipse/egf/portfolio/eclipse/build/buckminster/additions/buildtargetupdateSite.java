//Generated on Wed Oct 26 15:29:40 CEST 2011 with EGF 0.6.1.qualifier
package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class buildtargetupdateSite extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildtargetadd {
	protected static String nl;

	public static synchronized buildtargetupdateSite create(String lineSeparator) {
		nl = lineSeparator;
		buildtargetupdateSite result = new buildtargetupdateSite();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "\t\t<location path=\"${workspace_loc}/../tp\" type=\"Directory\"/>" + NL;
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL;

	public buildtargetupdateSite() {
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

		paramDesc = new IQuery.ParameterDescription("updateSiteBuildLocation", "http://www.eclipse.org/egf/1.0.1/buildstep#//UpdateSiteBuildLocation");
		queryCtx = new HashMap<String, String>();
		List<Object> updateSiteBuildLocationList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

		for (Object updateSiteBuildLocationParameter : updateSiteBuildLocationList) {

			this.updateSiteBuildLocation = (org.eclipse.egf.portfolio.eclipse.build.buildstep.UpdateSiteBuildLocation) updateSiteBuildLocationParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
		}

		stringBuffer.append(TEXT_2);
		stringBuffer.append(TEXT_3);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		String loop = Node.flattenWithoutCallback(ictx.getNode());
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("updateSiteBuildLocation", this.updateSiteBuildLocation);
			String outputWithCallBack = Node.flatten(ictx.getNode());
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			;
		}
		return loop;
	}

	protected org.eclipse.egf.portfolio.eclipse.build.buildstep.UpdateSiteBuildLocation updateSiteBuildLocation = null;

	public void set_updateSiteBuildLocation(org.eclipse.egf.portfolio.eclipse.build.buildstep.UpdateSiteBuildLocation object) {
		this.updateSiteBuildLocation = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("updateSiteBuildLocation", this.updateSiteBuildLocation);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}
}