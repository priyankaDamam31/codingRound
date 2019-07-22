package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pagefactory.HotelBooking;
import utils.ObjectRepositroy;
import utils.TestHandler;

public class HotelBookingTest extends TestHandler {

	WebDriver driver;

	@Test
	public void shouldBeAbleToSearchForHotels() {

		// get the driver object and Navigate to URL
		driver = getDriver();
		driver.get(ObjectRepositroy.URL);

		// initialize objects of HotelBooking page
		HotelBooking page = PageFactory.initElements(driver, HotelBooking.class);

		// Navigate to Hotels tab and search for hotels
		page.clickHotelsLink();
		page.sendKeysToLocality("Indiranagar, Bangalore");
		elementHandler.waitForListOfElements(ObjectRepositroy.LOCALITY_OPTIONS);
		List<WebElement> LocalityOptions = driver.findElement(By.id(ObjectRepositroy.LOCALITY_OPTIONS_ID))
				.findElements(By.tagName("a"));
		LocalityOptions.get(0).click();
		elementHandler.waitFor(500);
		page.selectTravellers("1 room, 2 adults");
		elementHandler.waitFor(500);

		// Click on search button
		page.clickSearch();
		elementHandler.waitFor(3000);
	}
}
