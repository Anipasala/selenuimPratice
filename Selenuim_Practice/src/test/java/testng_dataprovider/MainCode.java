package testng_dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MainCode {
	
	WebDriver driver;

    // Initialize WebDriver
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup(); // Automatically sets up the ChromeDriver
        driver = new ChromeDriver();
    }
    
    @Test(dataProvider = "loginCredentials", dataProviderClass = TestData.class)
    public void testLogin(String email, String password) throws InterruptedException {
    	
    	driver.get("https://www.facebook.com/");
             	
    	 WebElement emailField = driver.findElement(By.id("email"));
         emailField.sendKeys(email);
         
         WebElement passwordField = driver.findElement(By.id("pass"));
         passwordField.sendKeys(password);
         
         Thread.sleep(3000);
         
         WebElement loginButton = driver.findElement(By.name("login"));
         loginButton.click();
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
