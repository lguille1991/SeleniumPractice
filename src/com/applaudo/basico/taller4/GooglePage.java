package com.applaudo.basico.taller4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage extends BaseTest {
    WebDriver driver;

    By searchBar = By.name("q");
    By searchBtn = By.name("btnK");

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    WebElement txtSearchBar = driver.findElement(searchBar);
    WebElement btnSearch = driver.findElement(searchBtn);

    public void searchMarca(){
        txtSearchBar.sendKeys("Marca");
        btnSearch.click();
    }
}
