package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.Manage_Product_Search;
import pages.login_Class;
import utilities.Excel_Utilities;

public class Manage_Product_Search_Test extends Loginpage_Test {
  @Test(description = "verify user can able to search product in manage product")
  public void verifyUserCan_SearchProductIn_ManagePage() throws IOException {
	  //super.verifyUserIsAbleToSignInUsingValidCredentials();
	  String userNameValue=Excel_Utilities.getStringData(1, 0, "Loginpage");
	  String passwordValue=Excel_Utilities.getStringData(1, 1, "Loginpage");
	  login_Class loginClass=new login_Class(driver);
	  loginClass.enterUserNameField(userNameValue);
	  loginClass.enterPasswordField(passwordValue);
	  loginClass.clickSigninButton();
	  
	  Manage_Product_Search searchProduct=new Manage_Product_Search(driver);
	  searchProduct.manageProductClick();
	  searchProduct.searchButtonClick();
	  String titleName=Excel_Utilities.getStringData(1, 0, "SearchList");
	  String prodCode=Excel_Utilities.getIntegerData(1,1,"SearchList");
	  String categoryValue=Excel_Utilities.getStringData(1, 2, "SearchList");
	  String subCategoryvalue=Excel_Utilities.getStringData(1,3,"SearchList"); 
	  searchProduct.titleFieldValue(titleName);
	  searchProduct.productCodeFieldInput(prodCode);
	  searchProduct.categoryDropDownSelect(categoryValue);
	  searchProduct.subCategoryDropDown(subCategoryvalue);
	  searchProduct.searchButtonClickForRsult();
	  boolean isAllValueSubmitted=searchProduct.isAllValueSubmitted();
	  assertTrue(isAllValueSubmitted,Constants.MANAGEPRODUCTSEARCH);
  }
}
