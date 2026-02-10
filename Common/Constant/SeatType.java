package Constant;

public enum SeatType {
	HARD_SEAT("Hard seat"),
	SOFT_SEAT("Soft_seat"),
	SOFT_SEAT_AIR("Soft seat with air conditioner"),
	HARD_BED("Hard bed"),
	SOFT_BED("Soft bed"),
	SOFT_BED_AIR("Soft bed with air conditioner");
	
	private final String displayText;
	
	SeatType(String displayText) {
		this.displayText = displayText;
	}
	
	public String getText() {
		return displayText;
	}
}
