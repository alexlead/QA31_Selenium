package com.ait.qa31;

import org.openqa.selenium.*;
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

    public void openProductCategory() {
        WebElement menuItem = getElement(By.cssSelector(".header-menu .top-menu li:first-child a"));

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
        if ( !isPageCorrectUrl("https://demowebshop.tricentis.com/registerresult/1") ) {
            throw new NoSuchWindowException("Server was return incorrect page");
        }
        try{
            getElement(By.cssSelector(".register-continue-button")).click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isPageCorrectUrl(String url) {
        return (url.equals(driver.getCurrentUrl()));
    }

    public String actualRegisteredEmail() {
        if ( !isPageCorrectUrl("https://demowebshop.tricentis.com/") ) {
            throw new NoSuchWindowException("Server was return incorrect page");
        }
        return getElement(By.cssSelector("[href=\"/customer/info\"]")).getText();
    }

    public void submitLoginForm() {
        getElement(By.cssSelector(".returning-wrapper .buttons input[value=\"Log in\"]")).click();
    }

    public void fillLoginForm() {
        fillInputField("Email", "artest2@artest.test");
        fillInputField("Password", "TestPass1234$");
    }

    public void openLoginPage() {
        driver.navigate().to("https://demowebshop.tricentis.com/login");
    }

    public void clickLogoutLink() {
        getElement(By.cssSelector("a[href='/logout']")).click();
    }

    public String getProductItemTitle() {
        WebElement element = getElement(By.cssSelector(".product-grid .product-item:first-child .product-title a"));
        return element.getText();
    }

    public String getFirstElementFromCart() {
        return driver.findElement(By.cssSelector("table.cart .product a")).getText();
    }

    public void clearCart() {
        driver.findElement( By.cssSelector("table.cart .remove-from-cart [name='removefromcart']") ).click();
        pause(300);
        driver.findElement( By.name("updatecart") ).click();
        pause(2000);
    }
}
