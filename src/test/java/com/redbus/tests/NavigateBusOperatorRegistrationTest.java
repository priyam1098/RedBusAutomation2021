package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.InfoSectionPage;

import utilities.CommonUtils;

public class NavigateBusOperatorRegistrationTest extends BaseTest {
	private String sheetName = "InfoSection";

	
	@Test
	public void operatorRegistration() throws Throwable {
		extentTest = extent.startTest("Navigate to operator Registration section  scenario test");
		InfoSectionPage info = new InfoSectionPage(driver);
		String testcase = "operatorRegistration";
		//Data taken from excel
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();
		String mobile_number =data.get("Mobile Number");
		String page_title =data.get("Expected");
		CommonUtils.toCheckExecutionRequired(executionRequired);
		
		info.navitooperatorregistration(mobile_number);

		Assert.assertEquals(page_title, driver.getTitle());
		logger.info("Info operator Registration  Test Case Passed");

		Thread.sleep(9000);
	}

}
