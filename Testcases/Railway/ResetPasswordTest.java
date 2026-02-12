package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Utilities;
import Constant.MenuItem;

public class ResetPasswordTest extends BaseTest {
	@Test
	public void TC10() {
		System.out.println("TC10 - Reset password shows error if the new password is same as current");
		String expectedMsg = "The new password cannot be the same with the current password";

		System.out.println("Pre-condition: an actived account is existing");
		Account user = registerActiveAccount();
		
		System.out.println("1. Navigate to QA Railway Website");
		Utilities.switchToLastTab();
		
		System.out.println("2. Click on \"Forgot Password page\" link");
		homePage.gotoTab(MenuItem.LOGIN.getText());
		loginPage.gotoResetPasswordPage();
		
		System.out.println("3. Enter the email address of the activated account");
		resetPasswordPage.enterEmail(user.getUsername());
		
		System.out.println("4. Click on \"Send Instructions\" button");
		resetPasswordPage.requestInstructions();
		
		System.out.println("5. Login to the mailbox (the same mailbox when creating account) ");
		Utilities.switchToFirstTab();
		
		System.out.println("6. Open email with subject contaning \"Please reset your password\" and the email of the account at step 3");
		System.out.println("7. Click on reset link");
		guerrillamailPage.clickEmailTitle(user.getUsername(), "Please reset your password");
		
		System.out.println("Verify that system Redirects to Railways page and Form \"Password Change Form\" is shown with the reset password token");
		Utilities.switchToLastTab();
		Assert.assertTrue(resetPasswordPage.isPasswordChangeFormShow(), "Reset password page is not shown as expected");
		
		System.out.println("8. Input same password into 2 fields  \"new password\" and \"confirm password\"");
		System.out.println("9. Click Reset Password");
		resetPasswordPage.resetPassword(user.getPassword(), user.getPassword());
		
		System.out.println("Verify that Message \"The new password cannot be the same with the current password\" is shown");
		String actualMsg = resetPasswordPage.getLblMsg();
		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
	}
	
	@Test
	public void TC11() {
		System.out.println("TC11 - Reset password shows error if the new password and confirm password doesn't match");
		String expectedMsg = "Could not reset password. Please correct the errors and try again.";
		String expectedConfirmPasswordMsg = "The password confirmation did not match the new password.";

		System.out.println("Pre-condition: an actived account is existing");
		Account user = registerActiveAccount();
		
		System.out.println("1. Navigate to QA Railway Website");
		Utilities.switchToLastTab();
		
		System.out.println("2. Click on \"Forgot Password page\" link");
		homePage.gotoTab(MenuItem.LOGIN.getText());
		loginPage.gotoResetPasswordPage();
		
		System.out.println("3. Enter the email address of the activated account");
		resetPasswordPage.enterEmail(user.getUsername());
		
		System.out.println("4. Click on \"Send Instructions\" button");
		resetPasswordPage.requestInstructions();
		
		System.out.println("5. Login to the mailbox (the same mailbox when creating account) ");
		Utilities.switchToFirstTab();
		
		System.out.println("6. Open email with subject contaning \"Please reset your password\" and the email of the account at step 3");
		System.out.println("7. Click on reset link");
		guerrillamailPage.clickEmailTitle(user.getUsername(), "Please reset your password");
		
		System.out.println("Verify that system Redirects to Railways page and Form \"Password Change Form\" is shown with the reset password token");
		Utilities.switchToLastTab();
		Assert.assertTrue(resetPasswordPage.isPasswordChangeFormShow());
		
		System.out.println("8. Input different input into 2 fields  \"new password\" and \"confirm password\"");
		System.out.println("9. Click Reset Password");
		resetPasswordPage.resetPassword(user.getPassword() + user.getPassword(), user.getPassword());
		
		System.out.println("Verify that Error message \"Could not reset password. Please correct the errors and try again.\" displays above the form.");		
		String actualMsg = resetPasswordPage.getLblMsg();
		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
		
		System.out.println("Verify that Error message \"The password confirmation did not match the new password.\" displays next to the confirm password field.");
		String actualConfirmPasswordMsg = resetPasswordPage.getLblConfirmPasswordErrorMsg();
		Assert.assertEquals(actualConfirmPasswordMsg, expectedConfirmPasswordMsg, "Validation error message is not displayed as expected");
	}
}
