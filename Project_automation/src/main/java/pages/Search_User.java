package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Search_User {
	WebDriver driver;
	
	public Search_User(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']") WebElement adminUserClick;
@FindBy(xpath="//a[@onclick='click_button(2)']") WebElement searchButton;
@FindBy(xpath="//input[@id='un']") WebElement userNameField2;
@FindBy(xpath="//select[@id='ut']") WebElement userTypeDropDown2;
@FindBy(xpath="//button[@name='Search']") WebElement searchButton2;

public void adminUserSelect() {
	adminUserClick.click();
}

public void searchButtonForSearching() {
	searchButton.click();
}

public void enterUserName(String username) {
	userNameField2.sendKeys(username);
}

public void selectUserType(String usertype) {
	Select selectUser=new Select(userTypeDropDown2);
	selectUser.selectByVisibleText(usertype);	
}

public void submitButtonForSearch() {
	searchButton2.click();
}

public boolean isUserFound() {
	return searchButton2.isDisplayed();
}
}
