package com.andersenlab.team.autotests.pageobjects;

import com.andersenlab.team.autotests.driver.DriverSingleton;
import com.andersenlab.team.autotests.utils.Waiters;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {
    private final Logger log = LogManager.getRootLogger();
    private WebDriver webDriver = DriverSingleton.getDriver();
    private String pageTitle;

    protected String getPageTitle() {
        return pageTitle;
    }

    protected WebElement findElement(By locator) {
        return webDriver.findElement(locator);
    }

    protected void fillTheText(By fieldLocator, String text) {
        findElement(fieldLocator).sendKeys(text);
    }

    protected void pushTheButton(By buttonLocator) {
        findElement(buttonLocator).click();
    }

    protected boolean elementIsVisible(By elementLocator) {
        return findElement(elementLocator).isDisplayed();
    }

    @Step("Open {url}")
    public void open(String url) {
        webDriver.get(url);

    }

    public void waitForElementPresence(By element) {
        Waiters.waitForElementPresence(webDriver, element);
    }

}
