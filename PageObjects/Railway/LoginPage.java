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
	
	// Methods
	public HomePage login(String username, String password) {
		Utilities.sendKeys(_txtUsername, username);
		Utilities.sendKeys(_txtPassword, password);
		Utilities.click(_btnLogin);
		return new HomePage();
	}
	
	public String getWelcomeMessage() {
		return Utilities.getText(_lblWelcomeMsg);
	}
	
	public String getLoginErrorMsg() {
		return Utilities.getText(_lblLoginErrMsg);
	}
	
	public boolean isLoggedIn() {
		return isTabAppeared(MenuItem.LOGOUT.getText());
	}
}
