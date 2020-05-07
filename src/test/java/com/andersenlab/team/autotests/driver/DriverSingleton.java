package com.andersenlab.team.autotests.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    static Logger log = LogManager.getRootLogger();
//    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
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
                log.info("Property 'driver' was not set, setting up the default browser - Chrome");
                chromeDriverInit();
            }
        }

        setUpDriver();
        log.info("Initiated of driver successfully. Driver:" + driver.getClass().getName());
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

