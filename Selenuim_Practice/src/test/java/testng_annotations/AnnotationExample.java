package testng_annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AnnotationExample {

	WebDriver driver;

	
		@BeforeClass
		public void beforeClass() {
			WebDriverManager.chromedriver().setup();
		}

		@BeforeMethod
		public void beforeMethod() {
			driver = new ChromeDriver();
		}

		@Test
		public void testOpenFacebook() {
			driver.get("https://www.facebook.com");
			System.out.println("Opened Facebook in thread: " + Thread.currentThread().getId());
		}

		@Test
		public void testOpenFacebookLoginPage() {
			driver.get("https://www.facebook.com/login");
			System.out.println("Opened Facebook Login page in thread: " + Thread.currentThread().getId());
		}

		@AfterMethod
		public void afterMethod() {
			if (driver != null) {
				driver.quit();
			}
		}

		@AfterClass
		public void afterClass() {
			System.out.println("All tests in the class have been completed.");
		}

	}
