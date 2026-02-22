package Railway;

import org.openqa.selenium.By;

import Common.Utilities;

public class GeneralPage {
	// Locators
	private final By _tabSelected = By.xpath("//li[@class=\"selected\"]");
	private final String _tabLink = "//div[@id='menu']//a[span[text()='%s']]";

	// Methods	
	public void gotoTab(String tabName) {
		String xpathTab = String.format(_tabLink, tabName);
		Utilities.click(By.xpath(xpathTab));
	}
	
	protected boolean isTabSelected(String tabName) {
		return Utilities.getText(_tabSelected).equals(tabName);
	}

	protected boolean isTabAppeared(String tabName) {
		String xpathTab = String.format(_tabLink, tabName);
		return Utilities.isDisplayed(By.xpath(xpathTab));
	}
}
