import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstTest {

   private WebDriver driver;
   private String login, password;


    @Before
    public void setUp() {
        login = "as0701866@gmail.com";
        password = "123qwe321ewq";

        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://accounts.google.com");

    }

    @Test
    public void logInToGmailShouldWork() {
         driver.findElement(By.id("identifierId")).sendKeys(login);
         driver.findElement(By.xpath("//content/span")).click();
         delay(2000);
         driver.findElement(By.cssSelector("input[type=password]")).sendKeys(password);
         driver.findElement(By.xpath("//div/div/content/span")).click();
         delay(2000);
         String message = driver.findElement(By.cssSelector(".x7WrMb")).getText();
         Assert.assertEquals(message, "Добро пожаловать, Алексей Смирнов!");
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
