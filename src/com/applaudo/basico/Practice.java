package com.applaudo.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Practice {
    static WebDriver driver;
    static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", chromePath);
        String baseURL = "http://www.qaclickacademy.com/practice.php";
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        try {
            List<WebElement> cells = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/td[text()='25']"));
            /*Test starts here*/
            String before = "//table[@id='product']/tbody/tr[";
            String after = "]/td[3]";
            for (int i = 2; i <= 11; i++  ){
                String actual = before + i + after;
                WebElement element = driver.findElement(By.xpath(actual));
                //System.out.println(element.getText());
                if (element.getText().equals("25")){
                    System.out.println("Found at position: " + (i-1));
                    String beforeCourse = "//table[@id='product']/tbody/tr[";
                    String afterCourse = "]/td[2]";
                    String actualCourse = beforeCourse + i + afterCourse;
                    WebElement courseElement = driver.findElement(By.xpath(actualCourse));
                    System.out.println("Course name: " + courseElement.getText());
                }
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