package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.ObjectRepositroy;
import utils.TestHandler;

public class SignInTest extends TestHandler {

	WebDriver driver;

	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

		// get the driver object and Navigate to URL
		driver = getDriver();
		driver.get(ObjectRepositroy.URL);
		elementHandler.waitFor(2000);

		// Navigate to SignIn frame
		driver.findElement(By.linkText(ObjectRepositroy.YOUR_TRIPS_LNK)).click();
		driver.findElement(By.id(ObjectRepositroy.SIGNIN)).click();
		WebElement frame1 = driver.findElement(By.id(ObjectRepositroy.SIGN_IN_FRAME));
		elementHandler.waitFor(1000);
		driver.switchTo().frame(frame1);

		// click on SignIn button and get the errors for not entering username and
		// password
		driver.findElement(By.id(ObjectRepositroy.SIGN_IN_BTN)).click();
		String errors1 = driver.findElement(By.id(ObjectRepositroy.ERRORS_WEB_ELEMENT)).getText();
		Assert.assertTrue(errors1.contains(ObjectRepositroy.ERRORS_TXT));
	}

}
