package co.knowledgesd.poc.junit.Parameterized;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import co.knowledgesd.poc.junit.Fibonacci;

/**
 * Example taken from {@link https://github.com/junit-team/junit4/wiki/Parameterized-tests}
 */
@RunWith(Parameterized.class)
public class FibonacciTest {
	// name is use to Identify Individual test cases
	// Note: Eclipse IDE has a bug, and id does not show name properly
    @Parameters(name = "{index}: fib({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 7, 13 }  
           });
    }

    private int fInput;

    private int fExpected;

    public FibonacciTest(int input, int expected) {
        fInput= input;
        fExpected= expected;
    }

    @Test
    public void test() {
        assertEquals(fExpected, Fibonacci.compute(fInput));
    }
}


