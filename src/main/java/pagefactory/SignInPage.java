package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementHandler;

public class SignInPage {

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
	
	private ElementHandler elementHandler;
	
	// Constructor
	public SignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		elementHandler = new ElementHandler(driver);
	}

	// methods
	
	public void clickOnYourTrips() {
		yourTripsLnk.click();
	}
	
	public void clickOnSignInBtn() {
		SignInBtn.click();
		elementHandler.waitForElement(signInFrame);
	}
	
	public boolean checkSignInFrameExists() {
		return signInFrame.isDisplayed();
	}
	
	public void clickOnsignInFrameBtn() {
		signInFrameBtn.click();
	}
	
	public void navigateTosignInFrame() {
		elementHandler.navigateToFrame(signInFrame);
	}
	
	public boolean checkErrorExists() {
		return errorText.isDisplayed();
	}
	
	public String getErrorText() {
		return errorText.getText();
	}
	
}
