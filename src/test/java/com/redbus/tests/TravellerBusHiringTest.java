package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.TravellerBusHiringPage;

import utils.CommonUtils;

public class TravellerBusHiringTest extends BaseTest {
	private String sheetName = "RedbusFunctionality";

	@Test
	public void BusHiringOutstation() throws Throwable {
		extentTest = extent.startTest("Outstation hiring scenario test");
		TravellerBusHiringPage bushire = new TravellerBusHiringPage(driver);
		String testcase = "BusHiringOutstation";
		
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();

		CommonUtils.toCheckExecutionRequired(executionRequired);

		bushire.naviToBusHire();
		Thread.sleep(2000);

		bushire.clickOnOutstationMenu();
		
		Assert.assertEquals("Bus Hire: Rent Volvo, AC buses, Mini Buses, Tempo Travellers & Innova Cars - Book Online", driver.getTitle());

		logger.info("Outstation hiring Case Passed");

		Thread.sleep(1000);
	}


}
