package pageObjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Utils;

public class FormPageId {

	private WebDriver driver;
	private WebElement inpCookies;
	private Utils utils = new Utils();
	private WebElement inpFirstNombre;
	private WebElement inpLastname;
	private WebElement inpEmail;
	private WebElement inpNumber;
	private WebElement inpDateBirth;
	private WebElement inpSubjects;
	private WebElement inpSendPicture;
	private WebElement txareaCurrentAddress;
	private WebElement inpState;
	private WebElement inpCity;
	private WebElement btnSubmit;

	// By
	private By cookies = By.xpath("//div//child::button[@class='fc-button fc-cta-consent fc-primary-button']");
	private By byName = By.id("firstName");
	private By byLastName = By.id("lastName");
	private By byEmail = By.id("userEmail");
	private By byGender = By.id("gender-radio-1");
	private By byMobile = By.id("userNumber");
	private By byBirth = By.id("dateOfBirthInput");
	private By bysubjects = By.id("subjectsInput");
	private By byHobbies = By.id("hobbies-checkbox-1");
	private By byPicture = By.id("uploadPicture");
	private By byAddress = By.id("currentAddress");
	private By byState = By.id("react-select-3-input");
	private By byCity = By.id("react-select-4-input");
	private By bySubmit = By.id("submit");

	//By equals
	private By valueName = By.xpath("//td[text()='Student Name']//following::td");
	private By valueEmail = By.xpath("//td[text()='Student Email']//following::td");
	private By valueGender = By.xpath("//td[text()='Gender']//following::td");
	private By valueNumber = By.xpath("//td[text()='Mobile']//following::td");
	private By valueBirth = By.xpath("//td[text()='Date of Birth']//following::td");
	private By valueSubjects = By.xpath("//td[text()='Subjects']//following::td");
	private By valueHobbies = By.xpath("//td[text()='Hobbies']//following::td");
	private By valuePicture = By.xpath("//td[text()='Picture']//following::td");
	private By valueAddress = By.xpath("//td[text()='Address']//following::td");
	private By valueStateCity = By.xpath("//td[text()='State and City']//following::td");

	// Data
	private String name = "Juan";
	private String lastName = "Blanco";
	private String email = "email@gmail.com";
	private String gender = "Male";
	private String mobile = "0123456789";
	private String birth = "04/03/1996";
	private String subjects = "Maths";
	private String picture = "C:\\dev\\testing\\test.txt";
	private String currentAddress = "Calle Victoria, Bloque 2, 4A";
	private String state = "NCR";
	private String city = "Gurgaon";

	private String testBirth = "03 April,1996";
	private String testHobbies = "Sports";
	private String testPicture = "test.txt";

