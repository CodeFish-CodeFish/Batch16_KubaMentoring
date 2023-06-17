package com.qa_fox.tests;

import Utils.ConfigReader;
import com.qa_fox.pages.CheckoutPage;
import com.qa_fox.pages.MainPage;
import com.qa_fox.pages.ProductListPage;
import com.qa_fox.pages.SingleProductPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class QAFoxScripts extends Base{

    @Parameters({"firstName", "lastName", "email", "cell", "company", "address1", "address2", "city", "zipCode", "message"})
    @Test()
    public void TC_01(String firstName, String lastName, String email, String cell, String company, String address1,
                      String address2, String city, String zipCode, String message) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnDesktops();
        Thread.sleep(2000);

        ProductListPage page = new ProductListPage(driver);
        page.chooseLaptop();
        SingleProductPage productPage = new SingleProductPage(driver);

        productPage.addToCartFunction();

        CheckoutPage outPage = new CheckoutPage(driver);

        outPage.setAllInputFields(firstName, lastName, email,cell, company, address1, address2, city, zipCode, message);
}
@Test()
    public void ignoreTestCASE(){
        driver.get(ConfigReader.readProperty("url"));
}

}
