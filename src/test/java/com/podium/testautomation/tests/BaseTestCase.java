package com.podium.testautomation.tests;

import com.podium.testautomation.settings.TLDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public abstract class BaseTestCase {

    private static final String URL = "https://podium.com";
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        TLDriverFactory.setDriver("chrome");
        driver = TLDriverFactory.getDriver();
    }

    @AfterClass
    public void tearDown() {
        WebDriver driver = TLDriverFactory.getDriver();

        if (driver != null) {
            TLDriverFactory.endDriver();
        }
    }

}
