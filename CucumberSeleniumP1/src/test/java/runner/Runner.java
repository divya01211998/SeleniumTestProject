package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
	(features = ("src/test/java/feature"),
	glue = ("stepdefinitions"),
	plugin = {"pretty", "html:target/html-reports/report.html"},
	monochrome = true,
	publish = true)

public class Runner {

}
