package com.applaudo.basico.taller4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {

    public WebDriver driver;
    public String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    //@BeforeMethod
    public void launchBrowser(){
        System.setProperty("webdriver.chrome.driver", chromePath);
        String baseURL = "http://www.google.com/";
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
    }

    //@AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    //@BeforeSuite
    public void beforeSuite(){
        System.out.println("Ejecutando Test Suite");
    }

    //@AfterSuite
    public void testSuite(){
        System.out.println("Cerrando Test Suite");
    }

    //@BeforeTest
    public void beforeTest(){
        System.out.println("Ejecutando Test");
    }

    //@AfterTest
    public void afterTest(){
        System.out.println("Cerrando Test Suite");
    }

    //@BeforeClass
    public void beforeClass(){
        System.out.println("Ejecutando Clase");
    }

    //@AfterClass
    public void afterClass(){
        System.out.println("Cerrando Clase");
    }

    //@BeforeMethod
    public void beforeMethod(){
        System.out.println("Ejecutando Método");
    }

    //@AfterMethod
    public void afterMethod(){
        System.out.println("Cerrando Método");
    }
}
