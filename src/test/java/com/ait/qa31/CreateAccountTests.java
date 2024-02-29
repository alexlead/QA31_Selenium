package com.ait.qa31;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void createNewAccountPositiveTest() {

        String email = "artest2@artest.test";

        openRegistrationPage();
        fillCreateAccountForm(email);
        saveRegistrationForm();
        confirmRegistrationContinue();
        Assert.assertEquals(actualRegisteredEmail(), email);
    }

}
