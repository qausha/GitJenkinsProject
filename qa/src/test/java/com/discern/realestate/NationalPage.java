package com.discern.realestate;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.thoughtworks.gauge.Step;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class NationalPage {
	
	static boolean main_stage;
	static boolean global_bar;
	static boolean carousal_charts;
	//static boolean nationalsignals;
	//static boolean relatedcompanies;
	static boolean timer_frame;
	static boolean rank_frame;
	static boolean trends_frame;
	static boolean signal_list;
	static boolean related_companies;
	static WebDriverWait wait;
	@Step("Check National Page Mainstage Opened")
	public static void mainstage() throws IOException {
		
		System.out.println("##########National page Execution started##########");
		File scrFile = ((TakesScreenshot)login.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("C:\\Users\\admin\\eclipse-workspace\\Phantom_HomeBuilders_Smoke_Testing\\NationalPage" ,".png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("screencapture taken successfully for National page");
		//WebElement nationalicon = login.driver.findElement(By.xpath("//a[@href='#/national_view/?ticker=BZH']"));
		//WebElement nationalicon = login.driver.findElement(By.cssSelector("div.sub-head-menu-section ng-scope > div.sub-head-menu-updated no-padding > a.ng-scope > li.icon_case.icon-national"));
		//nationalicon.click();
		WebElement switchLabel = login.driver.findElement(By.cssSelector("li.icon_case.icon-national"));
		String colorRGB = (String) ((JavascriptExecutor) login.driver).executeScript("arguments[0].click();", switchLabel);
		wait=new WebDriverWait(login.driver,100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='assertLocationMap']")));
		WebElement mainstage = login.driver.findElement(By.xpath(".//*[@id='assertLocationMap']"));
		main_stage=login.driver.findElement(By.xpath(".//*[@id='assertLocationMap']")).isDisplayed();
		if(mainstage.isDisplayed()) {
			
			System.out.println("Google Map is loaded in National page, no issues");
		}
		
		else {
			
			System.out.println("Issue: Google map is not loaded, please check the application");
		}
		
	}
	
	@Step("Check Global Bar is Opened")
	public static void globalbar() {
		
		List<WebElement> globalbar=login.driver.findElements(By.xpath("//div[@class='col-lg-7 col-sm-9 col-xs-12 breadcrumb-2 no-padding']"));
		global_bar=login.driver.findElement(By.xpath("//div[@class='col-lg-7 col-sm-9 col-xs-12 breadcrumb-2 no-padding']")).isDisplayed();
		System.out.println("size of global bar in National page:"+globalbar.size());
	
		for(WebElement w:globalbar) {
			
			System.out.println("text in national page is:"+w.getText());
			
			break;
		}
	}
	
 
	@Step("Check Signals List is showing")
	public static void signals_list() {
		
		//signal and dataset buttons
		WebElement signalbutton = login.driver.findElement(By.xpath("//div[@class='header-bg-1']"));
		System.out.println("Signal button and dataset buttons are enabled in National page:"+signalbutton.isEnabled());
		//signalslist
		WebElement signalslist = login.driver.findElement(By.xpath("//ul[@class='list-group independents-list scroll-x']"));
		signal_list=login.driver.findElement(By.xpath("//ul[@class='list-group independents-list scroll-x']")).isDisplayed();
		System.out.println("Signals list is present in National page:"+signalslist.isDisplayed());
	}
	
	@Step("Check Related Companies are showing")
	public static void related_companies() {
		
		//related companies validation
		WebElement relatedcompanies = login.driver.findElement(By.xpath("//div[@class='related-company-tab']"));
		related_companies= login.driver.findElement(By.xpath("//div[@class='related-company-tab']")).isDisplayed();
		System.out.println("Related companies are loaded in National Page:"+relatedcompanies.isDisplayed());
		
	}
	
	@Step("Check National Page Timer is showing")
	public static void timer() {
		
		//Timer and Rank is displayed
		WebElement timer1 = login.driver.findElement(By.xpath("//div[@id='bottom_chart']"));
		timer_frame=login.driver.findElement(By.xpath("//div[@id='bottom_chart']")).isDisplayed();
		System.out.println("Timer is loaded in National page:"+timer1.isDisplayed());
		//WebElement timer2= login.driver.findElement(By.cssSelector("div.highcharts-container > svg.highcharts-root > rect.highcharts-plot-border"));
		//System.out.println("Timer data is displayed in National page:"+timer2.isDisplayed());
		//Trends validation
	}
	@Step("Check National Page Trends is showing")
	public static void trends() {
		WebElement trends = login.driver.findElement(By.xpath("//button[@id='dropdownMenu1']"));
		trends_frame=login.driver.findElement(By.xpath("//button[@id='dropdownMenu1']")).isDisplayed();
		if(trends.isEnabled())
		{
			System.out.println("Trends button is enabled in National page");
		}
		else {
			System.out.println("Issue: Trends are not enabled in National page");
		}
	}
	@Step("Check National Page Rank is showing")
	public static void rank() {
		//Rank Validation
		//rank complete frame
		WebElement rank = login.driver.findElement(By.xpath("//*[@id='rankChart']"));
		rank_frame=login.driver.findElement(By.xpath("//*[@id='rankChart']")).isDisplayed();
		if(rank.isDisplayed())
		{
			System.out.println("Rank is loaded in National page");
		}
		else {
			System.out.println("Issue: Rank is not loaded in National page");
		}
		//rank header section
		WebElement rankdetails = login.driver.findElement(By.xpath("//div[@class='Table rank-table']"));
		System.out.println("Rank details are:"+rankdetails.getText());
		if(rankdetails.isDisplayed()) {
			System.out.println("Rank details are properly loaded in National page");
		}
		else {
			System.out.println("Issue: Rank details are not loaded properly in National page");
		}
		//rank magnitude value
		WebElement rankno = login.driver.findElement(By.xpath("//span[@class='slider-value ng-binding']"));
		System.out.println("Rank magnitude value in National page is:"+rankno.getText());
		if(rankno.isDisplayed()) {
			
			System.out.println("Rank Magnitude value is displayed in National page");
		}
		
		else {
			System.out.println("Issue: Rank magnitude value is not displayed in National page");
		}
		//rank green bars
		WebElement rankgreenbar = login.driver.findElement(By.xpath("//div[@class='Row ng-scope last-rank-row-1']"));
		if(rankgreenbar.isDisplayed())
		{
			System.out.println("Rank green bars are loaded in National page");
		}
		else {
			
			System.out.println("Issue: Rank green bars are not there in National page, pls check application");
		}
	}
	

}

//@Test(priority=7)
//public static void carousalcharts() {
//	
//	WebElement carousalcharts = login.driver.findElement(By.xpath("//div[@class='slider-tile-section']"));
//	carousal_charts=login.driver.findElement(By.xpath("//div[@class='slider-tile-section']")).isDisplayed();
//	System.out.println("carousal charts are:"+carousalcharts.getText());
//	if(carousalcharts.isDisplayed())
//	{
//		System.out.println("Carousal charts are loaded in National page");
//	}
//	else {
//		
//		System.out.println("Issue: Carousal charts are not loaded, please check the application");
//	}
//}
