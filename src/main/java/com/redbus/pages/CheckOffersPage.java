package com.redbus.pages;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckOffersPage {
	
	WebDriver driver;

	public CheckOffersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}


	//----------------------Check offers link locators & methods--------------------
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Offers')]")
	public WebElement clickoffer;


	public void clickOfferButton() throws Throwable {
		clickoffer.sendKeys(Keys.ENTER);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(3000);

	}
	//---------------------------------------------------------------------------	


}
