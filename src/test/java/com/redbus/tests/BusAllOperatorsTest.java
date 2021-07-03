package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.BusAllOperatorsPage;

import utils.CommonUtils;

public class BusAllOperatorsTest extends BaseTest {

	private String sheetName = "RedbusFunctionality";

	@Test
	public void all_bus_operators() throws Throwable {
		extentTest = extent.startTest("All Operators page scenario test");
		String testcase = "all_bus_operators";

		BusAllOperatorsPage operator  = new BusAllOperatorsPage(driver);
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();
		String title = data.get("Expected");
		CommonUtils.toCheckExecutionRequired(executionRequired);

		operator.all_operators();

		logger.info("All Operators Test Case Passed");
		Assert.assertEquals(title, driver.getTitle());
		Thread.sleep(5000);
	}

}
