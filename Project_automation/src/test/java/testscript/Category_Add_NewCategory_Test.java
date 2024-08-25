package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.Category_Add_NewCategory;
import pages.login_Class;
import utilities.Excel_Utilities;

public class Category_Add_NewCategory_Test extends Loginpage_Test{
  @Test(description = "verify the user can able to add new category in manage cateogy")
  public void verifyUserCanAddNewCategory() throws IOException {
	 // super.verifyUserIsAbleToSignInUsingValidCredentials();
	  String userNameValue=Excel_Utilities.getStringData(1, 0, "Loginpage");
	  String passwordValue=Excel_Utilities.getStringData(1, 1, "Loginpage");
	  login_Class loginClass=new login_Class(driver);
	  loginClass.enterUserNameField(userNameValue);
	  loginClass.enterPasswordField(passwordValue);
	  loginClass.clickSigninButton();
	  Category_Add_NewCategory addNew= new Category_Add_NewCategory(driver);
	  addNew.categorySelect();
	  addNew.newButtonClick();
	  String categoryValue=Excel_Utilities.getStringData(1, 0, "addcategory");
	  String image=Excel_Utilities.getStringData(1, 1, "addcategory");
	  addNew.categoryFieldClick(categoryValue);
	  addNew.selectGroupField();
	  addNew.imageattachment(image);
	  addNew.Radio1();
	  addNew.radio2();
	  addNew.saveButtonForSubmit();
	  boolean isAllFieldsComplete=addNew.isAllFieldsComplete();
	  assertTrue(isAllFieldsComplete,Constants.ALLFIELDCOMPLETE);
  }
}
