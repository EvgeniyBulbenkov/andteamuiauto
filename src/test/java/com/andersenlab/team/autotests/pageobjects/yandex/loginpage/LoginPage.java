package com.andersenlab.team.autotests.pageobjects.yandex.loginpage;

import com.andersenlab.team.autotests.pageobjects.BasePage;
import com.andersenlab.team.autotests.pageobjects.yandex.music.MusicPage;
import com.andersenlab.team.autotests.pageobjects.yandex.postpage.PostPage;

import static com.andersenlab.team.autotests.pageobjects.yandex.loginpage.LoginPageLocators.*;

public class LoginPage extends BasePage {

    public LoginPage fillInLogin(String login) {
        fillTheText(LOGIN_FIELD, login);
        return this;
    }

    public LoginPage fillInPassword(String password) {
        fillTheText(PASSWORD_FIELD, password);
        return this;
    }

    public LoginPage pushSignInButton() {
        pushTheButton(SIGN_IN_BUTTON);
        return this;
    }

    public boolean errorMessageIsDisplayed() {
        return  elementIsVisible(ERROR_FIELD);
    }

    public String getErrorMessage() {
        return getElementText(ERROR_FIELD);
    }

    public void tryToLogin(String login, String password) {
        fillInLogin(login)
                .pushSignInButton()
                .fillInPassword(password)
                .pushSignInButton();
    }

    public MusicPage loginToMusic(String login, String password) {
        fillInLogin(login)
                .pushSignInButton()
                .fillInPassword(password)
                .pushSignInButton();
                switchToTheTab(0);
        return new MusicPage();
    }

    public PostPage loginToPost(String login, String password) {
        fillInLogin(login)
                .pushSignInButton()
                .fillInPassword(password)
                .pushSignInButton();
        return new PostPage();
    }

}
