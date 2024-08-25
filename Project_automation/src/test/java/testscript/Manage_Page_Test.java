package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.Manage_Page;
import pages.login_Class;
import utilities.Excel_Utilities;

public class Manage_Page_Test extends Base {
  @Test(description = "verify the user can able to add values in manage page")
  public void verifyThe_UserIs_AbleTo_Submit_ManagePageValues() throws IOException {
	 // super.verifyUserIsAbleToSignInUsingValidCredentials();
	  String userNameValue=Excel_Utilities.getStringData(1, 0, "Loginpage");
	  String passwordValue=Excel_Utilities.getStringData(1, 1, "Loginpage");
	  login_Class loginClass=new login_Class(driver);
	  loginClass.enterUserNameField(userNameValue);
	  loginClass.enterPasswordField(passwordValue);
	  loginClass.clickSigninButton();
	  
	  Manage_Page managePage=new Manage_Page(driver);
	  managePage.managePageClick();
	  managePage.newButtonClick();
	  
	  String titleValue1=Excel_Utilities.getStringData(1, 0, "Manage Page Data");
	  String descValue=Excel_Utilities.getStringData(1, 1, "Manage Page Data");
	  String pageValue=Excel_Utilities.getStringData(1,2, "Manage Page Data"); 
	  String pic=Excel_Utilities.getStringData(1, 3, "Manage Page Data");
	  
	  managePage.titleFieldValue(titleValue1);
	  managePage.descriptionField(descValue);
	  managePage.pageFieldValue(pageValue);
	  managePage.imageAttachment(pic);
	  
	  managePage.ManagePageSaveButtonClick();
	  
	  boolean isUserSubmitAllValues=managePage.isUserSubmitAllValues(); 
	  assertTrue(isUserSubmitAllValues,Constants.MANAGEPAGENOTSUBMITED);
	  
  }
}
