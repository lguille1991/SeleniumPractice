package com.applaudo.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ChromeBrowser {
    public static void main(String[] args) {
        WebDriver driver; //Open the browser
        String baseURL = "https://facebook.com";
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

        driver = new ChromeDriver(); //Launch browser
        driver.get(baseURL); //Go to the URL
        driver.manage().window().maximize(); //Maximize window

        //findElement retrieves a single element
        WebElement txtEmail = driver.findElement(By.name("email"));
        txtEmail.sendKeys("lguille@gmail.com");
        WebElement txtPass = driver.findElement(By.name("pass"));
        txtPass.sendKeys("ThisIsNotAllowes");
        txtPass.submit();

        //findElements retrieves a list of elements
        List<WebElement> something = driver.findElements(By.name("email"));
        for (int i = 0; i<something.size(); i++){
        }
        driver.close();
    }
}
