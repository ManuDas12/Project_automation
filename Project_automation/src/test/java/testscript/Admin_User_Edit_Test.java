package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.Admin_User_Edit;
import pages.login_Class;
import utilities.Excel_Utilities;

public class Admin_User_Edit_Test extends Base {
  @Test
  public void verifyTheUserCanAbleToEditAdminUSer() throws IOException {
	  Admin_User_Edit adminEdit=new Admin_User_Edit(driver);
	 // super.verifyUserIsAbleToSignInUsingValidCredentials();
	  String userNameValue=Excel_Utilities.getStringData(1, 0, "Loginpage");
	  String passwordValue=Excel_Utilities.getStringData(1, 1, "Loginpage");
	  login_Class loginClass=new login_Class(driver);
	  loginClass.enterUserNameField(userNameValue);
	  loginClass.enterPasswordField(passwordValue);
	  loginClass.clickSigninButton();
	  
	  adminEdit.adminUserClickForEdit();
	  adminEdit.editButtonClickForEdit();
	  String UserNameEdit=Excel_Utilities.getStringData(1, 0, "AdminUSerEdit");
	  String passwordEdit=Excel_Utilities.getStringData(1, 2, "AdminUSerEdit");
	  String userTypeEditDrop=Excel_Utilities.getStringData(1, 3, "AdminUSerEdit");
	  adminEdit.usernameEditField(UserNameEdit);
	  adminEdit.passwordEditField(passwordEdit);
	  adminEdit.userTypeEditDrop(userTypeEditDrop);
	  adminEdit.updateButtonClick();
	  boolean iSEditComplete=adminEdit.isEditComplete();
	  assertTrue(iSEditComplete,Constants.ISEDITDONE);
	  
  }
}
