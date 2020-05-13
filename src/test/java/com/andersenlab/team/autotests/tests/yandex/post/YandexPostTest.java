package com.andersenlab.team.autotests.tests.yandex.post;

import com.andersenlab.team.autotests.pageobjects.yandex.loginpage.LoginPage;
import com.andersenlab.team.autotests.pageobjects.yandex.mainpage.MainPage;
import com.andersenlab.team.autotests.pageobjects.yandex.postpage.PostPage;
import com.andersenlab.team.autotests.service.UserCreationService;
import com.andersenlab.team.autotests.tests.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YandexPostTest extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    PostPage postPage;

    @BeforeMethod
    public void setUp() {
        mainPage = new MainPage();
        mainPage.open("http://yandex.ru");
    }

    @Test(description = "Sign in to Yandex Post")
    @Issue("048")
    @TmsLink("Post-1")
    @Epic("Yandex Post")
    @Story("Sign in with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    public void signInToPost() {
        loginPage = mainPage.clickSignInToPost();
        postPage = loginPage.loginToPost(UserCreationService.userName, UserCreationService.userPassword);

        Assert.assertEquals(postPage.getUser(), "AutotestUser");
    }

    @Test(description = "Sign out from Yandex Post")
    @Issue("049")
    @TmsLink("Post-2")
    @Epic("Yandex Post")
    @Story("Sign out")
    @Severity(SeverityLevel.CRITICAL)
    public void signOut() {
        signInToPost();
        postPage.signOut();

        Assert.assertTrue(mainPage.postSignInButtonIsDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
        mainPage = null;
        loginPage = null;
        postPage = null;
    }
}
