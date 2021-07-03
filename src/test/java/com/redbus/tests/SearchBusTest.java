package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.*;
//import utils.ExcelData;

import utils.CommonUtils;

public class SearchBusTest extends BaseTest {
	private String sheetName = "SearchBusTest";

//	@Test(priority=1)
//	public void ValidsearchBus() throws Throwable {
//		extentTest = extent.startTest("Valid SearchBus scenario test");
//
//		String testcase = "ValidsearchBus";
//
//		// Fetching all test data from excel file
//		HashMap<String, String> data = new HashMap<String, String>();
//		data = reader.getRowTestData(sheetName, testcase);
//		String executionRequired = data.get("Execution Required").toLowerCase();
//		String source_Location = data.get("From");
//		String dest_Location = data.get("To");
//		String date_value = data.get("Date");
//
//		SearchBusPage userride = new SearchBusPage(driver);
//		CommonUtils.toCheckExecutionRequired(executionRequired);
//
//		userride.naviBusTicket();
//		userride.sourcelocation(source_Location);
//		userride.destinationlocation(dest_Location,testcase);
//		userride.clickDate(date_value);
//		userride.SearchButton();
//		Assert.assertEquals("Search Bus Tickets", driver.getTitle());
//		logger.info("SearchBus Test Case Passed");
//
//		Thread.sleep(5000);
//
//	}
//	
//	@Test//(groups= "Invalid", priority=2)
//	public void invalidDestinationSearchBus() throws Throwable {
//		extentTest = extent.startTest("InValid SearchBus scenario test");
//
//		String testcase = "invalidDestinationSearchBus";
//
//		// Fetching all test data from excel file
//		HashMap<String, String> data = new HashMap<String, String>();
//		data = reader.getRowTestData(sheetName, testcase);
//		String executionRequired = data.get("Execution Required").toLowerCase();
//		String source_Location = data.get("From");
//		String dest_Location = data.get("To");
//		String date_value = data.get("Date");
//
//		SearchBusPage userride = new SearchBusPage(driver);
//		CommonUtils.toCheckExecutionRequired(executionRequired);
//
//		userride.naviBusTicket();
//		userride.sourcelocation(source_Location);
//		userride.destinationlocation(dest_Location,testcase);
//		userride.clickDate(date_value);
//		userride.SearchButton();
//		//Assert.assertEquals("Online Bus Tickets Booking: Book Bus Ticket and Bus Reservation -redBus India", driver.getTitle());
//		Assert.assertEquals("Search Bus Tickets",driver.getTitle());
//		logger.info("InvalidSearchBus Test Case Passed");
//
//		Thread.sleep(2000);
//
//	}
	
	@Test//(groups= "Invalid", priority=3)
	public void invalidSourceSearchBus() throws Throwable {
		extentTest = extent.startTest("InValid source Search Bus scenario test");

		String testcase = "invalidSourceSearchBus";

		// Fetching all test data from excel file
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();
		String source_Location = data.get("From");
		String dest_Location = data.get("To");
		String date_value = data.get("Date");

		SearchBusPage userride = new SearchBusPage(driver);
		CommonUtils.toCheckExecutionRequired(executionRequired);

		userride.naviBusTicket();
		userride.sourcelocation(source_Location,testcase);
		userride.destinationlocation(dest_Location,testcase);
		userride.clickDate(date_value);
		userride.SearchButton();
		//Assert.assertEquals("Online Bus Tickets Booking: Book Bus Ticket and Bus Reservation -redBus India", driver.getTitle());
		Assert.assertEquals("Search Bus Tickets",driver.getTitle());
		logger.info("Invalid source Search Bus Test Case Passed");

		Thread.sleep(2000);

	}

}
