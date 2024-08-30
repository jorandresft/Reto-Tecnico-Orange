package co.com.orange.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/rejected.feature",
        glue = "co.com.orange.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@rejected"
)
public class RunnerRejected {
}
