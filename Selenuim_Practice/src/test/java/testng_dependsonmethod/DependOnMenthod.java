package testng_dependsonmethod;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DependOnMenthod {
	
	 WebDriver driver;

	    @BeforeMethod
	    public void setUp() {
	        WebDriverManager.chromedriver().setup(); 
	        driver = new ChromeDriver();
	    }

	    @Test
	    public void openWebsite() {
	       
	        driver.get("https://www.google.com/");

	       
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.titleContains("Google"));

	        
	        Assert.assertTrue(driver.getTitle().contains("ooogl"));
	    }

	    @Test(dependsOnMethods = "openWebsite")
	    public void performActionAfterOpeningWebsite() {
	    
	    	driver.get("https://www.google.com/");
	  
	        Assert.assertTrue(driver.getTitle().contains("Google"));
	    }

	    @AfterMethod
	    public void tearDown() {
	       
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
