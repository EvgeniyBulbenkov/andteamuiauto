package com.andersenlab.team.autotests.pageobjects.loginpage;

import com.andersenlab.team.autotests.pageobjects.BasePage;
import com.andersenlab.team.autotests.pageobjects.teammainpage.TeamMainPage;
import com.andersenlab.team.autotests.service.UserCreationService;
import io.qameta.allure.Step;

import static com.andersenlab.team.autotests.pageobjects.loginpage.LoginPageLocators.*;
import static com.andersenlab.team.autotests.pageobjects.teammainpage.TeamMainPageLocators.PORTAL_HEADER;

public class LoginPage extends BasePage {
    private final String pageTitle = "Andersen SSO";

    public String getPageTitle() {
        return pageTitle;
    }

    @Step
    public LoginPage fillInLogin(String login) {
        fillTheText(LOGIN_FIELD, login);
        return this;
    }

    @Step
    public LoginPage fillInPassword(String password) {
        fillTheText(PASSWORD_FIELD, password);
        return this;
    }

    @Step("Checking visibility of message 'Field is required' under login field")
    public boolean loginErrMessageIsVisible() {
        return elementIsVisible(LOGIN_ERROR_MESSAGE);
    }

    @Step("Checking visibility of message 'Field is required' under password field")
    public boolean passwordErrMessageIsVisible() {
        return elementIsVisible(PASSWORD_ERROR_MESSAGE);
    }

    @Step("Pushing 'Sign in' button")
    public LoginPage pushSubmitButton() {
        pushTheButton(SIGN_IN_BUTTON);
        /*WebElement linkLoggedInUser = new WebDriverWait(DriverSingleton.getDriver(), Duration.ofSeconds(15))
                .until(driver -> driver.findElement(PORTAL_HEADER));*/
        return this;
    }

    @Step("Log in with default creds (from file creds.properties)")
    public TeamMainPage logIn() {
        logIn(UserCreationService.userName, UserCreationService.userPassword);
        waitForElementPresence(PORTAL_HEADER);
        return new TeamMainPage();
    }

    @Step("Log in with creds: {login} and {password}")
    public TeamMainPage logIn(String login, String password) {
        fillInLogin(login);
        fillInPassword(password);
        pushSubmitButton();
        waitForElementPresence(PORTAL_HEADER);
        return new TeamMainPage();
    }
}
