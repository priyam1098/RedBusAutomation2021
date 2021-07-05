package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.TravellerBusHiringPage;

import utilities.CommonUtils;

public class OutstaionBusHiringTest extends BaseTest {
	private String sheetName = "RedbusFunctionality";

	@Test
	public void BusHiringOutstation() throws Throwable {
		extentTest = extent.startTest("Outstation hiring scenario test");
		TravellerBusHiringPage bushire = new TravellerBusHiringPage(driver);
		String testcase = "BusHiringOutstation";
		//Data taken from excel
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();
		String fromWhen = data.get("fromWhen");
		String TillWhen = data.get("TillWhen");
		String passenger = data.get("passenger");
		String from = data.get("From");
		String To = data.get("To");
		String title = data.get("Expected");

		CommonUtils.toCheckExecutionRequired(executionRequired);

		bushire.naviToBusHire();
		bushire.clickOnOutstationMenu();
		bushire.enterPickAddress(from);
		bushire.enterDestinationAddress(To);
		bushire.enterDateAndTimeForOutstation(fromWhen, TillWhen);
		bushire.enterTotalPassenger(passenger);
		bushire.clickonProceed();

		Assert.assertEquals(title, bushire.nexttitle.getText());

		logger.info("Outstation hiring Case Passed");

		Thread.sleep(9000);
	}

}
