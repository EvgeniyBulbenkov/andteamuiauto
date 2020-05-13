package com.andersenlab.team.autotests.tests.yandex.post;

import com.andersenlab.team.autotests.pageobjects.yandex.loginpage.LoginPage;
import com.andersenlab.team.autotests.pageobjects.yandex.mainpage.MainPage;
import com.andersenlab.team.autotests.tests.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YandexPostLoginTest extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        mainPage = new MainPage();
        mainPage.open("http://yandex.ru");
        loginPage = mainPage.clickSignInToPost();
    }

    @Test(description = "Sign in to Yandex Post with invalid password")
    @Issue("050")
    @TmsLink("Post-3")
    @Epic("Yandex Post")
    @Story("Sign in with invalid password")
    @Severity(SeverityLevel.CRITICAL)
    public void signInWithInvalidPassword() {
        loginPage.fillInLogin("AutotestUser");
        loginPage.pushSignInButton();
        loginPage.fillInPassword("NoAutotestUser123");
        loginPage.pushSignInButton();

        Assert.assertEquals(loginPage.getErrorMessage(), "Неверный пароль");
    }

    @Test(description = "Sign in to Yandex Post with invalid login")
    @Issue("051")
    @TmsLink("Post-4")
    @Epic("Yandex Post")
    @Story("Sign in with invalid login")
    @Severity(SeverityLevel.CRITICAL)
    public void signInWithInvalidLogin() {
        loginPage.fillInLogin("NoAutotestUser");
        loginPage.pushSignInButton();

        Assert.assertEquals(loginPage.getErrorMessage(), "Такого аккаунта нет");
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
        mainPage = null;
        loginPage = null;
    }
}
