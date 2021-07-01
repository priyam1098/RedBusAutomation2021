package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.CheckOffersPage;

import utils.CommonUtils;

public class CheckOffersTest extends BaseTest {
	private String sheetName = "RedbusFunctionality";

	@Test
	public void offers() throws Throwable {
		extentTest = extent.startTest(" offers page scenario test");
		String testcase = "offers";

		CheckOffersPage useroffers = new CheckOffersPage(driver);
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();

		CommonUtils.toCheckExecutionRequired(executionRequired);

		useroffers.clickOfferButton();

		logger.info("offers Test Case Passed");
		Assert.assertEquals("Offers: Bus Offers, Hotel Discounts & Coupon Codes - redBus", driver.getTitle());
		Thread.sleep(5000);
	}
}
