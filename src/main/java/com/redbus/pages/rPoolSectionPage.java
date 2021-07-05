package com.redbus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class rPoolSectionPage {
	
	WebDriver driver;

	public rPoolSectionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "cars")
	private WebElement rPoollink;

	@FindBy(how = How.XPATH, using = "//body/div[@id='reactContentMount']/div[1]/div[1]/div[12]/div[1]/ul[1]/li[1]/a[1]")
	private WebElement clickon;



	public void naviTorPool() throws Throwable {
		rPoollink.click();

	}

	public void serachForCity()  {
		clickon.click();

	}



}
