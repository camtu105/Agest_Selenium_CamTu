package Railway;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Common.Utilities;
import Constant.Constant;
import Constant.MenuItem;
import Guerrillamail.GuerrillamailPage;

public abstract class BaseTest {	
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	RegisterPage registerPage = new RegisterPage();
	ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
	BookTicketPage bookTicketPage = new BookTicketPage();
	TimeTablePage timeTablePage = new TimeTablePage();
	TicketPricePage ticketPricePage = new TicketPricePage();
	MyTicketPage myTicketPage = new MyTicketPage();
	GuerrillamailPage guerrillamailPage = new GuerrillamailPage();
	
	protected String newEmail;
	protected Account user;
	
	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(@Optional("chrome") String browser) {
		String runBrowser = System.getProperty("browser", browser);
		if ("chrome".equalsIgnoreCase(runBrowser)) Constant.WEBDRIVER = new ChromeDriver();
		else if ("firefox".equalsIgnoreCase(runBrowser)) Constant.WEBDRIVER = new FirefoxDriver();
		else throw new RuntimeException("Unsupported browser: " + runBrowser);
	
		Constant.WEBDRIVER.manage().window().maximize();
		
		System.out.println("Pre-condition");
		guerrillamailPage.open();
		newEmail = Utilities.randomEmail();
		guerrillamailPage.setEmail(newEmail);
		user = new Account(newEmail + Constant.EMAIL_DOMAIN, Constant.VALID_PASSWORD, Constant.VALID_PID);
	}
	
	public void registerAccount() {
		Utilities.switchToNewTab(Constant.RAILWAY_URL);
		homePage.gotoTab(MenuItem.REGISTER.getText());
		registerPage.register(user.getUsername(), user.getPassword(), user.getPassword());
	}
	
	public void activateAccount() {
		Utilities.switchToFirstTab();
		guerrillamailPage.clickEmailTitle(newEmail, "Please confirm your account");
	}
 	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Post-condition");
		
		Constant.WEBDRIVER.quit();
	}
}
