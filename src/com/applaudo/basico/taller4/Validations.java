package com.applaudo.basico.taller4;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Validations extends BaseTest{

    @Test
    public void something(){
        try{

            String baseURL = "https://www.rahulshettyacademy.com/AutomationPractice/";
            driver.get(baseURL);
            SoftAssert sa = new SoftAssert();

            WebElement btnHome = driver.findElement(By.cssSelector("body > header > div > a > button"));
            WebElement btnPractice = driver.findElement(By.cssSelector("body > header > div > button:nth-child(2)"));
            WebElement btnLogin = driver.findElement(By.cssSelector("body > header > div > button:nth-child(3)"));
            WebElement btnSignUp = driver.findElement(By.cssSelector("body > header > div > button:nth-child(4)"));
            String homeTitle = btnHome.getText();
            String practiceTitle = btnPractice.getText();
            String loginTitle = btnLogin.getText();
            String signupTitle = btnSignUp.getText();
            sa.assertEquals(homeTitle,"Home");
            System.out.println("Expected title: Home | Actual: " + homeTitle);
            sa.assertEquals(practiceTitle,"Practice");
            System.out.println("Expected title: Practice | Actual: " + practiceTitle);
            sa.assertEquals(loginTitle,"Login");
            System.out.println("Expected title: Login | Actual: " + loginTitle);
            sa.assertEquals(signupTitle,"Signup");
            System.out.println("Expected title: Signup | Actual: " + signupTitle);

            WebElement nameField = driver.findElement(By.id("name"));
            nameField.sendKeys("Guillermo");
            WebElement alertBtn = driver.findElement(By.id("alertbtn"));
            alertBtn.click();
            String alert = driver.switchTo().alert().getText();
            sa.assertEquals(alert, "Hello Guillermo, share this practice page and share your knowledge");
            System.out.println("Expected alert text: Hello Guillermo, share this practice page and share your " +
                    "knowledge | Actual: " + alert);
            sa.assertAll();

        } catch (NoSuchElementException ne) {
            System.err.println(ne.getMessage());
        }
    }
}
