package com.ait.qa31;

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
        String cartElement;
        openProductCategory();
        productItemTitle = getProductItemTitle();
        addProductToCartClick();
        pause(3000);
        navigateToCart();
        pause(3000);
        cartElement = getFirstElementFromCart();
        Assert.assertEquals( cartElement, productItemTitle);

    }

    @AfterMethod
    public void logoutAfterTest () {
        clearCart();
        clickLogoutLink();
    }

}
