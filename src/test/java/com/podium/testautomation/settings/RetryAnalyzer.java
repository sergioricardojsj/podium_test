package com.podium.testautomation.settings;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private static final int MAX_COUNT = 2;
    private int tried = 0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (MAX_COUNT > tried) {
            tried++;
            return true;
        }
        return false;
    }
}
