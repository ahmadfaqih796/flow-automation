package com.flow.hooks;

import com.flow.drivers.DriverSingleton;
import com.flow.utils.Constants;
import com.flow.utils.TestScenarios;
import com.flow.utils.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class Hooks {
    public static WebDriver driver;
    public static ExtentTest extentTest;
    public static ExtentReports reports = new ExtentReports("target/extent-report.html");

    @Before
    public static void setUp() {
        DriverSingleton.getInstance(Constants.FIREFOX);
        driver = DriverSingleton.getDriver();
        TestScenarios[] test = TestScenarios.values();
        extentTest = reports.startTest(test[Utils.testCount].getTestCaseName());
        Utils.testCount++;
    }

    @After
    public void endTestClass() {
        reports.endTest(extentTest);
        reports.flush();
    }

    @AfterStep
    public void getResultStatus(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            String screenshootPath = Utils.getScreenshot(driver, scenario.getName().replace(" ", "_"));
            extentTest.log(LogStatus.FAIL, scenario.getName() + "\n" +
                    extentTest.addScreenCapture(screenshootPath));
        }
    }

    @AfterAll
    public static void tearDown() {
        delay(2);
        DriverSingleton.closeObjectInstance();
    }

    public static void delay(double second) {
        Long timeSleep = (long) second*1000;
        try {
            Thread.sleep(timeSleep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void enter(){
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
    }
}
