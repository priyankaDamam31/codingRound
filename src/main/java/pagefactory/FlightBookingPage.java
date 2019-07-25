package pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.TestHandler;

//page factory class for FlightBooking screen
public class FlightBookingPage extends TestHandler {

	WebDriver driver;

	// WebElements
	@FindBy(id = "OneWay")
	private WebElement oneWayRdoBtn;
	
	@FindBy(id = "RoundTrip")
	private WebElement roundTripRdoBtn;
	
	@FindBy(id = "MultiCity")
	private WebElement multiCityRdoBtn;

	@FindBy(id = "FromTag")
	private WebElement fromLocationDrpdwn;
	
	@FindBy(id = "ui-id-1")
	private WebElement fromLocationOptionsID;

	@FindBy(id = "ToTag")
	private WebElement toLocationDrpdwn;

	@FindBy(xpath = "//*[@id='ui-id-2']//a")
	private WebElement toLocationOptions;

	@FindBy(id = "ui-id-2")
	private WebElement toLocationOptionsID;

	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[4]/td[7]/a")
	private WebElement departOnTxt;

	@FindBy(id = "SearchBtn")
	private WebElement searchBtn;

	@FindBy(className = "searchSummary")
	private WebElement searchSummaryDetails;
	
	// Constructor
	public FlightBookingPage(WebDriver driver) {
		PageFactory.initElements(getDriver(), this);
	}

	// Action methods
	public void selectTravelOptions(String travelType) {
		if(travelType.equalsIgnoreCase("oneway")) {
			oneWayRdoBtn.click();
		}
		else if(travelType.equalsIgnoreCase("oneway")) {
			roundTripRdoBtn.click();
		}
		else {
			multiCityRdoBtn.click();
		}
	}
	
	public void selectFromLocation(String value) {
		fromLocationDrpdwn.sendKeys(value);
		// wait for the auto complete options to appear for the origin
		elementHandler.waitForListOfElements(By.xpath("//*[@id='ui-id-1']//a"));
		List<WebElement> originOptions = fromLocationOptionsID.findElements(By.tagName("a"));
		originOptions.get(0).click();
	}

	public void selectToLocation(String value) {
		toLocationDrpdwn.sendKeys(value);
		// wait for the auto complete options to appear for the origin
		elementHandler.waitForListOfElements(By.xpath("//*[@id='ui-id-2']//a"));
		List<WebElement> originOptions = toLocationOptionsID.findElements(By.tagName("a"));
		originOptions.get(0).click();
	}

	public void clickSearch() {
		searchBtn.click();
	}
	
	public void selectDepartOn() {
		departOnTxt.click();
	}
	
	public boolean isSummaryPresent() {
		return elementHandler.isElementPresent(searchSummaryDetails);
	}
	
}
