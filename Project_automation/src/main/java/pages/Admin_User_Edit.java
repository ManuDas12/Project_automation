package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Page_Utilities;

public class Admin_User_Edit {
	WebDriver driver;
	
	public Admin_User_Edit(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	} 
Page_Utilities page=new Page_Utilities();
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']") WebElement adminUserClick;	
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/user/edit?edit=9960&page_ad=1']") WebElement editButtonClick;
@FindBy(xpath="//input[@id='username']") WebElement userNameEdit;
@FindBy(xpath="//input[@id='password']") WebElement passwordEdit;
@FindBy(xpath="//select[@id='user_type']") WebElement userTypeEdit;
@FindBy(xpath = "//button[@name='Update']")WebElement updateButton;

public Admin_User_Edit adminUserClickForEdit() {
	adminUserClick.click();
	return this;
}
public Admin_User_Edit editButtonClickForEdit() {
	editButtonClick.click();
	return this;
	
}
public Admin_User_Edit usernameEditField(String username) {
	userNameEdit.clear();
	userNameEdit.sendKeys(username);
	return this;
}
public Admin_User_Edit passwordEditField(String password) {
	passwordEdit.clear();
	passwordEdit.sendKeys(password);
	return this;
}
public Admin_User_Edit userTypeEditDrop(String userType) {
page.selectionMethods(userTypeEdit,userType);
return this;
}
public Admin_User_Edit updateButtonClick() {
	updateButton.click();
	return this;
}
public boolean isEditComplete() {
	return updateButton.isDisplayed();
}
}
