package MyRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;




@RunWith(Cucumber.class)

@CucumberOptions(
		features = "src/test/java/Features",
		glue = { "stepDefinitions" },
		plugin = { "pretty", "html:target/ui-cucumber-reports"}, 
		monochrome = true,
		strict = true, 
		dryRun = false,
		tags = {"@Checkout"})


public class TestRunner {
	

}
