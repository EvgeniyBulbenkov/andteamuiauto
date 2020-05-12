package com.andersenlab.team.autotests.tests.login;

import com.andersenlab.team.autotests.driver.DriverSingleton;
import com.andersenlab.team.autotests.pageobjects.loginpage.LoginPage;
import com.andersenlab.team.autotests.pageobjects.teammainpage.TeamMainPage;
import com.andersenlab.team.autotests.service.UserCreationService;
import com.andersenlab.team.autotests.tests.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseTest {
    private LoginPage loginPage;
    private TeamMainPage teamMainPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage();
        loginPage.open("http://team.andersenlab.com");
    }

//    @Test(description = "Sign in")
    @Epic("Logging in")
    @Story("Valid log in")
    @Severity(SeverityLevel.CRITICAL)
    public void validLogin() {

        teamMainPage = loginPage.logIn();
        Assert.assertEquals(teamMainPage.getPageTitle(), "Andersen Team");
    }

//    @Test(description = "Visibility of error messages")
    @Epic("Logging in")
    @Story("Visibility of error messages")
    @Severity(SeverityLevel.NORMAL)
    public void displayErrorMessages() {

        loginPage.pushSubmitButton();
        Assert.assertTrue(loginPage.loginErrMessageIsVisible() && loginPage.passwordErrMessageIsVisible());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        super.tearDown();
        loginPage = null;
        teamMainPage = null;
    }


}
