package com.andersenlab.team.autotests.pageobjects.yandex.mainpage;

import com.andersenlab.team.autotests.pageobjects.BasePage;
import com.andersenlab.team.autotests.pageobjects.yandex.loginpage.LoginPage;

import static com.andersenlab.team.autotests.pageobjects.yandex.mainpage.MainPageLocators.POST_BUTTON;

public class MainPage extends BasePage {

    public LoginPage clickSignInToPost() {
        pushTheButton(POST_BUTTON);
        switchToTheTab(1);
        return new LoginPage();
    }
}
