package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.TravellerBusHiringPage;

import utilities.CommonUtils;

public class LocalBusHiringTest extends BaseTest {
	private String sheetName = "RedbusFunctionality";

	@Test
	public void BusHiringLocal() throws Throwable {
		extentTest = extent.startTest("Local hiring scenario test");
		TravellerBusHiringPage bushire = new TravellerBusHiringPage(driver);
		String testcase = "BusHiringLocal";
		//Data taken from excel
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();
		String datetime = data.get("fromWhen");
		String passenger = data.get("passenger");
		String from = data.get("From");
		String title = data.get("Expected");
		CommonUtils.toCheckExecutionRequired(executionRequired);

		bushire.naviToBusHire();
		bushire.clickOnLocalMenu();
		bushire.enterLocalPickAddress(from);
		bushire.enterDateAndTimeForLocal(datetime);
		bushire.enterTotalLocalPassenger(passenger);
		bushire.click_on_Proceed();

		Assert.assertEquals(title, bushire.nexttitle.getText());
		logger.info("Local hiring Case Passed");

		Thread.sleep(5000);
	}

}
