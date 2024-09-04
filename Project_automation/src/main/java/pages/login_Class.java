package pages;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login_Class {
	WebDriver driver;
	
public login_Class(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver,this);
	
}	

@FindBy(xpath="//input[@type='text']")WebElement userNameField;
@FindBy(xpath="//input[@type='password']") WebElement passwordField;
@FindBy(xpath="//button[@type='submit']") WebElement signinButton;
@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;
@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement alertmsg;

public login_Class enterUserNameField(String userName) {
	userNameField.sendKeys(userName);
	return this;
}

public login_Class enterPasswordField(String password) {
	passwordField.sendKeys(password);
	return this;
}

public Admin_User_Edit clickSigninButton() {
	signinButton.click();
	return new Admin_User_Edit(driver);
}

public boolean isDashboardLoaded() {
	return dashboard.isDisplayed();
}

public boolean isDashboadNotLoaded() {
	return alertmsg.isDisplayed();
}

}
