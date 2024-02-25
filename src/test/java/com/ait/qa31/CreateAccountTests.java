package com.ait.qa31;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CreateAccountTests extends TestBase {

    @Test
    public void createNewAccountPositiveTest() {

        String email = "artest@artest.test";

        driver.findElement(By.cssSelector("[href='/register']")).click();
        driver.findElement(By.cssSelector("#gender-male")).click();

        driver.findElement(By.name("FirstName")).click();
        driver.findElement(By.name("FirstName")).clear();
        driver.findElement(By.name("FirstName")).sendKeys("Alexander");

        driver.findElement(By.name("LastName")).click();
        driver.findElement(By.name("LastName")).clear();
        driver.findElement(By.name("LastName")).sendKeys("R");

        driver.findElement(By.name("Email")).click();
        driver.findElement(By.name("Email")).clear();
        driver.findElement(By.name("Email")).sendKeys(email);

        driver.findElement(By.name("Password")).click();
        driver.findElement(By.name("Password")).clear();
        driver.findElement(By.name("Password")).sendKeys("TestPass1234$");

        driver.findElement(By.name("ConfirmPassword")).click();
        driver.findElement(By.name("ConfirmPassword")).clear();
        driver.findElement(By.name("ConfirmPassword")).sendKeys("TestPass1234$");

        driver.findElement(By.name("register-button")).click();

        Assert.assertEquals("https://demowebshop.tricentis.com/registerresult/1", driver.getCurrentUrl());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        driver.findElement(By.cssSelector(".register-continue-button")).click();

        Assert.assertEquals("https://demowebshop.tricentis.com/", driver.getCurrentUrl());
        Assert.assertTrue( isElementPresent(By.cssSelector("[href=\"/customer/info\"]")));

        Assert.assertEquals(email, driver.findElement(By.cssSelector("[href=\"/customer/info\"]")).getText());
    }

}
