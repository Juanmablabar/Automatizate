package testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test1 {
	private WebDriver driver;
	private ChromeOptions options = new ChromeOptions();

	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\DriverServers\\chromedriver.exe");
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		baseUrl = "https://www.estadiodeportivo.com/";
	}

	@Test
	public void testCase() throws Exception {
		// EMPEZAR CASO DE PRUEBA
		driver.get(baseUrl);

		// FIN DE CASO DE PRUEBA
		System.out.println("FINALIZAMOS");

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
