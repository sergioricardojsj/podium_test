package br.com.jl.taskit.settings;

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

        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("disable-extensions");
        chromeOptions.addArguments("disable-popup-blocking");

        System.setProperty(
                "webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/test/resources/chromedriver"
        );

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
