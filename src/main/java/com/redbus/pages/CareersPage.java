package com.redbus.pages;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CareersPage {
	WebDriver driver;

	public CareersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// ------------------------Careers link locators &
	// methods------------------------

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Careers')]")
	private WebElement careers;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'redbus')]")
	private WebElement home;

	public void careeerButton() throws Throwable {
		careers.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	public void goHome() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		home.click();

	}
	// ---------------------------------------------------------------------------

}
