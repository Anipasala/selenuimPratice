package Dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropdownWithMultiple {
	
	    @Test
		public void Tc001() {
			WebDriverManager.chromedriver().setup();
			
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://selenium08.blogspot.com/2019/11/dropdown.html");
			
			WebElement drop=driver.findElement(By.name("Month"));
			
			if (drop.isDisplayed()&& drop.isDisplayed()) {
				System.out.println("Drop is enabled and displayed");
			}
			else {
				System.out.println("Dropdown is not appearing");
			}
			
			Select s= new Select(drop);
			
			if (s.isMultiple()) {
				
				s.selectByValue("Ap");
				s.selectByVisibleText("August");
				
				List<WebElement> selectedOPtions=s.getAllSelectedOptions();
				
				for (WebElement option: selectedOPtions) {
					
					System.out.println(option.getText());
					
				}
			}
			else {
				driver.quit();
			}
			
	 }
}
