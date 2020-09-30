package com.selenium.yatra.pages;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.yatra.base.BasePage;
import com.selenium.yatra.util.ObjectRepository;

public class HomePage extends BasePage{
	
	//This can be moved to BasePage once BasePage is created
	//WebDriver driver;
	//ExtentTest test;
	
	@FindBy(css=ObjectRepository.tripButton)
	public WebElement tripButtton;
	
	//@FindBy(css="a[title='Round Trip']")
	//public WebElement tripButtton;
	
	@FindBy(css="input#BE_flight_origin_city")
	public WebElement originCity;

	@FindBy(css="//p[text()='Pune ']")
	public WebElement selectOrginCity;

	@FindBy(css="input#BE_flight_arrival_city")
	public WebElement arrivalCity;

	@FindBy(xpath="//p[text()='New Delhi ']")
	public WebElement selectArrivalCity;

	@FindBy(xpath="//*[@id='BE_flight_origin_date']")
	public WebElement originDate;
	
	@FindBy(xpath="//table/tbody/tr/td[@data-date='10/09/2020']")
	public WebElement selectOriginDate;

	@FindBy(xpath="//table/tbody/tr/td[@data-date='18/09/2020']")
	public WebElement selectReturnDate;

	@FindBy(xpath="//*[@id='BE_flight_paxInfoBox']/i")
	public WebElement paxInfoBox;
	
	@FindBy(css="div[data-flightagegroup='adult']>span.pax-title>span.adultcount")
	public WebElement adultCount;
	
	@FindBy(xpath="//div[@data-flightagegroup='adult']/div[1]/div[1]/div[1]/span[1]")
	public WebElement adultUpArrow;
	
	@FindBy(xpath="//div[@data-flightagegroup='adult']/div[1]/div[1]/div[1]/span[2]")
	public WebElement adultDownArrow;
	
	@FindBy(xpath="//span[text()='Economy']")
	public WebElement economyRadio;
	
	@FindBy(xpath="//*[@id='BE_flight_flsearch_btn']")
	public WebElement searchButton;
	
	@FindBy(css="li#userLoginBlock>a")
	public WebElement myAccountLink;
	
	public HomePage(WebDriver driver, ExtentTest test){
		super(driver, test);
		//System.out.println("Inside Homepage consutructor");
		//this.driver = driver;
	}
	
	
	public SearchFlightsPage goToSearchFlightsPage(Hashtable<String, String> data) throws InterruptedException{
		System.out.println("Origin : " + data.get("Origin") + " Arrival: " + data.get("Arrival"));
		//steps to enter data in the various fields on home page and click on Search Flights button
		driver.findElement(By.cssSelector("a[title='Round Trip']")).click();
		test.log(LogStatus.INFO, "Successfully clicked on Round Trip");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("input#BE_flight_origin_city")).click();
		WebElement depart = driver.findElement(By.xpath("//p[text()='Pune ']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", depart);
		//driver.findElement(By.xpath("//p[text()='Pune ']")).click();
		depart.click();
		driver.findElement(By.cssSelector("input#BE_flight_arrival_city")).click();
		driver.findElement(By.xpath("//p[text()='New Delhi ']")).click();
		driver.findElement(By.xpath("//*[@id='BE_flight_origin_date']")).click();
//		driver.findElement(By.xpath("klp'/P;/")).click();
		driver.findElement(By.xpath("//table/tbody/tr/td[@data-date='"+data.get("FromDate")+"']")).click();
		driver.findElement(By.xpath("//table/tbody/tr/td[@data-date='30/09/2020']")).click();
		driver.findElement(By.xpath("//*[@id='BE_flight_paxInfoBox']/i")).click();
		int Adult = 4;
		String readAdult = driver.findElement(By.cssSelector("div[data-flightagegroup='adult']>span.pax-title>span.adultcount")).getText();
		System.out.println(readAdult);
		int screenAdult = Integer.parseInt(readAdult);
		while(Adult!=screenAdult){
			System.out.println("Adult");
			if(Adult<screenAdult){
				driver.findElement(By.xpath("//div[@data-flightagegroup='adult']/div[1]/div[1]/div[1]/span[1]")).click();
			}else{
				driver.findElement(By.xpath("//div[@data-flightagegroup='adult']/div[1]/div[1]/div[1]/span[2]")).click();
			}
			screenAdult++;
			
		}
		
		int Child = 2;
		String readChild = driver.findElement(By.cssSelector("div[data-flightagegroup='child']>span.pax-title>span.adultcount")).getText();
		System.out.println(readChild);
		int screenChild = Integer.parseInt(readChild);
		while(Child!=screenChild){
			System.out.println("Child");
			if(Child<screenChild){
				driver.findElement(By.xpath("//div[@data-flightagegroup='child']/div[1]/div[1]/span[1]")).click();
			}else{
				driver.findElement(By.xpath("//div[@data-flightagegroup='child']/div[1]/div[1]/span[2]")).click();
			}
			screenChild++;
			
		}
		//driver.findElement(By.xpath("//span[text()='Premium Economy']")).click();
		driver.findElement(By.xpath("//span[text()='Economy']")).click();
		driver.findElement(By.xpath("//*[@id='BE_flight_flsearch_btn']")).click();
		
		//SearchFlightsPage sfp = PageFactory.initElements(driver, SearchFlightsPage.class);
		//SearchFlightsPage sfp = new SearchFlightsPage();
		//return sfp;
		SearchFlightsPage searchFlightsPage = new SearchFlightsPage(driver,test);
		PageFactory.initElements(driver,searchFlightsPage);
		//return PageFactory.initElements(driver, SearchFlightsPage.class);
		return searchFlightsPage;
	}
	
	
	//common functions
	public void verifyTitle(){
		
	}
	
	
	

}
