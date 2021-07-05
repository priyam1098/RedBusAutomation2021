package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.TravellerBusHiringPage;

import utilities.CommonUtils;

public class AirportBusHiringTest extends BaseTest {

	private String sheetName = "RedbusFunctionality";

	@Test
	public void BusHiringAirport() throws Throwable {
		extentTest = extent.startTest("Airport Bus hiring scenario test");
		TravellerBusHiringPage bushire = new TravellerBusHiringPage(driver);
		String testcase = "BusHiringAirport";
		//Data taken from excel
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();
		String Destination = data.get("Destination");
		String datetime = data.get("fromWhen");
		String passenger = data.get("passenger");
		String page_title = data.get("Expected");
		CommonUtils.toCheckExecutionRequired(executionRequired);
		//navigate to bus hire page
		bushire.naviToBusHire();
		bushire.clickOnAirportMenu();
		bushire.dropToArport();
		bushire.select_city();//Select city
		bushire.selectDesination(Destination);//User destination
		bushire.enterDateAndTimeForAirport(datetime);//select date and time
		bushire.enterTotalPassenger(passenger);
		//driver.switchTo().alert().accept();
		bushire.proceed();
		
		Assert.assertEquals(page_title, driver.getTitle());
		logger.info("Airport BUS hiring Case Passed");

		Thread.sleep(3000);
	}

}
