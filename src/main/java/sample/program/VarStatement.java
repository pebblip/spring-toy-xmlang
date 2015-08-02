package sample.program;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * 変数宣言文です。
 */
public class VarStatement implements Statement {
	private final String name;
	private final String expression;

	public VarStatement(String name, String expression) {
		this.name = name;
		this.expression = expression;
	}

	@Override
	public void evaluate(ProgramEnvironment context) {
		ExpressionParser parser = new SpelExpressionParser();
		Object value = parser.parseExpression(expression).getValue(context.getEvaluationContext());
		context.getEvaluationContext().setVariable(name, value);
	}
}
