package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pagefactory.HotelBookingPage;
import utils.ConstantRepositroy;

public class HotelBookingTest {

	WebDriver driver;
	HotelBookingPage page = new HotelBookingPage(this.driver);

	@Test
	public void shouldBeAbleToSearchForHotels() {

		// Navigate to Hotels tab and search for hotels
		page.clickHotelsLink();
		page.selectLocality(ConstantRepositroy.LOCATION);
		page.selectTravellers(ConstantRepositroy.TRAVELLER_INFO);

		// Click on search button
		page.clickSearch();
		page.logoutApplication();
	}
}
