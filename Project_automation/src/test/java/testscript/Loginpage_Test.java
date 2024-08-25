package testscript;

import static org.testng.Assert.assertEquals; 
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.login_Class;
import utilities.Excel_Utilities;

public class Loginpage_Test extends Base{
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
 // @Parameters({"user name","password"})
  public void verifyUserIsAbleToSignInUsingValidCredentials() throws IOException {
	 // String userNameValue="admin";
	  //String passwordVAlue="admin";
	  String userNameValue=Excel_Utilities.getStringData(1, 0, "Loginpage");
	  String passwordValue=Excel_Utilities.getStringData(1, 1, "Loginpage");
	  login_Class loginClass=new login_Class(driver); 
	  loginClass.enterUserNameField(userNameValue);
	  loginClass.enterPasswordField(passwordValue);
	  loginClass.clickSigninButton();
	  boolean isHomePageIsLoaded=loginClass.isDashboardLoaded();
	  assertTrue(isHomePageIsLoaded,Constants.ERRORMSGFORLOGIN);

  }
  @Test(groups = {"smoke testing"})
  @Parameters({"validuserName","invalidpassword"})
  public void verifyValidUsernameAndInvalidPassword(String validUser,String invalidPass) {
	 // String userNameValue="admin";
	  //String passwordVAlue="admin";
	  login_Class loginClass=new login_Class(driver);
	  loginClass.enterUserNameField(validUser);
	  loginClass.enterPasswordField(invalidPass);
	  loginClass.clickSigninButton();
	  boolean isDashboadNotLoaded=loginClass.isDashboadNotLoaded();
	  assertTrue(isDashboadNotLoaded,"home page is not loaded,alert is not displayed");
  }
  @Test(description = "parameterised ")
  //@Parameters({"user name","password"})
  public void verifyInvalidUsernameAndValidPassword() {
	  String userNameValue="user12";
	  String passwordVAlue="admin";
	  login_Class loginClass=new login_Class(driver);
	  loginClass.enterUserNameField(userNameValue);
	  loginClass.enterPasswordField(passwordVAlue);
	  loginClass.clickSigninButton();
	  boolean isDashboadNotLoaded=loginClass.isDashboadNotLoaded();
	  assertTrue(isDashboadNotLoaded,"home page is not loaded,alert is not displayed");
  }
  @Test(dataProvider = "Credentials")
  public void verifyInvalidUsernameAndInvalidPassword(String userNameValue,String passwordVAlue) {
	  //String userNameValue="user";
	  //String passwordVAlue="user@123";
	  login_Class loginClass=new login_Class(driver);
	  loginClass.enterUserNameField(userNameValue);
	  loginClass.enterPasswordField(passwordVAlue);
	  loginClass.clickSigninButton();
	  
	  
	  boolean isDashboadNotLoaded=loginClass.isDashboadNotLoaded();
	  assertTrue(isDashboadNotLoaded,"home page is not loaded,alert is not displayed");
  }
}
