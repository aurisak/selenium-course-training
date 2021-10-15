import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ThirdExerciseTests {
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
   public void FocusedElement()
   {
        driver.get("https://example.cypress.io/commands/actions");
        WebElement password = driver.findElement(By.cssSelector(".action-focus"));

        Actions actions = new Actions(driver);
        actions.moveToElement(password).click().perform();
        assertTrue(driver.findElement(By.xpath("//*[@for='password1']")).getAttribute("style").contains("color: orange"));
   }

   @Test
   public void Cookies()
   {
       driver.get("https://example.cypress.io/commands/cookies");
       WebElement element = driver.findElement(By.cssSelector("#getCookie .set-a-cookie"));
       element.click();

       var cookie = driver.manage().getCookieNamed("token");
       assertEquals("123ABC", ((Cookie) cookie).getValue());
   }

   @Test
   public void ScrollTestOne() throws InterruptedException
   {
       driver.get("https://ultimateqa.com/complicated-page");
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
       Thread.sleep(3000);
   }

  @Test
  public void ScrollTestTwo() throws InterruptedException
  {
    driver.get("https://ultimateqa.com/complicated-page");
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    Thread.sleep(3000);

    js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    Thread.sleep(3000);
  } 
}
