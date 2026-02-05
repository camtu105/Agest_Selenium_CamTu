package Common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	
	/* GET LOCATOR */
	public static By getTabLocator(String tabName) {
		String xpathString = String.format("//div[@id='menu']//a[span[text()='%s']]", tabName);
		return By.xpath(xpathString);
	}
	
	/* SCROLL */ 
	public static void scrollToElement(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", findElement(locator));
	}
	
	/* WAIT */
	public static By waitForElementToBeVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Constant.TIMEOUT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return locator;
	}
	
	public static By waitForElementToBeClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Constant.TIMEOUT);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		return locator;
	}
	
	/* METHODS */
	public static String getText(By locator) {
		waitForElementToBeVisible(locator);
		scrollToElement(locator);
		return findElement(locator).getText();
	}
	
	public static void clear(By locator) {
		waitForElementToBeVisible(locator);
		scrollToElement(locator);
		waitForElementToBeClickable(locator);
		findElement(locator).clear();
	}
	
	public static void sendKeys(By locator, String text) {
		waitForElementToBeVisible(locator);
		scrollToElement(locator);
		waitForElementToBeClickable(locator);
		findElement(locator).sendKeys(text);
	}
	
	public static void click(By locator) {
		waitForElementToBeClickable(locator);
		scrollToElement(locator);
		waitForElementToBeClickable(locator);
		findElement(locator).click();
	}
		
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
		DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
		String email = "test_" + dateTime.format(format).toString();
		return email;
	}
}
