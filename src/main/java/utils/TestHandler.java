package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

import com.sun.javafx.PlatformUtil;

public class TestHandler {

	/**
	 * Driver
	 */
	private WebDriver driver;

	final public ElementHandler elementHandler;

	/**
	 * Default Constructor
	 */
	public TestHandler() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("start-maximized");
		setDriverPath();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		elementHandler = new ElementHandler(driver);
	}

	// method to access driver instance
	public WebDriver getDriver() {
		return this.driver;
	}

	/**
	 * Function to close and quit the driver instance
	 */
	@AfterTest(alwaysRun = true)
	public void logoutApplication() {
		driver.close();
		driver.quit();
	}

	/**
	 * Function to set the driver path
	 */
	private void setDriverPath() {
		if (PlatformUtil.isMac()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
		}
		if (PlatformUtil.isWindows()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		}
		if (PlatformUtil.isLinux()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
		}
	}
}
