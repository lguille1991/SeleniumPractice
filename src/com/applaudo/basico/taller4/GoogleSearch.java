package com.applaudo.basico.taller4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class GoogleSearch extends BaseTest {

    @Test(testName = "metal")
    public void searchMetal() {
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("Metal");
        searchBar.sendKeys(Keys.ENTER);
        System.out.println("Buscando Metal");
    }

    @Test(testName = "heavyMetal")
    public void searchHeavyMetal() {
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("Heavy Metal");
        searchBar.sendKeys(Keys.ENTER);
        System.out.println("Buscando Heavy Metal");
    }
}
