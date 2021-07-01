package com.redbus.pages;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OpenGloballySitesBookingPage {

	WebDriver driver;

	public OpenGloballySitesBookingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Singapore')]")
	public WebElement Singaporesitelink;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Malaysia')]")
	public WebElement Malaysiasitelink;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Indonesia')]")
	public WebElement Indonesiasitelink;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Peru')]")
	public WebElement Perusitelink;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Colombia')]")
	public WebElement Colombiasitelink;

	public void singaporeBooking() {
		Singaporesitelink.sendKeys(Keys.ENTER);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

	}

	public void MalaysiaBooking() {
		Malaysiasitelink.sendKeys(Keys.ENTER);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

	}

	public void indonesiaBooking() {
		Indonesiasitelink.sendKeys(Keys.ENTER);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

	}

	public void peruBooking() {
		Perusitelink.sendKeys(Keys.ENTER);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

	}

	public void colombiaBooking() {
		Colombiasitelink.sendKeys(Keys.ENTER);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

	}

}