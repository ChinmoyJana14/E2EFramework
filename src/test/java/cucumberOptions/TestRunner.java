package cucumberOptions;

import org.junit.runner.RunWith;


//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class) // Commenting out to use TestNG instead of JUnit
@CucumberOptions(
		features = "src/test/java/features",
		glue = {"stepDefinition"},
		monochrome = true,
		plugin = {"pretty","html:target/Reports/report.html",
				"json:target/Reports/report.json",
				"junit:target/Reports/report.xml"},
		publish = false,
		tags ="@SmokeScenario"
		)
	public class TestRunner extends AbstractTestNGCucumberTests {	
	}
 