package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;

public class LoginPage extends GeneralPage {
	// Locators
	private final By _txtUsername = By.xpath("//input[@id='username']");
	private final By _txtPassword = By.xpath("//input[@id='password']");
	private final By _btnLogin = By.xpath("//input[@value='login']");
	private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
	
	// Elements
	public WebElement getTxtUsername() {
		return Utilities.waitForElementToBeVisible(_txtUsername);
	}
	
	public WebElement getTxtPassword() {
		return Utilities.waitForElementToBeVisible(_txtPassword);
	}
	
	public WebElement getBtnLogin() {
		return Utilities.waitForElementToBeClickable(_btnLogin);
	}
	
	public WebElement getLblLoginErrorMsg() {
		return Utilities.waitForElementToBeVisible(_lblLoginErrorMsg);
	}
	
	// Methods
	public HomePage login(String username, String password) {
		this.getTxtUsername().sendKeys(username);
		this.getTxtPassword().sendKeys(password);
		this.getBtnLogin().click();
		
		return new HomePage();
	}
	
	public String getLoginErrorMsg() {
		return this.getLblLoginErrorMsg().getText();
	}
}
