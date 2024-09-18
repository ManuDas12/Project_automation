package testscript;

import static org.testng.Assert.assertTrue;


import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUserNewProfile;
import pages.login_Class;
import utilities.Excel_Utilities;

public class AdminUserNewProfileTest extends Base{
	login_Class loginClass;
	AdminUserNewProfile adminUser;

 @Test
  public void verifythe_User_Is_Ableto_Add_NewUser() throws IOException {
	  //super.verifyUserIsAbleToSignInUsingValidCredentials();
	  String userNameValue=Excel_Utilities.getStringData(1, 0, "Loginpage");
	  String passwordValue=Excel_Utilities.getStringData(1, 1, "Loginpage");
	  
	  
	  String usernameValue1= Excel_Utilities.getStringData(1, 0, "AdminUserPage");
	  String passwordValue1=Excel_Utilities.getStringData(1, 1, "AdminUserPage");
	  String userTypeValue1=Excel_Utilities.getStringData(1, 2, "AdminUserPage");
	  
	  loginClass=new login_Class(driver);
	  loginClass.enterUserNameField(userNameValue).enterPasswordField(passwordValue).clickSigninButton();
	 /* loginClass.enterPasswordField(passwordValue);
	  loginClass.clickSigninButton();*/
	  adminUser=loginClass.adminUserClickButton().newButtonClick().userNamevalue(usernameValue1).passwordValue(passwordValue1).userTypeDropDownField(userTypeValue1).clickSubmitButton();
	  
	  /*AdminUserNewProfile adminUser=new AdminUserNewProfile(driver);
	  adminUser.adminUserClickButton();
	  adminUser.newButtonClick();
	
	  
	  adminUser.userNamevalue(usernameValue1);
	  adminUser.passwordValue(passwordValue1);
	  adminUser.userTypeDropDownField(userTypeValue1);
	  
	  adminUser.clickSubmitButton();*/
	  
	  boolean isNewUserCreated=adminUser.isNewUserCreated();
	  assertTrue(isNewUserCreated,Constants.NEWUSERNOTCREATED);
	  
  }
}
