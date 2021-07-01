package com.redbus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TravellerBusHiringPage {

	WebDriver driver;

	public TravellerBusHiringPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "redBus Bus Hire")
	public WebElement bushirelink;
	
	@FindBy(how = How.XPATH, using = "//body/div[@id='reactContentMount']/div[1]/div[5]/div[2]/object[1]")
    private WebElement frameWindow;

 
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Outstation')]")
    private WebElement outStationMenu;

//	@FindBy(how = How.XPATH, using = "//body/div[@id='reactContentMount']/div[1]/div[7]/div[1]/div[1]/div[1]/a[3]")
//	public WebElement clickoutsation;



	public void naviToBusHire() {
		bushirelink.click();
	}

//	public void Outstationhire() {
//		
//		//driver.switchTo().frame(driver.findElement(By.xpath("//body/div[@id='app']/div[1]")));   
//		//clickoutsation.click();
//
//	}
	 public void clickOnOutstationMenu() {

	        driver.switchTo().frame(frameWindow);
	        outStationMenu.click();
	        try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }

}
