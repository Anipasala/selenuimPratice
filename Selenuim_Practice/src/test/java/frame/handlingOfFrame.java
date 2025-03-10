package frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handlingOfFrame {

	@Test
	public void Tc001() throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://selenium08.blogspot.com/2019/11/selenium-iframe.html");
		Thread.sleep(3000);
		
		driver.switchTo().frame("iframe_a");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//input[@id=\"td-header-search\"])[2]")).sendKeys("hello");
		
		driver.findElement(By.xpath("//button[@id=\"td-header-search-top\"]")).click();
		
		driver.switchTo().parentFrame();
		
		WebElement frame=driver.findElement(By.id("comment-editor"));
		
		driver.switchTo().frame(frame);
		
		driver.findElement(By.xpath("//span[contains(text(),\"Sign in with Google\")]")).click();
		
		driver.quit();

	}
}