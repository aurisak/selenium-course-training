import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class searchAndSortTest {
    WebDriver driver;

    @Before
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void Search()
    {
        WebElement search = driver.findElement(By.id("search_query_top"));
        search.sendKeys("printed dresses");

        WebElement submitSerchButton = driver.findElement(By.xpath("//button[@name='submit_search']"));
        submitSerchButton.click();

        String searchResult = driver.findElement(By.className("lighter")).getText();
        assertTrue(searchResult.contains("PRINTED DRESSES"));

        Select drpPriceSelect = new Select(driver.findElement(By.id("selectProductSort")));
        drpPriceSelect.selectByValue("price:asc");       
    } 
}
