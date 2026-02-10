package Railway;

public class Ticket {
	private String departDate;
	private String departFrom;
	private String arriveAt;
	private String seatType;
	private String ticketAmount;
	
	public Ticket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
		this.departDate = departDate;
		this.departFrom = departFrom;
		this.arriveAt = arriveAt;
		this.seatType = seatType;
		this.ticketAmount = ticketAmount;
	}
	
	public String getDepartDate() {
		return this.departDate;
	}
	
	public String getDepartFrom() {
		return this.departFrom;
	}
	
	public String getArriveAt() {
		return this.arriveAt;
	}
	
	public String getSeatType() {
		return this.seatType;
	}
	
	public String getTicketAmount() {
		return this.ticketAmount;
	}
	
	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}
	
	public void setDepartFrom(String departFrom) {
		this.departFrom = departFrom;
	}
	
	public void setArriveAt(String arriveAt) {
		this.arriveAt = arriveAt;
	}
	
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
	
	public void setTicketAmount(String ticketAmount) {
		this.ticketAmount = ticketAmount;
	}
}
