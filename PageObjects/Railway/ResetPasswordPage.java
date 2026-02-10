package Railway;

import org.openqa.selenium.By;

import Common.Utilities;

public class ResetPasswordPage {
	// Variables
	private static String _formPasswordChange = "//legend[text()='Password Change Form']";
	
	// Locator
	private static By _txtEmail = By.xpath("//input[@id='email']");
	private static By _btnSendInstructions = By.xpath("//fieldset//input[@value='Send Instructions']");
	private static By _txtNewPassword = By.xpath("//input[@id='newPassword']");
	private static By _txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
	private static By _btnResetPassword = By.xpath("//input[@value='Reset Password']");
	private static By _lblMsg = By.xpath("//p[contains(@class,'message')]");
	private static By _lblConfirmPasswordErrorMsg = By.xpath("//li[@class='confirm-password']//label[@class='validation-error']");
	
	// Methods
	public void enterEmail(String email) {
		Utilities.sendKeys(_txtEmail, email);
	}
	
	public void requestInstructions() {
		Utilities.click(_btnSendInstructions);
	}
	
	public boolean isPasswordChangeFormShow() {
		return Utilities.isDisplayed(_formPasswordChange);
	}
	
	public void resetPassword(String newPassword, String confirmPassword) {
		Utilities.sendKeys(_txtNewPassword, newPassword);
		Utilities.sendKeys(_txtConfirmPassword, confirmPassword);
		Utilities.click(_btnResetPassword);
	}
	
	public String getLblMsg() {
		return Utilities.getText(_lblMsg);
	}
	
	public String getLblConfirmPasswordErrorMsg() {
		return Utilities.getText(_lblConfirmPasswordErrorMsg);
	}
}
