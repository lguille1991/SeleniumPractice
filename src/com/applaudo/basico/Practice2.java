package com.applaudo.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Practice2 {
    static WebDriver driver;
    static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", chromePath);
        String baseURL = "http://www.qaclickacademy.com/practice.php";
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        try {
            List<WebElement> rows = driver.findElements(By.xpath("//table[@id='product']/tbody/tr"));
            for (int i = 1; i <= rows.size(); i++  ){
                System.out.println(rows.get(i).getText());
            }
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