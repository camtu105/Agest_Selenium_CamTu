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
		Account user = new Account(newEmail + Constant.EMAIL_DOMAIN, Constant.VALID_PASSWORD, Constant.VALID_PID);
		
		System.out.println("Register and active new account");
		Utilities.switchToNewTab(Constant.RAILWAY_URL);
		homePage.gotoTab(MenuItem.REGISTER.getText());
		registerPage.register(user.getUsername(), user.getPassword(), user.getPassword());
		Utilities.switchToFirstTab();
		guerrillamailPage.activeAccount(newEmail, "Please confirm your account");
		
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
		Assert.assertTrue(homePage.isTabSelected(MenuItem.HOME.getText()));
		Assert.assertFalse(homePage.isTabAppeared(MenuItem.LOGOUT.getText()));
	}
}
