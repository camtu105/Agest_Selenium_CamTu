package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
	@Test
	public void TC06() {
		System.out.println("TC06 - User is redirected to Home page after logging out");
		
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Login with valid Email and Password");
		LoginPage loginPage = homePage.gotoLoginPage();
		loginPage.login(user.getUsername(), user.getPassword());
		
		System.out.println("3. Click on \"FAQ\" tab");
		homePage.getTabFAQ().click();
		
		System.out.println("4. Click on \"Log out\" tab");
		homePage.getTabLogout().click();
		
		System.out.println("Verify that Home page displays. \"Log out\" tab is disappeared.");
		Assert.assertFalse(homePage.isTabLogoutAppeared());
	}
}
