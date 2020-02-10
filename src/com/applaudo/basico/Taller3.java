package com.applaudo.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Taller3 {

    static WebDriver driver;
    static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", chromePath);
        String baseURL = "http://www.qaclickacademy.com";
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        try {
            WebDriverWait waitVar = new WebDriverWait(driver, 10);
            waitVar.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#homepage > div.sumo-form-wrapper.listbuilder-popup > div.listbuilder-popup-content > div > div > div > span > div > div.sumome-react-wysiwyg-component.sumome-react-wysiwyg-popup-background.sumome-react-wysiwyg-background > div > div > div")));
            WebElement input = driver.findElement(By.cssSelector("#homepage > div.sumo-form-wrapper.listbuilder-popup" +
                    " > div.listbuilder-popup-content > div > div > div > span > div > div.sumome-react-wysiwyg-component.sumome-react-wysiwyg-popup-textField.sumome-react-wysiwyg-textField > div > div > input[type=text]"));

            Actions builder = new Actions(driver);
            Actions seriesOfActions = builder
                    .sendKeys("2020@gmail.com")
                    .sendKeys(Keys.ESCAPE);
            seriesOfActions.perform();

        } catch (NoSuchElementException ne) {
            System.err.println("WebElement not found: " + ne.getMessage());
        } finally {
            driver.close();
        }
    }
}
