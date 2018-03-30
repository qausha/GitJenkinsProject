package com.discern.realestate;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.discern.properties.PropertiesReading;
import com.thoughtworks.gauge.Step;

public class login {
	
	static Properties prop=new Properties();
	static WebDriver driver;
	static String responseCode;
	static String rank_date;
	static boolean loginstatus;
	static WebDriverWait wait;
	@Step("Open Chrome Driver")
	public static void openDiscern() throws IOException {
			
	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\eclipse-workspace\\HomeBuilders_Smoke_Testing_Prod\\chromedriver.exe");
	driver=new ChromeDriver();
			
	driver.get(PropertiesReading.getValue("website"));
	wait=new WebDriverWait(driver, 50);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Member Log In']")));
	driver.manage().window().maximize();
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrFile, new File("C:\\Users\\admin\\eclipse-workspace\\Phantom_HomeBuilders_Smoke_Testing\\Login" ,".png"));
	
	System.out.println("screencapture taken successfully for login page");
	
	}
	@Step("Login to the account")
	public static void signIn() {
	//WebDriverWait wait=new WebDriverWait(driver, 50);
	WebElement text=driver.findElement(By.xpath("//h2[text()='Member Log In']"));
	if(text.isDisplayed()) {
		System.out.println("Sign In success");
	}
	else {
		
		System.out.println("Pls clear cache , page isn't loaded properly");
	}
	Assert.assertTrue(driver.getPageSource().contains("Home"));
	System.out.println("2.###Home button shows on home page###");
	Assert.assertTrue(driver.getPageSource().contains("Help"));
	System.out.println("3.###Help button shows on home page###");
	Assert.assertTrue(driver.getPageSource().contains("forgot password"));
	System.out.println("4.Forgot password link is present");
	Assert.assertTrue(driver.getPageSource().contains("New to DISCERN?"));
	System.out.println("5.New to DISCERN text is present");
	Assert.assertTrue(driver.getPageSource().contains("Sign up"));
	System.out.println("6.Sign up link is present");
	driver.findElement(By.xpath(PropertiesReading.getValue("email_xpath"))).sendKeys(PropertiesReading.getValue("Email"));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertiesReading.getValue("pwd_xpath"))));
	driver.findElement(By.xpath(PropertiesReading.getValue("pwd_xpath"))).sendKeys(PropertiesReading.getValue("Password"));
	driver.findElement(By.xpath(PropertiesReading.getValue("login_button_xpath"))).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Watchlist')]")));
	loginstatus=driver.findElement(By.xpath("//a[contains(text(),'Watchlist')]")).isDisplayed();
	System.out.println("Successful Login");
	
	
	}

	

}
