package co.knowledgesd.poc.junit.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

/**
 * Example with inject of parameters
 * 
 * more info: {@link http://www.leveluplunch.com/java/examples/junit-parameterized-test-with-field-injection/}
 * */
@RunWith(Parameterized.class)
public class AdditionTest {
	
	//name is use to Identify Individual test cases. 
	//Note: Eclipse IDE has a bug, and id does not show name properly
	@Parameters(name = "{index}: add({1},{2})={0}")
	public static Collection<Object[]> data() {
	    return Arrays.asList(new Object[][] {
	    		{0, 0, 0}, 
	     	       {1, 1, 0}, 
	     	       {2, 1, 1}, 
	     	       {3, 2, 1}, 
	     	       {4, 3, 1}, 
	     	       {5, 5, 0}, 
	     	       {6, 8, -2}  
	        });
	}
	 
	
	  @Parameter(value = 0) public int expected;
	  @Parameter(value = 1) public int input1; 
	  @Parameter(value = 2) public int input2; 
	  		
			
	  @Test 
	  public void testAddition() {
	    assertEquals(expected, add(input1, input2));
	  }

	  private int add(int m, int n) {
	    return m+n;
	  }
	  
}
