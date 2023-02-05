import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MyTest {


    private WebDriver driver;

    private void sleep() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://poczta.wp.pl/w/#/mails/?label=152");
        sleep(); //czekamy chwile, az się wszytsko załąduje i pokaze prośba o ciasteczka
    }

    @Test
    public void fullEmailTest() {
        //akceptujemy ciasteczka
        WebElement ciasteczkaButton = driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div[3]/div/button[2]"));
        ciasteczkaButton.click();
        sleep();
        //wpisujemy e-mail w pole login
        WebElement userNameField = driver.findElement(By.name("login_username"));
        userNameField.sendKeys("kacper.pilat@wp.pl");

        //wpisujemy hasło w pole password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("PropertyBrain98!");
        sleep();
        //klikamy zaloguj
        WebElement zalogujButton = driver.findElement(By.cssSelector("#stgMain > div > div > div.sc-bdvvtL.sc-gsDKAQ.styled__Wrapper-sc-1bs2nwv-9.ekJwFE.hIxhWw.dGxDai.login-box > form > button"));
        zalogujButton.click();
        sleep();
        //czekamy (sleep) aż się wszystko załaduje i klikamy przycisk "napisz"
        WebElement napiszButton = driver.findElement(By.xpath("//*[@id=\"main\"]/nh-app-view/div/div[2]/div/div[1]/div/div/div/div/nh-top-action-bar/div[2]/div[1]/button[2]"));
        napiszButton.click();
        sleep();
        //czekamy, aż się wszystko załaduje i wypełniamy pola adresata/temat/treść maila
        WebElement poleDo = driver.findElement(By.xpath("//*[@id=\"draftComponent\"]/div[1]/div/div[1]/div[2]/div[2]/div/div/input"));
        poleDo.sendKeys("falczi1404@gmail.com");
        String poleDoValue = poleDo.getAttribute("value");
        assertEquals(poleDoValue,"falczi1404@gmail.com"); //przykładowa asercja, sprawdzamy, czy wpisany adres e-mail zgadza się z zamierzonym
        sleep();
        WebElement subjectEmail = driver.findElement(By.name("subject"));
        subjectEmail.sendKeys("nauka Selenium 2 :)");
        WebElement email = driver.findElement(By.xpath("//*[@id=\"draftComponent\"]/div[1]/div/div[2]/div[2]"));
        email.getAttribute("value");
        email.clear(); //czyszczenie pola z treścią (domyślnie jest stopka)
        email.sendKeys("Dzień dobry maluszku 2 :)");
        //klikamy przycisk wyślij
        sleep();
        WebElement wyslijButton = driver.findElement(By.xpath("//*[@id=\"topbar\"]/div/div[1]/button"));
        wyslijButton.click();


    }

    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
