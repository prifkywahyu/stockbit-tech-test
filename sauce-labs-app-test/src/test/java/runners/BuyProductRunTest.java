package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"stepdefs"},
        features = "src/test/resources",
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        }
)

public class BuyProductRunTest {
        /*
        TODO - Fix this class runner, currently cannot running from this entrypoint.
        TODO - Note: But from feature file works fine.
        */
}