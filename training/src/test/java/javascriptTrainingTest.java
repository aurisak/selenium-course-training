import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

public class javascriptTrainingTest 
{
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
    public void JavascriptTraining()   
    {
    driver.get("http://the-internet.herokuapp.com/windows");
    
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.open('http://the-internet.herokuapp.com/windows/new')");

    String firstWindow = driver.getWindowHandle();
    Set handles = driver.getWindowHandles();
    handles.remove(firstWindow);

    String secondWindow = String.valueOf(handles.iterator().next());

    driver.switchTo().window(secondWindow);
    assertEquals("New Window", driver.getTitle());

    driver.close();
    driver.switchTo().window(firstWindow);
    assertEquals("The Internet", driver.getTitle());
    }
}
