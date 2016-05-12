package co.knowledgesd.poc.junit.suite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  TestFeatureLogin.class,
  TestFeatureLogout.class,
  TestFeatureNavigate.class,
  TestFeatureUpdate.class
})

/**
 * 
 * This suite will execute TestFeatureLogin,TestFeatureLogout,TestFeatureNavigate and TestFeatureUpdate one after the over.
 * 
 * @Before, @After and @Test are no possible of executing in this class.
 * @BeforeClas and @AfterClass are allowed only.  
 * 
 * */
public class FeatureTestSuite {
	// the class remains empty of test,although it is possible set up a before class and after class annotations.
	// used only as a holder for the above annotations
	
	@BeforeClass
	static public void beforeClass(){
		System.out.println(FeatureTestSuite.class.toString() + " BeforeClass Method");
	}
	
	@AfterClass
	static public void AfterClass(){
		System.out.println(FeatureTestSuite.class.toString() + " AfterClass Method");
	}	
}
