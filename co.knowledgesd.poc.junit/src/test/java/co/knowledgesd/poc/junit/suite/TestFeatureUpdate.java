package co.knowledgesd.poc.junit.suite;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFeatureUpdate {

	@BeforeClass
	static public void beforeClass(){
		System.out.println(TestFeatureUpdate.class.toString() + " BeforeClass Method");
	}
	
	@AfterClass
	static public void AfterClass(){
		System.out.println(TestFeatureUpdate.class.toString() + " AfterClass Method");
	}
	
	@Before
	public void before(){
		System.out.println(TestFeatureUpdate.class.toString() + " Before Method");
	}
	
	@After
	public void after(){
		System.out.println(TestFeatureUpdate.class.toString() + " After Method");
	}
	
	@Test
	public void Test1(){
		System.out.println(TestFeatureUpdate.class.toString() + " Test 1  Executed");
	}
	
	@Test
	public void Test2(){
		System.out.println(TestFeatureUpdate.class.toString() + " Test 2  Executed");
	}
	
	@Test
	public void Test3(){
		System.out.println(TestFeatureUpdate.class.toString() + " Test 3  Executed");
	}
}
