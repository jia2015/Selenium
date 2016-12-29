package pageClasses;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageFactory {
	WebDriver driver = null;
	static Logger log = Logger.getLogger(SearchPageFactory.class);
	
	@FindBy(id="header-history")
	WebElement headerHistory;
	
	@FindBy(id="tab-flight-tab")
	WebElement fligthsTab;
	
	@FindBy(id="flight-origin")
	WebElement originCity;
	
	@FindBy(id="flight-destination")
	WebElement destinationCity;
	
	@FindBy(id="flight-departing")
	WebElement departureDate;
	
	@FindBy(id="flight-returning")
	WebElement returnDate;
	
	public SearchPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickFlightsTab() {
		headerHistory.click();
		fligthsTab.click();
	}
	
	public void setOriginCity(String origin) {
		originCity.sendKeys(origin);
		log.info("enter city from "+ origin);
	}
	
	public void setDestinationCity(String destination) {
		destinationCity.sendKeys(destination);
		log.info("enter city to "+ destination);
	}
	
	public void setDepartureDate(String date) {
		departureDate.sendKeys(date);
		log.info("enter date from "+ date);
	}
	
	public void setReturnDate(String date) {
		returnDate.clear();
		returnDate.sendKeys(date);
		log.info("enter date to "+ date);
	}
	
}
