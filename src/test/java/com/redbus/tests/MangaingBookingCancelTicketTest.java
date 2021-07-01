package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.MangaingBookingPage;

import utils.CommonUtils;

public class MangaingBookingCancelTicketTest extends BaseTest {
	private String sheetName = "RedbusFunctionality";

	
	@Test
	public void TicketCancel() throws Throwable {
		extentTest = extent.startTest("Cancel ticket functionality scenario test");
		String testcase = "TicketCancel";

		MangaingBookingPage cancelticket = new MangaingBookingPage(driver);
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();

		CommonUtils.toCheckExecutionRequired(executionRequired);

		cancelticket.mangaeBooking();
		cancelticket.cancelButton();

		logger.info("Cancel ticket functionality Test Case Passed");
		Assert.assertEquals("Cancel Ticket - redBus", driver.getTitle());
		Thread.sleep(5000);
	}

}
