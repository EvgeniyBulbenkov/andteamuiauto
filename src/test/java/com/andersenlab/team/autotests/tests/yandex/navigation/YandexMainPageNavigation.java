package com.andersenlab.team.autotests.tests.yandex.navigation;

import com.andersenlab.team.autotests.pageobjects.yandex.mainpage.MainPage;
import com.andersenlab.team.autotests.tests.BaseTest;
import io.qameta.allure.*;
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

    @Test(description = "Main Yandex Page Navigation")
    @Issue("001")
    @TmsLink("Nav-1")
    @Epic("Main Page Navigation")
    @Story("Navigate to the Video Page")
    @Severity(SeverityLevel.CRITICAL)
    public void videoLinkOpen() {

    }
}
