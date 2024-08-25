package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constants;

public class Wait_Utilities {
	
	public void waitForElementToClick(WebDriver driver,WebElement elementName) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));
		wait.until(ExpectedConditions.elementToBeClickable(elementName));
	}
	public void waitForElementToClickByWebElement(WebDriver driver,WebElement elementName) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));
		wait.until(ExpectedConditions.elementToBeClickable(elementName));
	}
	public void waitForElementToBeSelectedLocator(WebDriver driver,WebElement elementName) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));
		wait.until(ExpectedConditions.elementToBeSelected(elementName));
	}
	public void waitForElementToClickSelectionStateTOBE(WebDriver driver,WebElement elementName) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));
		wait.until(ExpectedConditions.elementSelectionStateToBe(elementName, false));
	}
	public void waitInvisibilityOfAllElements(WebDriver driver,WebElement elementName) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));
		wait.until(ExpectedConditions.invisibilityOfAllElements(elementName));
	}
	public void waitForElementSelectionToBe(WebDriver driver,WebElement elementName) {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));
			wait.until(ExpectedConditions.elementSelectionStateToBe(elementName, false));
}
}

