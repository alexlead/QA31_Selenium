package com.ait.qa31;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void createNewAccountPositiveTest() {

        String email = "artest1@artest.test";

        openRegistrationPage();

        fillCreateAccountForm(email);

        saveRegistrationForm();

        isPageCorrectUrl("https://demowebshop.tricentis.com/registerresult/1");

        confirmRegistrationContinue();

        isPageCorrectUrl("https://demowebshop.tricentis.com/");


        Assert.assertEquals(email, getElement(By.cssSelector("[href=\"/customer/info\"]")).getText());
    }

}
