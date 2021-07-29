package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "FeaturesTransactions", glue = {"StepsDefinitionTransactions"})
public class RunnerTransactions {
}
