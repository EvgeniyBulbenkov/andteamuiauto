package com.andersenlab.team.autotests.tests.yandex.navigation;

import com.andersenlab.team.autotests.pageobjects.yandex.navigation.Services;
import com.andersenlab.team.autotests.pageobjects.yandex.navigation.ServicesPages;
import com.andersenlab.team.autotests.tests.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.andersenlab.team.autotests.pageobjects.yandex.navigation.Services.*;

public class YandexMainPageNavigationTest extends BaseTest {
    ServicesPages servicesPage;
    String pageTitle;

    @BeforeMethod
    public void setUp() {
        servicesPage = new ServicesPages();
        servicesPage.open("http://yandex.ru");
    }

    @Test(description = "Main Yandex Page Navigation")
    @Issue("001")
    @TmsLink("Nav-1")
    @Epic("Main Page Navigation")
    @Story("Navigate to the Video Page")
    @Severity(SeverityLevel.CRITICAL)
    public void videoLinkOpen() {
        servicesPage.clickLink(VIDEO);

        Assert.assertEquals(servicesPage.getPageTitle(), "Фильмы — Смотреть в Эфире");
    }
    @Test(description = "Main Yandex Page Navigation")
    @Issue("002")
    @TmsLink("Nav-2")
    @Epic("Main Page Navigation")
    @Story("Navigate to the Pictures Page")
    @Severity(SeverityLevel.CRITICAL)
    public void picturesLinkOpen() {
        servicesPage.clickLink(PICTURES);

        Assert.assertEquals(servicesPage.getPageTitle(), "Яндекс.Картинки: поиск изображений в интернете," +
                " поиск по картинке");
    }
    @Test(description = "Main Yandex Page Navigation")
    @Issue("003")
    @TmsLink("Nav-3")
    @Epic("Main Page Navigation")
    @Story("Navigate to the News Page")
    @Severity(SeverityLevel.CRITICAL)
    public void newsLinkOpen() {
        servicesPage.clickLink(NEWS);

        Assert.assertEquals(servicesPage.getPageTitle(), "Яндекс.Новости: Главные новости сегодня," +
                " самые свежие и последние новости Беларуси онлайн");
    }
    @Test(description = "Main Yandex Page Navigation")
    @Issue("004")
    @TmsLink("Nav-4")
    @Epic("Main Page Navigation")
    @Story("Navigate to the Video Page")
    @Severity(SeverityLevel.CRITICAL)
    public void mapsLinkOpen() {
        servicesPage.clickLink(MAPS);

        Assert.assertEquals(servicesPage.getPageTitle(), "Яндекс.Карты — поиск мест и адресов," +
                " городской транспорт");
    }
    @Test(description = "Main Yandex Page Navigation")
    @Issue("005")
    @TmsLink("Nav-5")
    @Epic("Main Page Navigation")
    @Story("Navigate to the Market Page")
    @Severity(SeverityLevel.CRITICAL)
    public void marketLinkOpen() {
        servicesPage.clickLink(MARKET);

        Assert.assertEquals(servicesPage.getPageTitle(), "Яндекс.Маркет — выбор и покупка товаров из" +
                " проверенных интернет-магазинов");
    }
    @Test(description = "Main Yandex Page Navigation")
    @Issue("006")
    @TmsLink("Nav-6")
    @Epic("Main Page Navigation")
    @Story("Navigate to the Translate Page")
    @Severity(SeverityLevel.CRITICAL)
    public void translateLinkOpen() {
        servicesPage.clickLink(TRANSLATE);

        Assert.assertEquals(servicesPage.getPageTitle(), "Яндекс.Переводчик – словарь и онлайн " +
                "перевод на английский, русский, немецкий, французский, украинский и другие языки.");
    }
    @Test(description = "Main Yandex Page Navigation")
    @Issue("007")
    @TmsLink("Nav-7")
    @Epic("Main Page Navigation")
    @Story("Navigate to the Music Page")
    @Severity(SeverityLevel.CRITICAL)
    public void musicLinkOpen() {
        servicesPage.clickLink(MUSIC);

        Assert.assertEquals(servicesPage.getPageTitle(), "Яндекс.Музыка");
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
        servicesPage = null;
    }

}
