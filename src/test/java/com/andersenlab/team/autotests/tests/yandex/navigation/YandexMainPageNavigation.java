package com.andersenlab.team.autotests.tests.yandex.navigation;

import com.andersenlab.team.autotests.pageobjects.yandex.mainpage.MainPage;
import com.andersenlab.team.autotests.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YandexMainPageNavigation extends BaseTest {
    MainPage mainPage;
    String pageTitle;

    @BeforeMethod
    public void setUp() {
        mainPage = new MainPage();
        mainPage.open("http://yandex.ru");
    }

    @Test
    public void videoLinkOpen() {

    }
}
