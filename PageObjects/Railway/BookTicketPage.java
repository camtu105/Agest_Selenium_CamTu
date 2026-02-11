package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;
import Constant.BookTicketDropDown;
import Constant.TicketTableHeader;

public class BookTicketPage {
	// Variables
	private final String _dropdownBookTicketForm = "//form//select[@name='%s']";
	private final String _ticketValues = "(//tr[@class='OddRow']//td)";
	private final String _valuePosition = "[count(//tr//th[text()='%s']//preceding-sibling::th) + 1]";
	
	// Locators
	private final By _btnBookTicket = By.xpath("//input[@value='Book ticket']");
	private final By _lblSuccessMsg = By.xpath("//div[@id='content']//h1");
	
	// Methods
	public String getSelectedValue(String dropdownName) {
		return Utilities.getTextSelected(By.xpath(String.format(_dropdownBookTicketForm, dropdownName)));
	}
	
	public void selectValue(String name, String value) {
		Utilities.select(By.xpath(String.format(_dropdownBookTicketForm, name)), value);
	}
	
	public void bookTicket(Ticket ticket) {
		WebElement arriveAt = Utilities.findElement(By.xpath(String.format(_dropdownBookTicketForm, BookTicketDropDown.ARRIVE_AT.getText())));
		selectValue(BookTicketDropDown.DEPART_DATE.getText(), ticket.getDepartDate());
		selectValue(BookTicketDropDown.DEPART_FROM.getText(), ticket.getDepartFrom());
		try {
			Utilities.waitForNewState(arriveAt);
		} catch (Exception e) {
			// TODO: handle exception
		}
		selectValue(BookTicketDropDown.ARRIVE_AT.getText(), ticket.getArriveAt());
		selectValue(BookTicketDropDown.SEAT_TYPE.getText(), ticket.getSeatType());
		selectValue(BookTicketDropDown.TICKET_AMOUNT.getText(), ticket.getTicketAmount());
		Utilities.click(_btnBookTicket);
	}
	
	public String getLblSuccessMsg() {
		return Utilities.getText(_lblSuccessMsg);
	}
	
	public String getColValue(String colName) {
		String valuePosition = String.format(_valuePosition, colName);
		return Utilities.getText(By.xpath(_ticketValues + valuePosition));
	}
	
	public boolean isInformationCorrect(Ticket ticket) {
		Boolean isDateCorrect = getColValue(TicketTableHeader.DEPART_DATE.getText()).equals(ticket.getDepartDate());
		Boolean isDepartFromCorrect = getColValue(TicketTableHeader.DEPART_FROM.getText()).equals(ticket.getDepartFrom());
		Boolean isArriveAtCorrect = getColValue(TicketTableHeader.ARRIVE_AT.getText()).equals(ticket.getArriveAt());
		Boolean isSeatTypeCorrect = getColValue(TicketTableHeader.SEAT_TYPE.getText()).equals(ticket.getSeatType());
		Boolean isAmountCorrect = getColValue(TicketTableHeader.TICKET_AMOUNT.getText()).equals(ticket.getTicketAmount());
		return isDateCorrect && isDepartFromCorrect && isArriveAtCorrect && isSeatTypeCorrect && isAmountCorrect;
	}
	
	public void bookTicketFromTimetable(Ticket ticket) {
		selectValue(BookTicketDropDown.SEAT_TYPE.getText(), ticket.getSeatType());
		selectValue(BookTicketDropDown.TICKET_AMOUNT.getText(), ticket.getTicketAmount());
		Utilities.click(_btnBookTicket);
	}
}
