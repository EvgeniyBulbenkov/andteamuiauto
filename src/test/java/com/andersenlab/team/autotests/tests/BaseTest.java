package com.andersenlab.team.autotests.tests;

import com.andersenlab.team.autotests.driver.DriverSingleton;
import com.andersenlab.team.autotests.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class BaseTest {
    protected WebDriver webDriver;

    @BeforeMethod
    public void setUp() {
        webDriver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}
