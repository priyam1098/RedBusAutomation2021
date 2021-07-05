package com.redbus.pages;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomeFunctionalityPage {
	
	WebDriver driver;

	public HomeFunctionalityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	//-------------------help section locators and methods---------------------------------------
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Help')]")
	private WebElement helpbutton;

	@FindBy(how = How.XPATH, using = "//body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")
	private WebElement cross;

	public void naviHelpSection()  {
		helpbutton.click();
		
	}

	public void closePopup() {
		String currentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String actual : handles) {
		if (!actual.equalsIgnoreCase(currentHandle)) {
		driver.switchTo().window(actual);
		}
		}
		cross.click();

	}
	//-----------------------------------------------------------------------
	//----------------------Check offers link locators & methods--------------------
		@FindBy(how = How.XPATH, using = "//a[contains(text(),'Offers')]")
		private WebElement clickoffer;

		public void clickOfferButton() throws Throwable {
			clickoffer.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			Thread.sleep(3000);
		}
		//---------------------------------------------------------------------------	


		@FindBy(how = How.XPATH, using = "//a[contains(text(),'Contact Us')]")
		private WebElement contactUsnav;

		@FindBy(how = How.XPATH, using = "//a[contains(text(),'Click Here')]")
		private WebElement clickhere;

		@FindBy(how = How.XPATH, using = "//i[@class='icon-close']")
		private WebElement closePopUp;

		public void contactUsButton() throws Throwable {
			contactUsnav.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
		}

		public void ClickForSupport() throws Throwable {
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			clickhere.click();
			
		}

		public void close() throws Throwable {
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(2));
			closePopUp.click();
			
		}
		// ------------------------Careers link locators &methods------------------------

		@FindBy(how = How.XPATH, using = "//a[contains(text(),'Careers')]")
		private WebElement careers;

		@FindBy(how = How.XPATH, using = "//a[contains(text(),'redbus')]")
		private WebElement home;

		public void careeerButton() throws Throwable {
			careers.sendKeys(Keys.ENTER);
			
		}

		public void goHome() {
			String currentHandle = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			for (String actual : handles) {
			if (!actual.equalsIgnoreCase(currentHandle)) {
			driver.switchTo().window(actual);
			}
			}
			home.click();

		}
		// ------------------------------ALL operators--------------------------------------------
		@FindBy(how = How.XPATH, using = "//a[contains(text(),'All Operators >')]")
		private WebElement operators;

		public void all_operators() {
			operators.sendKeys(Keys.ENTER);
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
		}
		//----------------------------cancel ticket--------------------------------------------------
		
		@FindBy(how = How.XPATH, using = "//div[contains(text(),'Manage Booking')]")
		private WebElement managebooking;

		@FindBy(how = How.XPATH, using = "//span[contains(text(),'Cancel')]")
		private WebElement clickcancel;
		
		@FindBy(how = How.XPATH, using = "//span[contains(text(),'Change Travel Date')]")
		private WebElement change_travel_date;
		
		@FindBy(how = How.XPATH, using = "//span[contains(text(),'Show My Ticket')]")
		private WebElement show_ticket ;
		

		public void mangaeBooking() throws Throwable {
			managebooking.click();
			


		}

		public void cancelButton() {
			clickcancel.click();
		}
		
		public void travelDate() {
			managebooking.click();
			change_travel_date.click();

		}

		public void showTicket() {
			managebooking.click();
			show_ticket.click();
		}
}

