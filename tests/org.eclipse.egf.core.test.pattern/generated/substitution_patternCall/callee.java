package substitution_patternCall;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class callee {
	protected static String nl;

	public static synchronized callee create(String lineSeparator) {
		nl = lineSeparator;
		callee result = new callee();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "  callee eAttribute : ";
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL;
	protected final String TEXT_4 = NL;

	public callee() {
		//Here is the constructor
		StringBuffer stringBuffer = new StringBuffer();

		// add initialisation of the pattern variables (declaration has been already done).

	}

	public String generate(Object argument) throws Exception {
		final StringBuffer stringBuffer = new StringBuffer();

		InternalPatternContext ctx = (InternalPatternContext) argument;
		Map<String, String> queryCtx = null;
		IQuery.ParameterDescription paramDesc = null;

		paramDesc = new IQuery.ParameterDescription("eAttribute", "http://www.eclipse.org/emf/2002/Ecore#//EAttribute");
		queryCtx = new HashMap<String, String>();
		List<Object> eAttributeList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.basic.query").execute(paramDesc, queryCtx, ctx);

		for (Object eAttributeParameter : eAttributeList) {

			this.eAttribute = (org.eclipse.emf.ecore.EAttribute) eAttributeParameter;

			if (preCondition())
				orchestration(ctx);

		}
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
			ctx.clearBuffer();
		}

		stringBuffer.append(TEXT_3);
		stringBuffer.append(TEXT_4);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		int executionIndex = ictx.getExecutionBuffer().length();

		method_body(ictx.getBuffer(), ictx);

		String loop = ictx.getBuffer().toString();
		if (ictx.useReporter()) {
			ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
			ictx.setExecutionCurrentIndex(0);
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("eAttribute", this.eAttribute);
			String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			ictx.clearBuffer();
		}
		return loop;
	}

	protected org.eclipse.emf.ecore.EAttribute eAttribute = null;

	public void set_eAttribute(org.eclipse.emf.ecore.EAttribute object) {
		this.eAttribute = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("eAttribute", this.eAttribute);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		stringBuffer.append(eAttribute.getName());
		stringBuffer.append(TEXT_2);
	}

	public boolean preCondition() throws Exception {
		return true;
	}
}