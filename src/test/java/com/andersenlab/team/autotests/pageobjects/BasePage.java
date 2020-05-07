package com.andersenlab.team.autotests.pageobjects;

import com.andersenlab.team.autotests.driver.DriverSingleton;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public abstract class BasePage {
    private final Logger log = LogManager.getRootLogger();
    private static WebDriver webDriver = DriverSingleton.getDriver();
    private String pageTitle;

    protected String getPageTitle() {
        return pageTitle;
    }

    protected static WebElement findElement(By locator) {
        return webDriver.findElement(locator);
    }

    protected static void fillTheText(By fieldLocator, String text) {
        findElement(fieldLocator).sendKeys(text);
    }

    protected static void pushTheButton(By buttonLocator) {
        findElement(buttonLocator).click();
    }

    protected static boolean elementIsVisible(By elementLocator) {
        return findElement(elementLocator).isDisplayed();
    }

    @Step("Open")
    public void open(String url) {
        log.info("Trying to open page " + url);
        webDriver.get(url);
        log.info("Page " + url + " opened");
        /*if(!onValidPage()) {
            log.error("Not on  thr valid page, Expected {}, Actual {}", getPageTitle(), webDriver.getTitle());
            Assert.fail("Not on valid page");
        } else {
            log.info("Opened page is valid");
        }*/
    }

    public boolean onValidPage() {
        log.info("webDriver.getTitle() {} -------- getPageTitle() {}", webDriver.getTitle(), getPageTitle());
        return webDriver.getTitle().equals(getPageTitle());
    }
}
