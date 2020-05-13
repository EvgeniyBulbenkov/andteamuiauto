package com.andersenlab.team.autotests.pageobjects;

import com.andersenlab.team.autotests.driver.DriverSingleton;
import com.andersenlab.team.autotests.utils.Waiters;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

import java.util.ArrayList;

public abstract class BasePage {
    private final Logger log = LogManager.getRootLogger();
    private WebDriver webDriver = DriverSingleton.getDriver();
    private ArrayList<String> tabs;

    public String getPageTitle() {
        return webDriver.getTitle();
    }

    private WebElement findElement(By locator) {
        return webDriver.findElement(locator);
    }

    protected void fillTheText(By fieldLocator, String text) {
        findElement(fieldLocator).sendKeys(text);
    }

    protected void pushTheButton(By buttonLocator) {
        waitForElementPresence(buttonLocator);
        findElement(buttonLocator).click();
    }

    protected String getElementText(By fieldLocator) {
        return findElement(fieldLocator).getText();
    }

    protected boolean elementIsVisible(By elementLocator) {
        try {
            return findElement(elementLocator).isDisplayed();
        } catch (NoSuchElementException e) {
            log.error(e.getMessage());
            log.error(e.getStackTrace());
            return false;
        }
    }

    @Step("Open {url}")
    public void open(String url) {
        webDriver.get(url);
    }

    public void waitForElementPresence(By element) {
        Waiters.waitForElementPresence(webDriver, element);
    }

    public void switchToTheTab(int tab) {
        if (tabs == null) {
            tabs = new ArrayList<>(webDriver.getWindowHandles());
        }
        webDriver.switchTo().window(tabs.get(tab));
        log.info("Checked out to browser tab #" + tab);
    }

}
