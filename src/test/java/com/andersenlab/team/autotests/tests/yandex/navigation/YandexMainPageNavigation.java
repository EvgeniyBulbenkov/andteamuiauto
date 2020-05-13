package com.andersenlab.team.autotests.tests.yandex.navigation;

import com.andersenlab.team.autotests.pageobjects.yandex.mainpage.MainPage;
import com.andersenlab.team.autotests.tests.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
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
    @Epic("Main Page Navigation")
    @Story("Navigate to the Video Page")
    @Severity(SeverityLevel.CRITICAL)
    public void videoLinkOpen() {

    }
}
