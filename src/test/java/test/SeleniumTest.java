package test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {
    private static WebDriver driver;
    
    @Test
    public void testFirefoxDriver() {
        
        System.setProperty("webdriver.gecko.driver", "./src/test/java/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://www.google.com");

        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("q"))));

        WebElement input = driver.findElement(By.name("q"));
        input.sendKeys("selenium");
        input.sendKeys(Keys.ENTER);

        driver.quit();
    }
    @Test
    public void testChromeDriver() {

        System.setProperty("webdriver.chrome.driver", "./src/test/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.youtube.com/watch?v=hvCALPmg9NE");
        
        WebDriverWait waitElement = new WebDriverWait(driver,15);
        waitElement.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#container > h1 > yt-formatted-string"))));
                
        WebElement element = driver.findElement(By.xpath("//*[@id=\"container\"]/h1/yt-formatted-string"));
        Assert.assertEquals("Costi Ionita - Cate nopti am plans [HQ]",element.getText());
        
        driver.quit();
    }
}
