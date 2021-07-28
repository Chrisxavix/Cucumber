package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "FeaturesParameters", glue = {"StepDefinitionOutline"})
public class RunnerOutline {
}
