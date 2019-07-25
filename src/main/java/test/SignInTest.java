package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pagefactory.SignInPage;
import utils.ConstantRepositroy;

public class SignInTest {

	WebDriver driver;
	SignInPage page = new SignInPage(this.driver);

	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

		// Navigate to SignIn frame
		page.clickOnYourTrips();
		page.clickOnSignInBtn();

		// check if sign in frame exists, if exists, navigate to sign in frame
		Assert.assertTrue(page.checkSignInFrameExists(), "SignIn Frame does not exist");
		page.navigateTosignInFrame();

		// click on SignIn btn and get errors for not entering username and password
		page.clickOnsignInFrameBtn();
		Assert.assertTrue(page.checkErrorExists(), "Error is not thrown when username and password are not given");
		Assert.assertTrue(page.getErrorText().contains(ConstantRepositroy.ERRORS_TXT));
		page.logoutApplication();
	}

}
