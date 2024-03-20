package testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageObjects.FormPageXpath;

public class Test5 {
	private WebDriver driver;
	private ChromeOptions options = new ChromeOptions();

	private String baseUrl;
	private FormPageXpath page;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\DriverServers\\chromedriver.exe");
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		baseUrl = "https://demoqa.com/automation-practice-form";
		page = new FormPageXpath(driver);
	}

	@Test
	public void testCase() throws Exception {
		driver.get(baseUrl);

		// page.clickCookies();
		page.deleteBanner();
		page.firstName();
		page.lastName();
		page.email();
		page.gender();
		page.number();
		page.dateBirth();
		page.subjects();
		page.hobbies();
		page.picture();
		page.currentAddress();
		page.state();
		page.city();
		page.submit();

		System.out.println("FINALIZAMOS");

	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();
	}

}
