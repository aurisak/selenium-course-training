import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BeforeTest {
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
    public void test()
    {
        driver.get("https://saucedemo.com");
    }

}
