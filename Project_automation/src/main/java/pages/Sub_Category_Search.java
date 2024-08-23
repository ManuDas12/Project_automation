package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Page_Utilities;

public class Sub_Category_Search {
	WebDriver driver;
	public Sub_Category_Search(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
Page_Utilities page=new Page_Utilities(); 

@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'][@class='small-box-footer']") WebElement subCategoryClick;	
@FindBy(xpath = "//a[@onclick='click_button(2)']") WebElement searchButton;
@FindBy(xpath = "//select[@id='un']") WebElement catgoryDropField;
@FindBy(xpath = "//input[@name='ut']") WebElement subCategoryField;
@FindBy(xpath = "//button[@name='Search']") WebElement searchButtonForResult;

public void subCategorySelect() {
	subCategoryClick.click();
}
public void searchButtonClick() {
	searchButton.click();
}
public void categoryFieldSelect(String cateogry) {
	page.selectionMethods(catgoryDropField,cateogry);
}
public void subCategoryField(String subCategory) {
	subCategoryField.sendKeys(subCategory);
}
public void searchButtonClickForResult() {
	searchButtonForResult.click();
}
public boolean isUserSubmitAllValues() {
	return 	searchButtonForResult.isDisplayed();
}

}
