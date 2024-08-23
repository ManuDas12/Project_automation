package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUpload_Utilities;
import utilities.Page_Utilities;

public class Manage_SubCategory {
	WebDriver driver;
public  Manage_SubCategory (WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);	
}
FileUpload_Utilities file=new FileUpload_Utilities();
@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'][@class='small-box-footer']") WebElement subCategory;
@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement newButton;
@FindBy(xpath = "//select[@id='cat_id']") WebElement categoryDrop;
@FindBy(xpath = "//input[@id='subcategory']") WebElement subCategoryField;
@FindBy(xpath = "//input[@id='main_img']") WebElement chooseFileField;
@FindBy(xpath = "//button[@type='submit']") WebElement submitButton;
@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alertMsg;

public void subcategoryClick() {
	subCategory.click();	
}
public void newButtonClick() {
	newButton.click();
}
public void categoryDrop(String category) {
	//categoryDrop.sendKeys(category);
	Page_Utilities page1=new Page_Utilities();
	page1.selectionMethods(categoryDrop, category);
}
public void subCategoryField(String subCategory) {
	subCategoryField.sendKeys(subCategory);
}
public void imageUpload(String image) {
	//chooseFileField.sendKeys(image);
	file.robotClass(chooseFileField, image);
}
public void submitButtonClick() {
	submitButton.click();
}
public boolean issubmitsuccesfull() {
	return alertMsg.isDisplayed();
}
}



