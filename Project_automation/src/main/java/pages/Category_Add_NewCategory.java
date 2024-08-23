package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUpload_Utilities;
import utilities.Page_Utilities;
import utilities.Wait_Utilities;

public class Category_Add_NewCategory {
	WebDriver driver;
	public Category_Add_NewCategory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
Page_Utilities page=new Page_Utilities();	
FileUpload_Utilities file=new FileUpload_Utilities();
Wait_Utilities wait =new Wait_Utilities();
@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'][@class='small-box-footer']") WebElement categoryClick;
@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement newButton;
@FindBy(xpath = "//input[@id='category']") WebElement categoryField;
@FindBy(xpath = "//li[@id='134-selectable']") WebElement selectGroupField;
@FindBy(xpath = "//input[@id='main_img']") WebElement imageButton;
@FindBy(xpath = "//input[@value='yes'][@name='top_menu']") WebElement radioButton1;
@FindBy(xpath = "//input[@value='yes'][@name='show_home']") WebElement radioButton2;
@FindBy(xpath = "//button[@type='submit']") WebElement saveButton;
@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alertMsg;

public void categorySelect() {
	categoryClick.click();
}
public void newButtonClick() {
	newButton.click();
}
public void categoryFieldClick(String category) {
	categoryField.sendKeys(category);
}
public void selectGroupField() {
	selectGroupField.click();
}
public void imageattachment(String image) {
	//imageButton.sendKeys(image);
	file.robotClass(imageButton, image);
}
public void Radio1() {
	radioButton1.isSelected();
}
public void radio2() {
	radioButton2.isSelected();
}
public void saveButtonForSubmit() { 
	wait.waitForElementToBeSelectedLocator(driver, saveButton);
	saveButton.click();
}
public boolean isAllFieldsComplete() {
	return alertMsg.isDisplayed();
}
}
