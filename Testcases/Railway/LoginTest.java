package Railway;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Utilities;
import Constant.Constant;
import Constant.MenuItem;

public class LoginTest extends BaseTest {
	@Test
	public void TC01() {
		System.out.println("TC01 - User can log into Railway with valid username and password");
		Account user = new Account(newEmail + Constant.EMAIL_DOMAIN, Constant.VALID_PASSWORD, Constant.VALID_PID);
		String expectedMsg = "Welcome " + user.getUsername();
		
		System.out.println("Register and activate new account");
		registerActiveAccount(user);
		
		System.out.println("Set up screen size");
		Dimension dimension = new Dimension(1200, 800);
		Constant.WEBDRIVER.manage().window().setSize(dimension);
		
		System.out.println("1. Navigate to QA Railway Website");
		Utilities.switchToLastTab();
		
		System.out.println("2. Click on \"Login\" tab");
		homePage.gotoTab(MenuItem.LOGIN.getText());
		
		System.out.println("3. Enter valid Email and Password");
		System.out.println("4. Click on \"Login\" button");
		loginPage.login(user.getUsername(), user.getPassword());
		
		System.out.println("Verify that user is logged into Railway and welcome user message is displayed.");
		String actualMsg = loginPage.getWelcomeMessage();
		Assert.assertTrue(loginPage.isLoggedIn());
		Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");;
	}
	
	@Test
	public void TC02() {
		System.out.println("TC02 - User cannot login with blank \"Username\" textbox");
		Account user = new Account(newEmail + Constant.EMAIL_DOMAIN, Constant.VALID_PASSWORD, Constant.VALID_PID);
		String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

		System.out.println("Register and activate new account");
		registerActiveAccount(user);
		
		System.out.println("1. Navigate to QA Railway Website");
		Utilities.switchToLastTab();
		
		System.out.println("2. Click on \"Login\" tab");
		homePage.gotoTab(MenuItem.LOGIN.getText());
		
		System.out.println("3. User doesn't type any words into \"Username\" textbox but enter valid information into \"Password\" textbox");	
		System.out.println("4. Click on \"Login\" button");
		loginPage.login(Constant.BLANK_VALUE, user.getPassword());
		
		System.out.println("Verify that system prevents logging in and message \"There was a problem with your login and/or errors exist in your form.\" appears.");
		String actualMsg = loginPage.getLoginErrorMsg();
		Assert.assertFalse(loginPage.isLoggedIn());
		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");;
	}
	
	@Test
	public void TC03() {
		System.out.println("TC03 - User cannot log into Railway with invalid password");
		Account user = new Account(newEmail + Constant.EMAIL_DOMAIN, Constant.VALID_PASSWORD, Constant.VALID_PID);
		String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

		System.out.println("Register and activate new account");
		registerActiveAccount(user);
		
		System.out.println("1. Navigate to QA Railway Website");
		Utilities.switchToLastTab();
		
		System.out.println("2. Click on \"Login\" tab");
		homePage.gotoTab(MenuItem.LOGIN.getText());
		
		System.out.println("3. Enter valid Email and invalid Password");
		System.out.println("4. Click on \"Login\" button");
		loginPage.login(user.getUsername(), Constant.INVALID_PASSWORD);
		
		System.out.println("Verify that error message \"There was a problem with your login and/or errors exist in your form.\" is displayed.");
		String actualMsg = loginPage.getLoginErrorMsg();
		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
	}
	
	@Test
	public void TC04() {
		System.out.println("TC04 - System shows message when user enters wrong password many times");
		Account user = new Account(newEmail + Constant.EMAIL_DOMAIN, Constant.VALID_PASSWORD, Constant.VALID_PID);
		String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

		System.out.println("Register and activate new account");
		registerActiveAccount(user);
		
		System.out.println("1. Navigate to QA Railway Website");
		Utilities.switchToLastTab();
		
		System.out.println("2. Click on \"Login\" tab");
		homePage.gotoTab(MenuItem.LOGIN.getText());
		
		System.out.println("3. Enter valid information into \"Username\" textbox except \"Password\" textbox");
		System.out.println("4. Click on \"Login\" button");
		System.out.println("5. Repeat step 3 and 4 three more times");
		for (int i = 0; i < 4; i++) {
			loginPage.login(user.getUsername(), Constant.INVALID_PASSWORD);
		}
	
		System.out.println("Verify that system prevents logging login and message \"You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.\" appears.");
		String actualMsg = loginPage.getLoginErrorMsg();
		Assert.assertFalse(loginPage.isLoggedIn());
		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
	}
	
	@Test
	public void TC05() {
		System.out.println("TC05 - User can't login with an account hasn't been activated");
		Account user = new Account(newEmail + Constant.EMAIL_DOMAIN, Constant.VALID_PASSWORD, Constant.VALID_PID);
		String expectedMsg = "Invalid username or password. Please try again.";
		
		System.out.println("Pre-condition: a not-active account is existing");
		registerAccount(user);
		
		System.out.println("1. Navigate to QA Railway Website");
		homePage.open();
		
		System.out.println("2. Click on \"Login\" tab");
		homePage.gotoTab(MenuItem.LOGIN.getText());
		
		System.out.println("3. Enter username and password of account hasn't been activated.");
		loginPage.login(user.getUsername(), user.getPassword());
		
		System.out.println("Verify that system prevents logging login and message \"Invalid username or password. Please try again.\" appears.");
		String actualMsg = loginPage.getLoginErrorMsg();
		Assert.assertFalse(loginPage.isLoggedIn());
		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
	}
}
