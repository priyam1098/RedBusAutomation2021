package com.redbus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.DateAndTimeHelper;

public class TravellerBusHiringPage {

	WebDriver driver;

	public TravellerBusHiringPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "redBus Bus Hire")
	private WebElement bushirelink;

	@FindBy(how = How.XPATH, using = "//body/div[@id='reactContentMount']/div[1]/div[5]/div[2]/object[1]")
	private WebElement frameWindow;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Outstation')]")
	private WebElement outStationMenu;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Local')]")
	private WebElement localMenu;

	@FindBy(how = How.ID, using = "locationTextFieldLocal")
	private WebElement localPickUpAdd;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Airport')]") // airport
	private WebElement airportMenu;

	@FindBy(how = How.ID, using = "locationTextFieldLocal") // outstation
	private WebElement enter_pick_address;

	@FindBy(how = How.ID, using = "local_dest_name") // outstation
	private WebElement enter_destination_address;

	@FindBy(how = How.ID, using = "numberOfPax") // outstation
	private WebElement numberoftraveller;

	@FindBy(how = How.ID, using = "numberOfPax") // local
	private WebElement totaltraveller;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'PROCEED')]") // local
	private WebElement clicklocalProceed;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Fill Contact Details')]") // local
	public WebElement nexttitle;

	@FindBy(how = How.XPATH, using = "//body/div[@id='AirporLeadGen_LandingPage']/div[@id='bodyCont']/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]") // airport
	private WebElement selectcity;

	@FindBy(how = How.ID, using = "proceedButtonOutstation")
	private WebElement proceedbutton;

	@FindBy(how = How.XPATH, using = "//*[@id='to_datepicker']/div/div/input")
	private WebElement toDateAndTimeForOutstation;

	@FindBy(how = How.XPATH, using = "//*[@id='from_datepicker']/div/div/input")
	private WebElement fromDateAndTimeForOutstation;

	@FindBy(how = How.XPATH, using = "//input[@class=\"MuiInputBase-input MuiInput-input\"]")
	private WebElement fromDateAndTimeForLocal;

	@FindBy(how = How.XPATH, using = "//input[@id='locationTextFieldLocal']") // airport
	private WebElement destination;

	@FindBy(how = How.XPATH, using = "//body/div[@id='AirporLeadGen_LandingPage']/div[@id='bodyCont']/div[2]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]")
	private WebElement fromDateAndTimeForAirport;

	@FindBy(how = How.ID, using = "proceedButtonAirport") // airport
	private WebElement proceed_button;
	
	@FindBy(how = How.XPATH, using = "//span[@id='to_airport']")
	private WebElement droptoAirportbutton;

	public void naviToBusHire() {

		bushirelink.click();
	}

	public void dropToArport() {

		droptoAirportbutton.click();
	}

	public void select_city() {// airport

		selectcity.click();

	}

	public void proceed() {// airport

		proceed_button.click();

	}

	public void selectDesination(String Destination) {// airport
		driver.findElement(By.xpath(
				"//body/div[@id='AirporLeadGen_LandingPage']/div[@id='bodyCont']/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]"))
				.click();
		destination.sendKeys(Destination);
		driver.findElement(By.xpath("//span[contains(text(),'Delhi Public School Bengaluru South, Road, Mango G')]"))
				.click();
	}

	public void clickOnOutstationMenu() {

		driver.switchTo().frame(frameWindow);
		outStationMenu.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickOnLocalMenu() {

		driver.switchTo().frame(frameWindow);
		localMenu.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickOnAirportMenu() {

		driver.switchTo().frame(frameWindow);
		airportMenu.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterPickAddress(String pickAddress) throws Throwable {
		enter_pick_address.sendKeys(pickAddress);
		driver.findElement(By.xpath("//span[contains(text(),'Delhi railway station, Mori Gate, Delhi, India')]"))
				.click();
		Thread.sleep(2000);

	}

	public void enterDestinationAddress(String destAddress) throws Throwable {
		enter_destination_address.sendKeys(destAddress);
		driver.findElement(By.xpath("//span[contains(text(),'Dehradun, Uttarakhand, Republic of India')]")).click();
		Thread.sleep(3000);

	}

	public void enterLocalPickAddress(String from) {
		localPickUpAdd.sendKeys(from);
		driver.findElement(By.xpath("//span[contains(text(),'Delhi railway station, Mori Gate, Delhi, India')]"))
				.click();
		;

	}

	public void enterTotalPassenger(String passenger) {// outstation
		numberoftraveller.sendKeys(passenger);
	}

	public void enterTotalLocalPassenger(String passenger) {// local
		totaltraveller.sendKeys(passenger);
	}

	public void clickonProceed() throws Throwable {// outstation
		proceedbutton.click();
		Thread.sleep(3000);

	}

	public void click_on_Proceed() throws Throwable {// local
		clicklocalProceed.click();
		Thread.sleep(3000);

	}

	public void enterDateAndTimeForOutstation(String fromDateAndTimeVal, String tillDateAndTimeVal)
			throws InterruptedException {

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", fromDateAndTimeForOutstation);

		// selecting date and time
		Thread.sleep(500);
		try {
			DateAndTimeHelper.selectDateAndTime_BusHirePage(driver, fromDateAndTimeVal);
		} catch (Exception e) {

			e.printStackTrace();
		}
		toDateAndTimeForOutstation.click();
		// selecting date and time
		try {
			DateAndTimeHelper.selectDateAndTime_BusHirePage(driver, tillDateAndTimeVal);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void enterDateAndTimeForLocal(String DateAndTimeVal) throws InterruptedException {

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", fromDateAndTimeForLocal);

		Thread.sleep(500);

		// selecting date and time
		try {
			DateAndTimeHelper.selectDateAndTime_BusHirePage(driver, DateAndTimeVal);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void enterDateAndTimeForAirport(String DateAndTimeVal) throws InterruptedException {

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", fromDateAndTimeForAirport);

		Thread.sleep(500);

		// selecting date and time
		try {
			DateAndTimeHelper.selectDateAndTime_BusHirePage(driver, DateAndTimeVal);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
