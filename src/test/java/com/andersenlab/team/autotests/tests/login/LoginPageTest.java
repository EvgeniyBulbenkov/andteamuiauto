package com.andersenlab.team.autotests.tests.login;

import com.andersenlab.team.autotests.driver.DriverSingleton;
import com.andersenlab.team.autotests.pageobjects.loginpage.LoginPage;
import com.andersenlab.team.autotests.pageobjects.teammainpage.TeamMainPage;
import com.andersenlab.team.autotests.tests.BaseTest;
import io.qameta.allure.Flaky;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageTest extends BaseTest {

    @Test()
    @Flaky
    @Story("Valid log in")
    public void validLogin() {
        /*-------------------- Open Sign In page --------------------*/
        loginPage.open("http://team.andersenlab.com");

        /*------------------------ Test Steps -----------------------*/
        teamMainPage = loginPage
                                .fillInLogin("")
                                .fillInPassword("")
                                .pushSubmitButton();

        /*---------------- Checking test results --------------------*/
        Assert.assertTrue(teamMainPage.onValidPage());

    }

}
