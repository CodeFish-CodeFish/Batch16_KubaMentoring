package lambda_test;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.TreeMap;

public class Test2 {

    /*
    print out names and emails as a key - value pair
    use map interface, try to use cssSelectors
     */


    @Test()
    public void TC_01() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.lambdatest.com/selenium-playground");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[contains(.,'Table Pagination')]")).click();
        WebElement dropDown = driver.findElement(By.cssSelector("select[id='maxRows']"));
        BrowserUtils.selectBy(dropDown, "0", "index");

        List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allEmails = driver.findElements(By.xpath("//tr//td[3]"));


        for (int i = 0; i < allNames.size(); i++) {
            TreeMap<String, String> map = new TreeMap<>();
            map.put(BrowserUtils.getText(allNames.get(i)), BrowserUtils.getText(allEmails.get(i)));
            System.out.println(map);
        }







    }

    @Test()
    public void TC_02() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.lambdatest.com/selenium-playground");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[contains(.,'Table Pagination')]")).click();
        WebElement dropDown = driver.findElement(By.cssSelector("select[id='maxRows']"));
        BrowserUtils.selectBy(dropDown,"5000","value");

        List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allnumber= driver.findElements(By.xpath("//tr//td[4]"));

        TreeMap<String,Long> map = new TreeMap<>();


        for (int i = 0; i<allNames.size();i++){

            map.put(BrowserUtils.getText(allNames.get(i)),Long.valueOf(BrowserUtils.getText(allnumber.get(i)).replace("-","")));

        }
        System.out.println("map   " + map);
        System.out.println();
        driver.quit();
    }


}
