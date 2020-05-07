package com.andersenlab.team.autotests.tests.login;

import com.andersenlab.team.autotests.service.UserCreationService;
import com.andersenlab.team.autotests.tests.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Flaky;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseTest {

    @Test(description = "Sign in")
    @Flaky
    @Epic("Logging in")
    @Story("Valid log in")
    public void validLogin() {

        loginPage.open("http://team.andersenlab.com");
        teamMainPage = loginPage
                                .fillInLogin(UserCreationService.userName)
                                .fillInPassword(UserCreationService.userPassword)
                                .pushSubmitButton();
        Assert.assertTrue(teamMainPage.onValidPage());

    }

    @Test(description = "Visibility of error messages")
    @Epic("Logging in")
    @Story("Visibility of error messages")
    public void displayErrorMessages() {
        loginPage.open("http://team.andersenlab.com");
        loginPage.pushSubmitButton();
        Assert.assertTrue(loginPage.loginErrMessageIsVisible() && loginPage.passwordErrMessageIsVisible());
    }


}
