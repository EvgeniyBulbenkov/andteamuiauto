package com.andersenlab.team.autotests.tests.yandex.music;

import com.andersenlab.team.autotests.pageobjects.yandex.loginpage.LoginPage;
import com.andersenlab.team.autotests.pageobjects.yandex.music.MusicPage;
import com.andersenlab.team.autotests.service.UserCreationService;
import com.andersenlab.team.autotests.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YandexMusicTest extends BaseTest {
    MusicPage musicPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        musicPage = new MusicPage();
        musicPage.open("http://music.yandex.ru");
    }

    @Test
    public void validSignIn() {
        loginPage = musicPage.clickSignInButton();
        musicPage = loginPage.loginToMusic(UserCreationService.userName, UserCreationService.userPassword);

        Assert.assertEquals(musicPage.getUser(), "AutotestUser");

    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
        musicPage = null;
        loginPage = null;
    }

}
