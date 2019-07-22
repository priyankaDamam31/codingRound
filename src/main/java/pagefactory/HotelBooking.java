package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

//page factory class for HotelBooking screen
public class HotelBooking {

	WebDriver driver;

	// WebElements
	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;

	@FindBy(id = "Tags")
	private WebElement localityTextBox;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;

	// Constructor
	public HotelBooking(WebDriver driver) {
		this.driver = driver;
	}

	// Action methods
	public void clickHotelsLink() {
		hotelLink.click();
	}

	public void sendKeysToLocality(String value) {
		localityTextBox.sendKeys(value);
	}

	public void selectTravellers(String value) {
		Select travellers = new Select(travellerSelection);
		travellers.selectByVisibleText(value);
	}

	public void clickSearch() {
		searchButton.click();
	}

}
