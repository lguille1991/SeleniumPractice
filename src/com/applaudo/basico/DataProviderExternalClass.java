package com.applaudo.basico;

import org.testng.annotations.DataProvider;

public class DataProviderExternalClass {
    @DataProvider(name = "SearchProvider")
    public Object[][] getDataProvider(){
        return new Object[][]{
                {"Fernando", "Google"},
                {"Luis", "Yahoo"},
                {"Guillermo", "Microsoft"}
        };
    }
}
