import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ThirdTest {

    private WebDriver driver;
    private String login, password;


    @Before
    public void setUp() {
        login = "as0701866@gmail.com";
        password = "123";

        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://accounts.google.com");

    }

    @Test
    public void loginToGmailWithIncorrectPasswordShouldNotWork() {
        driver.findElement(By.id("identifierId")).sendKeys(login);
        driver.findElement(By.xpath("//content/span")).click();
        delay(2000);
        driver.findElement(By.cssSelector("input[type=password]")).sendKeys(password);
        driver.findElement(By.xpath("//div/div/content/span")).click();
        delay(2000);
        String message = driver.findElement(By.cssSelector(".GQ8Pzc")).getText();
        Assert.assertEquals(message , "Неверный пароль. Повторите попытку или нажмите на ссылку \"Забыли пароль?\", чтобы сбросить его.");
    }

    @After
    public void tearDown() {
        delay(2000);
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
