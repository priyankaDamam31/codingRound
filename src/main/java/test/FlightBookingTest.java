package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pagefactory.FlightBookingPage;
import utils.ConstantRepositroy;

public class FlightBookingTest {

	WebDriver driver;
	FlightBookingPage page = new FlightBookingPage(driver);
	
	@Test
	public void testThatResultsAppearForAOneWayJourney() {

		// Select one way, from and to flight locations
		page.selectTravelOptions(ConstantRepositroy.TRIP_TYPE);
		page.selectFromLocation(ConstantRepositroy.FROM_LOCATION);
		page.selectToLocation(ConstantRepositroy.TO_LOCATION);
		page.selectDepartOn();
		page.clickSearch();
		
		// verify that result appears for the provided journey search
		Assert.assertTrue(page.isSummaryPresent());
		page.logoutApplication();
	}

}
