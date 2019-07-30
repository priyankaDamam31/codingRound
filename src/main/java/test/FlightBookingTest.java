package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pagefactory.FlightBookingPage;
import utils.ConstantRepositroy;
import utils.TestHandler;

public class FlightBookingTest extends TestHandler {

	@Test
	public void testThatResultsAppearForAOneWayJourney() {

		FlightBookingPage page = new FlightBookingPage(getDriver());
		
		// Select one way, from and to flight locations
		page.selectTravelOptions(ConstantRepositroy.TRIP_TYPE);
		page.selectFromLocation(ConstantRepositroy.FROM_LOCATION);
		page.selectToLocation(ConstantRepositroy.TO_LOCATION);
		page.selectDepartOn();
		page.clickSearch();
		
		// verify that result appears for the provided journey search
		Assert.assertTrue(page.isSummaryPresent());
	}

}
