package com.qa_fox.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutPage {

    public CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[value='guest']")
    WebElement radioBtnGuest;

    @FindBy(css = "input[id='button-account']")
            // //input[@id='button-account']
    WebElement continueBtn1;

    @FindBy(css = "input[id='input-payment-firstname']")
    WebElement firstName;

    @FindBy(css = "input[id='input-payment-lastname']")
    WebElement lastName;

    @FindBy(css = "input[id='input-payment-email']")
    WebElement emailInput;

    @FindBy(css = "input[id='input-payment-telephone']")
    WebElement telephone;

    @FindBy(css = "input[id='input-payment-company']")
    WebElement companyName;

    @FindBy(css = "input[id='input-payment-address-1']")
    WebElement address1;

    @FindBy(css = "input[id='input-payment-address-2']")
    WebElement address2;

    @FindBy(css = "input[id='input-payment-city']")
    WebElement city;

    @FindBy(css = "input[id='input-payment-postcode']")
    WebElement zipCode;

    @FindBy(css = "select[id='input-payment-country']")
    WebElement countryDropDown;

    @FindBy(css = "select[id='input-payment-zone']")
    WebElement state;

    @FindBy(css = "input[id='button-guest']")
    WebElement continueBtn2;

    @FindBy(css = "textarea[name='comment']")
    WebElement textArea;

    @FindBy(css = "input[id='button-shipping-method']")
    WebElement continueBtn3;

    @FindBy(css = "input[name='agree']")
    WebElement agreeRadioBtn;

    @FindBy(css = "input[id='button-payment-method']")
    WebElement continueBtn4;

    @FindBy(css = "input[id='button-confirm']")
    WebElement confirmOrder;

    @FindBy(xpath = "//h1[contains(.,'Your')]")
    WebElement successMsg;
    //Your order has been placed!

    public void setAllInputFields(String firstName, String lastName, String emailInput, String telephone, String companyName,
                                  String address1, String address2, String city, String zipCode, String confirmMessage) throws InterruptedException {
        radioBtnGuest.click();
        continueBtn1.click();
        Thread.sleep(2000);
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.emailInput.sendKeys(emailInput);
        this.telephone.sendKeys(telephone);
        this.companyName.sendKeys(companyName);

        this.address1.sendKeys(address1);
        this.address2.sendKeys(address2);
        this.city.sendKeys(city);
        this.zipCode.sendKeys(zipCode);
        BrowserUtils.selectBy(countryDropDown, "United States", "text");
        Thread.sleep(2000);
        BrowserUtils.selectBy(state, "Wyoming", "text");

        if (!radioBtnGuest.isSelected()) {

            radioBtnGuest.click();
        }

        continueBtn2.click();

        textArea.clear();
        textArea.sendKeys("test");
        Thread.sleep(2000);
        continueBtn3.click();
        textArea.clear();
        textArea.sendKeys("test");

        if (!agreeRadioBtn.isSelected()) {
            agreeRadioBtn.click();
            Thread.sleep(2000);
            continueBtn4.click();
            confirmOrder.click();
        }

        Assert.assertEquals(BrowserUtils.getText(successMsg), confirmMessage);

}}
