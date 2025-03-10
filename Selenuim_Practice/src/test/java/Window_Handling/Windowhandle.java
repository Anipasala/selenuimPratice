package Window_Handling;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windowhandle {

	@Test
	public void Tc001() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://omayo.blogspot.com/");
		
		String parent=driver.getWindowHandle();
		
		driver.findElement(By.linkText("Open a popup window")).click();
		
		Set <String> allwindows=driver.getWindowHandles();
		
		Iterator<String> itr= allwindows.iterator();
			 itr.next();
			String childwindow= itr.next();
		
			
		driver.switchTo().window(childwindow);
		
		String pagetitle= driver.getTitle();
		
		System.out.println(pagetitle);
		
		Thread.sleep(3000);
		
		driver.close();
		
		driver.switchTo().window(parent);
		
		driver.findElement(By.id("ta1")).sendKeys("successful completed the windows task");
		
		Thread.sleep(3000);
		
		driver.close();

	}
}
