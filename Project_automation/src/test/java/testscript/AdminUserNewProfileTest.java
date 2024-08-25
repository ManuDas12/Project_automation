package testscript;

import static org.testng.Assert.assertTrue;


import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUserNewProfile;
import pages.login_Class;
import utilities.Excel_Utilities;

public class AdminUserNewProfileTest extends Base{
  @Test
  public void verifythe_User_Is_Ableto_Add_NewUser() throws IOException {
	  //super.verifyUserIsAbleToSignInUsingValidCredentials();
	  String userNameValue=Excel_Utilities.getStringData(1, 0, "Loginpage");
	  String passwordValue=Excel_Utilities.getStringData(1, 1, "Loginpage");
	  login_Class loginClass=new login_Class(driver);
	  loginClass.enterUserNameField(userNameValue);
	  loginClass.enterPasswordField(passwordValue);
	  loginClass.clickSigninButton();
	  
	  AdminUserNewProfile adminUser=new AdminUserNewProfile(driver);
	  adminUser.adminUserClickButton();
	  adminUser.newButtonClick();
	  
	  String usernameValue1= Excel_Utilities.getStringData(1, 0, "AdminUserPage");
	  String passwordValue1=Excel_Utilities.getStringData(1, 1, "AdminUserPage");
	  String userTypeValue1=Excel_Utilities.getStringData(1, 2, "AdminUserPage");
	  
	  adminUser.userNamevalue(usernameValue1);
	  adminUser.passwordValue(passwordValue1);
	  adminUser.userTypeDropDownField(userTypeValue1);
	  
	  adminUser.clickSubmitButton();
	  
	  boolean isNewUserCreated=adminUser.isNewUserCreated();
	  assertTrue(isNewUserCreated,Constants.NEWUSERNOTCREATED);
	  
  }
}
