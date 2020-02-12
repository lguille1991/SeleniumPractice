package com.applaudo.basico.taller4.tests;

import com.applaudo.basico.taller4.BaseTest;
import com.applaudo.basico.taller4.pages.GooglePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchMarcaTest extends BaseTest {
    //WebDriver driver;
    GooglePage google = new GooglePage(driver);

    @BeforeMethod
    public void launch(){
        launchBrowser();
    }

    @Test
    public void googleSearchMarca(){
        google.searchMarca();
    }

    @AfterMethod
    public void close(){
        closeBrowser();
    }



}
