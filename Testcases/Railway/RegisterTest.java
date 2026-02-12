package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Utilities;
import Constant.Constant;
import Constant.MenuItem;

public class RegisterTest extends BaseTest {
	@Test
	public void TC07() {
		System.out.println("TC07 - User can't create account with an already in-use email");
		String expectedMsg = "This email address is already in use.";
		
		System.out.println("Pre-condition: an actived account is existing");
		Account user = registerActiveAccount();
		
		System.out.println("1. Navigate to QA Railway Website");
		Utilities.switchToLastTab();
		
		System.out.println("2. Click on \"Register\" tab");
		homePage.gotoTab(MenuItem.REGISTER.getText());
		
		System.out.println("3. Enter information of the created account in Pre-condition");
		System.out.println("4. Click on \"Register\" button");
		registerPage.register(user.getUsername(), Constant.VALID_PASSWORD, Constant.VALID_PID);
		
		System.out.println("Verify that error message \"This email address is already in use.\" displays above the form.");
		String actualMsg = registerPage.getLblRegErrMeg();
		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
	}
	
	@Test
	public void TC08() {
		System.out.println("TC08 - User can't create account while password and PID fields are empty");
		String newEmail = createEmail();
		String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
		String expectedPwMsg = "Invalid password length";
		String expectedPidMsg = "Invalid ID length";
		
		System.out.println("1. Navigate to QA Railway Website");
		homePage.open();
		
		System.out.println("2. Click on \"Register\" tab");
		homePage.gotoTab(MenuItem.REGISTER.getText());
		
		System.out.println("3. Enter valid email address and leave other fields empty");
		System.out.println("4. Click on \"Register\" button");
		registerPage.register(newEmail + Constant.EMAIL_DOMAIN, Constant.BLANK_VALUE, Constant.BLANK_VALUE);
		
		System.out.println("Verify that Message \"There're errors in the form. Please correct the errors and try again.\" appears above the form.");
		String actualMsg = registerPage.getLblRegErrMeg();
		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
		
		System.out.println("Verify that Next to password fields, error message \"Invalid password length.\" displays");
		String actualPwMsg = registerPage.getLblPwValErrMsg();
		Assert.assertEquals(actualPwMsg, expectedPwMsg, "Validation error message is not displayed as expected");
		
		System.out.println("Verify that Next to PID field, error message \"Invalid ID length.\" displays");
		String actualPidMsg = registerPage.getLblPidErrMsg();
		Assert.assertEquals(actualPidMsg, expectedPidMsg, "Validation error message is not displayed as expected");
	}
	
	@Test
	public void TC09() {
		System.out.println("TC09 - User create and activate account");
		String newEmail = createEmail();
		String expectedThankForRegisterMsg = "Thank you for registering your account";
		String expectedMsg = "Registration Confirmed! You can now log in to the site.";
		
		System.out.println("1. Navigate to QA Railway Website");
		Utilities.switchToNewTab(Constant.RAILWAY_URL);
		
		System.out.println("Verify that Home page is shown with guide containing href \"create an account\" to \"Register\" page");
		Assert.assertTrue(homePage.isTabSelected(MenuItem.HOME.getText()), "Home page is not shown as expected");
		Assert.assertTrue(homePage.isLinkCreateAccountDisplayed(), "Create an account href is not contained as expected");
		
		System.out.println("2. Click on \"Create an account\"");
		homePage.clickCreateAccountLink();
		
		System.out.println("Verify that Register page is shown");
		Assert.assertTrue(homePage.isTabSelected(MenuItem.REGISTER.getText()), "Register page is not shown as expected");
		
		System.out.println("3. Enter valid information into all fields");
		System.out.println("4. Click on \"Register\" button");
		registerPage.register(newEmail + Constant.EMAIL_DOMAIN, Constant.VALID_PASSWORD, Constant.VALID_PID);
		
		System.out.println("Verify that \"Thank you for registering your account\" is shown");
		String actualThankForRegisterMsg = registerPage.getLblPageMainContent();
		Assert.assertEquals(actualThankForRegisterMsg, expectedThankForRegisterMsg, "Thank for registering message is not displayed as expected");
		
		System.out.println("5. Get email information (webmail address, mailbox and password) and navigate to that webmail");
		System.out.println("6. Login to the mailbox");
		Utilities.switchToFirstTab();
		
		System.out.println("7. Open email with subject containing \"Please confirm your account\"  and the email of the new account at step 3");
		System.out.println("8. Click on the activate link");
		guerrillamailPage.clickEmailTitle(newEmail, "Please confirm your account");
		
		System.out.println("Verify that system redirects to Railways page and message \"Registration Confirmed! You can now log in to the site\" is shown");
		Utilities.switchToLastTab();
		String actualMsg = registerPage.getLblRegConfirmed();
		Assert.assertEquals(actualMsg, expectedMsg, "Registration Confirmed message is not displayed as expected");
	}
}
