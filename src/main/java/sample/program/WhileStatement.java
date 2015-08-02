package sample.program;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * while文です。
 */
public class WhileStatement extends ConditionalBlock {
	public WhileStatement(String expression, Block block) {
		super(expression, block);
	}

	@Override
	public void evaluate(ProgramEnvironment context) {
		ExpressionParser parser = new SpelExpressionParser();
		while (parser.parseExpression(expression).getValue(context.getEvaluationContext(), Boolean.class).booleanValue()) {
			block.evaluate(context);
		}
	}
}