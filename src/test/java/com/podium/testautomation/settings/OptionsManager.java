package com.podium.testautomation.settings;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public class OptionsManager {

    private static OptionsManager optionsManager;

    private OptionsManager() {  }

    public static OptionsManager getInstance() {
        if (optionsManager == null) {
            synchronized (OptionsManager.class) {
                if (optionsManager == null) {
                    optionsManager = new OptionsManager();
                }
            }
        }
        return optionsManager;
    }

    public ChromeOptions getChromeOptions() {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.home") + "/Downloads");

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");

        System.setProperty("webdriver.chrome.args", "--disable-logging");
        System.setProperty("webdriver.chrome.silentOutput", "true");

        chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        chromeOptions.addArguments("disable-infobars"); // disabling infobars
        chromeOptions.addArguments("--disable-extensions"); // disabling extensions
        chromeOptions.addArguments("window-size=1920,1080");

        System.setProperty(
                "webdriver.chrome.driver",
                "/app/bin/chromedriver"
        );

        /*System.setProperty(
                "webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/test/resources/chromedriver"
        ); */

        return chromeOptions;
    }

    public DesiredCapabilities getRemoteChromeOptions() {
        try {
            ChromeOptions chromeOptions = getChromeOptions();
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setPlatform(Platform.LINUX);
            capabilities.setCapability("chrome.verbose", true);
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            return capabilities;
        } catch (Exception e) {
            Log.logError(e.getMessage());
        }
        return null;
    }

}
