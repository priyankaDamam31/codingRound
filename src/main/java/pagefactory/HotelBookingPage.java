package pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.TestHandler;

//page factory class for HotelBooking screen
public class HotelBookingPage extends TestHandler {

	WebDriver driver;

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

	// Constructor
	public HotelBookingPage(WebDriver driver) {
		PageFactory.initElements(getDriver(), this);
	}

	// Action methods
	public void clickHotelsLink() {
		hotelLink.click();
	}

	public void selectLocality(String value) {
		localityTextBox.sendKeys(value);
		// wait for the auto complete options to appear for the origin
		elementHandler.waitForListOfElements(By.xpath("//*[@id='ui-id-1']//a"));
		List<WebElement> originOptions = locationOptionsID.findElements(By.tagName("a"));
		originOptions.get(0).click();
	}

	public void selectTravellers(String value) {
		Select travellers = new Select(travellerSelection);
		travellers.selectByVisibleText(value);
	}

	public void clickSearch() {
		searchBtn.click();
	}

}
