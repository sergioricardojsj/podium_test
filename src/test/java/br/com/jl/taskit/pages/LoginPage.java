package br.com.jl.taskit.pages;

import br.com.jl.taskit.constants.TestConstants;
import br.com.jl.taskit.settings.Log;
import br.com.jl.taskit.settings.ScreenshotMaker;
import br.com.jl.taskit.settings.TLDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public class LoginPage extends BasePage<LoginPage> {

    public LoginPage() {
        driver = TLDriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//li/child::a[text()='Sign in']")
    private WebElement signInButton;

    @FindBy(xpath = ".//div[@id='signinbox']")
    private WebElement signInLabel;

    @FindBy(xpath = ".//div[@id='signinbox']//input[@name='login']")
    private WebElement loginField;

    @FindBy(xpath = ".//div[@id='signinbox']//input[@name='password']")
    private WebElement passwdField;

    @FindBy(xpath = ".//div[@id='signinbox']//a[text()='Sign in']")
    private WebElement signInLoginButton;

    public HomePage fillLoginField() {
        fillLoginField("julio0001", "123456");
        return new HomePage();
    }

    private void fillLoginField(String login, String password) {
        goToWebSite(TestConstants.URL);
        Log.logInfo("Efetuando login: usuario <" + login + "> password: <" + password + ">");
        click(signInButton);
        waitForElementToShowUp(signInLabel);
        fillField(loginField, login);
        fillField(passwdField, password);
        click(signInLoginButton);
    }

    public void validateLogout() {
        try {
            String url = driver.getCurrentUrl();
            assertEquals(url, TestConstants.URL);
            ScreenshotMaker.takeScreenshot(false);
        } catch (AssertionError e) {
            ScreenshotMaker.takeScreenshot(true);
        }
    }

}
