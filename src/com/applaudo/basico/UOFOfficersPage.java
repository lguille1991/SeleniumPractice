package com.applaudo.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class UOFOfficersPage {
    static WebDriver driver;
    static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver",chromePath);
        String baseURL = "https://qa1.dev-benchmarkanalytics.com/";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseURL);

        try {

            By usernameField = By.id("username");
            By passwordField = By.id("password");
            By newReportButton = By.cssSelector(".bdm-icon-new-report");
            By uofGsButton = By.cssSelector(".ant-modal-body div:nth-child(2) button");
            By officerInfo = By.xpath("//h2[contains(text(),'Officer Info')]");
            By officerNameLabel = By.cssSelector("label[for='currentUserId']");
            By officerNameField = By.className("ant-select-search__field__mirror");
            By cameraLabel = By.cssSelector("label[for='officerWithInCarCameraVideo']");
            By cameraButton = By.cssSelector("#officerWithInCarCameraVideo > span");
            By inUniformLabel = By.cssSelector("label[for='fieldField653']");
            By inUniformButton = By.cssSelector("#fieldField653 > span");
            By bodyCameraLabel = By.cssSelector("label[for='officerWithCamera']");
            By bodyCameraButton = By.cssSelector("#officerWithCamera > span");
            By officersNavButton = By.id("276415");

            WebElement txtUsername = driver.findElement(usernameField);
            WebElement txtPassword = driver.findElement(passwordField);

            txtUsername.sendKeys("carlsonw@test1134.il.us");
            txtPassword.sendKeys("Ba123!");
            txtPassword.submit();

            WebElement btnNewReport = driver.findElement(newReportButton);
            btnNewReport.click();

            WebElement btnUofGs = driver.findElement(uofGsButton);
            btnUofGs.click();

            WebElement btnNavOfficers = driver.findElement(officersNavButton);
            btnNavOfficers.click();

            WebElement lblOfficerInfo = driver.findElement(officerInfo);
            WebElement lblOfficerName = driver.findElement(officerNameLabel);
            WebElement drpOfficerName = driver.findElement(officerNameField);
            WebElement lblCamera = driver.findElement(cameraLabel);
            WebElement btnCamera = driver.findElement(cameraButton);
            WebElement lblInUniform = driver.findElement(inUniformLabel);
            WebElement btnInUniform = driver.findElement(inUniformButton);
            WebElement lblBodyCamera = driver.findElement(bodyCameraLabel);
            WebElement btnBodyCamera = driver.findElement(bodyCameraButton);

        } catch (NoSuchElementException ne) {
            System.err.println("Element not found: " + ne.getMessage());
        } catch (WebDriverException we) {
            System.err.println("WebDriver failed: " + we.getMessage());
        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            driver.close();
        }
    }
}

