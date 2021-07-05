package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.HomeFunctionalityPage;

import utilities.CommonUtils;

public class CareersTest extends BaseTest {
	private String sheetName = "RedbusFunctionality";

	@Test
	public void careers() throws Throwable {
		extentTest = extent.startTest("Valid careers page scenario test");
		String testcase = "careers";

		HomeFunctionalityPage buildcareer = new HomeFunctionalityPage(driver);
		//Data taken from excel

		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();
		String page_title =data.get("Expected");
		CommonUtils.toCheckExecutionRequired(executionRequired);

		buildcareer.careeerButton();
		buildcareer.goHome();

		logger.info("CareersPage Test Case Passed");
		Assert.assertEquals(page_title, driver.getTitle());
		Thread.sleep(5000);
	}

}
