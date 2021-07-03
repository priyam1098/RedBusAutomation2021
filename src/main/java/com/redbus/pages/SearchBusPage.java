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
	private WebElement busticket;

	@FindBy(how = How.ID, using = "txtSource")
	private WebElement source;

	@FindBy(how = How.ID, using = "txtDestination")
	private WebElement destination;

	@FindBy(how = How.ID, using = "txtOnwardCalendar")
	private WebElement ClickonDate;

	@FindBy(how = How.XPATH, using = "//button[@class='D120_search_btn searchBuses']")
	private WebElement searchBus;

	public void naviBusTicket() {
		busticket.click();
	}

	public void sourcelocation(String sourceadd, String testcase) throws Throwable {
		source.click();
		source.sendKeys(sourceadd);
		if(testcase != "invalidSourceSearchBus") {
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[5]")).click();
		Thread.sleep(3000);
		}

	}

	public void destinationlocation(String desadd, String testcase) throws Throwable {
		destination.click();
		destination.sendKeys(desadd);
		if (testcase == "ValidsearchBus") {
			driver.findElement(By.xpath("//li[@class='C120_slist-item C120_suggestion-active']")).click();
			Thread.sleep(3000);

		}

	}

	public void clickDate(String datevalue) throws Throwable {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','" + datevalue + "')", ClickonDate);
		Thread.sleep(3000);


	}

	public void SearchButton() {
		searchBus.click();
	}

}
