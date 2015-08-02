package sample.program;

/**
 * 条件付ブロック文です。
 */
public abstract class ConditionalBlock implements Statement {
	protected final String expression;
	protected final Block block;

	public ConditionalBlock(String expression, Block block) {
		this.expression = expression;
		this.block = block;
	}
}