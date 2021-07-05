package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.HomeFunctionalityPage;

import utilities.CommonUtils;

public class ManageBookingShowMyTicketTest extends BaseTest {

	private String sheetName = "RedbusFunctionality";

	@Test
	public void ShowTicket() throws Throwable {
		extentTest = extent.startTest("ShowTicket functionality scenario test");
		String testcase = "ShowTicket";

		HomeFunctionalityPage show_ticket = new HomeFunctionalityPage(driver);
		//Data taken from excel
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();

		CommonUtils.toCheckExecutionRequired(executionRequired);

		show_ticket.showTicket();

		logger.info("ShowTicket functionality Test Case Passed");
		Assert.assertEquals("", driver.getTitle());
		Thread.sleep(5000);
	}

}
