package com.applaudo.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class IFrameTest {
    static WebDriver driver;
    static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", chromePath);
        String baseURL = "http://www.qaclickacademy.com/practice.php";
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        try {

            By iFrame = By.cssSelector("#courses-iframe");
            By btnPractice = By.cssSelector("a[href='practice.php']");
            By buttons = By.cssSelector("header" +
                    " button");

            WebElement iFrameWE = driver.findElement(iFrame);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1200)");

            WebDriver frame = driver.switchTo().frame(iFrameWE);
            WebElement btnPracticeWE = frame.findElement(btnPractice);
            List<WebElement> buttonsWE;
            Thread.sleep(3000);
            WebElement popup = frame.findElement(By.xpath("//*[@id=\'homepage\']/div[5]/div[2]/div/div/div/span/div/div[6]/div/div/button"));
            js.executeScript("window.scrollBy(100,600)");
            if (popup.isDisplayed()){
                popup.click();
            }
            btnPracticeWE.click();
            Thread.sleep(2000);
            buttonsWE = frame.findElements(buttons);
            for (int i = 0; i < buttonsWE.size(); i++){
                System.out.println("Botón " + (i + 1) + ": " + buttonsWE.get(i).getText());
            }

        } catch (NoSuchElementException ne) {
            System.err.println("WebElement not found: " + ne.getMessage());
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        } finally {
            driver.close();
        }


    }
}
