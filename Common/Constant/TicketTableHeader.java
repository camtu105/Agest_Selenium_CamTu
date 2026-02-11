package Constant;

public enum TicketTableHeader {
	DEPART_DATE("Depart Date"),
	DEPART_FROM("Depart Station"),
	ARRIVE_AT("Arrive Station"),
	SEAT_TYPE("Seat Type"),
	TICKET_AMOUNT("Amount");
	
	private final String displayText;
	
	private TicketTableHeader (String displayText) {
		this.displayText = displayText;
	}
	
	public String getText() {
		return displayText;
	}
}
