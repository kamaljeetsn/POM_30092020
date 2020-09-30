package com.selenium.yatra.base;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.yatra.common.CommonFeatures;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;



public class BasePage {
	
	public WebDriver driver;
	public CommonFeatures common;
	public ExtentTest test;
	

	public BasePage(){}
	
	//This will be added to the Base Page and super would be called 
	public BasePage(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test = test;
		//common = PageFactory.initElements(driver, CommonFeatures.class);
		//steps to pass test to
		common = new CommonFeatures(driver,test);
		PageFactory.initElements(driver,common);
	}
	
	public void takeScreenshot() {
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		String filePath = "D:\\Trainings\\Selenium\\WorkspaceP\\PageObjectModel\\Screenshots\\"+screenshotFile;
		//Convert web driver object to TakeScreenshot
		TakesScreenshot	scrShot = (TakesScreenshot) driver;
		//Call getScreenshotAs method to create image file
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, test.addScreenCapture(filePath));
	
	}
	
	public void takeFullPageScreenshot() {
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		String filePath = "D:\\Trainings\\Selenium\\WorkspaceP\\PageObjectModel\\Screenshots\\"+screenshotFile;
		//take screenshot of the entire page             
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		try {
			ImageIO.write(screenshot.getImage(),"PNG",new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, test.addScreenCapture(filePath));
	}
	
	public void PrintScreen() {
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		String filePath = "D:\\Trainings\\Selenium\\WorkspaceP\\PageObjectModel\\Screenshots\\"+screenshotFile;
				
		try {
			// This code will capture screenshot of current screen
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			// This will store screenshot on Specific location
			ImageIO.write(image, "png", new File(filePath)); 
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(LogStatus.INFO, test.addScreenCapture(filePath));
	}
	
	public void verifyTitle(String expectedText){
		String actualText = driver.getTitle();
		//System.out.println("inside verify title");
		PrintScreen();
		if(actualText.contains(expectedText)){
			test.log(LogStatus.PASS, "The expected title is: " + expectedText + " is present in the actual title is: " + actualText);
			//PrintScreen();
		}else{
			test.log(LogStatus.FAIL, "The expected title is: " + expectedText + " is present in the actual title is: " + actualText);
			//PrintScreen();
		}
	}

	public String verifyText(String locator,String expected){
		return "";
	}
	
	public boolean isElementPresent(String locator){
		return true;
	}
	
	public CommonFeatures getCommon() {
		return common;
	}
	
	public void enterData(String locator,String data){
		driver.findElement(By.xpath(locator)).sendKeys(data);
	}
	
	public void click(String locator){
		driver.findElement(By.xpath(locator)).click();
	}
	
}
