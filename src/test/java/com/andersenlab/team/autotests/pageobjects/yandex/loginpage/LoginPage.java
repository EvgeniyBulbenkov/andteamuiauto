package com.andersenlab.team.autotests.pageobjects.yandex.loginpage;

import com.andersenlab.team.autotests.pageobjects.BasePage;
import com.andersenlab.team.autotests.pageobjects.yandex.music.MusicPage;
import com.andersenlab.team.autotests.pageobjects.yandex.music.MusicPageLocators;
import com.andersenlab.team.autotests.pageobjects.yandex.postpage.PostPage;
import io.qameta.allure.Step;

import static com.andersenlab.team.autotests.pageobjects.yandex.loginpage.LoginPageLocators.*;

public class LoginPage extends BasePage {

    @Step("Fill in login {login}")
    public LoginPage fillInLogin(String login) {
        fillTheText(LOGIN_FIELD, login);
        return this;
    }

    @Step("Fill in password {password}")
    public LoginPage fillInPassword(String password) {
        fillTheText(PASSWORD_FIELD, password);
        return this;
    }

    @Step("Push Sign_In button")
    public LoginPage pushSignInButton() {
        pushTheButton(SIGN_IN_BUTTON);
        return this;
    }

    public String getErrorMessage() {
        return getElementText(ERROR_FIELD);
    }

    @Step("Login to Yandex Music Page with {login} and {password}")
    public MusicPage loginToMusic(String login, String password) {
        fillInLogin(login)
                .pushSignInButton()
                .fillInPassword(password)
                .pushSignInButton();
                switchToTheTab(0);
                waitForElementPresence(MusicPageLocators.AVATAR);
        return new MusicPage();
    }

    @Step("Login to Yandex Post Page with {login} and {password}")
    public PostPage loginToPost(String login, String password) {
        fillInLogin(login)
                .pushSignInButton()
                .fillInPassword(password)
                .pushSignInButton();
        return new PostPage();
    }

}
