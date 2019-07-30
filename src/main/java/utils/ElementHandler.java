package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementHandler {

	WebDriver driver;

	public ElementHandler(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForElement(WebElement ele) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(ele));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public void waitForElementToBeClickable (WebElement ele) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	public boolean isElementPresent(WebElement ele) {
		try {
			ele.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void waitForListOfElements(By value) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(value, 0));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	public void sendKeysToElement(WebElement ele, String value) {
		try {
			ele.clear();
			ele.sendKeys(value);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public void navigateToFrame(WebElement frame) {
		try {
			driver.switchTo().frame(frame);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public void pressEscapeKey () {
		try {
			Actions act = new Actions(driver);
			act.sendKeys(Keys.ESCAPE).perform();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
}
