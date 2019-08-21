/*package com.amazon.qa.driver;

import org.testng.annotations.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.json.Result;


@RunWith(Cucumber.class)


public class TestRunner {
    
	String Status;
	String ResultDesc;
	
	
    @Test
    public void testParallel() {
    	
    	String outputPath = "target\\surefire-reports";
        Result results = TestRunner.parallel(getClass(),7, "target/surefire-reports");
        //assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
        generateReport(outputPath);
    }
        
    
    private static Result parallel(Class<? extends TestRunner> class1, int i, String string) {
		// TODO Auto-generated method stub
		return null;
	}


	private static void generateReport(String outputPath) {
    	Collection<File> jsonFiles = FileUtils.listFiles(new File(outputPath), new String[] {"json"}, true);
    	List<String> jsonPaths = new ArrayList(jsonFiles.size());
    	jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
    	//jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
    	Configuration config = new Configuration(new File("target"), "AmazonTest Report");
    	ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
    	reportBuilder.generateReports();
    	
    }
    
}
*/