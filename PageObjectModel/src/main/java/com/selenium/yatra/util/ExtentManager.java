package com.selenium.yatra.util;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	public static ExtentReports reports;
	
	public static ExtentReports getReports(){
		if(reports==null){
			Date d = new Date();
			String filename = d.toString().replace(":", "_").replace(" ", "_") + ".html";
			String reportPath = "D:\\Trainings\\Selenium\\WorkspaceP\\PageObjectModel\\Reports\\";
			reports = new ExtentReports(reportPath + filename, false, DisplayOrder.NEWEST_FIRST);
			reports.loadConfig(new File("D:\\Trainings\\Selenium\\WorkspaceP\\PageObjectModel\\ReportsConfig.xml"));
		}
		return reports;
	}

}
