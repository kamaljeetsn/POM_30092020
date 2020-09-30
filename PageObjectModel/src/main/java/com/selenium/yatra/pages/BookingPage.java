package com.selenium.yatra.pages;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.selenium.yatra.base.BasePage;

public class BookingPage extends BasePage{
	
	//This can be moved to BasePage once BasePage is created
	//WebDriver driver;
	
	public BookingPage(WebDriver driver, ExtentTest test){
		super(driver,test);
		//System.out.println("Inside Booking consutructor");
		//this.driver = driver; This is moved to base class and is referred as super(driver)
	}

	public void verifylable(String expected,String actual){
		//steps to verify the lable
		//asserts
	}
	
	public void verifyTitle() {
		// TODO Auto-generated method stub
		
	}
	

}
