import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestWebElement {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void webElementTest() {
        driver.navigate().to("https://www.google.com");
        String title = driver.getTitle();
        System.out.println(title);
        WebElement przycisk = driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]"));
        String tekstPrzycisku = przycisk.getText();
        System.out.println(tekstPrzycisku);
    }

    @AfterMethod
    public void after(){
        driver.close();
        driver.quit();
    }
}