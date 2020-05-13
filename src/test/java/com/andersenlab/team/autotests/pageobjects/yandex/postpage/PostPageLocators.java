package com.andersenlab.team.autotests.pageobjects.yandex.postpage;

import org.openqa.selenium.By;

public class PostPageLocators {
    protected static final By USER_NAME = By.cssSelector("div[class='mail-User-Name']");
    protected static final By AVATAR = By.xpath("//div[@class=\"mail-User-Name\"]/..");
    protected static final By SIGN_OUT_BUTTON = By.cssSelector("a[href*='embeddedauth']");
}
