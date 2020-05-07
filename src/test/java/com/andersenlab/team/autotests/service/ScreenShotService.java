package com.andersenlab.team.autotests.service;

import com.andersenlab.team.autotests.driver.DriverSingleton;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenShotService {
    private static Logger log = LogManager.getRootLogger();

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshot() {
        return ((TakesScreenshot) DriverSingleton
                .getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
