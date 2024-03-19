package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Utils;

public class SportsPage {
	private Utils utils = new Utils();
	private WebDriver driver;

	private WebElement cookies;
	private WebElement shield;
	private WebElement firstNews;

	// By
	private By byCookies = By.xpath("//button[text()='Aceptar y continuar gratis']");
	private By byShield = By.xpath("//img[@alt='Real Betis Balompié']");
	private By byNews = By.xpath("//article[@data-mrf-recirculation='bloque1-post1-noticia-portada']");
	
	/**
	 * 
	 * @param driver
	 */
	public SportsPage(WebDriver driver) {
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
		cookies = utils.waitForElementToBeClickable(driver, byCookies);
		cookies.click();
	}

	/**
	 * Click shield 
	 */
	public void clickShield() {
		shield = utils.waitForElementToBeClickable(driver, byShield);
		shield.click();
	}

	
	/**
	 * click News
	 */
	public void clickNews() {
		firstNews = utils.waitForElementToBeClickable(driver,byNews);
		firstNews.click();
	}

}
