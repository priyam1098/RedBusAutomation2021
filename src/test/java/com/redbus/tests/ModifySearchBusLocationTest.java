package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.ModifySearchBusLocationPage;

import utilities.CommonUtils;

public class ModifySearchBusLocationTest extends BaseTest {
	private String sheetName = "RedbusFunctionality";

	@Test
	public void modifySearchLocation() throws Throwable {
		extentTest = extent.startTest("Valid ModifySearchBusLocation functionality scenario test");

		String testcase = "modifySearchLocation";

		ModifySearchBusLocationPage modify_location = new ModifySearchBusLocationPage(driver);
		//Data taken from excel
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();
		String source_Location = data.get("From");
		String dest_Location = data.get("To");
		String expected = data.get("Expected");
		String day = data.get("day");

		CommonUtils.toCheckExecutionRequired(executionRequired);

		modify_location.selectsource(source_Location);
		modify_location.selectdestination(dest_Location);
		modify_location.dateSelectButton("July 2021", day);
		modify_location.clicksearchbutton();
		modify_location.modifylocation(dest_Location, source_Location);
		modify_location.modifySearch();

		
		logger.info("ModifySearchBusLocation functionality Test Case Passed");
		Assert.assertEquals(expected, driver.getTitle());
		Thread.sleep(1000);
	}
}
