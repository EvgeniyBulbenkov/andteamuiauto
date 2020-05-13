package com.andersenlab.team.autotests.pageobjects.yandex.music;

import org.openqa.selenium.By;

public class MusicPageLocators {
    protected static final By SIGN_IN_BUTTON = By.cssSelector("[class*=\"log-in\"]");
    public static final By AVATAR = By.xpath("//div[@class='user__userpic user__userpic_size_L ']");
    protected static final By USER_NAME = By.xpath("//div[@class='multi-auth__user-name typo']");

}
