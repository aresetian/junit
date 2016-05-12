package co.knowledgesd.poc.junit.customrules;

import org.junit.Rule;
import org.junit.Test;

public class CustomRuleTest {

	    @Rule
	    public CustomRule rule = new CustomRule();
		
	    @Test
	    public void testRun1(){
	        System.out.println("Inside testRun1 'Every cloud has a silver lining'");
	    }
	    
	    @Test
	    public void testRun2(){
	        System.out.println("Inside testRun2 'Do not dream your life but live your dreams'");
	    }
	    
	    @Test
	    public void testRun3(){
	        System.out.println("Inside testRun3 'Be who you are, not who you think others want you to be'");
	    }
}
