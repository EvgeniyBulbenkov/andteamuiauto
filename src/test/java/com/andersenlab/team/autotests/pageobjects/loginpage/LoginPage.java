package com.andersenlab.team.autotests.pageobjects.loginpage;

import com.andersenlab.team.autotests.pageobjects.BasePage;
import com.andersenlab.team.autotests.pageobjects.teammainpage.TeamMainPage;
import io.qameta.allure.Step;

import static com.andersenlab.team.autotests.pageobjects.loginpage.LoginPageLocators.*;

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

    public boolean loginErrMessageIsVisible() {
        return elementIsVisible(LOGIN_ERROR_MESSAGE);
    }

    public boolean passwordErrMessageIsVisible() {
        return elementIsVisible(PASSWORD_ERROR_MESSAGE);
    }




/*

    public static void logIn() {
        logIn(UserCreationService.userName, UserCreationService.userPassword);
    }

    public static void logIn(String login, String password) {

    }
*/

    @Step
    public TeamMainPage pushSubmitButton() {
        pushTheButton(SIGN_IN_BUTTON);
        /*WebElement linkLoggedInUser = new WebDriverWait(DriverSingleton.getDriver(), Duration.ofSeconds(15))
                .until(driver -> driver.findElement(PORTAL_HEADER));*/
        return new TeamMainPage();
    }
}
