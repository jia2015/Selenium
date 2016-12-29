package com.expedia.flightsbooking;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageClasses.SearchPageFactory;


public class FrameworkTestCase {
	private WebDriver driver;
	private String baseUrl;
	SearchPageFactory searchPage;

	@BeforeClass
	public void beforeClass() {
		
		//System.setProperty("log4j.configurationFile","C:\\Users\\mrli\\Downloads\\eclipse-jee-neon-R-win32-x86_64\\eclipse\\workspace\\Test_firefox\\src\\log4j2.xml");
		//PropertyConfigurator.configure("log4j2.xml");
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\mrli\\Desktop\\software QA\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://www.expedia.com/";
		
		searchPage = new SearchPageFactory(driver);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws Exception {
		searchPage.clickFlightsTab();
		searchPage.setOriginCity("New York");
		searchPage.setDestinationCity("San Francisco");
		searchPage.setDepartureDate("12/28/2016");
		searchPage.setReturnDate("12/31/2016");
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
