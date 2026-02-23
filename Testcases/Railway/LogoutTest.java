package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Utilities;
import Constant.MenuItem;

public class LogoutTest extends BaseTest {
	@Test
	public void TC06() {
		System.out.println("TC06 - User is redirected to Home page after logging out");
		
		System.out.println("Before testing - Set up test data");
		Account user = registerActiveAccount();
		
		System.out.println("1. Navigate to QA Railway Website");
		Utilities.switchToLastTab();
		
		System.out.println("2. Login with valid Email and Password");
		homePage.gotoTab(MenuItem.LOGIN.getText());
		loginPage.login(user.getUsername(), user.getPassword());
		
		System.out.println("3. Click on \"FAQ\" tab");
		homePage.gotoTab(MenuItem.FAQ.getText());
		
		System.out.println("4. Click on \"Log out\" tab");
		homePage.gotoTab(MenuItem.LOGOUT.getText());
				
		System.out.println("Verify that Home page displays. \"Log out\" tab is disappeared.");
		Assert.assertTrue(homePage.isTabSelected(MenuItem.HOME.getText()), "Home page is not displayed as expected");
		Assert.assertFalse(homePage.isTabAppeared(MenuItem.LOGOUT.getText()), "\"Log out\" tab is not disappeared as expected");
	}
}
