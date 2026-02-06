package Railway;

import org.openqa.selenium.By;

import Common.Utilities;

public class RegisterPage {
	// Locators
	private final By _txtEmail = By.xpath("//input[@id='email']");
	private final By _txtPassword = By.xpath("//input[@id='password']");
	private final By _txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
	private final By _txtPid = By.xpath("//input[@id='pid']");
	private final By _btnRegister = By.xpath("//input[@value='Register']");
	private final By _lblRegErrMeg = By.xpath("//div[@id='content']//p[@class='message error']");
	private final By _lblPwValErrMeg = By.xpath("//li[@class='password']//label[@class='validation-error']");
	private final By _lblPidValErrMeg = By.xpath("//li[@class='pid-number']//label[@class='validation-error']");
	private final By _lblRegConfirmed = By.xpath("//div[@id='content']//p");
	
	// Methods
	public HomePage register(String email, String password, String pid) {
		Utilities.sendKeys(_txtEmail, email);
		Utilities.sendKeys(_txtPassword, password);
		Utilities.sendKeys(_txtConfirmPassword, password);
		Utilities.sendKeys(_txtPid, pid);
		Utilities.click(_btnRegister);
		
		return new HomePage();
	}
	
	public String getLblRegErrMeg() {
		return Utilities.getText(_lblRegErrMeg);
	}
	
	public String getLblPwValErrMsg() {
		return Utilities.getText(_lblPwValErrMeg);
	}
	
	public String getLblPidErrMsg() {
		return Utilities.getText(_lblPidValErrMeg);
	}
	
	public String getLblRegConfirmed() {
		return Utilities.getText(_lblRegConfirmed);
	}
}
