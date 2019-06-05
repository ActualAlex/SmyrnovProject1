import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SecondTest {

    private WebDriver driver;
    private String login;


    @Before
    public void setUp() {
        login = "qwe@gmail.com";
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://accounts.google.com");

    }

    @Test
    public void logInToGmailWithIncorrectMailShouldNotWork() {
        driver.findElement(By.id("identifierId")).sendKeys(login);
        driver.findElement(By.xpath("//span/span")).click();
        delay(2000);
        String message = driver.findElement(By.cssSelector(".GQ8Pzc")).getText();
        Assert.assertEquals(message , "Не удалось найти аккаунт Google");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
