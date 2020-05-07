package com.andersenlab.team.autotests.tests;

import com.andersenlab.team.autotests.driver.DriverSingleton;
import com.andersenlab.team.autotests.pageobjects.loginpage.LoginPage;
import com.andersenlab.team.autotests.pageobjects.teammainpage.TeamMainPage;
import com.andersenlab.team.autotests.utils.TestListener;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class BaseTest {

    protected LoginPage loginPage;
    protected TeamMainPage teamMainPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverSingleton.closeDriver();
        loginPage = null;
        teamMainPage = null;
    }
}
