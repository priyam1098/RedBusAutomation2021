package com.redbus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	WebDriver driver;

	public SignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "signin-block")
	private WebElement signin_button;

	@FindBy(how = How.ID, using = "signInLink")
	private WebElement clicksignin;

	@FindBy(how = How.XPATH, using = "//body/div[6]/div[1]/div[2]/div[1]/div[1]/div[3]/iframe[1]")
	private WebElement googlesignin;

	@FindBy(how = How.XPATH, using = "//body/div[6]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")
	private WebElement popupclose;
	
	@FindBy(how = How.ID, using = "mobileNoInp")
	private WebElement mobile;
	

	public void naviSignin() {
		signin_button.click();
	}

	public void signinButton()   {
		clicksignin.click();
	}

	public void signIn() throws Throwable  {
		driver.switchTo().frame(driver.findElement(By.xpath("//body/div[6]/div[1]/div[2]/div[1]/div[1]/div[3]/iframe[1]")));
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[8]/div[1]")).click();
		
		
	}
	


}
