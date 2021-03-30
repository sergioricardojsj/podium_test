package com.podium.testautomation.pages;

import com.podium.testautomation.settings.TLDriverFactory;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "emailOrPhoneInput")
    private WebElement emailField;

    @FindBy(id = "passwordInput")
    private WebElement passwordField;

    @FindBy(id = "signInButton")
    private WebElement nextButton;

    @FindBy(xpath = ".//div[@class='sc-hzDkRC hxavQn']")
    private WebElement message;

    @FindBy(xpath = ".//input[@id='passwordInput']/following-sibling::div")
    private WebElement passwordRequiredMessage;

    @FindBy(xpath = ".//input[@id='emailOrPhoneInput']/following-sibling::div")
    private WebElement emailOrMobilePhoneRequiredMessage;

    public LoginPage() {
        driver = TLDriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void validateLoginWithInvalidInformations() {
        waitPageLoad();
        fillField(emailField, "sergioricardojsj@gmail.com");
        click(nextButton);

        waitForElementToShowUp(passwordField);
        fillField(passwordField, "password123456");
        click(nextButton);

        waitForElementToShowUp(message);
        MatcherAssert.assertThat(message.getText(), CoreMatchers.containsString("Incorrect email or password."));
    }

    public void validateLoginWithoutEmail() {
        waitPageLoad();
        click(nextButton);

        waitForElementToShowUp(emailOrMobilePhoneRequiredMessage);
        MatcherAssert.assertThat(emailOrMobilePhoneRequiredMessage.getText(), CoreMatchers.equalTo("Email or mobile number is required"));
    }

    public void validateLoginWithoutPassword() {
        waitPageLoad();
        fillField(emailField, "sergioricardojsj@gmail.com");
        click(nextButton);

        waitForElementToShowUp(passwordField);
        click(nextButton);

        waitForElementToShowUp(passwordRequiredMessage);
        MatcherAssert.assertThat(passwordRequiredMessage.getText(), CoreMatchers.equalTo("Password is required"));
    }

}