	public FormPageId(WebDriver driver) {
		setDriver(driver);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * 
	 * @param driver
	 * @param locator
	 * @return
	 */
	public WebElement searchElement(WebDriver driver, By locator) {
		WebElement element = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
		return element;
	}
	
	
	/**
	 * Delete banner
	 */
	public void deleteBanner() {
		  ((JavascriptExecutor)driver).executeScript("arguments[0].style.visibility='hidden'", driver.findElement(By.id("fixedban")));
	}

	
	

	/**
	 * Accept cookies
	 */
	public void clickCookies() {
		try {
		inpCookies = utils.waitForElement(driver, cookies, 3);
		inpCookies.click();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	/**
	 * Fill in the first name field
	 */
	public void firstName() {
		inpFirstNombre = utils.waitForElementToBeClickable(driver, byName);
		inpFirstNombre.sendKeys(name);

	}

	/**
	 * Fill in the last name field
	 */
	public void lastName() {
		inpLastname = utils.waitForElementToBeClickable(driver, byLastName);
		inpLastname.sendKeys(lastName);

	}

	/**
	 * Fill in the email field
	 */
	public void email() {
		inpEmail = utils.waitForElementToBeClickable(driver, byEmail);
		inpEmail.sendKeys(email);
	}

	/**
	 * Fill in the gender field
	 */
	public void gender() {
		searchElement(driver, byGender);
	}

	/**
	 * Fill in the number field
	 */
	public void number() {
		inpNumber = utils.waitForElementToBeClickable(driver, byMobile);
		inpNumber.sendKeys(mobile);
	}

	/**
	 * Fill in the Date Birth field
	 */
	public void dateBirth() {
		inpDateBirth = utils.waitForElementToBeClickable(driver, byBirth);
		inpDateBirth.sendKeys(Keys.CONTROL, "a");
		inpDateBirth.sendKeys(birth, Keys.ENTER);
	}

	/**
	 * Fill in the subjects field
	 */
	public void subjects() {
		inpSubjects = utils.waitForElementToBeClickable(driver, bysubjects);
		inpSubjects.sendKeys(subjects);
		inpSubjects.sendKeys(Keys.ENTER);
	}

	/**
	 * Fill in the hobbies field
	 */
	public void hobbies() {
		searchElement(driver, byHobbies);
	}

	/**
	 * Fill in the picture field
	 */
	public void picture() {
		inpSendPicture = utils.waitForElementToBeClickable(driver, byPicture);
		inpSendPicture.sendKeys(picture);

	}

	/**
	 * Fill in the Current Address field
	 */
	public void currentAddress() {
		txareaCurrentAddress = utils.waitForElementToBeClickable(driver, byAddress);
		txareaCurrentAddress.sendKeys(currentAddress);

	}

	/**
	 * Fill in the State field
	 */
	public void state() {
		inpState = utils.waitForElementToBeClickable(driver, byState);
		inpState.sendKeys(state);
		inpState.sendKeys(Keys.ENTER);
	}

	/**
	 * Fill in the City field
	 */
	public void city() {
		inpCity = utils.waitForElementToBeClickable(driver, byCity);
		inpCity.sendKeys(city);
		inpCity.sendKeys(Keys.ENTER);
	}

	/**
	 * Click in the submit button
	 */
	public void submit() {
		btnSubmit = utils.waitForElementToBeClickable(driver, bySubmit);
		btnSubmit.click();
	}

	
	/**
	 * Check that the first name and last name field match the one entered
	 */
	public void checkName() {
		assertEquals(name+ " "+lastName, utils.waitForElementToBeVisible(driver, valueName).getText());
	}

	/**
	 * Check that the email field match the one entered
	 */
	public void checkEmail() {
		assertEquals(email, driver.findElement(valueEmail).getText());
	}

	/**
	 * Check that the gender field match the one entered
	 */
	public void checkGender() {
		assertEquals(gender, driver.findElement(valueGender).getText());
	}

	/**
	 * Check that the number field match the one entered
	 */
	public void checkNumber() {
		assertEquals(mobile, driver.findElement(valueNumber).getText());
	}

	/**
	 * Check that the email field match the one entered
	 */
	public void checkBirth() {
		assertEquals(testBirth, driver.findElement(valueBirth).getText());
	}

	/**
	 * Check that the subjects field match the one entered
	 */
	public void checkSubjects() {
		assertEquals(subjects, driver.findElement(valueSubjects).getText());

	}

	/**
	 * Check that the hobbies field match the one entered
	 */
	public void checkHobbies() {
		assertEquals(testHobbies, driver.findElement(valueHobbies).getText());

	}

	/**
	 * Check that the picture field match the one entered
	 */
	public void checkPicture() {
		assertEquals(testPicture, driver.findElement(valuePicture).getText());

	}

	/**
	 * Check that the Current Address field match the one entered
	 */
	public void checkAddress() {
		assertEquals(currentAddress, driver.findElement(valueAddress).getText());

	}

	/**
	 * Check that the State and City field match the one entered
	 */
	public void checkStateCity() {
		assertEquals(state + " " + city, driver.findElement(valueStateCity).getText());

	}

}
