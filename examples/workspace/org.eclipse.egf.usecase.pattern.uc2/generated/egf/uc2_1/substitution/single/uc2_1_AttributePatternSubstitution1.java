//Generated on Thu Jan 12 17:22:24 CET 2012 with EGF 0.6.1.qualifier
package egf.uc2_1.substitution.single;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class uc2_1_AttributePatternSubstitution1 {
	protected static String nl;

	public static synchronized uc2_1_AttributePatternSubstitution1 create(String lineSeparator) {
		nl = lineSeparator;
		uc2_1_AttributePatternSubstitution1 result = new uc2_1_AttributePatternSubstitution1();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "Sub1:";
	protected final String TEXT_2 = "_attribute ";
	protected final String TEXT_3 = NL;
	protected final String TEXT_4 = NL;

	public uc2_1_AttributePatternSubstitution1() {
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

		List<Object> anAttributeList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object anAttributeParameter : anAttributeList) {

			this.anAttribute = (org.eclipse.emf.ecore.EAttribute) anAttributeParameter;

			{
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

		method_body(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("anAttribute", this.anAttribute);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.eclipse.emf.ecore.EAttribute anAttribute = null;

	public void set_anAttribute(org.eclipse.emf.ecore.EAttribute object) {
		this.anAttribute = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("anAttribute", this.anAttribute);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		stringBuffer.append(anAttribute.getName());
		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}
}