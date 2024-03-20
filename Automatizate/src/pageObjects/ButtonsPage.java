package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Utils;

public class ButtonsPage {
	private Utils utils = new Utils();

	private WebDriver driver;
	private WebElement cookies;
	private WebElement btnAlert;
	private WebElement btnTimeAlert;
	private WebElement btnConfirm;
	private WebElement btnPrompt;
	
	private By byCookies = By.xpath("//button[@class='fc-button fc-cta-consent fc-primary-button']");
	private By byAlert = By.id("alertButton");
	private By byTimeAlert = By.id("timerAlertButton");
	private By byConfirm = By.id("confirmButton");
	private By byPromt = By.id("promtButton");
	
	public ButtonsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Accept Cookies
	 */
	public void clickCookies() {
		try {
			cookies = utils.waitForElement(driver,byCookies, 3);
			cookies.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}
	
	/**
	 * Click on the alert button
	 */
	public void btnAlert() {
		btnAlert= utils.waitForElementToBeClickable(driver, byAlert);
		btnAlert.click();

	}
	
	/**
	 * Click on the alert button 
	 */
	public void btnTimeAlert() {
		 btnTimeAlert = utils.waitForElementToBeClickable(driver, byTimeAlert);
		  btnTimeAlert.click();
	}
	
	/**
	 * Click on the confirm button
	 */
	public void btnConfirm() {
		btnConfirm = utils.waitForElementToBeClickable(driver, byConfirm);
		btnConfirm.click();
	}
	
	/**
	 * Click on the promt button
	 */
	public void btnPromt() {
		  btnPrompt = utils.waitForElementToBeVisible(driver, byPromt);
		  btnPrompt.click();
	}
	
	
	
}
