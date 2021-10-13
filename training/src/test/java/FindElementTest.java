import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementTest {
    @Test
    public void findFirstElement()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://saucedemo.com");

        driver.findElement(By.name("user-name"));
        driver.findElement(By.className("form_input"));
        driver.findElement(By.tagName("input"));
        driver.findElement(By.cssSelector("#user-name"));
        driver.quit();
    }
}