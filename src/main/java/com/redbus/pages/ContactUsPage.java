package com.redbus.pages;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

	WebDriver driver;

	public ContactUsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

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
		Thread.sleep(3000);
	}

	public void close() throws Throwable {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));
		closePopUp.click();
		Thread.sleep(3000);
	}

}
