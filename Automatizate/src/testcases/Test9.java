package testcases;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Test9{
	private WebDriver driver;
	private ChromeOptions options = new ChromeOptions();

	private String baseUrl;
	private WebElement element;
	private String text;
	
	
	
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\DriverServers\\chromedriver.exe");
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		baseUrl = "http://uitestingplayground.com/shadowdom";
		
	}

	@Test
	public void testCase() throws Exception {
		driver.get(baseUrl);

		SearchContext context = driver.findElement(By.tagName("guid-generator")).getShadowRoot();

		element = context.findElement(By.id("buttonGenerate"));
		element.click();

		text = context.findElement(By.id("editField")).getAttribute("value");
		System.out.println(text);

		System.out.println("FINALIZAMOS");

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
