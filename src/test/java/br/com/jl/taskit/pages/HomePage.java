package br.com.jl.taskit.pages;

import br.com.jl.taskit.settings.Log;
import br.com.jl.taskit.settings.ScreenshotMaker;
import br.com.jl.taskit.settings.TLDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class HomePage extends BasePage<HomePage> {

    public HomePage() {
        driver = TLDriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//a[@class='me']")
    private WebElement meElement;

    @FindBy(xpath = ".//a[text()='My tasks']")
    private WebElement botaoMyTasks;

    @FindBy(xpath = ".//button[contains(text(), 'Add')]")
    private WebElement botaoAddTask;

    @FindBy(xpath = ".//a[text()='Logout']")
    private WebElement botaoLogout;

    public void validateLogin() {
        waitForElementToShowUp(meElement);
        try {
            assertEquals(meElement.getText().trim(), "Hi, Julio");
            ScreenshotMaker.takeScreenshot(false);
            Log.logInfo("O texto " + meElement.getText().trim() + " foi encontrado!");
        } catch (AssertionError e) {
            ScreenshotMaker.takeScreenshot(true);
            Log.logInfo("Elemento não encontrado! " + e.getMessage());
            fail();
        }
    }

    public LoginPage logout() {
        click(botaoLogout);
        return new LoginPage();
    }

}
