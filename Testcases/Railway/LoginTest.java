package Railway;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;

import Constant.Constant;

public class LoginTest extends BaseTest {
	@Test
	public void TC01() {
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
		String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
		String expectedMsg = "Welcome " + Constant.USERNAME;
		
//		String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMsg();
//		String expectedMsg = "Welcome to Safe Railway";
		
		System.out.println("Verify that user is logged into Railway and welcome user message is displayed.");
		Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");;
	}
	
	@Test
	public void TC02() {
		System.out.println("TC02 - User cannot login with blank \"Username\" textbox");

		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Click on \"Login\" tab");
		LoginPage loginPage = homePage.gotoLoginPage();
		
		System.out.println("3. User doesn't type any words into \"Username\" textbox but enter valid information into \"Password\" textbox");	
		System.out.println("4. Click on \"Login\" button");
		loginPage.login("", Constant.PASSWORD);
		String actualMsg = loginPage.getLoginErrorMsg();
		String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
		
		System.out.println("Verify that system prevent logging in and message \"There was a problem with your login and/or errors exist in your form.\" appears.");
		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");;
	}
	
	@Test
	public void TC03() {
		System.out.println("TC03 - User cannot log into Railway with invalid password ");

		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Click on \"Login\" tab");
		LoginPage loginPage = homePage.gotoLoginPage();
		
		System.out.println("3. Enter valid Email and invalid Password");
		System.out.println("4. Click on \"Login\" button");
		loginPage.login(Constant.USERNAME, "123");
		String actualMsg = loginPage.getLoginErrorMsg();
		String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
		
		System.out.println("Verify that error message \"There was a problem with your login and/or errors exist in your form.\" is displayed.");
		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
	}
}
