import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
public class WebElementTest{

    private WebDriver driver;
    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl/test/full_form.html");
    }
    @Test
    public void typingIntoWebElementTest() {
        WebElement userNameField = driver.findElement(By.id("username"));
        sleep();
        userNameField.sendKeys("Selenium Start");
        String typeUserNameValue = userNameField.getAttribute("value");
        sleep();
        assertEquals(typeUserNameValue, "Selenium Start");
    }

    @Test
    public void filePickingTest(){


            sleep();

            WebElement uploadFilePicker = driver.findElement(By.id("upload_file"));
            uploadFilePicker.sendKeys("C:\\test.txt");
            sleep();
        }

        @Test
        public void typingAndClearingValueInsideWebElementTest() {

            WebElement userNameField = driver.findElement(By.id("username"));
            sleep();
            userNameField.sendKeys("Selenium Start");

            String typeUserNameValue = userNameField.getAttribute("value");
            sleep();

            assertEquals(typeUserNameValue, "Selenium Start");

            userNameField.clear();
            sleep();

            String emptyUserNameField = userNameField.getAttribute("value");
            assertEquals(emptyUserNameField, "");
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