package Constant;

public enum SeatTypePrice {
	HS("310000"),
	SS("335000"),
	SSC("360000"),
	HB("410000"),
	SB("460000"),
	SBC("510000");
	
	private final String displayText;
	
	SeatTypePrice(String displayText) {
		this.displayText = displayText;
	}
	
	public String getText() {
		return displayText;
	}
}
