package com.andersenlab.team.autotests.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Waiters {

    public static void waitForElementPresence(WebDriver driver, By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(500));
        wait
                .withMessage("Can' find element " + element)
                .until(ExpectedConditions.presenceOfElementLocated(element));

    }
}
