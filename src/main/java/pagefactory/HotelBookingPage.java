package pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.ElementHandler;

//page factory class for HotelBooking screen
public class HotelBookingPage {

	// WebElements
	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;

	@FindBy(id = "Tags")
	private WebElement localityTextBox;
	
	@FindBy(id = "ui-id-1")
	private WebElement locationOptionsID;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchBtn;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;
	
	@FindBy(className = "resultContainer")
	private WebElement tblHotelResults;
	
	private By locationOptions = By.xpath("//*[@id='ui-id-1']//a");
	
	private ElementHandler elementHandler;

	// Constructor
	public HotelBookingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		elementHandler = new ElementHandler(driver);
	}

	// Action methods
	public void clickHotelsLink() {
		hotelLink.click();
		elementHandler.waitForElement(travellerSelection);
	}

	public void selectLocality(String value) {
		localityTextBox.sendKeys(value);
		// wait for the auto complete options to appear for the origin
		elementHandler.waitForListOfElements(locationOptions);
		List<WebElement> originOptions = locationOptionsID.findElements(By.tagName("a"));
		originOptions.get(0).click();
	}

	public void selectTravellers(String value) {
		elementHandler.waitForElement(travellerSelection);
		Select travellers = new Select(travellerSelection);
		travellers.selectByVisibleText(value);
	}

	public void clickSearchAndWaitForResults() {
		elementHandler.pressEscapeKey();
		elementHandler.waitForElementToBeClickable(searchBtn);
		searchBtn.click();
		elementHandler.waitForElement(tblHotelResults);
	}
	
	public boolean verifyHotelResultsAreDisplayed() {
		return elementHandler.isElementPresent(tblHotelResults);
	}

}
