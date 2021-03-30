package com.podium.testautomation.tests;

import com.podium.testautomation.pages.HomePage;
import org.testng.annotations.Test;

public class BlogTest extends BaseTestCase {

    @Test
    public void shouldValidateBlogRedirect() {
        new HomePage().accessBlog().validateBlog();
    }

}
