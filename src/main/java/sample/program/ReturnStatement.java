package sample.program;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * リターン文です。
 */
public class ReturnStatement implements Statement {
	private final String expression;

	public ReturnStatement(String expression) {
		this.expression = expression;
	}

	@Override
	public void evaluate(ProgramEnvironment context) {
		ExpressionParser parser = new SpelExpressionParser();
		Object value = parser.parseExpression(expression).getValue(context.getEvaluationContext());
		context.setReturnValue(value);
		context.setTerminate(true);
	}
}
