package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.Sub_Category_Search;
import pages.login_Class;
import utilities.Excel_Utilities;

public class Sub_Category_Search_Test extends Base{
  @Test
  public void verifyUserCanAbleTo_SubCategory_Search() throws IOException {
	  //super.verifyUserIsAbleToSignInUsingValidCredentials();
	  String userNameValue=Excel_Utilities.getStringData(1, 0, "Loginpage");
	  String passwordValue=Excel_Utilities.getStringData(1, 1, "Loginpage");
	  login_Class loginClass=new login_Class(driver);
	  loginClass.enterUserNameField(userNameValue);
	  loginClass.enterPasswordField(passwordValue);
	  loginClass.clickSigninButton();
	  
	  Sub_Category_Search subCategory=new Sub_Category_Search(driver);
	  subCategory.subCategorySelect();
	  subCategory.searchButtonClick();
	  String categoryValue=Excel_Utilities.getStringData(1, 0, "Subcategory search");
	  String subCategoryValue=Excel_Utilities.getStringData(1, 1, "Subcategory search");
	  subCategory.categoryFieldSelect(categoryValue);
	  subCategory.subCategoryField(subCategoryValue);
	  subCategory.searchButtonClickForResult();
	  boolean isUserSubmitAllValues=subCategory.isUserSubmitAllValues();
	  assertTrue(isUserSubmitAllValues,Constants.ISSUBCATEGORYSEARCH);
	  
  }
}
