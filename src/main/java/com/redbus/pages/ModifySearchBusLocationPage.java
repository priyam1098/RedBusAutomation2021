package com.redbus.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.DatePicker;

public class ModifySearchBusLocationPage extends DatePicker {

	WebDriver driver;

	public ModifySearchBusLocationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")
	private WebElement selectdate;

	@FindBy(how = How.ID, using = "src")
	private WebElement source;

	@FindBy(how = How.ID, using = "dest")
	private WebElement destination;

	@FindBy(how = How.XPATH, using = "//button[@id='search_btn']")
	private WebElement searchbus;

	@FindBy(how = How.XPATH, using = "//div[@class='onward-modify-btn g-button clearfix fl']")
	private WebElement modifysearchbus;

	@FindBy(how = How.XPATH, using = "//button[@class=' button ms-btn']")
	private WebElement modifysearchbusbutton;

	public void selectsource(String sourcellocation) throws Throwable {
		// source.clear();
		source.sendKeys(sourcellocation);
		Thread.sleep(3000);

		// source.sendKeys(Keys.ENTER);

	}

	public void selectdestination(String destloaction) throws Throwable {
		// destination.clear();
		destination.sendKeys(destloaction);
		Thread.sleep(3000);

		// destination.sendKeys(Keys.ENTER);

	}

	public void dateSelectButton(String month_year, String date) throws Throwable {

		selectdatepicker(selectdate, month_year, date, driver);
		Thread.sleep(3000);

	}

	public void clicksearchbutton() throws Throwable {
		searchbus.click();
		Thread.sleep(3000);

	}

	public void modifylocation(String sourcellocation, String destloaction) {
		modifysearchbus.click();
		source.clear();
		source.sendKeys(sourcellocation);
		source.sendKeys(Keys.ENTER);
		destination.clear();
		destination.sendKeys(destloaction);
		destination.sendKeys(Keys.ENTER);

	}

	public void modifySearch() {
		modifysearchbusbutton.click();

	}

}
