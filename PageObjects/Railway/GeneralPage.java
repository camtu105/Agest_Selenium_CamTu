package Railway;

import org.openqa.selenium.By;

import Common.Utilities;

public class GeneralPage {
	// Locators
	private final By _tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
	private final By _tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
	private final By _tabFaq = By.xpath("//div[@id='menu']//a[@href='/Page/FAQ.cshtml']");
	private final By _selectedTab = By.xpath("//li[@class=\"selected\"]");
	
	protected By getTabLoginLocator() {
		return _tabLogin;
	}
	
	protected By getTabLogoutLocator() {
		return _tabLogout;
	}
	
	protected By getTabFaqLocator() {
		return _tabFaq;
	}

	// Methods
	public void gotoTab(String tabName) {
		Utilities.click(Utilities.getTabLocator(tabName));
	}
	
	protected boolean isTabSelected(String tabName) {
		return Utilities.getText(_selectedTab).equals(tabName);
	}

	protected boolean isTabAppeared(String tabName) {
		String xpathString = String.format("//a[span[text()='%s']]", tabName);
		return Utilities.isDisplayed(xpathString);
	}
}
