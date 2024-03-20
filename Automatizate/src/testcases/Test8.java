package testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageObjects.FramePage;

public class Test8 {
	private WebDriver driver;
	private ChromeOptions options = new ChromeOptions();

	private String baseUrl;
	private FramePage page;
	private String text;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\DriverServers\\chromedriver.exe");
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		baseUrl = "https://demoqa.com/nestedframes";
		page = new FramePage(driver);
	}

	@Test
	public void testCase() throws Exception {
		driver.get(baseUrl);

		page.clickCookies();

		page.searchFrame();
		text = driver.findElement(By.xpath("//html/body")).getText();

		System.out.println(text);

		page.searchIframe();
		text = driver.findElement(By.xpath("//p")).getText();

		System.out.println(text);

		// FIN DE CASO DE PRUEBA
		System.out.println("FINALIZAMOS");

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
