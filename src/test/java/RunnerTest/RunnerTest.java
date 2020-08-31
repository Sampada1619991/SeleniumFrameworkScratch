package RunnerTest;

import org.junit.runner.RunWith;
//import com.cucumber.listener.Reporter;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber. class)

@CucumberOptions(features={"src/test/resources/feature/Portal/03_SupplierPortal/SubmitRITMSupplier.feature"},
glue={"StepDefinations"},
plugin = {"html:reports/cucumber-html-report", "json:reports/appium_report.json" })



public class RunnerTest {
	
	/*@AfterClass
    public static void teardown() {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Mac OSX");
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }*/

	
	
}
