package ParallelWithDataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class parallel_Excution_DataProvider {
	
	@Test(dataProvider="logindata")
	public void tc_001(String email, String Password) throws Exception {
		
	
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/v1/");
		
		driver.findElement(By.id("user-name")).sendKeys(email);
		
		driver.findElement(By.id("password")).sendKeys(Password);
		
		driver.findElement(By.id("login-button")).click();
		
		WebElement error= driver.findElement(By.xpath("//h3[@data-test='error']"));
		
		Assert.assertEquals(error.getText(), "Epic sadface: Username and password do not match any user in this service");
		
		driver.close();
	}
	
	
	@DataProvider(parallel=true)
	public Object[][] logindata(){
		
		return new Object[][] {
			{ "user1@example.com", "password123" }, // First set of credentials
            { "user2@example.com", "password456" }, // Second set of credentials
            { "user3@example.com", "password789" },
            {"hello@gmail.com","weiuijoo"}
		};
		
	}
}
