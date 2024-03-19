package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Utils;

public class FramePage {
	private Utils utils = new Utils();

	private WebDriver driver;
	private WebElement cookies;
	private WebElement frame1;
	private WebElement iframe;

	private By byFrame1 = By.id("frame1");
	private By byIframe = By.xpath("//iframe");

	private By byCookies = By.xpath("//button[@class='fc-button fc-cta-consent fc-primary-button']");

	/**
	 * 
	 * @param driver
	 */
	public FramePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCookies() {
		return cookies;
	}

	public void setCookies(WebElement cookies) {
		this.cookies = cookies;
	}

	public void clickCookies() {
		cookies = utils.waitForElementToBeVisible(driver, byCookies);
		cookies.click();

	}

	public void searchFrame() {
		frame1 = utils.waitForElementToBeClickable(driver, byFrame1);
		driver.switchTo().frame(frame1);

	}

	public void searchIframe() {
		iframe = utils.waitForElementToBeClickable(driver, byIframe);
		driver.switchTo().frame(iframe);
	}

}
