package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Utilities;
import Constant.Constant;
import Constant.Destination;
import Constant.MenuItem;
import Constant.SeatType;

public class TestFunction extends BaseTest {
	
	/* PHẦN NÀY EM ĐỂ TEST CASE CHƯA HOÀN THÀNH ĐỂ LÀM TỪNG CÁI CHO DỄ NHÌN NHA MÍ ANH ^^
	 * PHẦN LOGIN ĐỂ MAIL CỨNG TẠI WEB HAY GIỚI HẠN GỬI MAIL NÊN TẠM THỜI EM ĐỂ ĐỂ DỄ TEST NHA :3
	 *  */
	
	@Test
	public void TC12() {
		System.out.println("User can book 1 ticket at a time");
		String expectedMsg = "Ticket booked successfully!";
		
//		System.out.println("Register and activate new account");
//		registerAccount();
//		activateAccount();
//		
//		System.out.println("1. Navigate to QA Railway Website");
//		Utilities.switchToLastTab();
		Utilities.switchToNewTab(Constant.RAILWAY_URL);
		
		System.out.println("2. Login with a valid account ");
		homePage.gotoTab(MenuItem.LOGIN.getText());
		loginPage.login("gxgwnkpe@sharklasers.com", user.getPassword());
		
		System.out.println("3. Click on \"Book ticket\" tab");
		homePage.gotoTab(MenuItem.BOOK_TICKET.getText());
		
		System.out.println("4. Select the next 2 days from \"Depart date\"");
		System.out.println("5. Select Depart from \"Nha Trang\" and Arrive at \"Huế\"");
		System.out.println("6. Select \"Soft bed with air conditioner\" for \"Seat type\"");
		System.out.println("7. Select \"1\" for \"Ticket amount\"");
		System.out.println("8. Click on \"Book ticket\" button");
		System.out.println("Before booking ticket - Create ticket object with required information");
		Ticket ticket = new Ticket(Utilities.returnDateAfter(bookTicketPage.getVisibleDate(), 2),
				Destination.NHA_TRANG.getText(),
				Destination.HUE.getText(),
				SeatType.SOFT_BED_AIR.getText(),
				"1");
		bookTicketPage.bookTicket(ticket);
		
		System.out.println("Verify that Message \"Ticket booked successfully!\" displays. Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)");
		String actualMsg = bookTicketPage.getLblSuccessMsg();
		Assert.assertEquals(actualMsg, expectedMsg, "Successfull message is not displayed as expected");
	}
}
