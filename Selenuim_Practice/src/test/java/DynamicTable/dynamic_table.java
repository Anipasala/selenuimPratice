package DynamicTable;

import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamic_table {
	
	@Test
	public void tc_001() throws Exception {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://practice.expandtesting.com/dynamic-table");
		
		List<WebElement> rows= driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
		
		for(int r=1;r<=rows.size();r++) {
			
			List<WebElement> names= driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr["+r+"]/td[1]"));
			Thread.sleep(3000);
			for (WebElement name:names) {
				Thread.sleep(3000);
				//System.out.println(name.getText());
				
				if(name.getText().equals("Chrome")) {
					
					WebElement cupLoad= driver.findElement(By.xpath("//td[normalize-space()='Chrome']//following-sibling::td[contains(text(),'%')]"));
					
					System.out.println(cupLoad.getText());
					
					
					
				}
				
		}
			
		
		
		
	}

}
}
