package com.andersenlab.team.autotests.pageobjects.yandex.postpage;

import com.andersenlab.team.autotests.pageobjects.BasePage;
import com.andersenlab.team.autotests.pageobjects.yandex.mainpage.MainPage;

import static com.andersenlab.team.autotests.pageobjects.yandex.postpage.PostPageLocators.*;

public class PostPage extends BasePage {

    public String getUser() {
        return getElementText(USER_NAME);
    }

    public MainPage signOut() {
        pushTheButton(AVATAR);
        pushTheButton(SIGN_OUT_BUTTON);
        return new MainPage();
    }
}
