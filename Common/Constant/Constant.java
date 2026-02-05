package Constant;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class Constant {
	public static WebDriver WEBDRIVER;
	public static final String RAILWAY_URL = "http://saferailway.somee.com/Page/HomePage.cshtml";
	public static final Duration TIMEOUT = Duration.ofSeconds(10);
	
	public static final String BLANK_VALUE = "";
	public static final String VALID_EMAIL = "gxgwnkpe@sharklasers.com";
	public static final String INVALID_EMAIL = "inactive@sharklasers.com";
	public static final String VALID_PASSWORD = "12345678";
	public static final String INVALID_PASSWORD = "123";
	public static final String VALID_PID = "12345678";
}
