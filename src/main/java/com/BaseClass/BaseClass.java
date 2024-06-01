package com.BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	//Declare selenium webdriver
	public WebDriver driver;
	
	//Declare Extent Report Classes
	public ExtentReports extent = new ExtentReports();
	public ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\test-output\\ExtentReport\\Report.html");
	public static ExtentTest test;
	
	@BeforeTest
	public void launchBrowser() throws InterruptedException {
		htmlReporter.config().setDocumentTitle("Automation Test Report");
		htmlReporter.config().setReportName("OrangeHRM Automation Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("HostName", "My Host");
		extent.setSystemInfo("ProjectName", "OrangeHRM");
		extent.setSystemInfo("Tester", "Agboola Michael Daramola");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Browser", "Chrome");
		
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriversBrowser\\chromedriver.exe");
		driver = new ChromeDriver();
//		driver.get("https://google.com");
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void closeBrowser() {
		extent.flush();
		driver.quit();
	}
}
	
//	
//	@BeforeMethod
//	public void openBrowser() throws InterruptedException {
//
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		Thread.sleep(4000);
//	}
//	
//	@AfterMethod
//	public void closeBrowser(ITestResult result) throws IOException {
////		if(result.getStatus()==ITestResult.FAILURE) {
////			test.log(Status.FATAL, MarkupHelper.createLabel(result.getName()+" - Test Case Failed", ExtentColor.RED));
////			test.log(Status.FATAL, MarkupHelper.createLabel(result.getThrowable()+" - Test Case Failed", ExtentColor.RED));
////		} else if(result.getStatus()==ITestResult.SKIP) {
////			test.log(Status.SKIP, "Skipped Test Case is: "+result.getName());
////		} else if (result.getStatus()==ITestResult.SUCCESS) {
////			test.log(Status.PASS, "Passed Test Case is: "+result.getName());
////		}
//		driver.quit(); 
//	}
//}
