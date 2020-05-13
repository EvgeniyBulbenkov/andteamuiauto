package com.andersenlab.team.autotests.pageobjects.yandex.navigation;

import com.andersenlab.team.autotests.pageobjects.BasePage;
import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;

public class ServicesPages extends BasePage {

    @Step("Clicking page link {services}")
    public ServicesPages clickLink(Services services) {
        pushTheButton(services.getSelector());
        switchToTheTab(1);
        return this;
    }

}
