package Constant;

public enum Destination {
	SAI_GON("Sài Gòn"),
	PHAN_THIET("Phan Thiết"),
	NHA_TRANG("Nha Trang"),
	DA_NANG("Đà Nẵng"),
	HUE("Huế"),
	QUANG_NGAI("Quảng Ngãi");
	
	private final String displayText;
	
	Destination(String displayText) {
		this.displayText = displayText;
	}
	
	public String getText() {
		return displayText;
	}
}
