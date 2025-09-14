package testRunner;

import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Listeners({ utilities.ConsoleCaptureListener.class })
@CucumberOptions(
	    features = "src/test/java/Features",
	    glue = {"stepDefinitions","hooks"},
	    plugin = {"pretty", "html:target/cucumber-report.html"},
	    monochrome = true
	)
public class TestRunner extends AbstractTestNGCucumberTests {

}
