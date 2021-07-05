package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.HomeFunctionalityPage;

import utilities.CommonUtils;

public class ContactUsTest extends BaseTest {

	private String sheetName = "RedbusFunctionality";

	@Test(priority = 1)
	public void ContactRedBus() throws Throwable {
		extentTest = extent.startTest("Valid SearchBus scenario test");

		String testcase = "ContactRedBus";

		// Fetching all test data from excel file
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();
		String page_title = data.get("Expected");


		CommonUtils.toCheckExecutionRequired(executionRequired);
		HomeFunctionalityPage contactus = new HomeFunctionalityPage(driver);
		contactus.contactUsButton();
		contactus.ClickForSupport();
		contactus.close();

		Assert.assertEquals(page_title, driver.getTitle());
		logger.info("SearchBus Test Case Passed");

		Thread.sleep(9000);

	}
}
