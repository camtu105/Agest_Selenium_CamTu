package Common;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constant.Constant;

public class Utilities {
	public static WebElement waitForElementToBeClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(5));
		return wait.until(
				ExpectedConditions.elementToBeClickable(locator)
			);
	}
	
	public static WebElement waitForElementToBeVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(5));
		return wait.until(
				ExpectedConditions.visibilityOfElementLocated(locator)
			);
	}
}
