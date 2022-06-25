package Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="@target/rerun.txt",
glue= {"stepDefinitions", "Utilities"},
dryRun = false,
monochrome = true,
plugin = {"pretty", "html:target/HTMLReports_Failed.html", 
		"json:target/JSON/Reports_Failed.json",
		"rerun:target/finalFailed.txt"}
)
public class FailedRunner {

}
