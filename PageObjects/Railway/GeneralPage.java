package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;
import Constant.Constant;

public class GeneralPage {
	// Locators
	private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
	private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
	private final By tabFAQ = By.xpath("//div[@id='menu']//a[@href='/Page/FAQ.cshtml']");
	private final By lblWelcomeMessage = By.xpath("//div[@class='account']//strong");
//	private final By lblWelcomeMsg = By.xpath("//div[@id='content']//h1");
	private final By selectedTab = By.xpath("//li[@class=\"selected\"]");
	
	// Elements
	protected WebElement getTabLogin() {
		return Utilities.waitForElementToBeClickable(tabLogin);
	}
	
	protected WebElement getTabLogout() {
		return Utilities.waitForElementToBeClickable(tabLogout);
	}
	
	protected WebElement getTabFAQ() {
		return Utilities.waitForElementToBeClickable(tabFAQ);
	}
	
	protected WebElement getLblWelcomeMessage() {
		return Utilities.waitForElementToBeVisible(lblWelcomeMessage);
	}
	
	protected boolean isTabSelected(String tabName) {
		return Constant.WEBDRIVER.findElement(selectedTab).getText().equals(tabName);
	}
	
	protected boolean isTabAppeared(String tabName) {
		String xpathString = String.format("//a[span[text()='%s']]", tabName);
		return Constant.WEBDRIVER.findElements(By.xpath(xpathString)).size() > 0;
	}
	
//	protected WebElement getLblWelcomeMsg() {
//		return Constant.WEBDRIVER.findElement(lblWelcomeMsg);
//	}
	
	// Methods
	public String getWelcomeMessage() {
		return this.getLblWelcomeMessage().getText();
	}
	
	public LoginPage gotoLoginPage() {
		this.getTabLogin().click();
		return new LoginPage();
	}
	
//	public String getWelcomeMsg() {
//		return this.getLblWelcomeMsg().getText();
//	}
}
