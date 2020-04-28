package com.andersenlab.team.autotests.pageobjects;

import com.andersenlab.team.autotests.driver.DriverSingleton;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public abstract class BasePage {
    protected WebDriver webDriver = DriverSingleton.getDriver();
    private String pageTitle;
    private final Logger log = LogManager.getRootLogger();

    public String getPageTitle() {
        return pageTitle;
    }

    @Step
    public void open(String url) {
        log.info("Trying to open page " + url);
        webDriver.get(url);
        log.info("Page " + url + " opened");
        if(!onValidPage()) {
            log.error("Not on  thr valid page, Expected {}, Actual {}", getPageTitle(), webDriver.getTitle());
            Assert.fail("Not on valid page");
        } else {
            log.info("Opened page is valid");
        }
    }

    public boolean onValidPage() {
        log.info("webDriver.getTitle() {} -------- getPageTitle() {}", webDriver.getTitle(), getPageTitle());
        return webDriver.getTitle().equals(getPageTitle());
    }
}
