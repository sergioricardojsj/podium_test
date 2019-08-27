package br.com.jl.taskit.listeners;

import br.com.jl.taskit.constants.Browser;
import br.com.jl.taskit.constants.TestConstants;
import br.com.jl.taskit.settings.TLDriverFactory;
import br.com.jl.taskit.settings.Utils;
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

            Utils.METHOD_NAME = method.getTestMethod().getMethodName();
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
