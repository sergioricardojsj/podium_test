package com.podium.testautomation.listeners;

import com.podium.testautomation.constants.Browser;
import com.podium.testautomation.settings.TLDriverFactory;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class InvokedMethodListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            String browser = method.getTestMethod().getXmlTest().getLocalParameters().get("browser");

            if (browser == null) {
                TLDriverFactory.setDriver(Browser.CHROME);
            } else {
                TLDriverFactory.setDriver(browser);
            }
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            if (TLDriverFactory.getDriver() != null) {
                TLDriverFactory.endDriver();
            }
        }
    }

}
