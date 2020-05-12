package com.andersenlab.team.autotests.tests.yandex.post;

import com.andersenlab.team.autotests.pageobjects.yandex.loginpage.LoginPage;
import com.andersenlab.team.autotests.pageobjects.yandex.mainpage.MainPage;
import com.andersenlab.team.autotests.pageobjects.yandex.postpage.PostPage;
import com.andersenlab.team.autotests.service.UserCreationService;
import com.andersenlab.team.autotests.tests.BaseTest;
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

    @Test
    public void signInToPost() {
        loginPage = mainPage.clickSignInToPost();
        postPage = loginPage.loginToPost(UserCreationService.userName, UserCreationService.userPassword);

        Assert.assertEquals(postPage.getUser(), "AutotestUser");
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
        mainPage = null;
        loginPage = null;
        postPage = null;
    }
}
