import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CorrectTest {
    @Test
    public void elementQuiz1()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https:saucedemo.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        assertTrue(element.isDisplayed());
        driver.quit();
    }
}
