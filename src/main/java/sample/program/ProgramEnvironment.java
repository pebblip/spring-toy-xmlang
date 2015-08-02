package sample.program;

import org.springframework.expression.EvaluationContext;

/**
 * プログラムの実行時環境です。
 */
public class ProgramEnvironment {
	private final EvaluationContext evaluationContext;
	private boolean isTerminate;
	private Object returnValue;

	public ProgramEnvironment(EvaluationContext evaluationContext) {
		this.evaluationContext = evaluationContext;
	}

	public EvaluationContext getEvaluationContext() {
		return evaluationContext;
	}	

	public boolean isTerminate() {
		return isTerminate;
	}

	public void setTerminate(boolean isTerminate) {
		this.isTerminate = isTerminate;
	}

	public Object getReturnValue() {
		return returnValue;
	}

	public void setReturnValue(Object returnValue) {
		this.returnValue = returnValue;
	}
}