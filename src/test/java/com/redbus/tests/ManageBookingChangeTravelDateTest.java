package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.MangaingBookingPage;

import utils.CommonUtils;

public class ManageBookingChangeTravelDateTest extends BaseTest {
	private String sheetName = "RedbusFunctionality";

	@Test
	public void TravelDate() throws Throwable {
		extentTest = extent.startTest("TravelDate functionality scenario test");
		String testcase = "TravelDate";

		MangaingBookingPage changedate = new MangaingBookingPage(driver);
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();

		CommonUtils.toCheckExecutionRequired(executionRequired);

		changedate.travelDate();

		logger.info("TravelDate functionality Test Case Passed");
		//Assert.assertEquals("https://www.redbus.in/Reschedule", driver.getTitle());
		Thread.sleep(5000);
	}

}
