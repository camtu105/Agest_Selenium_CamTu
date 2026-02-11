package Common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constant.Constant;

public class Utilities {	
	/* GET ELEMENT */
	public static WebElement findElement(By locator) {
		return Constant.WEBDRIVER.findElement(locator);
	}
	
	public static List<WebElement> findElements(By locator) {
		return Constant.WEBDRIVER.findElements(locator);
	}
	
	/* SCROLL */ 
	public static void waitAndScrollToElement(By locator) {
		waitForPageLoad();
		waitForElementToBeStable(locator);
		JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", findElement(locator));
	}
	
	/* WAIT */
	public static void waitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Constant.TIMEOUT);
		wait.until (driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
	}
	
	public static By waitForElementToBeStable(By locator) {
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Constant.TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return locator;
	}
	
	public static By waitForElementToBeClickable(By locator) {
		waitAndScrollToElement(locator);
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Constant.TIMEOUT);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		return locator;
	}
	
	public static void waitForNewState(WebElement webElement) { 
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Constant.TIMEOUT); 
		wait.until(ExpectedConditions.stalenessOf(webElement));
	}
		
	/* ACTIONS */
	public static String getText(By locator) {
		waitAndScrollToElement(locator);
		return findElement(locator).getText();
	}
	
	public static void sendKeys(By locator, String text) {
		waitForElementToBeClickable(locator);
		findElement(locator).clear();
		findElement(locator).sendKeys(text);
	}
	
	public static void click(By locator) {
		waitForElementToBeClickable(locator);
		findElement(locator).click();
	}
	
	public static void select(By locator, String value) {
		waitForElementToBeClickable(locator);
		Select dropdown = new Select(findElement(locator));
		dropdown.selectByContainsVisibleText(value);
	}
	
	public static String getTextSelected(By locator) {
		waitAndScrollToElement(locator);
		Select dropdown = new Select(findElement(locator));
		return dropdown.getFirstSelectedOption().getText();
	}
		
	/* METHODS */
	public static boolean isDisplayed(String element) {
		try {
			return Constant.WEBDRIVER.findElement(By.xpath(element)).isDisplayed();
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public static String randomEmail() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dMyy_Hms");
		return "us_" + dateTime.format(format).toString();
	}
	
	public static String returnDateAfter(String date, int numberOfDaysAfter) {
	    DateTimeFormatter format = DateTimeFormatter.ofPattern(Constant.DATE_TICKET_FORMAT);
		LocalDate dateParse = LocalDate.parse(date, format);
		dateParse.plusDays(numberOfDaysAfter);
	    return dateParse.format(format).toString();
	}
	
	/* SWITCH TO */
	public static void switchToNewTab(String url) {
		Constant.WEBDRIVER.switchTo().newWindow(WindowType.TAB);
		Constant.WEBDRIVER.get(url);
	}
	
	public static void switchToFirstTab() {
		List<String> tabs = new ArrayList<String>(Constant.WEBDRIVER.getWindowHandles());
		Constant.WEBDRIVER.switchTo().window(tabs.get(0));
	}
	
	public static void switchToLastTab() {
		Set<String> windows = Constant.WEBDRIVER.getWindowHandles();
		String lastWindow = windows.toArray(new String[0])[windows.size() - 1];
		Constant.WEBDRIVER.switchTo().window(lastWindow);
	}
}
