package com.podium.testautomation.tests;

import com.podium.testautomation.pages.HomePage;
import org.testng.annotations.Test;

public class DemoTest extends BaseTestCase {

    @Test
    public void shouldValidateRequiredField() {
        new HomePage().accessRequestDemo().watchDemoWithoutFillingFields();
    }

}
