package bdd.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"bdd.steps", "bdd.hooks"},
        plugin = {
                "pretty",
                "summary",
                "html:target/cucumber-report.html",
                "json:target/cucumber-report.json"
        }
)

public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
