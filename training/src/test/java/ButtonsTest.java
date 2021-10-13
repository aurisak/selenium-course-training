import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButtonsTest {
    WebDriver driver;

    @Before
    public void setUp()
    {
     driver = new ChromeDriver();
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void ButtonOne()
    {
    driver.get("https://ultimateqa.com/simple-html-elements-for-automation");
    driver.findElement(By.xpath("//*[contains(text(),'Xpath Button 1')]"));
    }

    @Test
    public void LocatorExam()
    {
        driver.get("https://saucedemo.com");
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).click();
        driver.findElement(By.xpath("//*[@id='checkout']")).click();
        driver.findElement(By.id("first-name")).sendKeys("first name");
        driver.findElement(By.id("last-name")).sendKeys("last name");
        driver.findElement(By.id("postal-code")).sendKeys("zip");
        driver.findElement(By.cssSelector(".btn_primary.cart_button")).click();
        driver.findElement(By.id("finish")).click();

       driver.findElement(By.cssSelector(".pony_express")).isDisplayed();
    }
}
