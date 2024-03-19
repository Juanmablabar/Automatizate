package testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.FormPageId;

public class Test4 {
  private WebDriver driver;
  private String baseUrl;  
  private FormPageId page;
 
  
  
  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\DriverServers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  baseUrl = "https://demoqa.com/automation-practice-form";
	  page = new FormPageId(driver);
	  
  }
  
  @Test
  public void testCase() throws Exception {
	  driver.get(baseUrl);
	  
	  page.deleteBanner();
	  page.clickCookies();
	  
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
	  
	  
	  
	  //FIN DE CASO DE PRUEBA
	  System.out.println("FINALIZAMOS");
    
  }

  @After
  public void tearDown() throws Exception {
	  driver.quit();
  }

}
