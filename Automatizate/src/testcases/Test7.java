package testcases;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.ButtonsPage;
import utils.Utils;

public class Test7 {
  private WebDriver driver;
  private String baseUrl;
  private ButtonsPage page;
  private Utils utils = new Utils();
 
  

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\DriverServers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  baseUrl = "https://demoqa.com/alerts";
	  page = new ButtonsPage(driver);
  }

  @Test
  public void testCase() throws Exception {
	  //EMPEZAR CASO DE PRUEBA
	  driver.get(baseUrl);
	  
	  
	  page.clickCookies();
	  
	  page.btnAlert(); 
	  driver.switchTo().alert().dismiss();

	  
	  page.btnTimeAlert();
	  utils.timer(driver, 5);
	  driver.switchTo().alert().dismiss();

	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	  jse.executeScript("window.scrollBy(0,250)");
	  
	  
	  
	  page.btnConfirm();
	  driver.switchTo().alert().accept();
	  
	  
	  page.btnPromt();
	  driver.switchTo().alert().sendKeys("Juanma");
	  driver.switchTo().alert().accept();	  
	  
	  //FIN DE CASO DE PRUEBA
	  System.out.println("FINALIZAMOS");
    
  }

  @After
  public void tearDown() throws Exception {
	  //driver.quit();
  }

}
