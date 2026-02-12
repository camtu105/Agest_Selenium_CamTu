package Constant;

public enum SeatTypeCode {
	HS("HS"),
	SS("SS"),
	SSC("SSC"),
	HB("HB"),
	SB("SB"),
	SBC("SBC");
	
	private final String displayText;
	
	SeatTypeCode(String displayText) {
		this.displayText = displayText;
	}
	
	public String getText() {
		return displayText;
	}
}
