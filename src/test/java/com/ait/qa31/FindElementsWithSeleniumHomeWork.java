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

public class FindElementsWithSeleniumHomeWork {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementsByCssSelectorsTest() {

//        1.
        List<WebElement> products = driver.findElements(By.cssSelector(".product-grid .item-box"));
        products.forEach(p->{
            System.out.println("Image URL: " + p.findElement(By.tagName("img")).getAttribute("src"));
            WebElement product = p.findElement(By.cssSelector(".details .product-title a"));
            System.out.println("Link: " + product.getAttribute("href"));
            System.out.println("Title: " + product.getText());
            System.out.println("Price: " + p.findElement(By.cssSelector(".add-info span")).getText());
        });

//        2.
        WebElement tagsBlock = driver.findElement(By.cssSelector(".block-popular-tags"));
        List<WebElement> tags = tagsBlock.findElements(By.cssSelector("a"));
        System.out.println("Tags:");
        tags.forEach(t-> System.out.println(t.getAttribute("href") + " : " + t.getText()));

//        3.
        WebElement headerLogo = driver.findElement(By.cssSelector(".header .header-logo img"));
        System.out.println("Logo:");
        System.out.println(headerLogo.getAttribute("src"));

//        4.
        WebElement subscriptionButton = driver.findElement(By.cssSelector("#newsletter-subscribe-block input[type='button']"));
        System.out.println("Subscription button:");
        System.out.println(subscriptionButton.getTagName() + " : " + subscriptionButton.getAttribute("value") + " : " + subscriptionButton.getSize() );

//        5.
        WebElement searchInputElement = driver.findElement(By.cssSelector(".search-box input[type='text']"));
        System.out.println("Search input element:");
        System.out.println(searchInputElement.getTagName() + " : " + searchInputElement.getAttribute("value")
                + " : " + searchInputElement.getSize() + " : " + searchInputElement.getDomProperty("autocomplete")  );

//        6.
        WebElement searchSubmitButton = driver.findElement(By.cssSelector(".search-box input[type='text']"));
        System.out.println("Search submit button:");
        System.out.println(searchSubmitButton.getTagName() + " : " + searchSubmitButton.getAttribute("value")
                + " : " + searchSubmitButton.getSize()  );


//        7.
        WebElement pollSubmitButton = driver.findElement(By.cssSelector("#poll-block-1 input[type='button']"));
        System.out.println("Poll submit button:");
        System.out.println(pollSubmitButton.getTagName() + " : " + pollSubmitButton.getAttribute("value")
                + " : " + pollSubmitButton.getSize()  );

//        8.
        WebElement registrationLink = driver.findElement(By.cssSelector(".header-links-wrapper a[href='/register']"));
        System.out.println("Registration link:");
        System.out.println(registrationLink.getTagName() + " : " + registrationLink.getText() + " : " + registrationLink.getAttribute("href") );

//        9.
        WebElement loginLink = driver.findElement(By.cssSelector(".header-links-wrapper a[href='/login']"));
        System.out.println("Login link:");
        System.out.println(loginLink.getTagName() + " : " + loginLink.getText() + " : " + loginLink.getAttribute("href") );

//        10.
        WebElement footerSitemapLink = driver.findElement(By.cssSelector(".footer .column.information a[href='/sitemap']"));
        System.out.println("Sitemap link:");
        System.out.println(footerSitemapLink.getTagName() + " : " + footerSitemapLink.getText() + " : " + footerSitemapLink.getAttribute("href") );


    }


