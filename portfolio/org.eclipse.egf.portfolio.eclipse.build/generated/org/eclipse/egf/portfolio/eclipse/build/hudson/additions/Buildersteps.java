//Generated with EGF 1.2.0.v20140805-0858
package org.eclipse.egf.portfolio.eclipse.build.hudson.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.*;
import org.eclipse.egf.portfolio.eclipse.build.*;
import org.eclipse.egf.portfolio.eclipse.build.builddeploy.*;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.*;

public class Buildersteps extends org.eclipse.egf.portfolio.eclipse.build.hudson.call.Builderadd {
	protected static String nl;

	public static synchronized Buildersteps create(String lineSeparator) {
		nl = lineSeparator;
		Buildersteps result = new Buildersteps();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "    <hudson.tasks.Ant>" + NL + "      <targets>all</targets>";
	protected final String TEXT_2 = NL + "      <antName>";
	protected final String TEXT_3 = "</antName>";
	protected final String TEXT_4 = NL + "      <buildFile>";
	protected final String TEXT_5 = "/releng/build.xml</buildFile>" + NL + "    </hudson.tasks.Ant>" + NL;
	protected final String TEXT_6 = NL;
	protected final String TEXT_7 = NL;

	public Buildersteps() {
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

		paramDesc = new IQuery.ParameterDescription("job", "http://www.eclipse.org/egf/1.0.1/buildcore#//Job");
		queryCtx = new HashMap<String, String>();
		List<Object> jobList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

		for (Object jobParameter : jobList) {

			this.job = (org.eclipse.egf.portfolio.eclipse.build.buildcore.Job) jobParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_6);
		stringBuffer.append(TEXT_7);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_body(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("job", this.job);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.eclipse.egf.portfolio.eclipse.build.buildcore.Job job = null;

	public void set_job(org.eclipse.egf.portfolio.eclipse.build.buildcore.Job object) {
		this.job = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("job", this.job);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);

		String buildFile = "..";
		if (job.getDeployment() instanceof HudsonDeployment) {
			HudsonDeployment deployment = (HudsonDeployment) job.getDeployment();
			if (deployment.getAntName() != null) {

				stringBuffer.append(TEXT_2);
				stringBuffer.append(deployment.getAntName());
				stringBuffer.append(TEXT_3);

			}
			if (deployment.getGenerationLocation() instanceof SVNGenerationLocation) {
				SVNGenerationLocation svnGenerationLocation = (SVNGenerationLocation) deployment.getGenerationLocation();
				buildFile = "svn/" + svnGenerationLocation.getSvnLocation().getLocalPath() + "/" + svnGenerationLocation.getFolderName() + "/"
						+ new GenerationHelper().getJobName(ctx, job);
			}
			if (deployment.getGenerationLocation() instanceof GITGenerationLocation) {
				GITGenerationLocation gitGenerationLocation = (GITGenerationLocation) deployment.getGenerationLocation();
				buildFile = "git/" + gitGenerationLocation.getGitLocation().getLocalPath() + "/" + gitGenerationLocation.getFolderName() + "/"
						+ new GenerationHelper().getJobName(ctx, job);
			}
		}

		stringBuffer.append(TEXT_4);
		stringBuffer.append(buildFile);
		stringBuffer.append(TEXT_5);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}
}