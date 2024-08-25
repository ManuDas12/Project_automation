package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.Category_Search;
import pages.login_Class;
import utilities.Excel_Utilities;

public class Category_Search_Test extends Base {
  @Test
  public void veifyTheUserAbleTo_CategorySearch() throws IOException {
	 // super.verifyUserIsAbleToSignInUsingValidCredentials();
	  String userNameValue=Excel_Utilities.getStringData(1, 0, "Loginpage");
	  String passwordValue=Excel_Utilities.getStringData(1, 1, "Loginpage");
	  login_Class loginClass=new login_Class(driver);
	  loginClass.enterUserNameField(userNameValue);
	  loginClass.enterPasswordField(passwordValue);
	  loginClass.clickSigninButton();
	  
	  Category_Search categorySearch=new Category_Search(driver);  
	  categorySearch.categorySearchClick();
	  categorySearch.searchButtonClickForCategory();
	  String catagoryValue=Excel_Utilities.getStringData(1, 0, "Categoryedit");
	  categorySearch.categoryFieldClick(catagoryValue);
	  categorySearch.searchButtonClickForResult();
	  boolean IsUserEdited=categorySearch.isUserEdited();
	  assertTrue(IsUserEdited,Constants.CATEGORYEDITDONE);
	  
  }
}
