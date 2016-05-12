package co.knowledgesd.poc.junit.customrules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Example taken from {@link http://www.cubearticle.com/articles/framework/junit/junit-rule}
 * */
public class CustomRule implements TestRule {

	@Override
	public Statement apply(final Statement stmt, final Description desc) {

		return new Statement() {

			@Override
			public void evaluate() throws Throwable {
				System.out.println("Before executing method "
						+ desc.getMethodName());
				stmt.evaluate();
				System.out.println("After executing method "
						+ desc.getMethodName());
			}
		};
	}
}
