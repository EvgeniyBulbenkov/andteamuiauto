package com.andersenlab.team.autotests.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                switch (System.getProperty("browser")) {
                    case "firefox": {
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;
                    }
                    case "opera": {
                        WebDriverManager.operadriver().setup();
                        driver = new OperaDriver();
                        break;
                    }
                    case "edge": {
                        WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();
                        break;
                    }
                    default: {
                        chromeDriverInit();
                    }
                }
            } catch (Exception e) {
                chromeDriverInit();
            }
        }

        setUpDriver();
        return driver;
    }

    private static void setUpDriver() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private static void chromeDriverInit() {
        WebDriverManager.chromedriver().setup();
        /*ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);*/
        driver = new ChromeDriver();
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

