package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.SignInPage;

import utilities.CommonUtils;

public class SigninTest extends BaseTest {
	private String sheetName = "RedbusFunctionality";


	@Test
	public void signin() throws Throwable {
		extentTest = extent.startTest("Valid Signin scenario test");
		SignInPage usersignin = new SignInPage(driver);
		String testcase = "signin";
		//Data taken from excel
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();
		String title = data.get("Expected");
		CommonUtils.toCheckExecutionRequired(executionRequired);


		usersignin.naviSignin();
		usersignin.signinButton();
		usersignin.signIn();
		Assert.assertEquals(title,driver.getTitle());
		logger.info("Signin Test Case Passed");
		

		Thread.sleep(2000);
	}

}
