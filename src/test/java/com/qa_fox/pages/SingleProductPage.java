package com.qa_fox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingleProductPage {

    public SingleProductPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//span[contains(.,'Checkout')]")
    WebElement checkoutBtn;

    public void addToCartFunction(){

        addToCartBtn.click();

        checkoutBtn.click();
    }


}
