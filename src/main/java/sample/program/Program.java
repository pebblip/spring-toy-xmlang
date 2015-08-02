package sample.program;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * プログラムです。
 */
public class Program {
	private final String argumentName;
	private final Block block;

	public String argumentName() {
		return argumentName;
	}

	public Block block() {
		return block;
	}

	public Program(String argumentName, Block block) {
		this.argumentName = argumentName;
		this.block = block;
	}

	public Object evaluation(Object argument) {
		EvaluationContext evaluationContext = new StandardEvaluationContext();
		evaluationContext.setVariable(argumentName, argument);
		ProgramEnvironment context = new ProgramEnvironment(evaluationContext);
		block.evaluate(context);
		return context.getReturnValue();
	}
}
