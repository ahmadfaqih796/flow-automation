package com.flow.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy {

    @Override
    public WebDriver setStrategy() {
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\PT.DIKA\\Documents\\Faqih\\PT.DIKA\\Automation\\Drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
}
