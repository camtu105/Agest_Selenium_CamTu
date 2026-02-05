package Railway;

import org.openqa.selenium.By;

import Common.Utilities;

public class GeneralPage {
	// Locators
	private final By _selectedTab = By.xpath("//li[@class=\"selected\"]");

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
