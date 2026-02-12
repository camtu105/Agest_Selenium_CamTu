package Railway;

import org.openqa.selenium.By;

import Common.Utilities;
import Constant.MenuItem;

public class LoginPage extends GeneralPage {
	// Locators
	private final By _txtUsername = By.xpath("//input[@id='username']");
	private final By _txtPassword = By.xpath("//input[@id='password']");
	private final By _btnLogin = By.xpath("//input[@value='login']");
	private final By _lblWelcomeMsg = By.xpath("//div[@class='account']//strong");
	private final By _lblLoginErrMsg = By.xpath("//p[@class='message error LoginForm']");
	private final By _linkResetPassword = By.xpath("//a[@href='/Account/ForgotPassword.cshtml']");
	//private final By _titlePage = By.xpath("//div[@id='content']//h1");
	
	// Methods
	public HomePage login(String username, String password) {
		Utilities.sendKeys(_txtUsername, username);
		Utilities.sendKeys(_txtPassword, password);
		Utilities.click(_btnLogin);
		return new HomePage();
	}
	
//	public String getPageTitle () {
//		return Utilities.getText(_titlePage);
//	}
//	
//	public static String getTextOfElement (By locator) {
//		return Utilities.getText(locator);
//	}
//	
//	@SuppressWarnings("unchecked")
//	public <T extends GeneralPage> T login(String username, String password) {
//	    Utilities.sendKeys(_txtUsername, username);
//	    Utilities.sendKeys(_txtPassword, password);
//	    Utilities.click(_btnLogin);
//
//	    try {
//	    	 Utilities.waitForTitleExist("Safe Railway");
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	    
//	    String titlePage = this.getPageTitle();
//	    if (titlePage.contains("Welcome to Safe Railway")) {
//	        return (T) new HomePage();
//	    } else {
//	        return (T) this;
//	    }
//	}
	
	public String getWelcomeMessage() {
		return Utilities.getText(_lblWelcomeMsg);
	}
	
	public String getLoginErrorMsg() {
		return Utilities.getText(_lblLoginErrMsg);
	}
	
	public boolean isLoggedIn() {
		return isTabAppeared(MenuItem.LOGOUT.getText());
	}
	
	public void gotoResetPasswordPage() {
		Utilities.click(_linkResetPassword);
	}
}
