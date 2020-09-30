package com.selenium.yatra.tests;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.yatra.pages.BookingPage;
import com.selenium.yatra.pages.HomePage;
import com.selenium.yatra.pages.HomePage_Old;
import com.selenium.yatra.pages.LaunchPage;
import com.selenium.yatra.pages.LoginPage;
import com.selenium.yatra.pages.SearchFlightsPage;
import com.selenium.yatra.tests.base.BaseTest;
import com.selenium.yatra.util.DataUtil;
import com.selenium.yatra.util.ExtentManager;
import com.selenium.yatra.util.Xls_Reader;

public class BookNowTest extends BaseTest{
	String testCaseName = "BookNowTest";
	Xls_Reader xls = new Xls_Reader("D:\\Trainings\\Selenium\\WorkspaceP\\PageObjectModel\\Data", testCaseName+".xlsx");
	Xls_Reader xlsExec = new Xls_Reader("D:\\Trainings\\Selenium\\WorkspaceP\\PageObjectModel\\Data","TestCaseExecutor.xlsx");
	//driver is initialized over here thus same driver needs to be shared across the page class
	//common functions
	//same function returning two type of objects
	@Test(dataProvider="getData")
	public void testBooking(Hashtable<String, String> data) throws InterruptedException{
		System.out.println("inside test booking");
		//ExtentReports reports = ExtentManager.getReports();//This can be moved to Base page 
		//ExtentTest test = reports.startTest("BookNowTest");
		test = reports.startTest(testCaseName);
		if(!DataUtil.isTestExecutable(xlsExec, testCaseName)){
			test.log(LogStatus.SKIP, "Skipping the test case " + testCaseName + " as Runmode is N");
			throw new SkipException("Skipping the test case " + testCaseName + " as Runmode is N");
		}
		test.log(LogStatus.INFO, "Starting Test");
		test.log(LogStatus.INFO, "Open Browser");
		launchBrowser("Chrome");
		System.out.println("After Calling Launch Browser");
		//System.setProperty("webdriver.chrome.driver", "D:\\Trainings\\Selenium\\WorkspaceP\\Drivers\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();//driver is initialized over here thus same driver needs to be shared across the page class
		
		//LaunchPage lp = PageFactory.initElements(driver, LaunchPage.class);
		//In order to pass the ExtentTest test to the page classes, the following changes is to be done for the page class object
		LaunchPage lp = new LaunchPage(driver,test);
		PageFactory.initElements(driver, lp);
		
		test.log(LogStatus.INFO, "Open Application");
		HomePage hp = lp.goToHomePage();
		hp.getCommon().support();
		test.log(LogStatus.INFO, "Search Flight");
		
	/*	Object page = hp.goToSearchFlightsPage();
		if(page instanceof LoginPage){
			//call the function of Login Page
			LoginPage logPage = (LoginPage) page;
			logPage.verifyTitle("Flight, Cheap Air Tickets , Hotels, Holiday, Trains Package Booking - Yatra.com");
		}else if(page instanceof SearchFlightsPage){
			//call the function on SearchFlightsPage
			SearchFlightsPage sfp = (SearchFlightsPage) page;
			sfp.verifyTitle("Flight, Cheap Air Tickets , Hotels, Holiday, Trains Package Booking - Yatra.com");
			test.log(LogStatus.PASS,"Search Flight Passed");
		}
	*/
		SearchFlightsPage sfp = hp.goToSearchFlightsPage(data);
		sfp.verifyTitle("Yatra");
		
		
		
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
	
	@DataProvider
	public Object[][] getData(){
	/*	Xls_Reader xls = new Xls_Reader("D:\\Trainings\\Selenium\\WorkspaceP\\PageObjectModel\\Data", testCaseName+".xlsx");
		String sheetName = testCaseName;
		int rows = xls.getRowCount(sheetName);
		int cols = xls.getColumnCount(sheetName);
		System.out.println("Rows Count : " + rows);
		System.out.println("Column Count : " + cols);
		Object[][] data = new Object[rows-1][1];
		int dataRow = 0;
		Hashtable<String, String> table = null;
		for(int iRow=2;iRow<=rows;iRow++){
			table = new Hashtable<String, String>();
			for(int iCol=0;iCol<cols;iCol++){
				//System.out.println("datarow : " + dataRow);
				String key = xls.getCellData(sheetName, iCol, 1);
				String value = xls.getCellData(sheetName, iCol, iRow);
				table.put(key, value);
				//System.out.println(xls.getCellData("Data", iCol, iRow));
			}
			data[dataRow][0] = table;
			dataRow++;
		}
		
	
		return data;
*/		
		return DataUtil.getData(xls, testCaseName);
	}
	


}
