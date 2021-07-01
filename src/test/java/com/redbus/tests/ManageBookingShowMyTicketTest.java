package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.MangaingBookingPage;

import utils.CommonUtils;

public class ManageBookingShowMyTicketTest extends BaseTest {

	private String sheetName = "RedbusFunctionality";

	@Test
	public void ShowTicket() throws Throwable {
		extentTest = extent.startTest("ShowTicket functionality scenario test");
		String testcase = "ShowTicket";

		MangaingBookingPage show_ticket = new MangaingBookingPage(driver);
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();

		CommonUtils.toCheckExecutionRequired(executionRequired);

		show_ticket.showTicket();

		logger.info("ShowTicket functionality Test Case Passed");
		//Assert.assertEquals("https://www.redbus.in/Home/PrintTicket", driver.getTitle());
		Thread.sleep(5000);
	}

}
