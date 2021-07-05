package com.redbus.pages;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class InfoSectionPage {
	WebDriver driver;

	public InfoSectionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'T & C')]")
	private WebElement termcondition;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Privacy Policy')]")
	private WebElement privacypolicy;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'FAQ')]")
	private WebElement faq;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Blog')]")
	private WebElement blog;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Bus Operator Registration')]")
	private WebElement operatorregistration;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Insurance Partner')]")
	private WebElement insurance;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'User Agreement')]")
	private WebElement useragreement;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Agent Registration')]")
	private WebElement agentRegistration;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Sign In / Sign Up')]")
	private WebElement signin;

	@FindBy(how = How.XPATH, using = "//input[@class='sc-htoDjs gdSuEF']")
	public WebElement enterMobileNumber;

	@FindBy(how = How.ID, using = "recaptcha-anchor-label")
	public WebElement clickcaptcha;

	public void naviToTC() throws Throwable   {
		termcondition.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(1));

	}

	public void navitoprivacypolicy() throws Throwable {
		privacypolicy.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(1));

	}

	public void navitofaq() throws Throwable  {
		faq.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(1));

	}

	public void navitoblog() throws Throwable   {
		blog.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(1));

	}

	public void navitooperatorregistration(String mobile_number) throws Throwable   {
		operatorregistration.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(1));
		
		signin.sendKeys(Keys.ENTER);
		enterMobileNumber.sendKeys(mobile_number);

		
	}
	

	public void navitoinsurance() throws Throwable  {
		insurance.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(1));

	}

	public void navitouseragreement() throws Throwable  {
		useragreement.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(1));

	}

	public void navitoagentRegistration() throws Throwable  {
		agentRegistration.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(1));

	}

}
