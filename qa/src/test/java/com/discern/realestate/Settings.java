package com.discern.realestate;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.thoughtworks.gauge.Step;

public class Settings {
	
	static boolean Portfolios;
	static boolean Signals;
	static boolean Products;
	static boolean Notification;
	static WebDriverWait wait;
	
	@Step("Check Settings is showing up")
	public static void settings_tabs() throws IOException {
		
		login.driver.findElement(By.cssSelector("i.dropdown-toggle.icon-hamberger")).click();
		login.driver.findElement(By.linkText("Settings")).click();
		wait=new WebDriverWait(login.driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='discern-checkbox-label']")));
		File scrFile = ((TakesScreenshot)login.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("C:\\Users\\admin\\eclipse-workspace\\Phantom_HomeBuilders_Smoke_Testing\\SettingsPage" ,".png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("screencapture taken successfully for Settings page");
		Portfolios=login.driver.findElement(By.linkText("Portfolios")).isDisplayed();
		Signals=login.driver.findElement(By.linkText("Signals")).isDisplayed();
		Products=login.driver.findElement(By.linkText("Products")).isDisplayed();
		Notification=login.driver.findElement(By.linkText("Notification")).isDisplayed();
		
		
//		//Assert.assertTrue(login.driver.getPageSource().
//		System.out.println("entered settings class");
//		
//		//locate the menu to hover over using its xpath
//		
//		WebElement menu = login.driver.findElement(By.cssSelector("i.dropdown-toggle.icon-hamberger"));
//		
//		//Initiate mouse action using Actions class
//		Actions builder = new Actions(login.driver);    
//		
//		// move the mouse to the earlier identified menu option
//		builder.moveToElement(menu).build().perform();
//		
//		//click on hamburgericon
//		menu.click();
		
		// wait for max of 5 seconds before proceeding. This allows sub menu appears properly before trying to click on it
//		WebDriverWait wait = new WebDriverWait(login.driver, 5); 
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href, '/#/settings_view/portfolios')]")));  // until this submenu is found
//		
//		//identify menu option from the resulting menu display and click
//		WebElement menuOption = login.driver.findElement(By.xpath("//a[contains(text(),'Settings')]")); //div[contains(text(),'breadcrumb-company-price')]
//		menuOption.click();
//		login.Wait(3000);
//		
//		System.out.println("element clicked");
		//Assert.assertTrue(login.driver.getPageSource().contains("Settings"));
		//Assert.assertTrue(login.driver.getPageSource().contains("Portfolios"));
		
		
		
	}

}
