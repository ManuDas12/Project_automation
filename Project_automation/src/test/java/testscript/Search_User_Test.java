package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUserNewProfile;
import pages.Search_User;
import pages.login_Class;
import utilities.Excel_Utilities;

public class Search_User_Test extends Base {
	
@Test
@Parameters({"user name","password","userName"})
  public void verfiy_The_User_Able_To_SearchTheUser(String userEditName) throws IOException {
	//super.verifyUserIsAbleToSignInUsingValidCredentials();
	  String userNameValue=Excel_Utilities.getStringData(1, 0, "Loginpage");
	  String passwordValue=Excel_Utilities.getStringData(1, 1, "Loginpage");
	  login_Class loginClass=new login_Class(driver);
	  loginClass.enterUserNameField(userNameValue);
	  loginClass.enterPasswordField(passwordValue);
	  loginClass.clickSigninButton();
	
	Search_User searchUserResult=new Search_User(driver);
	searchUserResult.adminUserSelect();
	searchUserResult.searchButtonForSearching();
	
	String userNameValue2=Excel_Utilities.getStringData(1, 0, "Search User");
	String userTypeValue2=Excel_Utilities.getStringData(1, 1, "Search User");
	
	searchUserResult.enterUserName(userNameValue2);
	searchUserResult.selectUserType(userTypeValue2);
	searchUserResult.submitButtonForSearch();
	
	boolean isUserFound=searchUserResult.isUserFound();
	assertTrue(isUserFound,Constants.USERNOTFOUND);
	
  }
}
