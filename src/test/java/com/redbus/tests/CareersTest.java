package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.CareersPage;

import utils.CommonUtils;

public class CareersTest extends BaseTest {
	private String sheetName = "RedbusFunctionality";

	@Test
	public void careers() throws Throwable {
		extentTest = extent.startTest("Valid careers page scenario test");
		String testcase = "careers";

		CareersPage buildcareer = new CareersPage(driver);
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();

		CommonUtils.toCheckExecutionRequired(executionRequired);

		buildcareer.careeerButton();
		buildcareer.goHome();

		logger.info("CareersPage Test Case Passed");
		Assert.assertEquals("Book Bus Travels, AC Volvo Bus, rPool & Bus Hire - redBus India", driver.getTitle());
		Thread.sleep(5000);
	}

}