    @Test
    public void findElementsByXpathsTest () {

        //        1.
        List<WebElement> products = driver.findElements(By.xpath(".//*[contains(concat(' ',normalize-space(@class),' '),' product-grid ')]//*[contains(concat(' ',normalize-space(@class),' '),' item-box ')]"));
        products.forEach(p->{
            System.out.println("Image URL: " + p.findElement(By.xpath("//img")).getAttribute("src"));
            WebElement product = p.findElement(By.xpath(".//*[contains(concat(' ',normalize-space(@class),' '),' details ')]//*[contains(concat(' ',normalize-space(@class),' '),' product-title ')]//a"));
            System.out.println("Link: " + product.getAttribute("href"));
            System.out.println("Title: " + product.getText());
            System.out.println("Price: " + p.findElement(By.xpath(".//*[contains(concat(' ',normalize-space(@class),' '),' add-info ')]//span")).getText());
        });

//        2.
        WebElement tagsBlock = driver.findElement(By.xpath(".//*[contains(concat(' ',normalize-space(@class),' '),' block-popular-tags ')]"));
        List<WebElement> tags = tagsBlock.findElements(By.xpath(".//a"));
        System.out.println("Tags:");
        tags.forEach(t-> System.out.println(t.getAttribute("href") + " : " + t.getText()));

//        3.
        WebElement headerLogo = driver.findElement(By.xpath(".//*[contains(concat(' ',normalize-space(@class),' '),' header ')]//*[contains(concat(' ',normalize-space(@class),' '),' header-logo ')]//img"));
        System.out.println("Logo:");
        System.out.println(headerLogo.getAttribute("src"));

//        4.
        WebElement subscriptionButton = driver.findElement(By.xpath(".//*[@id='newsletter-subscribe-block']//input[@type='button']"));
        System.out.println("Subscription button:");
        System.out.println(subscriptionButton.getTagName() + " : " + subscriptionButton.getAttribute("value") + " : " + subscriptionButton.getSize() );

//        5.
        WebElement searchInputElement = driver.findElement(By.xpath(".//*[contains(concat(' ',normalize-space(@class),' '),' search-box ')]//input[@type='text']"));
        System.out.println("Search input element:");
        System.out.println(searchInputElement.getTagName() + " : " + searchInputElement.getAttribute("value")
                + " : " + searchInputElement.getSize() + " : " + searchInputElement.getDomProperty("autocomplete")  );

//        6.
        WebElement searchSubmitButton = driver.findElement(By.xpath(".//*[contains(concat(' ',normalize-space(@class),' '),' search-box ')]//input[@type='text']"));
        System.out.println("Search submit button:");
        System.out.println(searchSubmitButton.getTagName() + " : " + searchSubmitButton.getAttribute("value")
                + " : " + searchSubmitButton.getSize()  );


//        7.
        WebElement pollSubmitButton = driver.findElement(By.xpath(".//*[@id='poll-block-1']//input[@type='button']"));
        System.out.println("Poll submit button:");
        System.out.println(pollSubmitButton.getTagName() + " : " + pollSubmitButton.getAttribute("value")
                + " : " + pollSubmitButton.getSize()  );

//        8.
        WebElement registrationLink = driver.findElement(By.xpath(".//*[contains(concat(' ',normalize-space(@class),' '),' header-links-wrapper ')]//a[@href='/register']"));
        System.out.println("Registration link:");
        System.out.println(registrationLink.getTagName() + " : " + registrationLink.getText() + " : " + registrationLink.getAttribute("href") );

//        9.
        WebElement loginLink = driver.findElement(By.xpath(".//*[contains(concat(' ',normalize-space(@class),' '),' header-links-wrapper ')]//a[@href='/login']"));
        System.out.println("Login link:");
        System.out.println(loginLink.getTagName() + " : " + loginLink.getText() + " : " + loginLink.getAttribute("href") );

//        10.
        WebElement footerSitemapLink = driver.findElement(By.xpath(".//*[contains(concat(' ',normalize-space(@class),' '),' footer ')]//*[contains(concat(' ',normalize-space(@class),' '),' column ')][contains(concat(' ',normalize-space(@class),' '),' information ')]//a[@href='/sitemap']"));
        System.out.println("Sitemap link:");
        System.out.println(footerSitemapLink.getTagName() + " : " + footerSitemapLink.getText() + " : " + footerSitemapLink.getAttribute("href") );

    }


    @AfterMethod
    public void tearDownd () {
        driver.quit();
    }


}
