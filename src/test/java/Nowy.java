import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

//
//public class Nowy {
//
//    private WebDriver driver;
//
//    @BeforeMethod
//    public void beforeTest() {
//        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
//        driver= new ChromeDriver();
//    }
//
//    @Test
//    public void myFirstTest() {
//        driver.navigate().to("https://profil.wp.pl/login/login.html" );
//        sleep();
//        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[3]/div/button[2]")).click();
//        sleep();
//        WebElement login = driver.findElement(By.name("login_username"));
//        String logintext =login.getText();
//        login.sendKeys("cokolwiek");
//        assertEquals(logintext,"cokolwiek");
//        System.out.println(logintext);
//        sleep();
//        login.clear();
//        sleep();
//        driver.findElement(By.id("password")).sendKeys("FraneK2828!");
//        sleep();
//    }
//    private void sleep() {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    @AfterMethod
//    public void afterTest() {
//        driver.close();
//        driver.quit();
//    }
//}
//
//


public class Nowy {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver= new ChromeDriver();
    }

    @Test
    public void RegisterToWP() {
        driver.navigate().to("https://1login.wp.pl/rejestracja?login_challenge=Cj4KJDEwNmQ1OGQ1MDc5YWYwZDAzZWY3NTc5MzQzZjI0MDRjMzZjYRDl6f6eBhoQCgpvbC1wcm9maWxlEgJ2MRIg80TBjdI15CAG8iWEpyrjSKKhRvpl2i7eUcW2DvusQgA&registrationFlow=new&registrationBrand=wp" );
        sleep();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[3]/div/button[2]")).click();
        sleep();
//        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/main/div/div/div[3]/button")).click();
//        sleep();
//        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div/form/div/div[3]/div[2]/button[1]")).click();
//        sleep();
        WebElement name = driver.findElement(By.name("name"));
        name.sendKeys("Franek");
        String nametext =name.getAttribute("value");
        assertEquals(nametext,"Franek");
        System.out.println(nametext);
        sleep();

        WebElement lastName = driver.findElement(By.name("lastName"));
        String lastNametext =name.getText();
        lastName.sendKeys("Kozina");
        assertEquals(lastName,"Kozina");
        System.out.println(lastNametext);
        sleep();
        WebElement login = driver.findElement(By.className("Input__StyledInput-sc-13nwuzl-1 cRoKrD"));
        String logintext =login.getText();
        login.sendKeys("franekkozina28");
        assertEquals(login,"franekkozina28");
        System.out.println(logintext);
        sleep();
        driver.findElement(By.name("sex")).click();
        sleep();
        driver.findElement(By.linkText("Kobieta")).click();
        sleep();
        WebElement date = driver.findElement(By.id("date"));
        String datetext =date.getText();
        date.sendKeys("28");
        assertEquals(date,"28");
        System.out.println(datetext);
        sleep();
        driver.findElement(By.id("month")).click();
        driver.findElement(By.className("Select__StyledSelect-sc-xc8kd4-0 bWVZO")).click();
        sleep();
        WebElement year = driver.findElement(By.id("year"));
        String yeartext =year.getText();
        year.sendKeys("1928");
        assertEquals(year,"1928");
        System.out.println(yeartext);
        sleep();
        driver.findElement(By.className("sc-bczRLJ Buttons__Button-sc-g2fyk2-0 cUmwhS faNyi")).click();
        sleep();
        WebElement password = driver.findElement(By.id("password"));
        String passwordtext =password.getText();
        password.sendKeys("FranekkozinA2828!");
        assertEquals(password,"FranekkozinA2828!");
        System.out.println(passwordtext);
        sleep();
        WebElement passwordRepeat = driver.findElement(By.id("passwordRepeat"));
        String passwordRepeattext =passwordRepeat.getText();
        passwordRepeat.sendKeys("FranekkozinA2828!");
        assertEquals(passwordRepeat,"FranekkozinA2828!");
//        znak specjalny
        System.out.println(passwordRepeattext);
        sleep();
        driver.findElement(By.className("sc-bczRLJ Buttons__Button-sc-g2fyk2-0 cUmwhS faNyi")).click();
        sleep();
        driver.findElement(By.className("sc-bczRLJ sc-gsnTZi bzwOIK jnFvAE")).click();
        sleep();
        WebElement recoveryPhone = driver.findElement(By.id("recoveryPhone"));
        String recoveryPhonetext =recoveryPhone.getText();
        recoveryPhone.sendKeys("123456789");
        assertEquals(recoveryPhone,"123456789");
        System.out.println(recoveryPhonetext);
        sleep();
    }
    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}