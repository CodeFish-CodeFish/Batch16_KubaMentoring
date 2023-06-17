package com.qa_fox.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage {

        public ProductListPage(WebDriver driver){
                PageFactory.initElements(driver, this);
        }

        @FindBy(xpath = "//select[@id='input-sort']")
        WebElement sortDropDown;

        @FindBy(xpath = "//p[contains(.,'Stop')]//..//following-sibling::div")
        WebElement addedLaptop;

        public void chooseLaptop() throws InterruptedException {

                BrowserUtils.selectBy(sortDropDown, "Price (Low > High)", "text");
                Thread.sleep(2000);
                addedLaptop.click();
        }





}
