package com.applaudo.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Taller3Definitivo {

    static WebDriver driver;
    static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", chromePath);
        String baseURL = "http://webdriveruniversity.com/";
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        try {
            //EJERCICIO 1
            String oldTab = driver.getWindowHandle();
            By ajaxLink = By.cssSelector("#ajax-loader > div > div.section-title > h1");
            By loaderImg = By.cssSelector("#loader");
            By clickButton = By.cssSelector("#button1 > p");
            By alertsButton = By.cssSelector("#popup-alerts > div > div.section-title > h1");
            By javascriptButton = By.id("button1");
            By actionsLink = By.cssSelector("#actions > div > div.section-title > h1");
            By dragButton = By.cssSelector("#draggable > p > b");
            By dropButton = By.cssSelector("#droppable > p");
            By doubleClickBtn = By.cssSelector("#double-click > h2");
            By hoverFirstBtn = By.cssSelector("#div-hover > div.dropdown.hover > button");
            By hoverSecondBtn = By.cssSelector("#div-hover > div:nth-child(2) > button");
            By hoverThirdBtn = By.cssSelector("#div-hover > div:nth-child(3) > button");
            By holdButton = By.cssSelector("#click-box");

            WebElement ajaxLinkWE = driver.findElement(ajaxLink);
            ajaxLinkWE.click();

            //Moves to new tab
            ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
            newTab.remove(oldTab);
            driver.switchTo().window(newTab.get(0));

            WebDriverWait waitVar = new WebDriverWait(driver, 10);
            WebElement loaderImgWE = driver.findElement(loaderImg);
            waitVar.until(ExpectedConditions.invisibilityOf(loaderImgWE));

            WebElement clickButtonWE = driver.findElement(clickButton);
            System.out.println("Ejercicio 1: " + clickButtonWE.getText());
            driver.close();

            //EJERCICIO 2
            driver.switchTo().window(oldTab);
            WebElement alertButtonWE = driver.findElement(alertsButton);
            alertButtonWE.click();

            //Moves to new tab
            newTab = new ArrayList<String>(driver.getWindowHandles());
            newTab.remove(oldTab);
            driver.switchTo().window(newTab.get(0));

            WebElement javascriptWE = driver.findElement(javascriptButton);
            javascriptWE.click();
            System.out.println("Ejercicio 2: " + driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();
            driver.close();

            //EJERCICIO 3
            driver.switchTo().window(oldTab);
            WebElement actionsLinkWE = driver.findElement(actionsLink);
            actionsLinkWE.click();

            //Moves to new tab
            newTab = new ArrayList<String>(driver.getWindowHandles());
            newTab.remove(oldTab);
            driver.switchTo().window(newTab.get(0));

            WebElement dragButtonWE = driver.findElement(dragButton);
            WebElement dropButtonWE = driver.findElement(dropButton);
            WebElement doubleClickWE = driver.findElement(doubleClickBtn);
            WebElement hoverFistWE = driver.findElement(hoverFirstBtn);
            WebElement hoverSecondWE = driver.findElement(hoverSecondBtn);
            WebElement hoverThirdWE = driver.findElement(hoverThirdBtn);
            WebElement holdBtnWE = driver.findElement(holdButton);

            System.out.println("Text before dragging: " + dropButtonWE.getText());

            Actions builder = new Actions(driver);

            Actions seriesOfActions = builder
                    .clickAndHold(dragButtonWE)
                    .moveToElement(dropButtonWE)
                    .release(dragButtonWE);

            seriesOfActions.perform();

            System.out.println("Text after dragging: " + dropButtonWE.getText());

            Actions seriesOfActions2 = builder
                    .doubleClick(doubleClickWE)
                    .moveToElement(hoverFistWE)
                    .moveToElement(hoverSecondWE)
                    .moveToElement(hoverThirdWE);

            seriesOfActions2.perform();
            Thread.sleep(2000);

            Actions seriesOfActions3 = builder
                    .moveToElement(hoverFistWE)
                    .moveToElement(hoverSecondWE)
                    .moveToElement(hoverThirdWE);

            seriesOfActions3.perform();

            Actions seriesOfActions4 = builder
                    .clickAndHold(holdBtnWE);

            seriesOfActions4.perform();
            System.out.println("Held button text: " + holdBtnWE.getText());
            Thread.sleep(6000);

            seriesOfActions4.release(holdBtnWE).build().perform();
            System.out.println("Released button text: " + holdBtnWE.getText());

        }catch (NoSuchElementException | InterruptedException ne) {
            System.err.println(ne.getMessage());
        } finally {
            //driver.quit();
        }
    }
}
