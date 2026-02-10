package Railway;

import org.openqa.selenium.By;

import Common.Utilities;
import Constant.BookTicketSelect;

public class BookTicketPage {
	// Variables
	private String _selectBookTicketForm = "//form//select[@name='%s']";
	
	// Locators
	private final By _btnBookTicket = By.xpath("//input[@value='Book ticket']");
	private final By _lblSuccessMsg = By.xpath("//div[@id='content']//h1");
	
	// Methods
	public String getVisibleDate() {
		return Utilities.getTextSelected(By.xpath(String.format(_selectBookTicketForm, BookTicketSelect.DEPART_DATE.getText())));
	}
	
	public void selectValue(String name, String value) {
		Utilities.select(By.xpath(String.format(_selectBookTicketForm, name)), value);
	}
	
	public void bookTicket(Ticket ticket) {
		selectValue(BookTicketSelect.DEPART_DATE.getText(), ticket.getDepartDate());
		selectValue(BookTicketSelect.DEPART_FROM.getText(), ticket.getDepartFrom());
		selectValue(BookTicketSelect.ARRIVE_AT.getText(), ticket.getArriveAt());
		selectValue(BookTicketSelect.SEAT_TYPE.getText(), ticket.getSeatType());
		selectValue(BookTicketSelect.TICKET_AMOUNT.getText(), ticket.getTicketAmount());
		Utilities.click(_btnBookTicket);
	}
	
	public String getLblSuccessMsg() {
		return Utilities.getText(_lblSuccessMsg);
	}
}
