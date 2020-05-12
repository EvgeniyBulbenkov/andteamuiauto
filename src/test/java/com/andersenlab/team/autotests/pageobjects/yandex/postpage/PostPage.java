package com.andersenlab.team.autotests.pageobjects.yandex.postpage;

import com.andersenlab.team.autotests.pageobjects.BasePage;

import static com.andersenlab.team.autotests.pageobjects.yandex.postpage.PostPageLocators.USER_NAME;

public class PostPage extends BasePage {

    public String getUser() {
        return getElementText(USER_NAME);
    }
}
