package testng_parallel;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassB {
	
	@Test
    public void testMethodB1() {
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        // Open Facebook
        driver.get("https://www.facebook.com");
        
        // Output the current thread ID and the URL opened
        System.out.println("ClassB - Opened Facebook in thread: " + Thread.currentThread().getId() + " with URL: " + driver.getCurrentUrl());
        
        // Close the browser
        driver.quit();
    }
	 @Test
	    public void openGoogleClassB2() {
	        // Setup ChromeDriver using WebDriverManager
	        WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        
	        // Open Facebook again
	        driver.get("https://www.google.com/");
	        
	        // Output the current thread ID and the URL opened
	        System.out.println("ClassB - Opened google thread: " + Thread.currentThread().getId() + " with URL: " + driver.getCurrentUrl());
	        
	        // Close the browser
	        driver.quit();
	    }

}
