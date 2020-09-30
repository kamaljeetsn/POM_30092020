package com.selenium.yatra.common;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.yatra.base.BasePage;

public class CommonFeatures extends BasePage{
	
	//WebDriver driver;
	
	public CommonFeatures(WebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		
		//super(driver,test);
		//System.out.println("inside common features constructor");
	}
	
	public void support(){
		System.out.println("inside support");
		test.log(LogStatus.INFO, "Inside Common features");
	}

}
