package com.selenium.yatra.pages;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.selenium.yatra.base.BasePage;

public class LoginPage extends BasePage{

	//This can be moved to BasePage once BasePage is created
	//WebDriver driver;
	
	public LoginPage(WebDriver driver,ExtentTest test){
		super(driver,test);
		//this.driver = driver;
		//System.out.println("Inside Login Page Constructor");
		//driver.get("http://gmail.com");
	}
	
	public void verifyLogin(){
		System.out.println("Inside verify Login");
	}
	
}
