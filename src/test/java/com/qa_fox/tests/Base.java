package com.qa_fox.tests;

import Utils.ConfigReader;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {

    public WebDriver driver;

    @BeforeMethod
    public void StartUp(){

        driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("urlQAFox"));
    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
    }
}
