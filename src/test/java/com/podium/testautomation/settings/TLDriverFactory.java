package com.podium.testautomation.settings;

import com.podium.testautomation.constants.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class TLDriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
    private static OptionsManager optionsManager = OptionsManager.getInstance();

    public static synchronized void setDriver(String browser) {
        if (browser.equalsIgnoreCase(Browser.CHROME)) {
            tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
        } else if (browser.equalsIgnoreCase(Browser.REMOTE_CHROME)) {
            try {
                tlDriver.set(new RemoteWebDriver(
                        new URL(System.getProperty("gridUrl")),
                        optionsManager.getRemoteChromeOptions())
                );
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

    public static synchronized WebDriverWait getWait(WebDriver driver) {
        return new WebDriverWait(driver, 20);
    }

    public static synchronized void endDriver() {
        tlDriver.get().quit();
        tlDriver.remove();
    }

}
