package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.Manage_Page_List_Search;
import pages.login_Class;
import utilities.Excel_Utilities;

public class Manage_Page_List_Search_Test extends Base {
  @Test
  public void verify_The_UserAbleTo_SearchItemsIn_ManagePage() throws IOException {
	 // super.verifyUserIsAbleToSignInUsingValidCredentials();
	  String userNameValue=Excel_Utilities.getStringData(1, 0, "Loginpage");
	  String passwordValue=Excel_Utilities.getStringData(1, 1, "Loginpage");
	  login_Class loginClass=new login_Class(driver);
	  loginClass.enterUserNameField(userNameValue);
	  loginClass.enterPasswordField(passwordValue);
	  loginClass.clickSigninButton();
	  
	  Manage_Page_List_Search managePageSearch=new Manage_Page_List_Search(driver);
	  
	  managePageSearch.managePageClick();
	  managePageSearch.searchButtonForSearchItems();
	  
	  String titleValueSearch= Excel_Utilities.getStringData(1, 0, " Manage Search List");
	  managePageSearch.enterValueForTitleField(titleValueSearch);
	  managePageSearch.submitButtonForResults();
	  
	  boolean isSearchResultFound=managePageSearch.isSearchResultFound();
	  assertTrue(isSearchResultFound,Constants.SEARCHITEMSNOTFOUND);
  }
}
