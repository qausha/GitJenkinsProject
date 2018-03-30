package com.discern.realestate;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.thoughtworks.gauge.Step;

public class Logout {
	
	static boolean logout_success;
	static WebDriverWait wait;
	@Step("Check the Logout is working")
	public static void logout() throws IOException {
		
		login.driver.findElement(By.cssSelector("i.dropdown-toggle.icon-hamberger")).click();
		login.driver.findElement(By.linkText("Logout")).click();
		wait=new WebDriverWait(login.driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='sign-in-btn']")));
		File scrFile = ((TakesScreenshot)login.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Users\\admin\\eclipse-workspace\\Phantom_HomeBuilders_Smoke_Testing\\Logout" ,".png"));
		
		System.out.println("screencapture taken successfully for Logout page");
		logout_success=login.driver.findElement(By.xpath("//button[@class='sign-in-btn']")).isDisplayed();
		
	}

}
