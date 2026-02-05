package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Utilities;
import Constant.Constant;
import Constant.MenuItem;

public class LogoutTest extends BaseTest {
	@Test
	public void TC06() {
		System.out.println("TC06 - User is redirected to Home page after logging out");
		Account user = new Account(Constant.VALID_EMAIL, Constant.VALID_PASSWORD, Constant.VALID_PID);
		
		System.out.println("1. Navigate to QA Railway Website");
		homePage.open();
		
		System.out.println("2. Login with valid Email and Password");
		homePage.gotoTab(MenuItem.LOGIN.getText());
		loginPage.login(user.getUsername(), user.getPassword());
		
		System.out.println("3. Click on \"FAQ\" tab");
		Utilities.click(homePage.getTabFaqLocator());
		
		System.out.println("4. Click on \"Log out\" tab");
		Utilities.click(homePage.getTabLogoutLocator());
				
		System.out.println("Verify that Home page displays. \"Log out\" tab is disappeared.");
		Assert.assertTrue(homePage.isTabSelected(MenuItem.HOME.getText()));
		Assert.assertFalse(homePage.isTabAppeared(MenuItem.LOGOUT.getText()));
	}
}
