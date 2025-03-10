package Listener_handling;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {
	
	 WebDriver driver;

	    // Initialize WebDriver before each test method
	    @BeforeMethod
	    public void setUp() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	    }

	    @Test
	    public void testMethod1() {
	        System.out.println("Executing testMethod1");
	    }

	    @Test
	    public void testMethod2() {
	        driver.get("https://www.facebook.com/");
	        System.out.println("Executing testMethod2");
	        
	        // Fail the test intentionally to trigger screenshot capture in listener
	        Assert.assertTrue(false, "Intentional failure in testMethod2");
	    }

	    // Clean up WebDriver after each test method
	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
