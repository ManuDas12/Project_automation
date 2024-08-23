package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Manage_Page_List_Search {
	WebDriver driver;
	public Manage_Page_List_Search(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
@FindBy(xpath="//a[@class='small-box-footer'][1]") WebElement managePage;
@FindBy(xpath = "//a[@onclick='click_button(2)']") WebElement searchButton;
@FindBy(xpath = "//input[@name='un']") WebElement titleFieldSearch;
@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']") WebElement searchButtonResult;

public void managePageClick() {
	managePage.click();
}	
 
public void searchButtonForSearchItems() {
	searchButton.click();
}

public void enterValueForTitleField(String title) {
	titleFieldSearch.sendKeys(title);
}

public void submitButtonForResults() {
	searchButtonResult.click();
}

public boolean isSearchResultFound() {
	return searchButtonResult.isDisplayed();
}

}
