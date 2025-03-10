package testng_annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Annotations {
	
	WebDriver driver;

    // This runs before any test suite starts
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite: This runs before the entire test suite");
    }

    // This runs after all the tests in the suite have finished
    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite: This runs after the entire test suite");
    }

    // This runs before each test
    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test: This runs before any tests in this test class");
    }

    // This runs after each test
    @AfterTest
    public void afterTest() {
        System.out.println("After Test: This runs after all tests in this test class");
    }

    // This runs before the first test method in this class
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class: This runs before the first test method in the class");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    // This runs after all test methods in this class
    @AfterClass
    public void afterClass() {
        System.out.println("After Class: This runs after all test methods in the class");
        if (driver != null) {
            driver.quit();
        }
    }

    // This runs before each test method
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method: This runs before each test method");
        // Open the browser and navigate to the website
        driver.get("https://www.google.com");
    }

    // This runs after each test method
    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method: This runs after each test method");
        // You can add any post-test cleanup code here (e.g., taking a screenshot)
    }

    // This is a test method
    @Test
    public void testOpenGoogle() {
        System.out.println("Test 1: Opening Google");
        System.out.println("Page Title: " + driver.getTitle());
    }

    // Another test method
    @Test
    public void testOpenFacebook() {
        driver.get("https://www.facebook.com");
        System.out.println("Test 2: Opening Facebook");
        System.out.println("Page Title: " + driver.getTitle());
    }

    // A third test method
    @Test
    public void testOpenTwitter() {
        driver.get("https://www.twitter.com");
        System.out.println("Test 3: Opening Twitter");
        System.out.println("Page Title: " + driver.getTitle());
    }

}
