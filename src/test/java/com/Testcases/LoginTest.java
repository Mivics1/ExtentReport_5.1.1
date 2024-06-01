package com.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;

public class LoginTest extends BaseClass{
	@Test (priority = 1)
	public void confirmLogo() {
		test = extent.createTest("Confirmation of Logo Test").assignAuthor("Agboola Michael Daramola")
				.assignCategory("Functional Testing").assignDevice("Windows 10");
		test.info("Locating the web element for logo");
		WebElement logo = driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']/img"));
		test.info("Confirm if the web logo is displayed");
		if(logo.isDisplayed()) {
			test.pass("Test Passed -- Logo is visible");
		} else {
			test.fail("Test Failed -- Logo not visible");
		}
	}
	@Test (priority = 2)
	public void logDetails() {
		test = extent.createTest("Validating form's fields").assignAuthor("Agboola Michael Daramola").assignCategory("Functional Testing")
				.assignDevice("Windows 10");
		test.info("Input values into the provided form's fields");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");;
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		test.info("Verify Page title");
		if(driver.getTitle().equals("OrangeHRM")) {
			test.pass("Test Pass -- Page Title confirmed");
		} else {
			test.fail("Test fail -- Page Title failed");
		}
	}

}
