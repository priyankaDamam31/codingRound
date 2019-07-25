package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {

	WebDriver driver;

	// WebElements
	@FindBy(linkText = "Your trips")
	private WebElement yourTripsLnk;

	@FindBy(id = "SignIn")
	private WebElement SignInBtn;

	@FindBy(id = "modal_window")
	private WebElement signInFrame;

	@FindBy(id = "signInButton")
	private WebElement signInFrameBtn;

	@FindBy(id = "errors1")
	private WebElement errorText;

	// methods
	
	public void clickOnYourTrips() {
		yourTripsLnk.click();
	}
	
	public void clickOnSignInBtn() {
		SignInBtn.click();
	}
	
	public boolean checkSignInFrameExists() {
		return signInFrame.isDisplayed();
	}
	
	public void clickOnsignInFrameBtn() {
		signInFrameBtn.click();
	}
	
	public void navigateTosignInFrame() {
		driver.switchTo().frame(signInFrame);
	}
	
	public boolean checkErrorExists() {
		return errorText.isDisplayed();
	}
	
	public String getErrorText() {
		return errorText.getText();
	}
	
}
