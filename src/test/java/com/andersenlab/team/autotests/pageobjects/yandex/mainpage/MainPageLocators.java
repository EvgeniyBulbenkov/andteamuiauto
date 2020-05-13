package com.andersenlab.team.autotests.pageobjects.yandex.mainpage;

import org.openqa.selenium.By;

public class MainPageLocators {
    protected static final By POST_BUTTON = By.cssSelector("a[class*='button desk']");

    protected static final By LINK_VIDEO = By.cssSelector("a[data-id*='video']");
    protected static final By LINK_PICTURES = By.cssSelector("a[data-id*='images']");
    protected static final By LINK_NEWS = By.cssSelector("a[data-id*='news']");
    protected static final By LINK_MAPS = By.cssSelector("a[data-id*='maps']");
    protected static final By LINK_MARKET = By.cssSelector("a[data-id*='market']");
    protected static final By LINK_TRANSLATE = By.cssSelector("a[data-id*='translate']");
    protected static final By LINK_MUSIC = By.cssSelector("a[data-id*='music']");
}
