package Runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "junit:target/cucumber-report/TestResult.xml",
                "json:target/cucumber-report/TestResult.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "Steps"
)
public class TestRunner {
}
