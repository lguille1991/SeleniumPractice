package com.applaudo.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FrameAlertWait {
    static WebDriver driver;
    static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", chromePath);
        String baseURL = "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt";
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebDriverWait waitVar = new WebDriverWait(driver, 10);

        try {
            driver.switchTo().frame("iframeResult");
            WebElement btnTry = driver.findElement(By.xpath("/html/body/button"));
            waitVar.until(ExpectedConditions.elementToBeClickable(btnTry));
            btnTry.click();
            Thread.sleep(2000);

            waitVar.until(ExpectedConditions.alertIsPresent());
            Alert alrtWindow = driver.switchTo().alert();
            String alertText = alrtWindow.getText();
            System.out.println(alertText);
            alrtWindow.sendKeys("Guillermo Abrego");
            alrtWindow.accept();
            Thread.sleep(2000);
            String finalText = driver.findElement(By.id("demo")).getText();
            System.out.println(finalText.contains("Guillermo")?finalText:"Prueba fallida");

        } catch (NoSuchElementException ne) {
            System.err.println("WebElement not found: " + ne.getMessage() );
        } catch (NoSuchFrameException nf) {
            System.err.println("Frame not found: " + nf.getMessage() );
        } catch (NoAlertPresentException na) {
            System.err.println("Alert not found: " + na.getMessage() );
        } catch (TimeoutException te) {
            System.err.println("Wait time exceeded: " + te.getMessage() );
        } catch (WebDriverException we) {
            System.err.println("Webdriver failed: " + we.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            driver.close();
        }
    }
}
