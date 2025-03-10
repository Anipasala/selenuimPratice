package DragAndDrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class manualDragAndDrop {

	@Test
	public void Tc001() throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/droppable/");
		Thread.sleep(3000);

		driver.switchTo().frame(0);

		WebElement source= driver.findElement(By.id("draggable"));

		WebElement destination= driver.findElement(By.id("droppable"));

		Actions act= new Actions(driver);
		
		act.clickAndHold(source).
		moveToElement(destination).
		release(destination).build().perform();
		
		Thread.sleep(3000);
		
		driver.close();

	}
}