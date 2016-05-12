package co.knowledgesd.poc.junit.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runners.model.TestTimedOutException;

/**
 * This rules replace the code on every test : 
 *  
 * public class BlahTest {
 * 	@Test(timeout = 1000)
 * 	public void testA() throws Exception {
 * 		// ...
 * 	}
 * 
 * 	@Test(timeout = 1000)
 * 	public void testB() throws Exception {
 * 		// ...
 * 	}
 * 
 * 	@Test(timeout = 1000)
 * 	public void testC() throws Exception {
 * 		// ...
 * 	}
 * 
 * 	@Test(timeout = 1000)
 * 	public void testD() throws Exception {
 * 		// ...
 * 	}
 * 
 * 	@Test(timeout = 1000)
 * 	public void testE() throws Exception {
 * 		// ...
 * 	}
 *  // ...
 * }
 * 
 * 
 * More info {@link http://carlosbecker.com/posts/junit-rules}
 * 
 */
public class RuleTestTimeOut {

	  @Rule
	  public Timeout globalTimeout= Timeout.seconds(5); // 10 seconds max per method tested

	  @Rule
	  public ExpectedException thrown = ExpectedException.none();
	  
	  /**
	   * Testing that  this method finished before the time out, so it will be OK.
	   * 
	   * Due to the test finish before the timeout , InterruptedException is never throws.  
	   * */
	  @Test
	  public void runOK() throws InterruptedException {
	      Thread.sleep(100);
	  }

	  /*
	   * Testing that this method generate a TestTimedOutException because of the time out.  
	   * */
	  @Test
	  public void infiniteLoop() {
		  thrown.expect(TestTimedOutException.class);
		  thrown.expectMessage("test timed out after 5 seconds");
		  
	      while (true) {}
	  }
}
