package Railway;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Utilities;
import Constant.BookTicketDropDown;
import Constant.Constant;
import Constant.MenuItem;

public class CancelBookingTest extends BaseTest {
	@Test
	public void TC16() {
		System.out.println("User can check price of ticket from Timetable");
		Account user = new Account(newEmail + Constant.EMAIL_DOMAIN, Constant.VALID_PASSWORD, Constant.VALID_PID);

		System.out.println("Pre-condition: an actived account is existing");
		registerAccount(user);
		activateAccount();
		
		System.out.println("1. Navigate to QA Railway Website");
		Utilities.switchToLastTab();
		
		System.out.println("2. Login with a valid account ");
		homePage.gotoTab(MenuItem.LOGIN.getText());
		loginPage.login(user.getUsername(), user.getPassword());
		
		System.out.println("Before booking ticket - Create ticket object");
		homePage.gotoTab(MenuItem.BOOK_TICKET.getText());
		Ticket ticket = new Ticket(bookTicketPage.getSelectedValue(BookTicketDropDown.DEPART_DATE.getText()),
							bookTicketPage.getSelectedValue(BookTicketDropDown.DEPART_FROM.getText()),
							bookTicketPage.getSelectedValue(BookTicketDropDown.ARRIVE_AT.getText()),
							bookTicketPage.getSelectedValue(BookTicketDropDown.SEAT_TYPE.getText()),
							bookTicketPage.getSelectedValue(BookTicketDropDown.TICKET_AMOUNT.getText()));
		
		System.out.println("3. Book a ticket");
		bookTicketPage.bookTicket(ticket);
		
		System.out.println("4. Click on \"My ticket\" tab");
		homePage.gotoTab(MenuItem.MY_TICKET.getText());
		
		System.out.println("5. Click on \"Cancel\" button of ticket which user want to cancel.");
		System.out.println("6. Click on \"OK\" button on Confirmation message \"Are you sure?\"");
		myTicketPage.cancelTicket(ticket, LocalDate.now().format(DateTimeFormatter.ofPattern("M/d/yyyy")));
		
		System.out.println("Verify that The canceled ticket is disappeared.");
		Assert.assertFalse(Utilities.isDisplayed(myTicketPage.getTicketRowXpath(ticket, LocalDate.now().format(DateTimeFormatter.ofPattern(Constant.DATE_TICKET_FORMAT)))));
	}
}
