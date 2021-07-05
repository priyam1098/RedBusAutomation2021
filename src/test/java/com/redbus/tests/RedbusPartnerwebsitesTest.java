package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.PartnerWebsitesPage;

import utilities.CommonUtils;

public class RedbusPartnerwebsitesTest extends BaseTest {
	private String sheetName = "RedbusFunctionality";

	
	@Test
	public void partnerWebsitesgoibibosite() throws Throwable {
		extentTest = extent.startTest("Valid PartnerWebsitesPage functionality scenario test");
		PartnerWebsitesPage website1 = new PartnerWebsitesPage(driver);
		String testcase = "partnerWebsitesgoibibosite";
		//Data taken from excel
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();

		CommonUtils.toCheckExecutionRequired(executionRequired);

		website1.goToGoibiboSite();
		String titleofpage = data.get("Expected");

		logger.info("PartnerWebsitesPage functionality Test Case Passed");
		Assert.assertEquals(titleofpage, driver.getTitle());
		Thread.sleep(5000);
	}
	
	@Test
	public void partnerWebsitesmakemytrip() throws Throwable {
		extentTest = extent.startTest("Valid PartnerWebsitesPage functionality scenario test");
		String testcase = "partnerWebsitesmakemytrip";

		PartnerWebsitesPage website2 = new PartnerWebsitesPage(driver);
		//Data taken from excel
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();

		CommonUtils.toCheckExecutionRequired(executionRequired);

		website2.goToMakemytripSite();
		String page_title =data.get("Expected");
		logger.info("PartnerWebsitesPage functionality Test Case Passed");
		Assert.assertEquals(page_title, driver.getTitle());
		Thread.sleep(5000);
	}

}
