package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Wait_Utilities;

public class Category_Search {
	WebDriver driver;
	public Category_Search(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	Wait_Utilities wait=new Wait_Utilities();
@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'][@class='small-box-footer']") WebElement categorySearch;
@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']") WebElement searchButton;
@FindBy(xpath = "//input[@placeholder='Category']")WebElement categoryField;
@FindBy(xpath = "//button[@name='Search']") WebElement searchButtonForResult;



public void categorySearchClick() {
	categorySearch.click();
}
public void searchButtonClickForCategory() {
	searchButton.click();
}
public void categoryFieldClick(String category) {
	categoryField.sendKeys(category);
}
public void searchButtonClickForResult() {
	wait.waitForElementToBeSelectedLocator(driver, searchButtonForResult);
	//searchButtonForResult.click();
}
public boolean isUserEdited() {
	return searchButtonForResult.isDisplayed();
}

}
