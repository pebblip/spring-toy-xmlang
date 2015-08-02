package sample.program;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * if文です。
 */
public class IfStatement extends ConditionalBlock {
	public IfStatement(String expression, Block block) {
		super(expression, block);
	}

	@Override
	public void evaluate(ProgramEnvironment context) {
		ExpressionParser parser = new SpelExpressionParser();
		if (parser.parseExpression(expression).getValue(context.getEvaluationContext(), Boolean.class).booleanValue()) {
			block.evaluate(context);
		}
	}
}