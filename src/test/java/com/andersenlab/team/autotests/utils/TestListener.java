package com.andersenlab.team.autotests.utils;

import com.andersenlab.team.autotests.service.ScreenShotService;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        ScreenShotService.saveScreenshot();
    }

}
