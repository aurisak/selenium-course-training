import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
    @BeforeClass 
    public static void setupClass () {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void myTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://example.cypress.io");
        driver.quit();
    }
}


