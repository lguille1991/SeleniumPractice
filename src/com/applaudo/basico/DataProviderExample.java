package com.applaudo.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DataProviderExample {
    WebDriver driver;
    public String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.com.sv/");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @DataProvider(name = "SearchProvider")
    public Object[][] getDataProvider(){
        return new Object[][]{
                {"Fernando", "Google"},
                {"Luis", "Yahoo"},
                {"Guillermo", "Microsoft"}
        };
    }

    @Test(dataProvider = "SearchProvider", dataProviderClass = DataProviderExternalClass.class)
    public void testMethod(String tester, String search) throws InterruptedException {
        WebElement txtSearch = driver.findElement(By.name("q"));
        txtSearch.sendKeys(search);
        System.out.println("Welcome " + tester + ", your search is: " +search);
        Thread.sleep(3000);
        String testValue = txtSearch.getAttribute("value");
        System.out.println("The entered search values is: " + testValue + " and it is equal to: " +search);
        txtSearch.clear();

        Assert.assertTrue(testValue.equals(search));

    }
}
