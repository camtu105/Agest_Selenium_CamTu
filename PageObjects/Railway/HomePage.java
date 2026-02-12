package Railway;

import org.openqa.selenium.By;

import Common.Utilities;
import Constant.Constant;

public class HomePage extends GeneralPage {
	// Locators
	private final String _linkCreateAccount = "//a[@href='/Account/Register.cshtml\']";
	
	// Methods
	public HomePage open() {
		Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);;
		return this;
	}
	
	public Boolean isLinkCreateAccountDisplayed() {
		return Utilities.isDisplayed(_linkCreateAccount);
	}
	
	public void clickCreateAccountLink() {
		Utilities.click(By.xpath(_linkCreateAccount));
	}
}
