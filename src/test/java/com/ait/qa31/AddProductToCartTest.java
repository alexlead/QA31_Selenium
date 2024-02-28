package com.ait.qa31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToCartTest extends TestBase{


    @Test
    public void createAddToCartPositiveTest() {

        WebElement productItemTitle;
        openProductCategory(By.cssSelector(".header-menu .top-menu li:first-child a"));
        productItemTitle = getElement(By.cssSelector(".product-grid .product-item:first-child .product-title a"));
        addProductToCartClick();
        pause(10000);
        navigateToCart();

        Assert.assertTrue( isElementPresent(By.linkText( productItemTitle.getText() )));


    }

}
