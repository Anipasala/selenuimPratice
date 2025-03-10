package tableHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tablehandle {

	@Test
	public void Tc001() throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		String beforexpath= "//table[@id=\"customers\"]/tbody/tr[";
		
		String afterxpath= "]/td[1]";
		
		for (int i=2;i<=7;i++) {
			
			String fin = beforexpath + i+ afterxpath;
			
			WebElement ele = driver.findElement(By.xpath(fin));
			
			System.out.println(ele.getText());
		}
		
		driver.close();

	}
}