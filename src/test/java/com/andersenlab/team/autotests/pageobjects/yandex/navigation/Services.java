package com.andersenlab.team.autotests.pageobjects.yandex.navigation;

import org.openqa.selenium.By;

public enum Services {
    VIDEO (By.cssSelector("a[data-id*='video']")),
    PICTURES (By.cssSelector("a[data-id*='images']")),
    NEWS (By.cssSelector("a[data-id*='news']")),
    MAPS (By.cssSelector("a[data-id*='maps']")),
    MARKET (By.cssSelector("a[data-id*='market']")),
    TRANSLATE (By.cssSelector("a[data-id*='translate']")),
    MUSIC (By.cssSelector("a[data-id*='music']"));

    private By selector;

    Services(By selector) {
        this.selector = selector;
    }

    public By getSelector() {
        return selector;
    }
}
