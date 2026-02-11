package Railway;

import org.openqa.selenium.By;

import Common.Utilities;

public class GeneralPage {
	// Variables
	private final String _tabLink = "//div[@id='menu']//a[span[text()='%s']]";
	
	// Locators
	private final By _tabSelected = By.xpath("//li[@class=\"selected\"]");

	// Methods
	public By getTabLocator(String tabName) {
		String xpathString = String.format(_tabLink, tabName);
		return By.xpath(xpathString);
	}
	
	public void gotoTab(String tabName) {
		Utilities.click(getTabLocator(tabName));
	}
	
	protected boolean isTabSelected(String tabName) {
		return Utilities.getText(_tabSelected).equals(tabName);
	}

	protected boolean isTabAppeared(String tabName) {
		String xpathString = String.format("//a[span[text()='%s']]", tabName);
		return Utilities.isDisplayed(xpathString);
	}
}
