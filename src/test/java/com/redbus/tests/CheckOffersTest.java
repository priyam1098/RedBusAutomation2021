package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.HomeFunctionalityPage;

import utilities.CommonUtils;

public class CheckOffersTest extends BaseTest {
	private String sheetName = "RedbusFunctionality";

	@Test
	public void offers() throws Throwable {
		extentTest = extent.startTest(" offers page scenario test");
		String testcase = "offers";

		HomeFunctionalityPage useroffers = new HomeFunctionalityPage(driver);
		//Data taken from excel

		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();
		String page_title =data.get("Expected");
		CommonUtils.toCheckExecutionRequired(executionRequired);

		useroffers.clickOfferButton();

		logger.info("offers Test Case Passed");
		Assert.assertEquals(page_title, driver.getTitle());
		Thread.sleep(5000);
	}
}
