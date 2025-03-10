package Alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class alertsHandling {
	 @Test
		public void Tc001() throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://the-internet.herokuapp.com/javascript_alerts");
			
			driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]")).click();
			
			Thread.sleep(3000);
			
			driver.switchTo().alert().accept();
			
			Thread.sleep(3000);
			
			// checking both dismiss and accept
			
			driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]")).click();
			
			Thread.sleep(3000);
			
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]")).click();
			
			Thread.sleep(3000);
			
			driver.switchTo().alert().dismiss();
			Thread.sleep(3000);
			
			//now writing the alert box
			
			driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]")).click();
			
			Thread.sleep(3000);
			
			driver.switchTo().alert().sendKeys("hello world");
			
			Thread.sleep(3000);
			
			driver.switchTo().alert().accept();
			
			driver.quit();
				
		 }
	}
