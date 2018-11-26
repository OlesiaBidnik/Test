import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NetcrackerTest {
    public ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/users/OlesiaBidnik/Downloads/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void isLinkEnsbled(){
        driver.get("https://www.google.com/");
        WebElement search = driver.findElement(By.xpath("//input[@type = 'text']"));
        search.click();
        search.sendKeys("Netcracker");
        search.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//a/h3[contains (text(), 'Википедия')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//table[@class = 'infobox vcard']//a[text() = 'netcracker.com']")).isEnabled());
    }

    @After
    public void close(){
        driver.quit();
    }
}

