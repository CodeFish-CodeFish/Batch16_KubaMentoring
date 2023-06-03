package mentoring_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsPractice {

    @Test()
    public void TC_05() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.lambdatest.com/selenium-playground");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[contains(.,'Javascript Alerts')]")).click();

        WebElement jsAlert = driver.findElement(By.xpath("//p[contains(.,'JS Alert')]//following-sibling::button"));
        jsAlert.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement confirmBtn = driver.findElement(By.xpath("//p[contains(.,'Confirm box:')]//following-sibling::button"));
        confirmBtn.click();

        alert.dismiss();
        Thread.sleep(2000);
        WebElement promptBtn = driver.findElement(By.xpath("//p[contains(.,'Prompt box:')]//following-sibling::button"));

        promptBtn.click();

        alert.sendKeys("test test");
        alert.accept();

    }
}
