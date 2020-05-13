package com.andersenlab.team.autotests.tests;

import com.andersenlab.team.autotests.driver.DriverSingleton;
import com.andersenlab.team.autotests.utils.TestListener;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class BaseTest {

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverSingleton.closeDriver();
    }

}
