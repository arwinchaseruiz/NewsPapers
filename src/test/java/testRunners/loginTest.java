package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "stepDefinitions", strict = true, monochrome = true,
plugin = {"pretty","json:target/NewspaperLoginReport.json","de.monochromata.cucumber.report.PrettyReports:target/pretty-cucumber"})
public class loginTest {

}
