package Railway;

import org.openqa.selenium.By;

import Common.Utilities;

public class TimeTablePage {
	// Variables
	private final String _linkValue = "//td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td//a[text()='%s']";
	
	// Methods
	public void clickRowValue(Ticket ticket, String value) {
		Utilities.click(By.xpath(String.format(_linkValue, ticket.getDepartFrom(), ticket.getArriveAt(), value)));
	}
}
