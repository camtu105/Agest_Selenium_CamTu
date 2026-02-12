package Railway;

import org.openqa.selenium.By;

import Common.Utilities;
import Constant.Constant;

public class MyTicketPage extends GeneralPage {
	// Locators
	private final String _valueDepartStation = "//td[text()='%s']";
	private final String _valuePrevious = "//following-sibling::td[text()='%s']";
	private final String _btnCancel = "//following-sibling::td//input[@value='Cancel']";
	
	// Methods
	public String getTicketRowXpath(Ticket ticket, String bookDate) {
		String valueDepartStation = String.format(_valueDepartStation, ticket.getDepartFrom());
		String valueArriveStation = String.format(_valuePrevious, ticket.getArriveAt());
		String valueSeatType = String.format(_valuePrevious, ticket.getSeatType());
		String valueDepartDate = String.format(_valuePrevious, ticket.getDepartDate());
		String valueBookDate = String.format(_valuePrevious, bookDate);
		String valueTicketAmount = String.format(_valuePrevious, ticket.getTicketAmount());
		return valueDepartStation + valueArriveStation + valueSeatType 
				+ valueDepartDate + valueBookDate + valueTicketAmount + _btnCancel;
	}
	
	public void cancelTicket(Ticket ticket, String bookDate) {
		Utilities.click(By.xpath(getTicketRowXpath(ticket, bookDate)));
		Constant.WEBDRIVER.switchTo().alert().accept();
	}
}
