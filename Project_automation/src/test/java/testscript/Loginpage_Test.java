package testscript;

import static org.testng.Assert.assertEquals; 
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUserNewProfile;
import pages.Admin_User_Edit;
import pages.login_Class;
import utilities.Excel_Utilities;

public class Loginpage_Test extends Base{
	login_Class loginClass;
	AdminUserNewProfile adminUser;
	@DataProvider(name = "Credentials")
	public Object[][] testData() {// data provider
		Object[][] input = new Object[2][2];
		input[0][0] = "admin";
		input[0][1] = "admin";
		input[1][0] = "admin@123";
		input[1][1] = "admin123";
		return input;

	}
  @Test(retryAnalyzer = retry.Retry.class) 
  public void verifyUserIsAbleToSignInUsingValidCredentials() throws IOException {
	  
	  String userNameValue=Excel_Utilities.getStringData(1, 0, "Loginpage");
	  String passwordValue=Excel_Utilities.getStringData(1, 1, "Loginpage");
	  String usernameValue1= Excel_Utilities.getStringData(1, 0, "AdminUserPage");
	  String passwordValue1=Excel_Utilities.getStringData(1, 1, "AdminUserPage");
	  String userTypeValue1=Excel_Utilities.getStringData(1, 2, "AdminUserPage");
	  
	  loginClass=new login_Class(driver);
	  adminUser=loginClass.enterUserNameField(userNameValue).enterPasswordField(passwordValue).clickSigninButton().adminUserClickButton().newButtonClick().userNamevalue(usernameValue1).passwordValue(passwordValue1).userTypeDropDownField(userTypeValue1).clickSubmitButton();
	  //loginClass.enterUserNameField(userNameValue);
	  //loginClass.enterPasswordField(passwordValue);
	  //loginClass.clickSigninButton();
	  boolean isHomePageIsLoaded=loginClass.isDashboardLoaded();
	  assertTrue(isHomePageIsLoaded,Constants.ERRORMSGFORLOGIN);

  }
  @Test(groups = {"smoke testing"})
  @Parameters({"validuserName","invalidpassword"})
  public void verifyValidUsernameAndInvalidPassword(String validuserName,String invalidpassword) {
	
	  login_Class loginClass=new login_Class(driver);
	  loginClass.enterUserNameField(validuserName);
	  loginClass.enterPasswordField(invalidpassword);
	  loginClass.clickSigninButton();
	  boolean isDashboadNotLoaded=loginClass.isDashboadNotLoaded();
	  assertTrue(isDashboadNotLoaded,Constants.ERRORMSGFORLOGIN);
  }
  @Test(description = "parameterised ")
  //@Parameters({"user name","password"})
  public void verifyInvalidUsernameAndValidPassword() throws IOException {
	  String userNameValue=Excel_Utilities.getStringData(2, 0, "Loginpage");
	  String passwordValue=Excel_Utilities.getStringData(2, 1, "Loginpage");
	  login_Class loginClass=new login_Class(driver);
	  loginClass.enterUserNameField(userNameValue);
	  loginClass.enterPasswordField(passwordValue);
	  loginClass.clickSigninButton();
	  boolean isDashboadNotLoaded=loginClass.isDashboadNotLoaded();
	  assertTrue(isDashboadNotLoaded,Constants.ERRORMSGFORLOGIN);
  }
  @Test(dataProvider = "Credentials")
  public void verifyInvalidUsernameAndInvalidPassword(String userNameValue,String passwordVAlue) {

	  login_Class loginClass=new login_Class(driver);
	  loginClass.enterUserNameField(userNameValue);
	  loginClass.enterPasswordField(passwordVAlue);
	  loginClass.clickSigninButton();
	  
	  
	  boolean isDashboadNotLoaded=loginClass.isDashboadNotLoaded();
	  assertTrue(isDashboadNotLoaded,Constants.ERRORMSGFORLOGIN);
  }
}















/*@Test(description = "parameterised ")
//@Parameters({"user name","password"})
public void verifyInvalidUsernameAndValidPassword() {
	  String userNameValue="user12";
	  String passwordVAlue="admin";
	  login_Class loginClass=new login_Class(driver);
	  loginClass.enterUserNameField(userNameValue);
	  loginClass.enterPasswordField(passwordVAlue);
	  loginClass.clickSigninButton();
	  boolean isDashboadNotLoaded=loginClass.isDashboadNotLoaded();
	  assertTrue(isDashboadNotLoaded,"home page is not loaded,alert is not displayed");*/