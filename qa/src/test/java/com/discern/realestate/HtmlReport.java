package com.discern.realestate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;

//import org.testng.annotations.Test;

import com.discern.properties.PropertiesReading;
import com.thoughtworks.gauge.Step;

public class HtmlReport {
	
	//@Test(priority=11)
	@Step("Show the output in HTML Report")
	public static void htmlsetup() throws IOException {
	
	StringBuilder htmlStringBuilder = new StringBuilder(); 
	htmlStringBuilder
	.append("<html><head><title>HomeBuilder Smoke Testing</title></head>"
			+ "<body>"
			+ "<h2 align=\"center\">RealEstate Smoke Testing Report</h2>"
			+ "<h3 align=\"center\">Login Page</h3>"
			+ "<table align=\"center\" border=\"1\" bordercolor=\"#000000\">"
			+"<tr>"
			+"<th bgcolor=\"#51FFDA\" align=\"center\">Ticker</th>"
		    +"<th colspan=\"2\" bgcolor=\"#51FFDA\" align=\"center\">Login</th>"
		    +"</tr>"
		    +"<tr>"
		    +"<td>"+Watchlist.ticker+"</td>"
		    +"<td>Login Successfull</td>"
		    +"<td>"+login.loginstatus+"</td></tr>"
			+ "</table></body></html>");
	
	htmlStringBuilder
	.append("<html>"
			+ "<body>"
			+ "<h3 align=\"center\">Watchlist Page</h2>"
			+ "<table align=\"center\" border=\"1\" bordercolor=\"#000000\">"
			+"<tr>"
			+"<th bgcolor=\"#51FFDA\" align=\"center\">Watchlist Page Functionalities</th>"
		    +"<th bgcolor=\"#51FFDA\" align=\"center\">Test case(true/false)</th>"
		    +"</tr>"
		    +"<tr>"
		    +"<td>Watchlist HeatMaps loaded</td>"
		    +"<td>"+Watchlist.heatmaps+"</td></tr>"
		    +"<tr>"
		    +"<td>Watchlist Portfolios loaded</td>"
		    +"<td>"+Watchlist.portfoilios+"</td></tr>"
			+ "</table></body></html>");
	htmlStringBuilder
	.append("<html>"
			+ "<body>"
			+ "<h3 align=\"center\">Company Page</h2>"
			+ "<table align=\"center\" border=\"1\" bordercolor=\"#000000\">"
			+"<tr>"
			+"<th bgcolor=\"#51FFDA\" align=\"center\">Company Page Functionalities</th>"
		    +"<th bgcolor=\"#51FFDA\" align=\"center\">Test case(true/false)</th>"
		    +"</tr>"
		    +"<tr>"
		    +"<td>Company page Global Bar</td>"
		    +"<td>"+CompanyPage.global_bar+"</td></tr>"
		    +"<tr>"
		    +"<td>Company page Aperture Chart loaded</td>"
		    +"<td>"+CompanyPage.aperture_chart+"</td></tr>"
		    +"<tr>"
		    +"<td>Company page Signals list loaded</td>"
		    +"<td>"+CompanyPage.signal_list+"</td></tr>"
		    +"<tr>"
		    +"<td>Company page Signals Chart loaded</td>"
		    +"<td>"+CompanyPage.signal_chart+"</td></tr>"
		    +"<tr>"
		    +"<td>Company page Signals side panel loaded</td>"
		    +"<td>"+CompanyPage.signal_button+"</td></tr>"
		    +"<tr>"
		    +"<td>Company page Timer chart loaded</td>"
		    +"<td>"+CompanyPage.timer+"</td></tr>"
		    +"<tr>"
		    +"<td>Company page Rank chart loaded</td>"
		    +"<td>"+CompanyPage.rank_frame+"</td></tr>"
		    +"<tr>"
		    +"<td>Company page Trends chart loaded</td>"
		    +"<td>"+CompanyPage.trends_frame+"</td></tr>"
		    +"<tr>"
		    +"<td>Company page Carousal charts loaded</td>"
		    +"<td>"+CompanyPage.carousal_charts+"</td></tr>"
		    +"<tr>"
		    +"<td>Company page Related companies loaded</td>"
		    +"<td>"+CompanyPage.related_companies+"</td></tr>"
			+ "</table></body></html>");
	htmlStringBuilder
	.append("<html>"
			+ "<body>"
			+ "<h3 align=\"center\">National Page</h2>"
			+ "<table align=\"center\" border=\"1\" bordercolor=\"#000000\">"
			+"<tr>"
			+"<th bgcolor=\"#51FFDA\" align=\"center\">National Page Functionalities</th>"
		    +"<th bgcolor=\"#51FFDA\" align=\"center\">Test case(true/false)</th>"
		    +"</tr>"
		    +"<tr>"
		    +"<td>National page Global Bar</td>"
		    +"<td>"+NationalPage.global_bar+"</td></tr>"
		    +"<tr>"
		    +"<td>National page Main Stage loaded</td>"
		    +"<td>"+NationalPage.main_stage+"</td></tr>"
		    +"<tr>"
		    +"<td>National page Signals list loaded</td>"
		    +"<td>"+NationalPage.signal_list+"</td></tr>"
		    +"<tr>"
		    +"<td>National page Timer chart loaded</td>"
		    +"<td>"+NationalPage.timer_frame+"</td></tr>"
		    +"<tr>"
		    +"<td>National page Rank chart loaded</td>"
		    +"<td>"+NationalPage.rank_frame+"</td></tr>"
		    +"<tr>"
		    +"<td>National page Trends chart loaded</td>"
		    +"<td>"+NationalPage.trends_frame+"</td></tr>"
		    +"<tr>"
		    +"<td>National page Carousal charts loaded</td>"
		    +"<td>"+NationalPage.carousal_charts+"</td></tr>"
		    +"<tr>"
		    +"<td>National page Related companies loaded</td>"
		    +"<td>"+NationalPage.related_companies+"</td></tr>"
			+ "</table></body></html>");
	htmlStringBuilder
	.append("<html>"
			+ "<body>"
			+ "<h3 align=\"center\">Settings Page</h2>"
			+ "<table align=\"center\" border=\"1\" bordercolor=\"#000000\">"
			+"<tr>"
			+"<th bgcolor=\"#51FFDA\" align=\"center\">Settings Page Functionalities</th>"
		    +"<th bgcolor=\"#51FFDA\" align=\"center\">Test case(true/false)</th>"
		    +"</tr>"
		    +"<tr>"
		    +"<td>Settings Page Portfolios tab loaded</td>"
		    +"<td>"+Settings.Portfolios+"</td></tr>"
		    +"<tr>"
		    +"<td>Settings Page Signals tab loaded</td>"
		    +"<td>"+Settings.Signals+"</td></tr>"
		    +"<tr>"
		    +"<td>Settings Page Products tab loaded</td>"
		    +"<td>"+Settings.Products+"</td></tr>"
		    +"<tr>"
		    +"<td>Settings Page Notifications tab loaded</td>"
		    +"<td>"+Settings.Notification+"</td></tr>"
			+ "</table></body></html>");
	htmlStringBuilder
	.append("<html>"
			+ "<body>"
			+ "<h3 align=\"center\">Logout</h2>"
			+ "<table align=\"center\" border=\"1\" bordercolor=\"#000000\">"
			+"<tr>"
			+"<th bgcolor=\"#51FFDA\" align=\"center\">Logout of the Application</th>"
		    +"<th bgcolor=\"#51FFDA\" align=\"center\">Test case(true/false)</th>"
		    +"</tr>"
		    +"<tr>"
		    +"<td>Signed out Successfully</td>"
		    +"<td>"+Logout.logout_success+"</td></tr>"
			+ "</table></body></html>");
	   java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
	   WriteToFile(htmlStringBuilder.toString(),"RealEstate_Smoke_Testing_Report_"+sdf.format(new java.util.Date())+".html");
	  }
	 

	 public static void WriteToFile(String fileContent, String fileName)
	   throws IOException {
	  String projectPath = PropertiesReading.getValue("path");
	  String tempFile = projectPath + File.separator + fileName;
	  File file = new File(tempFile);
	  OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
	  Writer writer = new OutputStreamWriter(outputStream);
	  writer.write(fileContent);
	  writer.close();
	 }

}
