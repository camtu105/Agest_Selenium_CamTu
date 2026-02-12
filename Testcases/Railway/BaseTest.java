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
		
	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(@Optional("chrome") String browser) {
		String runBrowser = System.getProperty("browser", browser);
		if ("chrome".equalsIgnoreCase(runBrowser)) Constant.WEBDRIVER = new ChromeDriver();
		else if ("firefox".equalsIgnoreCase(runBrowser)) Constant.WEBDRIVER = new FirefoxDriver();
		else throw new RuntimeException("Unsupported browser: " + runBrowser);
	
		System.out.println("Pre-condition");
		Constant.WEBDRIVER.manage().window().maximize();
	}
	
	public String createEmail() {
		guerrillamailPage.open();
		String newEmail = Utilities.randomEmail();
		guerrillamailPage.setEmail(newEmail);
		return newEmail;
	}
	
	public Account registerAccount() {
		String email = createEmail();
		Account user = new Account(email + Constant.EMAIL_DOMAIN, Constant.VALID_PASSWORD, Constant.VALID_PID);
		
		Utilities.switchToNewTab(Constant.RAILWAY_URL);
		homePage.gotoTab(MenuItem.REGISTER.getText());
		registerPage.register(user.getUsername(), user.getPassword(), user.getPassword());
		return user;
	}
	
	public Account registerActiveAccount() {
		String email = createEmail();
		Account user = new Account(email + Constant.EMAIL_DOMAIN, Constant.VALID_PASSWORD, Constant.VALID_PID);
		
		Utilities.switchToNewTab(Constant.RAILWAY_URL);
		homePage.gotoTab(MenuItem.REGISTER.getText());
		registerPage.register(user.getUsername(), user.getPassword(), user.getPassword());
		
		Utilities.switchToFirstTab();
		guerrillamailPage.clickEmailTitle(user.getUsername(), "Please confirm your account");
		return user;
	}
 	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Post-condition");
		
		Constant.WEBDRIVER.quit();
	}
}
