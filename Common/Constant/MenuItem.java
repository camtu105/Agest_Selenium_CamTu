package Constant;

public enum MenuItem {
	HOME("Home"),
	FAQ("FAQ"),
	REGISTER("Register"),
	LOGIN("Login"),
	LOGOUT("Log out"),
	BOOK_TICKET("Book ticket"),
	TIMETABLE("Timetable"),
	TICKET_PRICE("Ticket price"),
	MY_TICKET("My ticket");
	
	private final String displayText;
	
	MenuItem(String displayText) {
		this.displayText = displayText;
	}
	
	public String getText() {
		return displayText;
	}
}
