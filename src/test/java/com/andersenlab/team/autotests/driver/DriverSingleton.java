package com.andersenlab.team.autotests.driver;

import com.andersenlab.team.autotests.utils.WebDriverListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    static Logger log = LogManager.getRootLogger();
//    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    private static EventFiringWebDriver driver;

    private DriverSingleton() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                switch (System.getProperty("browser")) {
                    case "firefox": {
                        WebDriverManager.firefoxdriver().setup();
                        driver = new EventFiringWebDriver(new FirefoxDriver());
                        break;
                    }
                    case "opera": {
                        WebDriverManager.operadriver().setup();
                        driver = new EventFiringWebDriver(new OperaDriver());
                        break;
                    }
                    case "edge": {
                        WebDriverManager.edgedriver().setup();
                        driver = new EventFiringWebDriver(new EdgeDriver());
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

        driver.register(new WebDriverListener());
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
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--headless"); //should be enabled for Jenkins
        options.addArguments("--disable-dev-shm-usage"); //should be enabled for Jenkins
        options.addArguments("--window-size=1920x1080");
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless", "--no-sandbox");
//        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//        driver = new ChromeDriver(chromeOptions);
        driver = new EventFiringWebDriver(new ChromeDriver(options));
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

