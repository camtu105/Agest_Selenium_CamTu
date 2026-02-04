package Railway;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;

import Constant.Constant;

public class LoginTest extends BaseTest {
	@Test
	public void TC01() {
		User user = new User("gxgwnkpe@sharklasers.com","12345678");
		
		Dimension dimension = new Dimension(1200, 800);
		Constant.WEBDRIVER.manage().window().setSize(dimension);
		
		System.out.println("TC01 - User can log into Railway with valid username and password");
		
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Click on \"Login\" tab");
		LoginPage loginPage = homePage.gotoLoginPage();
		
		System.out.println("3. Enter valid Email and Password");
		System.out.println("4. Click on \"Login\" button");
		String actualMsg = loginPage.login(user.getUsername(), user.getPassword()).getWelcomeMessage();
		String expectedMsg = "Welcome " + user.getUsername();
		
//		String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMsg();
//		String expectedMsg = "Welcome to Safe Railway";
		
		System.out.println("Verify that user is logged into Railway and welcome user message is displayed.");
		Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");;
	}
	
	@Test
	public void TC02() {
		User userBlankUsername = new User("","12345678");
		
		System.out.println("TC02 - User cannot login with blank \"Username\" textbox");

		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Click on \"Login\" tab");
		LoginPage loginPage = homePage.gotoLoginPage();
		
		System.out.println("3. User doesn't type any words into \"Username\" textbox but enter valid information into \"Password\" textbox");	
		System.out.println("4. Click on \"Login\" button");
		loginPage.login(userBlankUsername.getUsername(), userBlankUsername.getPassword());
		String actualMsg = loginPage.getLoginErrorMsg();
		String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
		
		System.out.println("Verify that system prevents logging in and message \"There was a problem with your login and/or errors exist in your form.\" appears.");
		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");;
	}
	
	@Test
	public void TC03() {
		User userInvalidPassword = new User("gxgwnkpe@sharklasers.com","123");
		
		System.out.println("TC03 - User cannot log into Railway with invalid password");

		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Click on \"Login\" tab");
		LoginPage loginPage = homePage.gotoLoginPage();
		
		System.out.println("3. Enter valid Email and invalid Password");
		System.out.println("4. Click on \"Login\" button");
		loginPage.login(userInvalidPassword.getUsername(), userInvalidPassword.getPassword());
		String actualMsg = loginPage.getLoginErrorMsg();
		String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
		
		System.out.println("Verify that error message \"There was a problem with your login and/or errors exist in your form.\" is displayed.");
		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
	}
	
	@Test
	public void TC04() {
		User userInvalidPassword = new User("gxgwnkpe@sharklasers.com","123");
		
		System.out.println("TC04 - System shows message when user enters wrong password many times");

		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Click on \"Login\" tab");
		LoginPage loginPage = homePage.gotoLoginPage();
		
		System.out.println("3. Enter valid information into \"Username\" textbox except \"Password\" textbox");
		System.out.println("4. Click on \"Login\" button");
		System.out.println("5. Repeat step 3 and 4 three more times");
		for (int i = 0; i < 4; i++) {
			loginPage.getTxtUsername().clear();
			loginPage.login(userInvalidPassword.getUsername(), userInvalidPassword.getPassword());
		}
		String actualMsg = loginPage.getLoginErrorMsg();
		String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
	
		System.out.println("Verify that system prevents logging login and message \"You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.\" appears.");
		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
	}
	
	@Test
	public void TC05() {
		User userInactivatedUsername = new User("inactive@sharklasers.com","12345678");
		
		System.out.println("TC05 - User can't login with an account hasn't been activated");
		
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Click on \"Login\" tab");
		LoginPage loginPage = homePage.gotoLoginPage();
		
		System.out.println("3. Enter username and password of account hasn't been activated.");
		loginPage.login(userInactivatedUsername.getUsername(), userInactivatedUsername.getPassword());
		
		String actualMsg = loginPage.getLoginErrorMsg();
		String expectedMsg = "Invalid username or password. Please try again.";
		
		System.out.println("Verify that system prevents logging login and message \"Invalid username or password. Please try again.\" appears.");
		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
	}
}
