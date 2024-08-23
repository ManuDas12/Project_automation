package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUpload_Utilities;
import utilities.Page_Utilities;

public class Manage_Product_Search {
	WebDriver driver;
	public Manage_Product_Search(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
Page_Utilities page=new Page_Utilities();	
@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product'][@class='small-box-footer']")WebElement manageProduct;
@FindBy(xpath = "//a[@onclick='click_button(2)']") WebElement searchButton;
@FindBy(xpath = "//input[@name='un']") WebElement titleField;
@FindBy(xpath = "//input[@name='cd']") WebElement productCodeField;
@FindBy(xpath = "//select[@id='cat_id']") WebElement categoryDropDown;
@FindBy(xpath = "//select[@id='sb']") WebElement subCategoryDrop; 
@FindBy(xpath = "//button[@value='sr']") WebElement searchButtonForResult;

public void manageProductClick() {
	manageProduct.click();
}
public void searchButtonClick() {
	searchButton.click();
}
public void titleFieldValue(String title) {
	titleField.sendKeys(title);
}
public void productCodeFieldInput(String pCode) {
	productCodeField.sendKeys(pCode);
}
public void categoryDropDownSelect(String category) {
	page.selectionMethods(categoryDropDown, category);
}
public void subCategoryDropDown(String SubCat) {
	page.selectionMethods(subCategoryDrop,SubCat);
}
public void searchButtonClickForRsult() {
	searchButtonForResult.click();
}
public boolean isAllValueSubmitted() {
	return searchButtonForResult.isDisplayed();
}
	

}
