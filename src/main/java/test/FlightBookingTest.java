package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.ObjectRepositroy;
import utils.TestHandler;

public class FlightBookingTest extends TestHandler {

	WebDriver driver;

	@Test
	public void testThatResultsAppearForAOneWayJourney() {

		// get the driver object and Navigate to URL
		driver = getDriver();
		driver.get(ObjectRepositroy.URL);
		elementHandler.waitFor(2000);

		// Select one way, from and to flight locations
		driver.findElement(By.id(ObjectRepositroy.ONE_WAY_RDO_BTN)).click();
		WebElement fromFlight = driver.findElement(By.id(ObjectRepositroy.FROM_FLIGHT_DROPDOWN));
		elementHandler.sendKeysToElement(fromFlight, "Bangalore");

		// wait for the auto complete options to appear for the origin
		elementHandler.waitForListOfElements(ObjectRepositroy.LOCALITY_OPTIONS);
		List<WebElement> originOptions = driver.findElement(By.id(ObjectRepositroy.LOCALITY_OPTIONS_ID))
				.findElements(By.tagName("a"));
		originOptions.get(0).click();

		elementHandler.waitFor(100);
		WebElement toFlight = driver.findElement(By.id(ObjectRepositroy.TO_FLIGHT_DROPDOWN));
		elementHandler.sendKeysToElement(toFlight, "Delhi");

		// wait for the auto complete options to appear for the destination
		elementHandler.waitForListOfElements(ObjectRepositroy.TO_FLIGHT_DROPDOWN_OPTIONS);
		List<WebElement> destinationOptions = driver.findElement(By.id(ObjectRepositroy.TO_FLIGHT_DROPDOWN_OPTIONS_ID))
				.findElements(By.tagName("a"));
		destinationOptions.get(0).click();

		// select date
		driver.findElement(By.xpath(ObjectRepositroy.DEPART_ON_DATE)).click();

		// all fields filled in. Now click on search
		driver.findElement(By.id(ObjectRepositroy.SEARCH_BTN)).click();

		elementHandler.waitFor(5000);
		// verify that result appears for the provided journey search
		Assert.assertTrue(elementHandler.isElementPresent(By.className(ObjectRepositroy.SEARCH_SUMMARY)));
	}

}
