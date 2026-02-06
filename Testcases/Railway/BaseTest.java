package Railway;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Common.Utilities;
import Constant.Constant;
import Guerrillamail.GuerrillamailPage;

public abstract class BaseTest {	
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	RegisterPage registerPage = new RegisterPage();
	GuerrillamailPage guerrillamailPage = new GuerrillamailPage();
	
	protected String newEmail;
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Pre-condition");
		
		Constant.WEBDRIVER = new ChromeDriver();
		
		Constant.WEBDRIVER.manage().window().maximize();
		
		guerrillamailPage.open();
		newEmail = Utilities.randomEmail();
		guerrillamailPage.setEmail(newEmail);
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Post-condition");
		
		Constant.WEBDRIVER.quit();
	}
}
