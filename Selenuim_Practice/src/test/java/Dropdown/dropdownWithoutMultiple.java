package Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class dropdownWithoutMultiple {
    @Test
	public void Tc001() {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://selenium08.blogspot.com/2019/11/dropdown.html");
		
		WebElement drop=driver.findElement(By.name("country"));
		
		if (drop.isDisplayed()&& drop.isDisplayed()) {
			System.out.println("Drop is enabled and displayed");
		}
		else {
			System.out.println("Dropdown is not appearing");
		}
		
		Select s= new Select(drop);
		
		if(!s.isMultiple()) {
			
			int numberOfList = s.getOptions().size();
			System.out.println(numberOfList +" total no of options presentin dropdown");
			s.selectByIndex(2);
			String option= s.getFirstSelectedOption().getText();
			System.out.println(option);
			s.selectByValue("AS");
			s.selectByVisibleText("Colombia");
			
		}
		else {
			driver.close();
		}
		
	}
	
}
