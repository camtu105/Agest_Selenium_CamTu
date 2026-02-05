package Constant;

public enum MenuItem {
	
	HOME("Home"),
	FAQ("FAQ"),
	REGISTER("Register"),
	LOGIN("Login"),
	LOGOUT("Log out");
	
	private final String displayText;
	
	MenuItem(String displayText) {
		this.displayText = displayText;
	}
	
	public String getText() {
		return displayText;
	}
}
