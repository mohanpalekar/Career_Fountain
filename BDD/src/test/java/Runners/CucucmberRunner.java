package Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/",
glue= {"stepDefinitions", "Utilities"},
dryRun = false,
publish = true,
monochrome = true,
tags = ("@wip13212 or @Smoke"),
plugin = {"pretty", "html:target/HTMLReports.html", 
		"json:target/JSON/Reports.json",
		"rerun:target/rerun.txt"}
)
public class CucucmberRunner {

}
