package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.Manage_SubCategory;
import pages.login_Class;
import utilities.Excel_Utilities;

public class Manage_SubCategory_Test extends Base {
  @Test
  public void verifyTheUserAbleToSubmitManageSubCategory() throws IOException {
	 // super.verifyUserIsAbleToSignInUsingValidCredentials();
	  String userNameValue=Excel_Utilities.getStringData(1, 0, "Loginpage");
	  String passwordValue=Excel_Utilities.getStringData(1, 1, "Loginpage");
	  login_Class loginClass=new login_Class(driver);
	  loginClass.enterUserNameField(userNameValue);
	  loginClass.enterPasswordField(passwordValue);
	  loginClass.clickSigninButton();
	  
	  Manage_SubCategory manageSub=new Manage_SubCategory(driver);
	  manageSub.subcategoryClick();
	  manageSub.newButtonClick();
	  String categoryValue=Excel_Utilities.getStringData(1, 0, "ManageSubCategory");
	  String subCatValue=Excel_Utilities.getStringData(1, 1, "ManageSubCategory");
	  String imagePath=Excel_Utilities.getStringData(1, 2, "ManageSubCategory");
	  manageSub.categoryDrop(categoryValue);
	  manageSub.subCategoryField(subCatValue);
	  manageSub.imageUpload(imagePath);
	  manageSub.submitButtonClick();
	  boolean issubmitSuccesfull=manageSub.issubmitsuccesfull();
	  assertTrue(issubmitSuccesfull,Constants.SUBMITSUCCESSFORMANAGESUB);
			  
  }  
}
