package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	
	  private WebDriverWait time;


	public WebElement waitForElementToBeVisible(WebDriver driver,By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element  = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		return element;
	}
	
	public WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element  = wait.until(ExpectedConditions.elementToBeClickable(locator));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);

		return element;
	}
	
	public void timer(WebDriver driver, int seconds) {
		 time = new WebDriverWait(driver, Duration.ofSeconds(5));
		 time.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * Returns a WebElement found through its locator only after it is present and after waiting a given amount of seconds.
	 *
	 * @param driver
	 * @param locator
	 * @param seconds
	 * @return
	 */
	public WebElement waitForElement(WebDriver driver, By locator, Integer seconds) {
 
		// Instantiates the WebDriverWait with the given driver and seconds.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
 
		// Waits for the element to exist.
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
 
		// Returns the found element.
		return element;
	}
	
	public List<WebElement> waitForElements(WebDriver driver, By locator, Integer seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

	
	
}
