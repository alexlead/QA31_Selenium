package com.ait.qa31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");
        driver.manage().window().maximize();

//        delay for downloads everything

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByTagNameTest () {
//        find element by tag

        WebElement element = driver.findElement(By.tagName("h1"));

        System.out.println(element.getText());

        List<WebElement> element1 = driver.findElements(By.tagName("a"));
        System.out.println(element1.size());

        element1.forEach((value) -> System.out.println(value.getAttribute("href")+":"+value.getText()));
    }
    @Test
    public void findElementsBySimpleLocatorsTest () {
//        by id
        driver.findElement(By.id("city"));

//        by class
        WebElement element = driver.findElement(By.className("navigation-link"));
        System.out.println(element.getText());

//        Link Text

        WebElement element1 = driver.findElement(By.linkText("Let the car work"));
        System.out.println(element1.getText());

//        Partial link text
        WebElement element2 = driver.findElement(By.partialLinkText("work"));
        System.out.println(element2.getAttribute("href"));
    }


    @Test
    public void findElementByCssSelectorTest() {
//        id -> #id
        WebElement element = driver.findElement(By.cssSelector("#city"));
        System.out.println(element.getAttribute("href"));

//
        WebElement element1 = driver.findElement(By.cssSelector(".navigation-link"));
        System.out.println(element1.getText());
//        any -> attr

        WebElement element2 = driver.findElement(By.cssSelector("[href='/search']"));
        System.out.println(element2.getText());
    }

    @Test
    public void findByXPathTest() {
        driver.findElement(By.xpath("//h1"));
        driver.findElement(By.xpath("//*[@id='city']"));
        driver.findElement(By.xpath("//*[@class='navigation-link']"));
        driver.findElement(By.xpath("//*[@href='/search']"));
        driver.findElement(By.xpath("//*[text()='Find your car now!']"));
        driver.findElement(By.xpath("//*[.='Find your car now!']"));
        driver.findElement(By.xpath("//*[contains(.,'your car now!')]"));
    }

    @Test
    public void myPersonalSeleniumTest () {
        WebElement element = driver.findElement(By.cssSelector(".special-offers-container .title-container span"));
        System.out.println(element.getText());




    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
