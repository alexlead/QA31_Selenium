package com.ait.qa31;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    WebDriver driver;

//    before  - setUp
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
//        driver.get("https://www.google.com");
    driver.navigate().to("https://store.mirantis.com/");
    driver.navigate().back();
    driver.navigate().forward();
    driver.navigate().refresh();

    }

//    tests

    @Test
    public void openGoogleTest() {
        System.out.println("Google opened!");
    }

//    after - tearDown
    @AfterMethod(enabled = false)
    public void tearDownd () {
//        driver.quit();
    driver.close();
    }


}
