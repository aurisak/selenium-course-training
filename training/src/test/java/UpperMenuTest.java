import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UpperMenuTest {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void womenTag() 
    {
        By womenMenuSelector = By.xpath("//*[@id='block_top_menu']/ul/li/a[@title=('Women')]");
        By womenHoverSelector = By.cssSelector(".sfHoverForce.sfHover");
        Actions action = new Actions(driver);

        driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");

        WebElement women = driver.findElement(womenMenuSelector);

        action.moveToElement(women).perform();
        WebElement womenHover = driver.findElement(womenHoverSelector);

        assertTrue("menu item women is visible on hoover", womenHover.isDisplayed());
    }

    @Test
    public void DressesTag()
    {
        By dressesMenuSelector = By.xpath("//*[@id='block_top_menu']/ul/li/a[@title=('Dresses')]");
        By dressesHoverSelector = By.cssSelector(".sfHover");
        By summerDressesSelector = By.xpath("//*[@id='block_top_menu']/ul/li[2]/ul/li[3]/a[@title=('Summer Dresses')]");
        By summerDressesSectionSelector = By.cssSelector("span.cat-name");
        Actions action = new Actions(driver);

        driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");

        WebElement dresses = driver.findElement(dressesMenuSelector);

        action.moveToElement(dresses).perform();
        WebElement dressesHover = driver.findElement(dressesHoverSelector);
        assertTrue("menu item dresses is visible on hoover", dressesHover.isDisplayed());

        WebElement summerDresses = driver.findElement(summerDressesSelector);
        summerDresses.click();

        WebElement summerDressesSection = driver.findElement(summerDressesSectionSelector);
        String summerDressesSectionText = summerDressesSection.getText();
        assertTrue(summerDressesSectionText.contains("SUMMER DRESSES"));
    }
}
