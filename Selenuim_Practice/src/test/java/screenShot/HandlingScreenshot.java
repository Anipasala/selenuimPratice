package screenShot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingScreenshot {

	@Test
	public void Tc001() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		
		File file= ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File( "D:\\Seleniumscreenshot\\testingupdate.png"));
		FileUtils.copyFile(file, new File( "C:\\Selenuim\\Selenuim_Practice\\screenshots\\testingUpdate.png"));
		
		
		driver.close();

	}
}