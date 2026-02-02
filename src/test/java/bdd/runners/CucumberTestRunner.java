package bdd.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"bdd.steps", "bdd.hooks"},
        plugin = {"pretty"}
)

public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
