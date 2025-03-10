package Listener_handling;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

	WebDriver driver;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test started: " + result.getName());
	}

	// This will run when a test is passed
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed: " + result.getName());
	}

	// This will run when a test fails
	@Override
	public void onTestFailure(ITestResult result) {
		TestClass testClass = (TestClass) result.getInstance();
		WebDriver driver = testClass.driver;

		if (driver != null) {
			// Capture screenshot
			TakesScreenshot ts = (TakesScreenshot) driver;
			File file = ts.getScreenshotAs(OutputType.FILE);

			try {
				FileUtils.copyFile(file, new File("D:\\Seleniumscreenshot\\testingupdate.png"));
				FileUtils.copyFile(file, new File("C:\\Selenuim\\Selenuim_Practice\\screenshots\\listnerfailure.png"));
				System.out.println("Screenshot taken on test failure: " + result.getName());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Driver is null, unable to take screenshot.");
		}
	}


	// This will run when a test is skipped
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped: " + result.getName());
	}

	// This will run when the test suite starts
	@Override
	public void onStart(org.testng.ITestContext context) {
		System.out.println("Test suite started: " + context.getName());
	}

	// This will run when the test suite finishes
	@Override
	public void onFinish(org.testng.ITestContext context) {
		System.out.println("Test suite finished: " + context.getName());
	}


}
