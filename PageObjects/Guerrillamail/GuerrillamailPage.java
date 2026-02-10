package Guerrillamail;

import org.openqa.selenium.By;

import Common.Utilities;
import Constant.Constant;

public class GuerrillamailPage {
	// Variables
	private String _rowTitle = "//tbody[@id='email_list']//tr[contains(., '%s')]";
	
	// Locators
	private final By _spanEmail = By.xpath("//span[@id='inbox-id']");
	private final By _txtEmail = By.xpath("//span[@id='inbox-id']//input");
	private final By _btnSet = By.xpath("//button[@class='save button small']");
	private final By _linkEmail = By.xpath("//div[@class='email_body']//a");
	private final By _alertEmailSet = By.xpath("//div[contains(@id,'status_alert')]");

	
	// Methods
	public GuerrillamailPage open() {
		Constant.WEBDRIVER.navigate().to(Constant.GUERRILLA_URL);;
		return this;
	}
	
	public void setEmail(String email) {
		Utilities.click(_spanEmail);
		Utilities.sendKeys(_txtEmail, email);
		Utilities.click(_btnSet);
		Utilities.waitForElementToBeStable(_alertEmailSet);
	}
	
	public void clickEmailTitle(String email, String title) {
		Constant.WEBDRIVER.navigate().refresh();
		if (!Utilities.getText(_spanEmail).equals(email)) setEmail(email);
		Utilities.click(By.xpath(String.format(_rowTitle, title)));
		Utilities.click(_linkEmail);
	}
}
