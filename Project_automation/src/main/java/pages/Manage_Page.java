package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Wait_Utilities;

public class Manage_Page {
	WebDriver driver;
	public Manage_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
@FindBy(xpath="//a[@class='small-box-footer'][1]") WebElement managePage;
@FindBy(xpath = "//a[@onclick=\"click_button(1)\"]") WebElement newButton;
@FindBy(xpath = "//input[@id='title']") WebElement titleField;
@FindBy(xpath = "//div[@class='note-editable card-block']") WebElement description;
@FindBy(xpath = "//input[@id='page']") WebElement pageField;
@FindBy(xpath = "//input[@id='main_img']") WebElement chooseImage;
@FindBy(xpath ="//button[@type='submit']") WebElement saveButtonManagePage;
@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alert_Msg_After_Succesfull;


public void managePageClick() {
	managePage.click();
}

public void newButtonClick() {
	newButton.click();
}

public void titleFieldValue(String title) {
	titleField.sendKeys(title);
}

public void descriptionField(String desc) { 
	description.sendKeys(desc);
}
public void pageFieldValue(String pageValue) {
	pageField.sendKeys(pageValue);
}

public void imageAttachment(String image) {		
chooseImage.sendKeys(image); 
}

public void ManagePageSaveButtonClick() {
	Wait_Utilities wait=new Wait_Utilities();
	wait.waitForElementToClick(driver,saveButtonManagePage);
	saveButtonManagePage.click();
}

public boolean isUserSubmitAllValues() {
	return alert_Msg_After_Succesfull.isDisplayed();
}
}