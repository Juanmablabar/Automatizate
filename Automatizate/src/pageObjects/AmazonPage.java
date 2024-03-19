package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Utils;

public class AmazonPage {
	private Utils utils = new Utils();
	private WebDriver driver;

	//WebElements
	private WebElement inpCookies;
	private WebElement inpGoogle;
	private WebElement inpProduct;
	private WebElement inpCookiesAmazon;
	private WebElement inpDateLine;
	private WebElement inpPrice;
	private WebElement inpSearchAmazon;
	private WebElement inpPrime;
	private WebElement inpFilterPrice;
	private WebElement inpFilterLowToHigh;
	List<WebElement> names;

	// by
	private By byCookies = By.xpath("//button//div[text()='Aceptar todo']");
	private By bySearchGoogle = By.xpath("//form[@action='/search']//textarea");
	private By byProduct = By.xpath("//g-scrolling-carousel//span[contains(text(),'Amazon.es')]//parent::div//parent::div");
	private By byAmazonCookies = By.xpath("//input[contains(@id,'accept')]");
	private By byDateLine = By.xpath("//div[@id='mir-layout-DELIVERY_BLOCK-slot-PRIMARY_DELIVERY_MESSAGE_LARGE']//span[@class='a-text-bold'][1]");
	private By byPrice = By.xpath("//span[@class='a-price aok-align-center']/span[@class='a-offscreen']");
	private By bySearchAmazon = By.xpath("//input[@id='twotabsearchtextbox']");
	private By byPrime = By.xpath("//li[@id='p_n_free_shipping_eligible/20930980031']//i");
	private By byFilterPrice = By.xpath("//span[@id='a-autoid-2']");
	private By byFilterLowToHigh = By.xpath("//a[@id='s-result-sort-select_1']");
	private By byPrintText = By.xpath("//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']//span");
	private By byPrintText2 = By.xpath("//h2[@class=\"a-size-mini a-spacing-none a-color-base s-line-clamp-4\"]");
	
	
	
	public AmazonPage(WebDriver driver) {
		setDriver(driver);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement searchElement(WebDriver driver, By locator) {
		WebElement element = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
		return element;

	}

	/**
	 * Accept cookies
	 */
	public void clickCookies() {
		inpCookies = utils.waitForElementToBeClickable(driver, byCookies);
		inpCookies.click();
	}

	/**
	 * Search in Google the product
	 * @param search
	 */
	public void searchGoogle(String search) {
		inpGoogle = utils.waitForElementToBeClickable(driver, bySearchGoogle);
		inpGoogle.sendKeys(search);
		inpGoogle.sendKeys(Keys.ENTER);
	}

	
	/**
	 * Click on the first link in the carousel that Amazon has
	 */
	public void joinProduct() {
		inpProduct = utils.waitForElementToBeClickable(driver, byProduct);
		inpProduct.click();
	}

	/**
	 * To skip the captcha, we reload the normal page and the Amazon cookies appear
	 */
	public void captcha() {
		// Get tabs
		List<String> tabs = new ArrayList<>(driver.getWindowHandles());

		// Switch to tab just created
		driver.switchTo().window(tabs.get(1));

		// Refresh some times the page to bypass bot detection
		while (inpCookiesAmazon == null) {
			try {
				inpCookiesAmazon = utils.waitForElement(driver, byAmazonCookies, 3);
			} catch (Exception e) {
				driver.navigate().refresh();
			}
		}
		inpCookiesAmazon.click();
	}

	/**
	 * Searches the delivery date and prints it through the console
	 */
	public void printTextDate() {
		inpDateLine = utils.waitForElementToBeVisible(driver, byDateLine);
		System.out.println(inpDateLine.getAttribute("innerText"));
	}
	
	
	/**
	 * Searches the price and prints it through the console
	 */
	public void printTextPrice() {
		inpPrice = utils.waitForElement(driver, byPrice, 3);
		System.out.println(inpPrice.getAttribute("innerText"));
	}
	
	
	/**
	 * Search for the product on Amazon
	 * @param search
	 */
	public void searchAmazon(String search) {
		inpSearchAmazon = utils.waitForElement(driver, bySearchAmazon, 3);
		inpSearchAmazon.sendKeys(search);
		inpSearchAmazon.sendKeys(Keys.ENTER);
	}
	
	/**
	 * press the prime option
	 */
	public void filterPrime() {
		inpPrime = utils.waitForElement(driver, byPrime, 3);
		inpPrime.click();;
	}
	/**
	 * Display the order menu and choose the option from lowest to highest
	 */
	public void filterPrice() {
		inpFilterPrice = utils.waitForElement(driver, byFilterPrice, 3);
		inpFilterPrice.click();
		
		
		inpFilterLowToHigh = utils.waitForElement(driver, byFilterLowToHigh, 3);
		inpFilterLowToHigh.click();
	}
	
	/**
	 * selects all product names and displays them in console
	 */
	public void printText() {      
        try {
            names = utils.waitForElements(driver, byPrintText, 10);
		} catch (Exception e) {
	        names = utils.waitForElements(driver, byPrintText2, 5);
		}
        for (WebElement name : names) {
            System.out.println(name.getAttribute("innerText"));
        }
	}
	
	
}
