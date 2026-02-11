package Railway;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Utilities;
import Constant.BookTicketDropDown;
import Constant.Constant;
import Constant.Destination;
import Constant.MenuItem;
import Constant.SeatType;
import Constant.TimeTableAction;

public class BookTicketTest extends BaseTest {
	@Test
	public void TC12() {
		System.out.println("User can book 1 ticket at a time");
		Account user = new Account(newEmail + Constant.EMAIL_DOMAIN, Constant.VALID_PASSWORD, Constant.VALID_PID);
		String expectedMsg = "Ticket booked successfully!";
		
		System.out.println("Pre-condition: an actived account is existing");
		registerAccount(user);
		activateAccount();
		
		System.out.println("1. Navigate to QA Railway Website");
		Utilities.switchToLastTab();
		
		System.out.println("2. Login with a valid account ");
		homePage.gotoTab(MenuItem.LOGIN.getText());
		loginPage.login(user.getUsername(), user.getPassword());
		
		System.out.println("3. Click on \"Book ticket\" tab");
		homePage.gotoTab(MenuItem.BOOK_TICKET.getText());
		
		System.out.println("4. Select the next 2 days from \"Depart date\"");
		System.out.println("5. Select Depart from \"Nha Trang\" and Arrive at \"Huế\"");
		System.out.println("6. Select \"Soft bed with air conditioner\" for \"Seat type\"");
		System.out.println("7. Select \"1\" for \"Ticket amount\"");
		System.out.println("Before booking ticket - Create ticket object with required information");
		Ticket ticket = new Ticket(Utilities.returnDateAfter(bookTicketPage.getSelectedValue(BookTicketDropDown.DEPART_DATE.getText()), 2),
							Destination.NHA_TRANG.getText(),
							Destination.HUE.getText(),
							SeatType.SOFT_BED_AIR.getText(),
							"1");
		
		System.out.println("8. Click on \"Book ticket\" button");
		bookTicketPage.bookTicket(ticket);
		
		System.out.println("Verify that Message \"Ticket booked successfully!\" displays. Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)");
		String actualMsg = bookTicketPage.getLblSuccessMsg();
		Assert.assertEquals(actualMsg, expectedMsg, "Successfull message is not displayed as expected");
		Assert.assertTrue(bookTicketPage.isInformationCorrect(ticket));
	}
	
	@Test
	public void TC13() {
		System.out.println("User can book many tickets at a time");
		Account user = new Account(newEmail + Constant.EMAIL_DOMAIN, Constant.VALID_PASSWORD, Constant.VALID_PID);
		String expectedMsg = "Ticket booked successfully!";
		
		System.out.println("Pre-condition: an actived account is existing");
		registerAccount(user);
		activateAccount();
		
		System.out.println("1. Navigate to QA Railway Website");
		Utilities.switchToLastTab();
		
		System.out.println("2. Login with a valid account ");
		homePage.gotoTab(MenuItem.LOGIN.getText());
		loginPage.login(user.getUsername(), user.getPassword());
		
		System.out.println("3. Click on \"Book ticket\" tab");
		homePage.gotoTab(MenuItem.BOOK_TICKET.getText());
		
		System.out.println("4. Select the next 2 days from \"Depart date\"");
		System.out.println("5. Select Depart from \"Nha Trang\" and Arrive at \"Huế\"");
		System.out.println("6. Select \"Soft bed with air conditioner\" for \"Seat type\"");
		System.out.println("7. Select \"1\" for \"Ticket amount\"");
		System.out.println("Before booking ticket - Create ticket object with required information");
		Ticket ticket = new Ticket(Utilities.returnDateAfter(bookTicketPage.getSelectedValue(BookTicketDropDown.DEPART_DATE.getText()), 25),
							Destination.NHA_TRANG.getText(),
							Destination.SAI_GON.getText(),
							SeatType.SOFT_SEAT_AIR.getText(),
							"5");
		
		System.out.println("8. Click on \"Book ticket\" button");
		bookTicketPage.bookTicket(ticket);
		
		System.out.println("Verify that Message \"Ticket booked successfully!\" displays. Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)");
		String actualMsg = bookTicketPage.getLblSuccessMsg();
		Assert.assertEquals(actualMsg, expectedMsg, "Successfull message is not displayed as expected");
		Assert.assertTrue(bookTicketPage.isInformationCorrect(ticket));
	}
	
