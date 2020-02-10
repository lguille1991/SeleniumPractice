package com.applaudo.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class Taller2 {
    static WebDriver driver;
    static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    public static int generateRandom(int max, int min){
        int randomNumber = (int)(Math.random() * ((max - min) + 1)) + min;
        System.out.println("Generated random number: " + randomNumber);
        return randomNumber;
    }

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", chromePath);
        String baseURL = "http://www.qaclickacademy.com/practice.php";
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        try {
            //Locating elements
            By radioButtons = By.cssSelector("[name='radioButton']");
            By autocomplete = By.cssSelector("[id='autocomplete']");
            By countrySelect = By.cssSelector("[id='dropdown-class-example']");
            By country = By.cssSelector("[id='dropdown-class-example']");
            By checkbox = By.cssSelector("[type='checkbox']");
            By buttons = By.cssSelector("header div button");

            //Creating WebElements
            List<WebElement> radioWE = driver.findElements(radioButtons);
            WebElement autocompleteWE = driver.findElement(autocomplete);
            Select drpCountry = new Select(driver.findElement(countrySelect));
            WebElement countryWE = driver.findElement(country);
            List<WebElement> checkWE = driver.findElements(checkbox);
            List<WebElement> buttonsWE = driver.findElements(buttons);

            //PRIMERA PARTE//
            System.out.println("[][][][][] PRIMERA PARTE [][][][][]\n");
            int randomAux = generateRandom(3,1);
            radioWE.get(randomAux - 1).click();
            Thread.sleep(3000);
            for (int i = 0; i < radioWE.size(); i++){
                if (radioWE.get(i).isSelected()){
                    System.out.println("Selected radio button: " +radioWE.get(i).getAttribute("value"));
                } else {
                    System.out.println("NOT selected radio button: " + radioWE.get(i).getAttribute("value"));
                }
            }

            //SEGUNDA PARTE//
            System.out.println("\n[][][][][] SEGUNDA PARTE [][][][][]\n");
            System.out.println("Texfield text: " + autocompleteWE.getAttribute("value"));
            autocompleteWE.sendKeys("El Salvador");
            Thread.sleep(2000);
            System.out.println("Texfield text: " + autocompleteWE.getAttribute("value"));

            //TERCERA PARTE//
            System.out.println("\n[][][][][] TERCERA PARTE [][][][][]\n");
            drpCountry.selectByVisibleText("Option2");
            Thread.sleep(2000);
            System.out.println("Selected option: " + drpCountry.getFirstSelectedOption().getText());
            countryWE.click();
            countryWE.sendKeys("Option3");
            countryWE.click();
            Thread.sleep(2000);
            System.out.println("Selected option: " + driver.findElement(By.cssSelector("#dropdown-class-example option[value='option3']")).getText());

            //CUARTA PARTE//
            System.out.println("\n[][][][][] CUARTA PARTE [][][][][]\n");
            int randomAux2 = generateRandom(3,1);

            for (int i = 0; i < checkWE.size(); i++) {
                if(i != randomAux2 - 1) {
                    checkWE.get(i).click();
                    Thread.sleep(1500);
                }
            }

            for (int i = 0; i < checkWE.size(); i++){
                if(checkWE.get(i).isSelected()){
                    System.out.println("Selected checkbox: " + checkWE.get(i).getAttribute("value"));
                } else {
                    System.out.println("NOT selected checkbox: " + checkWE.get(i).getAttribute("value"));
                }
            }

            //QUINTA PARTE//
            System.out.println("\n[][][][][] QUINTA PARTE [][][][][]\n");
            String expectedURL = "http://www.qaclickacademy.com/practice.php";
            for (int i =0; i < buttonsWE.size(); i++) {
                buttonsWE.get(i).click();
                String currentURL = driver.getCurrentUrl();
                if (currentURL.equals(expectedURL)) {
                    System.out.println("Same URL - Btn: " + buttonsWE.get(i).getText());
                } else {
                    driver.navigate().back();
                    buttonsWE = driver.findElements(buttons);
                    System.out.println("Different URL - Btn: " +buttonsWE.get(i).getText());
                }
            }
        } catch (NoSuchElementException ne) {
            System.err.println("WebElement not found: " +ne.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            driver.close();
        }
    }
}
