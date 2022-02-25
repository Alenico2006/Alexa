package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"classpath:stepDefinitions"},
        plugin = { "pretty", "json:target/cucumber/cucumber.json" }
)

public class RunCucumberTest {
}
