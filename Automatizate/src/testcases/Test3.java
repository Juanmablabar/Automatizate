package testcases;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.SportsPage;

public class Test3 {
  private WebDriver driver;
  private String baseUrl;
  private SportsPage page;


  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\DriverServers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  baseUrl = "https://www.estadiodeportivo.com/";
	  page = new SportsPage(driver);
  }

  @Test
  public void testCase() throws Exception {
	  driver.get(baseUrl);
	  
	  page.clickCookies();
	  page.clickShield();
	  
	  /**
	   * for loop that searches for the news titles and displays them through the console
	   */
	  for(WebElement element: driver.findElements(By.xpath("//span[@class='row borde ']"))) {
		  if(element.findElement(By.className("enlace-oscuro")).getText() != null) {
			  System.out.println(element.findElement(By.className("enlace-oscuro")).getText());
		  }	  
	  }
	
	  //click on the first news
	  page.clickNews();
	  
	  System.out.println("--------------");
	  
	  //Create a list with the news from the carousel
	  List<WebElement> list = driver.findElements(By.xpath("//a[@cmp-ltrk='lo-ultimo']"));
	  
	  //loop that goes through the list and through the if it extracts the first and last news
	  for(WebElement element: list) {
		  if(element.getAttribute("cmp-ltrk-idx").equals("0")||element.getAttribute("cmp-ltrk-idx").equals(list.size()-1+"")) {
			  System.out.println(element.getAttribute("title"));
		  }	 
		  
		  //look for the latest news from the carousel, take the url and open it
		  if(element.getAttribute("cmp-ltrk-idx").equals(list.size()-1+"")){
			  baseUrl = element.getAttribute("href");
			  driver.get(baseUrl);
		  }
		 
	  }
	  
	  
	  
	  System.out.println("FINALIZAMOS");
    
  }

  @After
  public void tearDown() throws Exception {
	  driver.quit();
  }

}
