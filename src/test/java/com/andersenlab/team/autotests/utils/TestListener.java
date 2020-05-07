package com.andersenlab.team.autotests.utils;

import com.andersenlab.team.autotests.service.ScreenShotService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Date;

public class TestListener implements ITestListener {
    private static Logger log = LogManager.getRootLogger();
    private static int testCount;

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Running test #" + ++testCount + ". " + result.getMethod().getTestClass().getName() +
                '-' + result.getMethod().getMethodName() + " started at " + new Date());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info(result.getMethod().getTestClass().getName() + '-' + result.getMethod().getMethodName() +
                " passed at " + new Date());
        log.info("Execution time: " + (result.getEndMillis() - result.getStartMillis()) / 1000 + " seconds");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ScreenShotService.saveScreenshot();
        log.info(result.getMethod().getTestClass().getName() + '-' + result.getMethod().getMethodName() +
                " failed at " + new Date());
        log.info("Execution time: " + (result.getEndMillis() - result.getStartMillis()) / 1000 + " seconds");
        if (result.getThrowable() != null) {
            result.getThrowable().printStackTrace();
        }
    }

}
