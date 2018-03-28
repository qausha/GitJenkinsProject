package com.gitjenkinsprac.yahoo;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooScraping {

	static WebDriver driver;
	static String tickers =  "AAP,CAKE" ;
	static FileWriter fr; //new FileWriter("D:\\Ashik\\bufferedreader\\yahooscraping.xlsx");
	static BufferedWriter br; //new BufferedWriter(fr);

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		initDriver();
		openYahoo();
		createWriter();
		passTicker();
		driverClose();

	}

	public static void initDriver() {

		System.setProperty("webdriver.chrome.driver",
				"D:\\chromedriver\\chromedriver_win32\\chromedriver_2.37.exe");
		driver = new ChromeDriver();

	}

	public static void openYahoo() {
		driver.get("https://finance.yahoo.com/");
		driver.manage().window().maximize();
		wait(1000);

	}
	public static void createWriter() throws IOException {
		
		try {
			
			fr=new FileWriter("D:\\Ashik\\bufferedreader\\yahooscraping.csv");
			br=new BufferedWriter(fr);
			br.append("company\",\"open_price\",\"close_price\",\"market_cap\""+"\n");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void passTicker() throws IOException {
		
		List<String> tickerslist = Arrays.asList(tickers.split(","));
		List<String> trimmedlist = new ArrayList<>(tickerslist);
		
		for (int i = 0; i < trimmedlist.size() ; i++) {
			
			System.out.println(trimmedlist.get(i));
			driver.findElement(By.xpath("//input[@name='p']")).sendKeys(trimmedlist.get(i));
			wait(1000);
			driver.findElement(By.xpath("//button[@id='search-button']")).click();
			wait(3000);
			
			//String company_title=driver.findElement(By.xpath("//h1[@class='D(ib) Fz(18px)']")).getText();
			//System.out.println(company_title);
			br.append(trimmedlist.get(i));
			br.append(",");
			
			String open_price_text=driver.findElement(By.xpath("//td[@data-test='OPEN-value']")).getText();
			System.out.println(open_price_text);
			br.append(open_price_text);
			br.append(",");
			
			String close_price_text=driver.findElement(By.xpath("//td[@data-test='PREV_CLOSE-value']")).getText();
			System.out.println(close_price_text);
			br.append(close_price_text);
			br.append(",");
			
			String market_cap_text=driver.findElement(By.xpath("//td[@data-test='MARKET_CAP-value']")).getText();
			System.out.println(market_cap_text);
			br.append(market_cap_text);
			//br.append(",");
			br.append("\n");

		}
		br.flush();
		//br.close();
	}

	public static void driverClose() {
		driver.close();
	}

	public static void wait(int Wait) {

		try {
			Thread.sleep(Wait);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
