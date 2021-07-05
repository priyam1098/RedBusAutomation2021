package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.InfoSectionPage;

import utilities.CommonUtils;

public class InfoSectionTest extends BaseTest {
	private String sheetName = "InfoSection";

	@Test
	public void termAndCondition() throws Throwable {
		extentTest = extent.startTest("Navigate to term And Condition page scenario test");
		InfoSectionPage info = new InfoSectionPage(driver);
		String testcase = "termAndCondition";
		//Data taken from excel
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();
		String page_title = data.get("Expected");
		CommonUtils.toCheckExecutionRequired(executionRequired);

		info.naviToTC();

		logger.info("TermAndCondition Test Case Passed");
		Assert.assertEquals(page_title, driver.getTitle());

		Thread.sleep(2000);
	}

	@Test
	public void privacyPolicysection() throws Throwable {
		extentTest = extent.startTest("Navigate to Privacy Policy page  scenario test");
		InfoSectionPage info = new InfoSectionPage(driver);
		String testcase = "privacyPolicysection";
		//Data taken from excel
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();

		CommonUtils.toCheckExecutionRequired(executionRequired);

		info.navitoprivacypolicy();

		logger.info("Info privacyPolicy  Test Case Passed");
		Assert.assertEquals("", driver.getTitle());

		Thread.sleep(2000);
	}

	@Test
	public void faqsection() throws Throwable {
		extentTest = extent.startTest("Navigate to FAQ Page  scenario test");
		InfoSectionPage info = new InfoSectionPage(driver);
		String testcase = "faqsection";
		//Data taken from excel
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();
		String page_title = data.get("Expected");

		CommonUtils.toCheckExecutionRequired(executionRequired);

		info.navitofaq();

		logger.info("Info FAQ  Test Case Passed");
		Assert.assertEquals(page_title, driver.getTitle());

		Thread.sleep(2000);
	}

	@Test
	public void blogSection() throws Throwable {
		extentTest = extent.startTest("Navigate to Blog Section  scenario test");
		InfoSectionPage info = new InfoSectionPage(driver);
		String testcase = "blogSection";
		//Data taken from excel
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();
		String page_title = data.get("Expected");


		CommonUtils.toCheckExecutionRequired(executionRequired);

		info.navitoblog();

		logger.info("Info Blog Section  Test Case Passed");
		Assert.assertEquals(page_title, driver.getTitle());

		Thread.sleep(2000);
	}

	@Test
	public void insuranceSection() throws Throwable {
		extentTest = extent.startTest("Navigate to Insurance Section  scenario test");
		InfoSectionPage info = new InfoSectionPage(driver);
		String testcase = "insuranceSection";
		//Data taken from excel
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();
		String page_title = data.get("Expected");


		CommonUtils.toCheckExecutionRequired(executionRequired);

		info.navitoinsurance();

		logger.info("Info Insurance Section  Test Case Passed");
		Assert.assertEquals(page_title, driver.getTitle());
		Thread.sleep(2000);
	}

	@Test
	public void userAgreementSection() throws Throwable {
		extentTest = extent.startTest("Navigate to User Agreement Section  scenario test");
		InfoSectionPage info = new InfoSectionPage(driver);
		String testcase = "useragreementSection";
		//Data taken from excel
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();
		String page_title = data.get("Expected");


		CommonUtils.toCheckExecutionRequired(executionRequired);

		info.navitouseragreement();

		logger.info("Info user Agreement Section   Test Case Passed");
		Assert.assertEquals(page_title, driver.getTitle());

		Thread.sleep(2000);
	}

	@Test
	public void agentRegistration() throws Throwable {
		extentTest = extent.startTest("Navigate to Agent Registration  scenario test");
		InfoSectionPage info = new InfoSectionPage(driver);
		String testcase = "agentRegistration";
		//Data taken from excel
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();
		String page_title = data.get("Expected");

		CommonUtils.toCheckExecutionRequired(executionRequired);

		info.navitoagentRegistration();

		logger.info("Info agentRegistration  Test Case Passed");
		Assert.assertEquals(page_title, driver.getTitle());

		Thread.sleep(2000);
	}

}
