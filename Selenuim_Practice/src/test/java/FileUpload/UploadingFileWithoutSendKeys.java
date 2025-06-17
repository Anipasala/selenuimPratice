package FileUpload;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UploadingFileWithoutSendKeys {
	
	@Test
	public void tc_001() throws Exception {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.foundit.in/upload");
		
		driver.findElement(By.xpath("//div[@class='heroSection-buttonContainer_secondaryBtn__text']")).click();
		
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click();", driver.findElement(By.id("file-upload")));
		
		StringSelection filePath = new StringSelection("D:\\Resume Update\\Pasala_Anirudh_Resume.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
		
		//Ctrl+V
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		Thread.sleep(3000);
		// click on enter/return
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(3000);
		driver.close();
	}
}
