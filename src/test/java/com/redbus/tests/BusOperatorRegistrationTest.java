package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.InfoSectionHomePage;

import utils.CommonUtils;

public class BusOperatorRegistrationTest extends BaseTest {
	private String sheetName = "InfoSection";

	
	@Test
	public void operatorRegistration() throws Throwable {
		extentTest = extent.startTest("Navigate to operator Registration section  scenario test");
		InfoSectionHomePage info = new InfoSectionHomePage(driver);
		String testcase = "operatorRegistration";

		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();
		String mobile_number =data.get("Mobile Number");
		CommonUtils.toCheckExecutionRequired(executionRequired);
		
		info.navitooperatorregistration(mobile_number);

		Assert.assertEquals("", driver.getTitle());
		logger.info("Info operator Registration  Test Case Passed");

		Thread.sleep(9000);
	}

}
