package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.HomeFunctionalityPage;

import utilities.CommonUtils;

public class CustomerHelpsectionTest extends BaseTest {
	private String sheetName = "RedbusFunctionality";


	@Test
	public void Help() throws Throwable {
		extentTest = extent.startTest("Valid HelpButton functionality scenario test");
		String testcase = "Help";

		HomeFunctionalityPage helpsection = new HomeFunctionalityPage(driver);
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();
		String page_title = data.get("Expected");
		CommonUtils.toCheckExecutionRequired(executionRequired);

		helpsection.naviHelpSection();
		helpsection.closePopup();

		logger.info("HelpButton functionality Test Case Passed");
		Assert.assertEquals(page_title, driver.getTitle());
		Thread.sleep(5000);
	}

}
