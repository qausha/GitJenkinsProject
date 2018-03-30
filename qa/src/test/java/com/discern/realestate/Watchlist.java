package com.discern.realestate;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.discern.properties.PropertiesReading;
import com.thoughtworks.gauge.Step;

public class Watchlist {
	
	static boolean heatmaps;
	static boolean portfoilios;
	static String ticker=PropertiesReading.getValue("ticker");
	//static boolean AllTicker;
	//static boolean watchlistsignals;
	static WebDriverWait wait;
	@Step("Check Watchlist is showing up")

	public static void watchlist() throws IOException, InterruptedException {
		System.out.println("###########Watchlist execution started#############");
		
		
		File scrFile = ((TakesScreenshot)login.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Users\\admin\\eclipse-workspace\\Phantom_HomeBuilders_Smoke_Testing\\Watchlist" ,".png"));
		
		System.out.println("screencapture taken successfully for watchlist page");
		//login.Wait(1000);
		//verifying heatmap present or not , all 4
	}
	@Step("Check HeatMaps are showing up")
	public static void heatmaps() {
		List<WebElement> heatmap = login.driver.findElements(By.xpath("//div[@class='watchlist-chart']"));
		System.out.println("size is:"+heatmap.size());
		//System.out.println("heat map is displayed: "+heatmap.isDisplayed());
		WebElement heatmap1 = login.driver.findElement(By.cssSelector("#heat_map1"));	
		System.out.println("heat map is displayed: "+heatmap1.isDisplayed());
		heatmaps=login.driver.findElement(By.cssSelector("#heat_map1")).isDisplayed();
	}
	@Step("Check Portfolio List is showing up")
	public static void portfolioList() {
		//portfolio dropdown
		List<WebElement> portfolio_dropdown = login.driver.findElements(By.xpath("//select"));
		
		System.out.println("Portfolio dropdown list is:"+portfolio_dropdown.size());
		WebElement pdropdown=login.driver.findElement(By.xpath("//select[@class='portfolio-dropdown ng-scope ng-pristine ng-valid']"));
		System.out.println("Portfolio dropdown is showing up:"+pdropdown.isDisplayed());
		portfoilios=login.driver.findElement(By.xpath("//select[@class='portfolio-dropdown ng-scope ng-pristine ng-valid']")).isDisplayed();
	}
	@Step("Check ALL Ticker is showing up")
	public static void allTicker() {
		//all ticker
		//WebElement allTicker=login.driver.findElement(By.xpath("//a[@href='http://dev.discernnetwork.com/#/national_view/?ticker=_ALL']"));
		wait=new WebDriverWait(login.driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='http://app.discern.com/#/national_view/?ticker=_ALL']")));
		login.driver.findElement(By.xpath("//a[@href='http://dev.discernnetwork.com/#/company_view/?ticker=_ALL']")).isEnabled();
		System.out.println("ALL ticker is present in HomeBuilder");
	}
	
		//AllTicker=login.driver.findElement(By.xpath("//select[@class='portfolio-dropdown ng-scope ng-pristine ng-valid']")).isDisplayed();
		//System.out.println("Portfolio list is:"+pdropdown.getText());
	@Step("Check if the Buttons Navigation is working")
	public static void buttonsNavigation() {
		//verify is search bar is working or not
		WebElement searchbar=login.driver.findElement(By.xpath("//div[@class='input-group search-input add-on']"));
		System.out.println("search bar enabled:"+searchbar.isEnabled());
		login.driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(PropertiesReading.getValue("ticker"));
		login.driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='http://dev.discernnetwork.com/#/company_view/?ticker=BZH&signalView=true']")));
		login.driver.findElement(By.xpath(PropertiesReading.getValue("signal_view"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='signal-clock-menu']")));
		System.out.println("Signal page opened");
		//login.driver.navigate().back();
		
	}
}


//Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='text'])[3]"));
//WebElement heatmap = driver.findElement(By.cssSelector("#heat_map1"));
	/*wait=new WebDriverWait(login.driver, 122);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='http://dev.discernnetwork.com/#/company_view/?ticker=BZH']")));
login.driver.findElement(By.xpath(PropertiesReading.getValue("national_page"))).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='assertLocationMap']")));
WebElement staleElementMap=login.driver.findElement(By.xpath("//*[@id='assertLocationMap']"));
//login.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='assertLocationMap']")));
System.out.println("National page opened");
login.driver.navigate().back();
//icons navigations - company page
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Watchlist')]")));
//wait.until(ExpectedConditions.stalenessOf(staleElementMap));
login.driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(PropertiesReading.getValue("ticker"));

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='http://dev.discernnetwork.com/#/company_view/?ticker=BZH'])[2]")));
login.driver.findElement(By.xpath(PropertiesReading.getValue("company_page"))).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='aperture_chart']")));
System.out.println("Company page opened");
login.driver.navigate().back();
//icons navigations - signal page
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Watchlist')]")));
login.driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(PropertiesReading.getValue("ticker"));
*/