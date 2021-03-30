package com.podium.testautomation.pages;

import com.podium.testautomation.settings.TLDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "(.//a[text()='Login'])[1]")
    private WebElement loginButton;

    @FindBy(xpath = ".//a[text()='Resources']/parent::h4/following-sibling::a[text()='Blog']")
    private WebElement blogLink;

    @FindBy(xpath = ".//a[text()='Request Demo']")
    private WebElement requestDemoLink;

    public HomePage() {
        driver = TLDriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    private void accessPodium() {
        driver.navigate().to("https://podium.com");
    }

    public LoginPage goToLogin() {
        accessPodium();
        waitPageLoad();
        click(loginButton);
        return new LoginPage();
    }

    public BlogPage accessBlog() {
        accessPodium();
        waitPageLoad();
        click(blogLink);
        return new BlogPage();
    }

    public RequestDemoPage accessRequestDemo() {
        accessPodium();
        waitPageLoad();
        click(requestDemoLink);

        return new RequestDemoPage();
    }

}
