package com.applaudo.basico.taller4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearch2 extends BaseTest {

    @Test
    public void searchMarca() {
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("Marca");
        searchBar.sendKeys(Keys.ENTER);
        System.out.println("Buscando Marca");
        WebElement marcaLink = driver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div > div > div > div.r > a > div > cite"));
        marcaLink.click();
        String expectedMarcaUrl = "https://www.marca.com/";
        Assert.assertEquals(driver.getCurrentUrl(),expectedMarcaUrl);
    }

    @Test
    public void searchSport() {
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("Sport");
        searchBar.sendKeys(Keys.ENTER);
        System.out.println("Buscando Sport");
        WebElement sportLink = driver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div > div > div > " +
                "div.r > a > div > cite"));
        sportLink.click();
        String expectedSportUrl = "https://www.sport.es/es/";
        Assert.assertEquals(driver.getCurrentUrl(),expectedSportUrl);
    }
}
