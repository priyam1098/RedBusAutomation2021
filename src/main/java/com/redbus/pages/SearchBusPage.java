package com.redbus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchBusPage {

	WebDriver driver;

	public SearchBusPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "redBus")
	public WebElement busticket;

	@FindBy(how = How.ID, using = "txtSource")
	public WebElement source;

	@FindBy(how = How.ID, using = "txtDestination")
	public WebElement destination;

	@FindBy(how = How.ID, using = "txtOnwardCalendar")
	public WebElement ClickonDate;

	@FindBy(how = How.XPATH, using = "//button[@class='D120_search_btn searchBuses']")
	public WebElement searchBus;

	public void naviBusTicket() {
		busticket.click();
	}

	public void sourcelocation(String sourceadd) {
		source.click();
		source.sendKeys(sourceadd);
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[5]")).click();
	}

	public void destinationlocation(String desadd, String testcase) {
		destination.click();
		destination.sendKeys(desadd);
		if (testcase == "ValidsearchBus") {
			driver.findElement(By.xpath("//li[@class='C120_slist-item C120_suggestion-active']")).click();
		}

	}

	public void clickDate(String datevalue) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','" + datevalue + "')", ClickonDate);

	}

	public void SearchButton() {
		searchBus.click();
	}

}
