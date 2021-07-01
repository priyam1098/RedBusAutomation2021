package com.redbus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MangaingBookingPage {

	WebDriver driver;

	public MangaingBookingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Manage Booking')]")
	public WebElement managebooking;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Cancel')]")
	public WebElement clickcancel;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Change Travel Date')]")
	public WebElement change_travel_date;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Show My Ticket')]")
	public WebElement show_ticket ;
	

	public void mangaeBooking() {
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
