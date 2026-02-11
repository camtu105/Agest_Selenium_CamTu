package Constant;

public enum TimeTableAction {
	CHECK_PRICE("check price"),
	BOOK_TICKET("book ticket");
	
	private final String displayText;
	
	TimeTableAction(String displayText) {
		this.displayText = displayText;
	}
	
	public String getText() {
		return displayText;
	}
}
