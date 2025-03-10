package auto_suggestions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestions {

	@Test
	public void Tc001() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		
		driver.findElement(By.className("gLFyf")).sendKeys("Selenuim");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[role='listbox'] li")));
		
		
		List <WebElement> li= driver.findElements(By.cssSelector("ul[role='listbox'] li"));
		
		for (WebElement ele: li) {
			
			if(ele.getText().trim().equalsIgnoreCase("selenuim webdriver")) {
				ele.click();
				Thread.sleep(3000);
				break;
			}
		}
		
		Thread.sleep(3000);
		
		System.out.println(li.size());
		
		driver.close();
		
	}
}