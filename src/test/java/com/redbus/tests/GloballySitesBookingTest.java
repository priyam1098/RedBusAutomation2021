package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.OpenGloballySitesBookingPage;

import utils.CommonUtils;

public class GloballySitesBookingTest extends BaseTest {
	private String sheetName = "RedbusFunctionality";


	@Test
	public void open_singapore_Booking() throws Throwable {
		extentTest = extent.startTest("Valid Open Globally sites booking Singapore  functionality scenario test");
		String testcase = "open_singapore_Booking";

		OpenGloballySitesBookingPage country_singapore = new OpenGloballySitesBookingPage(driver);
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();

		CommonUtils.toCheckExecutionRequired(executionRequired);

		country_singapore.singaporeBooking();
		
		String page_title= "Singapore Bus tickets online, Singapore Express Bus, Super VIP Coach Booking - redBus";
		logger.info("Global website country  functionality Test Case Passed");
		Assert.assertEquals(page_title, driver.getTitle());
		Thread.sleep(5000);
	}
	
	@Test
	public void open_Malaysia_Booking() throws Throwable {
		extentTest = extent.startTest("Valid Open Globally sites booking of Malaysia functionality scenario test");
		String testcase = "open_Malaysia_Booking";

		OpenGloballySitesBookingPage country_malaysia = new OpenGloballySitesBookingPage(driver);
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();

		CommonUtils.toCheckExecutionRequired(executionRequired);

		country_malaysia.MalaysiaBooking();
		String page_title ="Bus Tickets Online, Ferry Booking | Best Online Bus Booking Platform - redBus Malaysia";
		logger.info("Global website country  functionality Test Case Passed");
		Assert.assertEquals(page_title, driver.getTitle());
		Thread.sleep(5000);
	}
	
	@Test
	public void open_indonesia_Booking() throws Throwable {
		extentTest = extent.startTest("Valid Open Globally sites booking of Indonesia  functionality scenario test");
		String testcase = "open_indonesia_Booking";

		OpenGloballySitesBookingPage country_indonesia = new OpenGloballySitesBookingPage(driver);
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();

		CommonUtils.toCheckExecutionRequired(executionRequired);
		country_indonesia.indonesiaBooking();
		
		String page_title= "Tiket Bus Online | Pesan Tiket Bus - redBus Indonesia";
		logger.info("Global website country  functionality Test Case Passed");
		Assert.assertEquals(page_title, driver.getTitle());
		Thread.sleep(5000);
	}
	
	@Test
	public void open_peru_Booking() throws Throwable {
		extentTest = extent.startTest("Valid Open Globally sites booking of Peru functionality scenario test");
		String testcase = "open_peru_Booking";

		OpenGloballySitesBookingPage country_peru = new OpenGloballySitesBookingPage(driver);
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();

		CommonUtils.toCheckExecutionRequired(executionRequired);

		country_peru.peruBooking();
		String page_title ="redBus | La forma más fácil de comprar pasajes de bus";
		logger.info("Global website country  functionality Test Case Passed");
		Assert.assertEquals(page_title, driver.getTitle());
		Thread.sleep(5000);
	}
	
	@Test
	public void open_colombia_Booking() throws Throwable {
		extentTest = extent.startTest("Valid Open Globally sites booking of Colombia functionality scenario test");
		String testcase = "open_colombia_Booking";

		OpenGloballySitesBookingPage country_colombia = new OpenGloballySitesBookingPage(driver);
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();

		CommonUtils.toCheckExecutionRequired(executionRequired);

		country_colombia.colombiaBooking();
		String page_title ="Compra Pasajes de Bus Online - redBus Colombia";
		logger.info("Global website country  functionality Test Case Passed");
		Assert.assertEquals(page_title, driver.getTitle());
		Thread.sleep(5000);
	}
}
