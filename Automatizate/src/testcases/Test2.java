package testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageObjects.SportsPage;

public class Test2 {
	private WebDriver driver;
	private ChromeOptions options = new ChromeOptions();

	private String baseUrl;
	private SportsPage page;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\DriverServers\\chromedriver.exe");
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		baseUrl = "https://www.estadiodeportivo.com/";
		page = new SportsPage(driver);
	}

	@Test
	public void testCase() throws Exception {
		// EMPEZAR CASO DE PRUEBA
		driver.get(baseUrl);

		page.clickCookies();
		page.clickShield();

		// for loop that searches for the news titles and displays them through the
		// console
		for (WebElement element : driver.findElements(By.xpath("//span[@class='row borde ']"))) {
			if (element.findElement(By.className("enlace-oscuro")).getText() != null) {
				System.out.println(element.findElement(By.className("enlace-oscuro")).getText());
			}
		}

		// FIN DE CASO DE PRUEBA
		System.out.println("FINALIZAMOS");

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
