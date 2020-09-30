package com.selenium.yatra.tests;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.yatra.tests.base.BaseTest;
import com.selenium.yatra.util.DataUtil;
import com.selenium.yatra.util.Xls_Reader;

public class SearchFlightsTest extends BaseTest{
	String testCaseName = "SearchFlightsTest";
	//Xls_Reader xls = new Xls_Reader("D:\\Trainings\\Selenium\\WorkspaceP\\PageObjectModel\\Data", testCaseName+".xlsx");
	Xls_Reader xlsExec = new Xls_Reader("D:\\Trainings\\Selenium\\WorkspaceP\\PageObjectModel\\Data","TestCaseExecutor.xlsx");
	
	@Test
	public void testSearchFlights(){
		test = reports.startTest(testCaseName);
		if(!DataUtil.isTestExecutable(xlsExec, testCaseName)){
			test.log(LogStatus.SKIP, "Skipping the test case " + testCaseName + " as Runmode is N");
			throw new SkipException("Skipping the test case " + testCaseName + " as Runmode is N");
		}
		test.log(LogStatus.INFO, "Starting Test");
		launchBrowser("Chrome");
		driver.get("https://iengage.coforgetech.com/ess1/authentication/loginauth.aspx");
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void quit(){
		if(reports!=null){
			reports.endTest(test);
			reports.flush();
		}
		if(driver!=null){
			driver.quit();
		}
	}
	

}
