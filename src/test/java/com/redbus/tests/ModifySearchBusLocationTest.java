package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.ModifySearchBusLocationPage;

import utils.CommonUtils;

public class ModifySearchBusLocationTest extends BaseTest {
	private String sheetName = "RedbusFunctionality";

	@Test
	public void modifySearchLocation() throws Throwable {
		extentTest = extent.startTest("Valid ModifySearchBusLocation functionality scenario test");

		String testcase = "modifySearchLocation";

		ModifySearchBusLocationPage modify_location = new ModifySearchBusLocationPage(driver);

		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();
		String source_Location = data.get("From");
		String dest_Location = data.get("To");
		//String month = data.get("month");
		String day = data.get("day");
		//String Year = data.get("Year");
		//String month_year = month+" "+Year;
		

		CommonUtils.toCheckExecutionRequired(executionRequired);

		modify_location.selectsource(source_Location);
		Thread.sleep(2000);
		modify_location.selectdestination(dest_Location);
		Thread.sleep(2000);

		modify_location.dateSelectButton( "July 2021" , day);
		Thread.sleep(2000);


		modify_location.clicksearchbutton();

		modify_location.modifylocation(dest_Location, source_Location);
		modify_location.modifySearch();

		modify_location.viewseats();

		String expected = driver.getTitle();
		logger.info("ModifySearchBusLocation functionality Test Case Passed");
		Assert.assertEquals(expected, driver.getTitle());
		Thread.sleep(5000);
	}
}
