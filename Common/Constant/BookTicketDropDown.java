package Constant;

public enum BookTicketDropDown {
	DEPART_DATE("Date"),
	DEPART_FROM("DepartStation"),
	ARRIVE_AT("ArriveStation"),
	SEAT_TYPE("SeatType"),
	TICKET_AMOUNT("TicketAmount");
	
	private final String displayText;
	
	private BookTicketDropDown (String displayText) {
		this.displayText = displayText;
	}
	
	public String getText() {
		return displayText;
	}
}
