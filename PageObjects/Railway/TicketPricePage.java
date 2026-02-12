package Railway;

import org.openqa.selenium.By;

import Common.Utilities;
import Constant.SeatTypeCode;
import Constant.SeatTypePrice;

public class TicketPricePage extends GeneralPage {
	// Locators
	private final By _tableHeader = By.xpath("//tr[@class='TableSmallHeader']//th");
	private final String _prices = "(//th[contains(text(),'Price')]/following-sibling::td)";
	private final String _pricePosition = "[count(//th[contains(text(),'Seat')]/following-sibling::td[text()='%s']//preceding-sibling::td)+1]";
	
	// Methods
	public String getTableHeader() {
		return Utilities.getText(_tableHeader);
	}
	
	public String getColPrice(String seatType) {
		String pricePosition = String.format(_pricePosition, seatType);
		return Utilities.getText(By.xpath(_prices + pricePosition));
	}
	
	public Boolean isPriceCorrect() {
		Boolean isHSPriceCorrect = getColPrice(SeatTypeCode.HS.getText()).equals(SeatTypePrice.HS.getText());
		Boolean isSSPriceCorrect = getColPrice(SeatTypeCode.SS.getText()).equals(SeatTypePrice.SS.getText());
		Boolean isSSCPriceCorrect = getColPrice(SeatTypeCode.SSC.getText()).equals(SeatTypePrice.SSC.getText());
		Boolean isHBPriceCorrect = getColPrice(SeatTypeCode.HB.getText()).equals(SeatTypePrice.HB.getText());
		Boolean isSBPriceCorrect = getColPrice(SeatTypeCode.SB.getText()).equals(SeatTypePrice.SB.getText());
		Boolean isSBCPriceCorrect = getColPrice(SeatTypeCode.SBC.getText()).equals(SeatTypePrice.SBC.getText());
		return isHSPriceCorrect && isSSPriceCorrect && isSSCPriceCorrect && isHBPriceCorrect && isSBPriceCorrect && isSBCPriceCorrect;
	}
}
