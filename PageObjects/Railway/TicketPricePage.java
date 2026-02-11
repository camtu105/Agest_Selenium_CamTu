package Railway;

import org.openqa.selenium.By;

import Common.Utilities;
import Constant.SeatType;
import Constant.SeatTypePrice;

public class TicketPricePage {
	// Variables
	private final String _prices = "(//th[contains(text(),'Price')]/following-sibling::td)";
	private final String _pricePosition = "[count(//th[contains(text(),'Seat')]/following-sibling::td[text()='%s']//preceding-sibling::td)+1]";
	
	// Locators
	private final By _tableHeader = By.xpath("//tr[@class='TableSmallHeader']//th");
	
	// Methods
	public String getTableHeader() {
		return Utilities.getText(_tableHeader);
	}
	
	public String getColPrice(String seatType) {
		String pricePosition = String.format(_pricePosition, seatType);
		return Utilities.getText(By.xpath(_prices + pricePosition));
	}
	
	public Boolean isPriceCorrect() {
		Boolean isHSPriceCorrect = getColPrice(SeatType.HS.getText()).equals(SeatTypePrice.HS.getText());
		Boolean isSSPriceCorrect = getColPrice(SeatType.SS.getText()).equals(SeatTypePrice.SS.getText());
		Boolean isSSCPriceCorrect = getColPrice(SeatType.SSC.getText()).equals(SeatTypePrice.SSC.getText());
		Boolean isHBPriceCorrect = getColPrice(SeatType.HB.getText()).equals(SeatTypePrice.HB.getText());
		Boolean isSBPriceCorrect = getColPrice(SeatType.SB.getText()).equals(SeatTypePrice.SB.getText());
		Boolean isSBCPriceCorrect = getColPrice(SeatType.SBC.getText()).equals(SeatTypePrice.SBC.getText());
		return isHSPriceCorrect && isSSPriceCorrect && isSSCPriceCorrect && isHBPriceCorrect && isSBPriceCorrect && isSBCPriceCorrect;
	}
}
