import static org.junit.Assert.assertTrue;

import java.time.Duration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OrderTest {
    WebDriver driver;

    @Before
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void ShopItemOrder() throws InterruptedException
    {
        Actions action = new Actions(driver);

        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li/a[@title=('T-shirts')]")).click();

        String TShirtsText = driver.findElement(By.cssSelector("span.cat-name")).getText();

        assertTrue(TShirtsText.contains("T-SHIRTS"));

        action.moveToElement(driver.findElement(By.cssSelector(".product_img_link")));
        action.perform();

        WebElement addToCartButton = driver.findElement(By.cssSelector(".button.ajax_add_to_cart_button.btn.btn-default"));   
        addToCartButton.isDisplayed();
        addToCartButton.click();


        WebElement addToCartWindow = driver.findElement(By.cssSelector("#layer_cart"));
        addToCartWindow.isDisplayed();

        WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//*[@id='layer_cart']//a[@title='Proceed to checkout']"));
        proceedToCheckoutButton.isDisplayed();
        proceedToCheckoutButton.click();

        WebElement cartSummaryTitle = driver.findElement(By.cssSelector("#cart_title"));
        cartSummaryTitle.isDisplayed();

        WebElement addAmount = driver.findElement(By.cssSelector(".icon-plus"));
        addAmount.click();

        Thread.sleep(10000);

        String quantity=driver.findElement(By.xpath("//input[@value='2']")).getAttribute("value");

        System.out.println(quantity);
        
        String quantitySummaryText = driver.findElement(By.id("summary_products_quantity")).getText();
        assertTrue(quantitySummaryText.contains("2 Products"));

        WebElement summaryOrderProceed = driver.findElement(By.xpath("//p//a[@title='Proceed to checkout']"));
        summaryOrderProceed.click();

        WebElement creatAccountForm = driver.findElement(By.id("create-account_form"));
        creatAccountForm.isDisplayed();
    }
}
