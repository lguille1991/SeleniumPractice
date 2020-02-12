package com.applaudo.basico.taller4.pages;

import com.applaudo.basico.taller4.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage extends BaseTest {
    WebDriver driver;

    By searchBar = By.name("q");
    By searchBtn = By.name("btnK");
    By luckyButton = By.name("btnI");

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement txtSearchBar = driver.findElement(searchBar);
    public WebElement btnSearch = driver.findElement(searchBtn);
    public WebElement btnLucky = driver.findElement(luckyButton);

    public void searchMarca(){
        txtSearchBar.sendKeys("Marca");
        btnSearch.click();
    }
}
