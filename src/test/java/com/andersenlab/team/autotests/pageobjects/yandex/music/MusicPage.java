package com.andersenlab.team.autotests.pageobjects.yandex.music;

import com.andersenlab.team.autotests.pageobjects.BasePage;
import com.andersenlab.team.autotests.pageobjects.yandex.loginpage.LoginPage;

import static com.andersenlab.team.autotests.pageobjects.yandex.music.MusicPageLocators.SIGN_IN_BUTTON;


public class MusicPage extends BasePage {

    public LoginPage clickSignInButton() {
        pushTheButton(SIGN_IN_BUTTON);
        return new LoginPage();
    }

    /*public static MusicPage open(String url) {
        open(url);
        return new MusicPage();
    }*/
}
