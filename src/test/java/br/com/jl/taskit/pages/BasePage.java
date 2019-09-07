package br.com.jl.taskit.pages;

import br.com.jl.taskit.settings.Log;
import br.com.jl.taskit.settings.ScreenshotMaker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.NoSuchElementException;

import static br.com.jl.taskit.settings.TLDriverFactory.getWait;
import static org.testng.Assert.fail;

public abstract class BasePage<T> {

    protected WebDriver driver;

    public void click(Object webElement) {
        try {
            if (webElement instanceof By) {
                click(driver.findElement((By) webElement));
            } else if (webElement instanceof WebElement) {
                click((WebElement) webElement);
            }
        } catch (Exception e) {

        }
    }

    private void click(WebElement element) {
        try {
            waitForClickableElement(element);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollTo(0, " + element.getLocation().y + ")");
            element.click();
        } catch (NoSuchElementException e) {
            ScreenshotMaker.takeScreenshot(true);
            Log.logError("Erro ao tentar clicar no elemento: " + e.getMessage());
            fail();
        }
    }

    public void fillField(Object element, String keysToKend) {
        try {
            if (element instanceof By) {
                fillField(driver.findElement((By) element), keysToKend);
            } else if (element instanceof WebElement) {
                fillField((WebElement) element, keysToKend);
            }
        } catch (Exception e) {

        }
    }

    private void fillField(WebElement element, String keysToSend) {
        try {
            element.sendKeys(Keys.CLEAR);
            element.clear();
            element.sendKeys(keysToSend);
        } catch (NoSuchElementException e) {
            ScreenshotMaker.takeScreenshot(true);
            Log.logError("Erro ao tentar preencher o campo: " + e.getMessage());
            fail();
        }
    }

    public void goToWebSite(String url) {
        try {
            driver.navigate().to(url);
            Log.logInfo("Acessando o site... " + url);
        } catch (Exception e) {
            ScreenshotMaker.takeScreenshot(true);
            Log.logError("Não foi possivel acessar o site: " + url + " " + e.getMessage());
            fail();
        }
    }

    private void waitForClickableElement(WebElement element) {
        try {
            getWait(driver).until(ExpectedConditions.elementToBeClickable(element));
        } catch (NoSuchElementException e) {
            ScreenshotMaker.takeScreenshot(true);
            Log.logError("Erro ao esperar o elemento clicável: " + e.getMessage());
            fail();
        }
    }

    public void waitForClickableElement(Object element) {
        try {
            if (element instanceof By) {
                getWait(driver).until(ExpectedConditions.elementToBeClickable((By) element));
            } else if (element instanceof WebDriver) {
                waitForClickableElement((WebElement) element);
            }
        } catch (Exception e) {

        }
    }

    private void waitForElementToShowUp(WebElement element) {
        try {
            getWait(driver).until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException e) {
            ScreenshotMaker.takeScreenshot(true);
            Log.logError("Erro ao tentar preencher o campo: " + e.getMessage());
            fail();
        }
    }

    public void waitForElementToShowUp(Object element) {
        try {
            if (element instanceof By) waitForElementToShowUp(driver.findElement((By) element));
            else if (element instanceof WebElement) waitForElementToShowUp((WebElement) element);
        } catch (Exception e) {

        }
    }

}
