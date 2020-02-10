package com.applaudo.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Taller1 {
    static WebDriver driver;
    static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", chromePath);
        String baseURL = "http://www.qaclickacademy.com/practice.php";
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        try {
            //PRIMERA PARTE
            //a
            By logo = By.className("logoClass");
            //b
            By home = By.linkText("Home");
            //c
            By title = By.tagName("h1");
            //d
            By radio = By.cssSelector("#radio-btn-example > fieldset > label:nth-child(3)");
            //e
            By txtCountries = By.id("autocomplete");
            //f
            By drpName = By.name("dropdown-class-example");
            //g
            By checkbox = By.cssSelector("#checkBoxOption3");
            //h
            By btnOpenWindow = By.xpath("//*[@id=\'openwindow\']");
            //i
            By table = By.className("table-display");
            //j
            By lblElement = By.xpath("/html/body/div[3]/div[2]/fieldset/legend");
            //k
            By iframe = By.id("courses-iframe");
            //l
            String tabTitle = driver.getTitle();
            //m
            By cssButtons = By.cssSelector("header button");

            //a
            WebElement webLogo = driver.findElement(logo);
            //b
            WebElement webHomw = driver.findElement(home);
            //c
            WebElement webTitle = driver.findElement(title);
            //d
            WebElement webRadio = driver.findElement(radio);
            //e
            List<WebElement> webCountries = driver.findElements(txtCountries);
            //f
            WebElement webName = driver.findElement(drpName);
            //g
            WebElement webCheck = driver.findElement(checkbox);
            //h
            WebElement webBtnOpenWindow = driver.findElement(btnOpenWindow);
            //i
            WebElement webTable = driver.findElement(table);
            //j
            WebElement webLblElement = driver.findElement(lblElement);
            //j
            WebElement webIframe = driver.findElement(iframe);
            //k
            //System.out.println(tabTitle);
            //m
            List<WebElement> webButtons = driver.findElements(cssButtons);

            //SEGUNDA PARTE
            //a
            System.out.println("Logo: " + webLogo.getText());
            //c
            System.out.println("Título: " + webTitle.getText());
            //e
            System.out.println("Botones: " + webCountries.get(0).getAttribute("placeholder"));
            //h
            System.out.println("Botón: " + webBtnOpenWindow.getText());
            //k
            System.out.println("iFrame: " + webIframe.getAttribute("name"));
            //l
            System.out.println("Título de la pestaña: " + tabTitle);

            //PARTE 4
            for (int i = 0; i < webButtons.size(); i++){
                System.out.println("Botón " + (i + 1) + ": " + webButtons.get(i).getText());
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