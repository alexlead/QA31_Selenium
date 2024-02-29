package com.ait.qa31;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProductToCartTest extends TestBase{


    @BeforeMethod
    public void loginBeforeAddProduct () {
        openLoginPage();
        fillLoginForm();
        submitLoginForm();
        pause(5000);
    }

    @Test
    public void createAddToCartPositiveTest() {

        String productItemTitle;
        openProductCategory();
        productItemTitle = getProductItemTitle();
        addProductToCartClick();
        pause(3000);
        navigateToCart();
        pause(3000);
        Assert.assertTrue( isElementPresent(By.linkText( productItemTitle )));

    }

    @AfterMethod
    public void logoutAfterTest () {
        clickLogoutLink();
    }

}
