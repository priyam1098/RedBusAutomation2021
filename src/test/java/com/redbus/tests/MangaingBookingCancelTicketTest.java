package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.HomeFunctionalityPage;

import utilities.CommonUtils;

public class MangaingBookingCancelTicketTest extends BaseTest {
	private String sheetName = "RedbusFunctionality";

	
	@Test
	public void TicketCancel() throws Throwable {
		extentTest = extent.startTest("Cancel ticket functionality scenario test");
		String testcase = "TicketCancel";

		HomeFunctionalityPage cancelticket = new HomeFunctionalityPage(driver);
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();
		String title = data.get("Expected");
		CommonUtils.toCheckExecutionRequired(executionRequired);

		cancelticket.mangaeBooking();
		cancelticket.cancelButton();

		logger.info("Cancel ticket functionality Test Case Passed");
		Assert.assertEquals(title, driver.getTitle());
		Thread.sleep(5000);
	}

}
