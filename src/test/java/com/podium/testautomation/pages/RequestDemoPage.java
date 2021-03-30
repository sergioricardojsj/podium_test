package com.podium.testautomation.pages;

import com.podium.testautomation.settings.TLDriverFactory;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestDemoPage extends BasePage {

    @FindBy(xpath = ".//button[text()='Watch Demo']")
    private WebElement watchDemoButton;

    @FindBy(id = "ValidMsgFirstName")
    private WebElement firstNameRequiredMessage;

    public RequestDemoPage() {
        driver = TLDriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void watchDemoWithoutFillingFields() {
        waitPageLoad();
        click(watchDemoButton);

        waitForElementToShowUp(firstNameRequiredMessage);
        MatcherAssert.assertThat(firstNameRequiredMessage.getText(), CoreMatchers.equalTo("This field is required."));
    }

}
