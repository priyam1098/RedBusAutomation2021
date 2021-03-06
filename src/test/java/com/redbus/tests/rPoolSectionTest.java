package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.rPoolSectionPage;

import utilities.CommonUtils;

public class rPoolSectionTest extends BaseTest{
	private String sheetName = "RedbusFunctionality";

	
	@Test
	public void rPoolfunctionality() throws Throwable {
		extentTest = extent.startTest("rPool Page functionality scenario test");
		rPoolSectionPage rpool = new rPoolSectionPage(driver);
		String testcase = "rPoolfunctionality";
		//Data taken from excel
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();

		CommonUtils.toCheckExecutionRequired(executionRequired);
		rpool.naviTorPool();
		rpool.serachForCity();


		String titleofpage = data.get("Expected");
		logger.info("rPool Test Case Passed");
		Assert.assertEquals(titleofpage, driver.getTitle());

		Thread.sleep(2000);
	}


}
