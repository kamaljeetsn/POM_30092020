package com.selenium.yatra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.selenium.yatra.base.BasePage;

public class SearchFlightsPage extends BasePage{
	
	//This can be moved to BasePage once BasePage is created
	//WebDriver driver;
	
	public SearchFlightsPage(WebDriver driver, ExtentTest test){
		super(driver,test);
		//System.out.println("Inside SearchFlightsPage consutructor");
		//this.driver = driver;
	}

	public BookingPage goToBookingPage(){
		//From list of flights displayed, select the first flight and click on Book Now button
		//driver.findElement(By.Xpath("").sendkeys "Depart"
		BookingPage bookingPage = new BookingPage(driver,test);
		PageFactory.initElements(driver,bookingPage);
		
		//BookingPage bp = PageFactory.initElements(driver, BookingPage.class);
		
		//BookingPage bp = new BookingPage();
		
		//return bp;
		
		return bookingPage;
	}
	


/*	public void verifyTitle() {
		// TODO Auto-generated method stub
		
	}
*/
}
