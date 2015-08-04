package sample.program;

import java.util.ArrayList;
import java.util.List;

/**
 * ブロック文です。文の集合です。
 */
public class Block implements Statement {
	private final List<Statement> statements = new ArrayList<>();

	public List<Statement> statements() {
		return statements;
	}

	public void addStatement(Statement statement) {
		this.statements.add(statement);
	}

	@Override
	public void evaluate(ProgramEnvironment context) {
		statements.forEach(s -> {
			if (context.isTerminate())
				return;
			s.evaluate(context);
		});
	}
}