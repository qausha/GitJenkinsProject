package com.discern.realestate;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;

import com.thoughtworks.gauge.Step;

public class CompanyPage {
	
	static boolean global_bar;
	static boolean signal_button;
	static boolean signal_list;
	static boolean signal_chart;
	static boolean aperture_chart;
	static boolean related_companies;
	static boolean timer;
	static boolean rank_frame;
	static boolean trends_frame;
	static boolean carousal_charts;
	static WebDriverWait wait;

	@Step("Open Company Page")
	public static void globalbar() throws IOException {
		
		System.out.println("##########Company page execution started###########");
		
		File scrFile = ((TakesScreenshot)login.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Users\\admin\\eclipse-workspace\\Phantom_HomeBuilders_Smoke_Testing\\CompanyPage" ,".png"));
		
		System.out.println("screencapture taken successfully for Company page");
		
		List<WebElement> globalbar=login.driver.findElements(By.xpath("//div[@class='col-lg-7 col-sm-9 col-xs-12 breadcrumb-2 no-padding']"));
		System.out.println("size is:"+globalbar.size());
		global_bar=login.driver.findElement(By.xpath("//div[@class='col-lg-7 col-sm-9 col-xs-12 breadcrumb-2 no-padding']")).isDisplayed();
	
		for(WebElement w:globalbar) {
			
			System.out.println("text is:"+w.getText());
			
			break;
		}
			
	}
	@Step("Open Signal View chart")
	public static void signal_view_chart() {
		//signal view checking
		wait=new WebDriverWait(login.driver, 60);
		WebElement signalpage = login.driver.findElement(By.xpath("//div[@class='signal-clock-list']"));
		System.out.println("Signal clock is showing up:"+signalpage.isEnabled());
		WebElement signalcount = login.driver.findElement(By.xpath("//div[@class='signal-count']"));
		System.out.println("Signal count is showing up:"+signalcount.isEnabled());
		System.out.println("Signal count is:"+signalcount.getText());
		//signal and dataset buttons
		WebElement signalbutton = login.driver.findElement(By.xpath("//div[@class='header-bg-1']"));
		System.out.println("Signal button and dataset buttons are enabled:"+signalbutton.isEnabled());
		signal_button=login.driver.findElement(By.xpath("//div[@class='header-bg-1']")).isEnabled();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='header-bg-1']")));
		//signalslist
		WebElement signalslist = login.driver.findElement(By.xpath("//p[@class='comp-list-label']"));
		System.out.println("Signals list is present in company page:"+signalslist.isDisplayed());
		signal_list=login.driver.findElement(By.xpath("//p[@class='comp-list-label']")).isDisplayed();
		//signal chart navigation and validation
		WebElement signalchart = login.driver.findElement(By.xpath("//button[@class='glyphicon glyphicon-stats']"));
		signal_chart=login.driver.findElement(By.xpath("//button[@class='glyphicon glyphicon-stats']")).isDisplayed();
		signalchart.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='glyphicon glyphicon-stats']")));
		System.out.println("Signal chart is displayed in company page:"+signalchart.isEnabled());
	}
	@Step("Check aperture chart is present")
	public static void apertureChart() {
		//aperture chart navigation and validation
		WebElement aperturechart = login.driver.findElement(By.xpath("//button[@class='triggerIcon-aperture']"));
				aperturechart.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='apertureChart']")));
		WebElement apertureframe = login.driver.findElement(By.xpath("//div[@id='apertureChart']"));
		aperture_chart=login.driver.findElement(By.xpath("//div[@id='apertureChart']")).isDisplayed();
		System.out.println("Aperture chart is loaded:"+apertureframe.isDisplayed());
	}
	@Step("Check Related companies are present")
	public static void relatedCompanies() {
		//related companies validation
		WebElement relatedcompanies = login.driver.findElement(By.xpath("//div[@class='related-company-tab']"));
		related_companies=login.driver.findElement(By.xpath("//div[@class='related-company-tab']")).isDisplayed();
		System.out.println("Related companies are loaded in Company page:"+relatedcompanies.isDisplayed());
	}
	@Step("Check Timer is Present")
	public static void Timer() {
		//Timer and Rank is displayed
		WebElement timer1 = login.driver.findElement(By.xpath("//div[@id='bottom_chart']"));
		System.out.println("Timer is loaded:"+timer1.isDisplayed());
	}
		//WebElement timer2= login.driver.findElement(By.cssSelector("div.highcharts-container > svg.highcharts-root > rect.highcharts-background"));
		//System.out.println("Timer data is displayed:"+timer2.isDisplayed());
		//timer=login.driver.findElement(By.cssSelector("div.highcharts-container > svg.highcharts-root > rect.highcharts-background")).isDisplayed();
	@Step("Check Trends are displayed")
	public static void Trends() {
		//Trends validation
		WebElement trends = login.driver.findElement(By.xpath("//button[@class='btn btn-default btn-trends dropdown-toggle']"));
		trends_frame=login.driver.findElement(By.xpath("//button[@class='btn btn-default btn-trends dropdown-toggle']")).isDisplayed();
		if(trends.isEnabled())
		{
			System.out.println("Trends button is enabled");
		}
		else {
			System.out.println("Issue: Trends are not enabled");
		}
	}
	@Step("Check Rank is Present")
	public static void rank() {
		//Rank Validation
		//rank complete frame
		WebElement rank = login.driver.findElement(By.xpath("//div[@class='company-rank']"));
		rank_frame=login.driver.findElement(By.xpath("//div[@class='company-rank']")).isDisplayed();
		if(rank.isDisplayed())
		{
			System.out.println("Rank is loaded");
		}
		else {
			System.out.println("Issue: Rank is not loaded");
		}
		//rank header section
		WebElement rankdetails = login.driver.findElement(By.xpath("//div[@class='Table rank-table']"));
		System.out.println("Rank details are:"+rankdetails.getText());
		if(rankdetails.isDisplayed()) {
			System.out.println("Rank details are properly loaded");
		}
		else {
			System.out.println("Issue: Rank details are not loaded properly");
		}
		//rank magnitude value
		WebElement rankno = login.driver.findElement(By.xpath("//span[@class='slider-value ng-binding']"));
		System.out.println("Rank magnitude value is:"+rankno.getText());
		if(rankno.isDisplayed()) {
			
			System.out.println("Rank Magnitude value is displayed");
		}
		
		else {
			System.out.println("Issue: Rank magnitude value is not displayed");
		}
		//rank green bars
		WebElement rankgreenbar = login.driver.findElement(By.xpath("//div[@class='Row ng-scope last-rank-row-1']"));
		if(rankgreenbar.isDisplayed())
		{
			System.out.println("Rank green bars are loaded");
		}
		else {
			
			System.out.println("Issue: Rank green bars are not there, pls check application");
		}
//		WebElement carousalcharts = login.driver.findElement(By.xpath("//div[@class='slider-tile-section']"));
//		carousal_charts=login.driver.findElement(By.xpath("//div[@class='slider-tile-section']")).isDisplayed();
//		System.out.println("carousal charts are:"+carousalcharts.getText());
		
	
} 
} 