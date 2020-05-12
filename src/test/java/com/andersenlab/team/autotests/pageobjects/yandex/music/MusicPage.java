package com.andersenlab.team.autotests.pageobjects.yandex.music;

import com.andersenlab.team.autotests.pageobjects.BasePage;
import com.andersenlab.team.autotests.pageobjects.yandex.loginpage.LoginPage;

import static com.andersenlab.team.autotests.pageobjects.yandex.music.MusicPageLocators.*;


public class MusicPage extends BasePage {

    public LoginPage clickSignInButton() {
        pushTheButton(SIGN_IN_BUTTON);
        switchToTheTab(1);
        return new LoginPage();
    }

    public String getUser() {
        String user;
        pushTheButton(AVATAR);
        return getElementText(USER_NAME);
    }

}
