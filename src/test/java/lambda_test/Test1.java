package lambda_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Test1 {

    // go with test annotation @TEST
    @Test()
    public void TC_01() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.lambdatest.com/selenium-playground");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[contains(text(),'Input Form Submit')]")).click();


        WebElement nameField = driver.findElement(By.xpath("//input[@id='name']"));
        nameField.sendKeys("Kuba");

        WebElement emailField = driver.findElement(By.cssSelector("input[id='inputEmail4']"));
        emailField.sendKeys("test@test.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input[id='inputPassword4']"));
        passwordField.sendKeys("12345");

        WebElement companyField = driver.findElement(By.cssSelector("input[id='company']"));
        companyField.sendKeys("TestComany");

        WebElement websiteField = driver.findElement(By.cssSelector("input[id='websitename']"));
        websiteField.sendKeys("www.google.com");

        WebElement cityField = driver.findElement(By.cssSelector("input[id='inputCity']"));
        cityField.sendKeys("Chitown");

        WebElement address1 = driver.findElement(By.cssSelector("input[id='inputAddress1']"));
        address1.sendKeys("test st 1");

        WebElement address2 = driver.findElement(By.cssSelector("input[id='inputAddress2']"));
        address2.sendKeys("test st 2");

        WebElement stateField = driver.findElement(By.cssSelector("input[id='inputState']"));
        stateField.sendKeys("IL");

        WebElement zipCode = driver.findElement(By.cssSelector("input[id='inputZip']"));
        zipCode.sendKeys("60656");

        List<WebElement> allButtons = driver.findElements(By.cssSelector("button[type='submit']"));

        for (int i = 0; i < allButtons.size(); i++) {

            if (allButtons.get(i).getText().equalsIgnoreCase("submit")) {
                allButtons.get(i).click();
            }

        }

        List<WebElement> allMessages = driver.findElements(By.xpath("//p"));
        for (int i = 0; i < allMessages.size(); i++) {
            if (allMessages.get(i).getText().contains("Thanks")) {
                System.out.println(allMessages.get(i).getText());
                Assert.assertTrue(allMessages.get(i).isDisplayed());
            }
        }

        System.out.println("this one for github");


    }


}