	@Test
	public void TC14() {
		System.out.println("User can check price of ticket from Timetable");
		Account user = new Account(newEmail + Constant.EMAIL_DOMAIN, Constant.VALID_PASSWORD, Constant.VALID_PID);
		String expectedHeader = "Ticket price from Đà Nẵng to Sài Gòn";
		
		System.out.println("Pre-condition: an actived account is existing");
		registerAccount(user);
		activateAccount();
		
		System.out.println("1. Navigate to QA Railway Website");
		Utilities.switchToLastTab();
		
		System.out.println("2. Login with a valid account ");
		homePage.gotoTab(MenuItem.LOGIN.getText());
		loginPage.login(user.getUsername(), user.getPassword());
		
		System.out.println("3. Click on \"Timetable\" tab");
		homePage.gotoTab(MenuItem.TIMETABLE.getText());
		
		System.out.println("4. Click on \"check price\" link of the route from \"Đà Nẵng\" to \"Sài Gòn\"");
		System.out.println("Before booking ticket - Create ticket object with required information");
		Ticket ticket = new Ticket(Destination.DA_NANG.getText(),
							Destination.SAI_GON.getText());
		timeTablePage.clickRowValue(ticket, TimeTableAction.CHECK_PRICE.getText());
		
		System.out.println("Verify that \"Ticket Price\" page is loaded.");
		Assert.assertTrue(homePage.isTabSelected(MenuItem.TICKET_PRICE.getText()));
		
		System.out.println("Verify that Ticket table shows \"Ticket price from Đà Nẵng to Sài Gòn\"");
		String actualHeader = ticketPricePage.getTableHeader();
		Assert.assertEquals(actualHeader, expectedHeader, "Table header is not displayed as expected");
		
		System.out.println("Price for each seat displays correctly\r\n"
				+ "HS = 310000, SS = 335000, SSC = 360000, HB = 410000, SB = 460000, SBC = 510000");
		Assert.assertTrue(ticketPricePage.isPriceCorrect());
	}
	
	@Test
	public void TC15() {
		System.out.println("User can book ticket from Timetable");
		Account user = new Account(newEmail + Constant.EMAIL_DOMAIN, Constant.VALID_PASSWORD, Constant.VALID_PID);
		String expectedMsg = "Ticket booked successfully!";
		
		System.out.println("Pre-condition: an actived account is existing");
		registerAccount(user);
		activateAccount();
		
		System.out.println("1. Navigate to QA Railway Website");
		Utilities.switchToLastTab();
		
		System.out.println("2. Login with a valid account ");
		homePage.gotoTab(MenuItem.LOGIN.getText());
		loginPage.login(user.getUsername(), user.getPassword());
		
		System.out.println("3. Click on \"Timetable\" tab");
		homePage.gotoTab(MenuItem.TIMETABLE.getText());
		
		System.out.println("4. Click on book ticket of route \"Quảng Ngãi\" to \"Huế\"");
		System.out.println("Before click on book ticket - Create ticket object with required information");
		Ticket ticket = new Ticket(Destination.QUANG_NGAI.getText(),
							Destination.HUE.getText());
		timeTablePage.clickRowValue(ticket, TimeTableAction.BOOK_TICKET.getText());
		
		System.out.println("Verify that Book ticket form is shown with the corrected \"depart from\" and \"Arrive at\"");
		Assert.assertEquals(bookTicketPage.getSelectedValue(BookTicketDropDown.DEPART_FROM.getText()), ticket.getDepartFrom());
		Assert.assertEquals(bookTicketPage.getSelectedValue(BookTicketDropDown.ARRIVE_AT.getText()), ticket.getArriveAt());
		
		System.out.println("5. Select Depart date = tomorrow");
		System.out.println("6. Select Ticket amount = 5");
		System.out.println("7. Click on \"Book ticket\" button");
		System.out.println("Before booking ticket - Update ticket object with required information and update seat type information");
		ticket.setDepartDate(Utilities.returnDateAfter(LocalDate.now().format(DateTimeFormatter.ofPattern(Constant.DATE_TICKET_FORMAT)), 1));
		ticket.setSeatType(bookTicketPage.getSelectedValue(BookTicketDropDown.SEAT_TYPE.getText()));
		ticket.setTicketAmount("5");
		bookTicketPage.bookTicketFromTimetable(ticket);
		
		System.out.println("Verify that Message \"Ticket booked successfully!\" displays. Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)");
		String actualMsg = bookTicketPage.getLblSuccessMsg();
		Assert.assertEquals(actualMsg, expectedMsg, "Successfull message is not displayed as expected");
		Assert.assertTrue(bookTicketPage.isInformationCorrect(ticket));
	}
}
