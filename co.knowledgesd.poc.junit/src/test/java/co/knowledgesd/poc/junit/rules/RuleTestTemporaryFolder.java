package co.knowledgesd.poc.junit.rules;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.Rule;
 
//To import all the static use : functions import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * 
 *  Explanation taken from Example taken from  {@link http://howtodoinjava.com/junit/junit-creating-temporary-filefolder-using-temporaryfolder-rule/} :<br/>
 *  <br/>
 *  Many times we need to create junit unit tests where we need to <h2>create temporary folders or</h2> <br/> 
 *  <h2>temporary files</h2> for executing the testcase. Many times we rely on having a temp folder at<br/>
 *  particular location and generate all temp files there.Well, it has its own disadvantages. <br/>
 *  Major disadvantage is that you need to cleanup these files manually.<br/>
 *  <br/>
 *  Junit comes with TemporaryFolder class which you can use for generating temp folders.<br/>
 *   <br/>
 *  
 *  The TemporaryFolder Rule <h2>allows creation of files and folders that should be deleted when the 
 *  test method finishes</h2> (whether it passes or fails). Whether the deletion is successful or not 
 *  is not checked by this rule. No exception will be thrown in case the deletion fails..<br/>
 *  
 *  
 *  Api from Temporary Folder is founded in {@link http://junit.org/junit4/javadoc/latest/org/junit/rules/TemporaryFolder.html}
 *  
 *  
 * */
public class RuleTestTemporaryFolder {

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	@Test
	public void testRuleFolder() throws IOException {
		File newFolder = tempFolder.newFolder("Temp Folder");
		assertTrue(newFolder.exists());
	}
	
	/**
	 * 
	 *  
	 * Example taken from  {@link http://howtodoinjava.com/junit/junit-creating-temporary-filefolder-using-temporaryfolder-rule/}
	 */
	@Test
	public void testRuleFile() throws IOException {
		 // Create a temporary file.
	     final File tempFile = tempFolder.newFile("tempFile.txt");
	   
	     // Write something to it.
	     FileUtils.writeStringToFile(tempFile, "'There is one thing  that can  kill the movies, and  that is education' : Will Rogers");
	   
	     // Read it from temp file
	     final String s = FileUtils.readFileToString(tempFile);
	   
	     // Verify the content
	     assertEquals("'There is one thing  that can  kill the movies, and  that is education' : Will Rogers", s);
	      
	     //Note: File is guaranteed to be deleted after the test finishes.
	}
}
