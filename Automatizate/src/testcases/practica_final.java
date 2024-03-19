package testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.AmazonPage;

public class practica_final {
	private WebDriver driver;
	private String baseUrl;
	private AmazonPage page;
	private String search = "patinete";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\DriverServers\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		/**
		 * finder path
		 */
		baseUrl = "https://www.google.com/";
		page = new AmazonPage(driver);

	}

	@Test
	public void testCase() throws Exception {
		driver.get(baseUrl);

		/**
		 * function call
		 */
		page.clickCookies();
		page.searchGoogle(search);
		page.joinProduct();
		page.captcha();
		page.printTextDate();
		page.printTextPrice();
		page.searchAmazon(search);
		page.filterPrime();
		page.filterPrice();
		page.printText();


	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
