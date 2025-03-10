package calender_handling;

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

public class Calender {

	@Test
	public void Tc001() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

		driver.findElement(By.id("datepicker")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement next = driver.findElement(By.xpath("//a[@title='Next']"));

		for (int i = 1; i <= 2; i++) {
			
			wait.until(ExpectedConditions.elementToBeClickable(next)).click();

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//td")));

			next = driver.findElement(By.xpath("//a[@title='Next']"));
		}

		List <WebElement> dates= driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//td"));

		for (WebElement date: dates) {

			String datename= date.getText();

			if(datename.equals("20")) {
				date.click();
				Thread.sleep(3000);
			}
		}
		driver.close();

	}
}
