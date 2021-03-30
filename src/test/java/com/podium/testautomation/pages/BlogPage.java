package com.podium.testautomation.pages;

import com.podium.testautomation.settings.TLDriverFactory;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.support.PageFactory;

public class BlogPage extends BasePage {

    public BlogPage() {
        driver = TLDriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void validateBlog() {
        MatcherAssert.assertThat(getTitle(), Matchers.containsString("Podium Blog - Best Practices"));
    }

}
