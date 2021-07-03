package com.redbus.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PartnerWebsitesPage {

	WebDriver driver;

	public PartnerWebsitesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Goibibo')]")
	private WebElement goibibosite;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Makemytrip')]")
	private WebElement makemytrip;

	public void goToGoibiboSite() {
		goibibosite.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}
	
	public void goToMakemytripSite() {
		makemytrip.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}


	

}