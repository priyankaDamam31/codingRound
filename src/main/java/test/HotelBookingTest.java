package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pagefactory.HotelBookingPage;
import utils.ConstantRepositroy;
import utils.TestHandler;

public class HotelBookingTest extends TestHandler {

	@Test
	public void shouldBeAbleToSearchForHotels() {

		HotelBookingPage page = new HotelBookingPage(getDriver());
		
		// Navigate to Hotels tab and search for hotels
		page.clickHotelsLink();
		page.selectLocality(ConstantRepositroy.LOCATION);
		page.selectTravellers(ConstantRepositroy.TRAVELLER_INFO);

		// Click on search button
		page.clickSearchAndWaitForResults();
		Assert.assertTrue(page.verifyHotelResultsAreDisplayed(), "Unable to fetch results for hotels in location " + ConstantRepositroy.LOCATION);
	}
}
