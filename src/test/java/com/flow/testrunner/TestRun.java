
package com.flow.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/resources/features/01-Login.feature",
                // features = {"src/main/resources/features/01-Login.feature",
                // "src/main/resources/features/02-UserManagement.feature"},
                glue = { "com.flow" }, dryRun = false, plugin = { "pretty", "html:target/cucumber-report.html",
                                "json:target/cucumber-report.json" })

public class TestRun extends AbstractTestNGCucumberTests {

}
