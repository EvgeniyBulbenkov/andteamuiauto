package com.andersenlab.team.autotests.pageobjects.yandex.loginpage;

import org.openqa.selenium.By;

public class LoginPageLocators {
    protected static final By LOGIN_FIELD = By.cssSelector("#passp-field-login");
    protected static final By PASSWORD_FIELD = By.cssSelector("#passp-field-passwd");
    protected static final By PASSWORD_ERROR_FIELD = By.cssSelector("div[class*='passp-form-field__error']");
    protected static final By SIGN_IN_BUTTON = By.cssSelector("button[type='submit']");

}
