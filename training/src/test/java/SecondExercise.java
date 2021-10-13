import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SecondExercise {
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
    public void SelectDropDownElement()
    {
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id='content']/ul/li[11]/a")).click();
        
         WebElement dropdown = driver.findElement(By.id("dropdown"));
         dropdown.click();

        WebElement optionOne = driver.findElement(By.cssSelector("option[value='1']"));
        WebElement optionTwo = driver.findElement(By.cssSelector("option[value='2']"));
        optionOne.click();
        assertTrue(optionOne.isSelected());
        assertFalse(optionTwo.isSelected());
    }

    @Test 
    public void PressArrow()
    {
        driver.get("http://the-internet.herokuapp.com/key_presses");
        
        WebElement input = driver.findElement(By.id("target"));
        input.click();

        input.sendKeys(Keys.ARROW_RIGHT);

        WebElement result = driver.findElement(By.id("result"));
        assertEquals("Clicked right arrow key", "You entered: RIGHT", result.getText());
    }

    @Test
    public void Hover()
    {
        driver.get("http://the-internet.herokuapp.com/hovers");

        WebElement user1 = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/img"));

        Actions action = new Actions(driver);
        action.moveToElement(user1).perform();

        WebElement userConfirmation = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/h5"));
        assertTrue("user1 is displayed when hover on first image", userConfirmation.isDisplayed());
    }

    @Test
    public void RightClick()
    {
        driver.get("http://the-internet.herokuapp.com/context_menu");

        WebElement box = driver.findElement(By.id("hot-spot"));

        Actions action = new Actions(driver);
        action.contextClick(box).perform();
        driver.switchTo().alert().accept();
    }

    @Test
    public void CheckCSSValue()
    {
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation"); 

        WebElement clicableIcon = driver.findElement(By.linkText("Clickable Icon"));
        String link = clicableIcon.getAttribute("href");
        assertEquals("https://ultimateqa.com/link-success/", link);
        assertEquals("padding-box", clicableIcon.getCssValue("background-origin"));
    }
}
