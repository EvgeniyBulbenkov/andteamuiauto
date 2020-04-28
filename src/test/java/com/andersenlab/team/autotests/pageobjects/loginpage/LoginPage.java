package com.andersenlab.team.autotests.pageobjects.loginpage;

import com.andersenlab.team.autotests.pageobjects.BasePage;
import com.andersenlab.team.autotests.pageobjects.teammainpage.TeamMainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.andersenlab.team.autotests.pageobjects.loginpage.LoginPageLocators.*;
import static com.andersenlab.team.autotests.pageobjects.teammainpage.TeamMainPageLocators.PORTAL_HEADER;

public class LoginPage extends BasePage {
    private final String pageTitle = "Andersen SSO";

    public String getPageTitle() {
        return pageTitle;
    }

    @Step
    public LoginPage fillInLogin(String login) {
        webDriver.findElement(LOGIN_FIELD).sendKeys(login);
        return this;
    }

    @Step
    public LoginPage fillInPassword(String password) {
        webDriver.findElement(PASSWORD_FIELD).sendKeys(password);
        return this;
    }

    @Step
    public TeamMainPage pushSubmitButton() {
        webDriver.findElement(SIGN_IN_BUTTON).click();
        WebElement linkLoggedInUser = new WebDriverWait(webDriver, Duration.ofSeconds(15))
                .until(driver -> driver.findElement(PORTAL_HEADER));
        return new TeamMainPage();
    }
}
