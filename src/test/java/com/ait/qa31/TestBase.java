package com.ait.qa31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0 ;
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

    public void pause (int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void addProductToCartClick() {
        WebElement productItemAddToCartButton = getElement(By.cssSelector(".product-grid .product-item:first-child input[type='button']"));
        productItemAddToCartButton.click();
    }

    public WebElement getElement(By by) {
        return driver.findElement(by);
    }

    public void navigateToCart() {
        driver.navigate( ).to("https://demowebshop.tricentis.com/cart");
    }

    public void openProductCategory(By by) {
        WebElement menuItem = getElement(by);

        driver.navigate( ).to(menuItem.getAttribute("href"));
    }

    public void saveRegistrationForm() {
        getElement(By.name("register-button")).click();
    }

    public void openRegistrationPage() {
        getElement(By.cssSelector("[href='/register']")).click();
    }

    public void fillCreateAccountForm(String email) {
        getElement(By.cssSelector("#gender-male")).click();
        fillInputField("FirstName", "Alexander");

        fillInputField("LastName", "R");

        fillInputField("Email", email);

        fillInputField("Password", "TestPass1234$");
        fillInputField("ConfirmPassword", "TestPass1234$");

    }

    public void fillInputField(String inputFieldName, String value) {
        getElement(By.name(inputFieldName)).click();
        getElement(By.name(inputFieldName)).clear();
        getElement(By.name(inputFieldName)).sendKeys(value);
    }

    public void confirmRegistrationContinue() {
        getElement(By.cssSelector(".register-continue-button")).click();
    }

    public void isPageCorrectUrl(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }
}
