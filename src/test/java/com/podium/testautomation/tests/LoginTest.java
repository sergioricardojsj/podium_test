package com.podium.testautomation.tests;

import com.podium.testautomation.pages.HomePage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTestCase {

    @Test
    public void shouldValidateInvalidLogin() {
        new HomePage().goToLogin().validateLoginWithInvalidInformations();
    }

    @Test
    public void shouldValidateLoginWithoutPassword() {
        new HomePage().goToLogin().validateLoginWithoutPassword();
    }

    @Test
    public void shouldValidateLoginWithoutEmail() {
        new HomePage().goToLogin().validateLoginWithoutEmail();
    }


}
