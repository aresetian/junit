package co.knowledgesd.poc.junit.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

//To import all the static use : functions import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * Api of matchers {@link http://hamcrest.org/JavaHamcrest/javadoc/1.3/org/hamcrest/CoreMatchers.html}
 * 
 * */

public class RuleTestExpectedException {

	/*
	 * Junit 3.x
	 * 
	 * This alternative. Not recommended anymore.
	 */
	@Test
	public void testExceptionMessage() {
		try {
			new ArrayList<Object>().get(0);
			fail("Expected an IndexOutOfBoundsException to be thrown");
		} catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
			assertThat(anIndexOutOfBoundsException.getMessage(),
					containsString("Index: 0, Size: 0"));
		}
	}

	/*
	 * Junit 4.x
	 * 
	 * Best way to work with JUNIT
	 */

	/**
	 * This code should throw an IndexOutOfBoundsException. The @Test annotation
	 * has an optional parameter "expected" that takes as values subclasses of
	 * Throwable. If we wanted to verify that ArrayList throws the correct
	 * exception, we would write the test below. The expected parameter should
	 * be used with care. The above test will pass if any code in the method
	 * throws IndexOutOfBoundsException. For longer tests, it's recommended to
	 * use the ExpectedException rule, which is described in
	 * shouldTestExceptionMessage(Test in this class):
	 * */
	/*
	 * Test 1
	 */
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void empty() {
		new ArrayList<Object>().get(0);
	}

	/*
	 * Test 2
	 * This options is the alternative that I recommend most highly.
	 */
		@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void shouldTestExceptionMessage() throws IndexOutOfBoundsException {
		List<Object> list = new ArrayList<Object>();
		thrown.expect(IndexOutOfBoundsException.class);
		thrown.expectMessage("Index: 0, Size: 0");
		list.get(0); // execution will never get past this line
	}
}
