package com.selenium.yatra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.yatra.base.BasePage;

public class LaunchPage extends BasePage{
	
	//This can be moved to BasePage once BasePage is created
	//WebDriver driver;
	//ExtentTest test;
	public LaunchPage(WebDriver driver,ExtentTest test){
		super(driver,test); //test is added afterwards to pass test object to pages
		//super(test);
		//this.test = test;
		System.out.println("Inside Launch Page Constructor");
		//this.driver = driver;
		//driver.get("http://gmail.com");
	}
	
	public HomePage goToHomePage(){
		test.log(LogStatus.INFO, "Opening the URL");
		driver.get("https://www.yatra.com/");
		test.log(LogStatus.PASS, "The url https://www.yatra.com/ is successfully opened");
		//return PageFactory.initElements(driver, HomePage.class);
		HomePage hp = new HomePage(driver,test);
		PageFactory.initElements(driver,hp);
		//HomePage hp = new HomePage();
		return hp;
		
	}
	
}
