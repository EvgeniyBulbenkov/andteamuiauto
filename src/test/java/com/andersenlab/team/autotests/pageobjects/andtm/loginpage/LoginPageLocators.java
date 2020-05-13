package com.andersenlab.team.autotests.pageobjects.andtm.loginpage;

import org.openqa.selenium.By;

public class LoginPageLocators {
    protected static final By LOGIN_FIELD = By.id("login");
    protected static final By PASSWORD_FIELD = By.id("password");
    protected static final By SIGN_IN_BUTTON = By.className("btn-submit");
    protected static final By FORGOT_PASSWORD_BUTTON = By.className("forgot-link");
    protected static final By LOGIN_ERROR_MESSAGE = By.xpath("(//span[@class='form-error ng-star-inserted'])[1]");
    protected static final By PASSWORD_ERROR_MESSAGE = By.xpath("(//span[@class='form-error ng-star-inserted'])[2]");

}
