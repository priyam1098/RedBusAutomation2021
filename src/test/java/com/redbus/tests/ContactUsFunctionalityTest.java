package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.ContactUsPage;

import utils.CommonUtils;

public class ContactUsFunctionalityTest extends BaseTest {

	private String sheetName = "RedbusFunctionality";

	@Test(priority = 1)
	public void ContactRedBus() throws Throwable {
		extentTest = extent.startTest("Valid SearchBus scenario test");

		String testcase = "ContactRedBus";

		// Fetching all test data from excel file
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();

		CommonUtils.toCheckExecutionRequired(executionRequired);
		ContactUsPage contactus = new ContactUsPage(driver);
		contactus.contactUsButton();
		contactus.ClickForSupport();
		contactus.close();

		Assert.assertEquals("red:Care", driver.getTitle());
		logger.info("SearchBus Test Case Passed");

		Thread.sleep(9000);

	}
}
