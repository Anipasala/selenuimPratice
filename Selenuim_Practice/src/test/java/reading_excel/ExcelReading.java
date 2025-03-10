package reading_excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelReading {
	@Test
	public void tc01() throws IOException, InterruptedException {
		
		 WebDriver driver;
		

		File file = new File("C:\\ExcelData\\Book1.xlsx");  
		if (file.exists() && file.canRead()) {
			System.out.println("File exists and is readable.");
		} else {
			System.out.println("File does not exist or cannot be read.");
		}
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

		FileInputStream fs = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int lastRowValue= sheet.getLastRowNum();
		
		for(int i= 0;i<=lastRowValue;i++) {
			XSSFCell username= sheet.getRow(i).getCell(0);
			XSSFCell password= sheet.getRow(i).getCell(1);
			
			String user=username.toString();
			String pass=password.toString();
			
			driver.findElement(By.id("email")).sendKeys(user);
			
			driver.findElement(By.id("pass")).sendKeys(pass);
			
			Thread.sleep(3000);
			
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("pass")).clear();
			
			
		}
		
		Thread.sleep(3000);
		
		driver.close();
		wb.close();
		
		
	}

}
