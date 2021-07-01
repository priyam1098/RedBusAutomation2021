package com.redbus.tests;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.redbus.pages.SignInPage;

import utils.CommonUtils;

public class SigninTest extends BaseTest {
	private String sheetName = "RedbusFunctionality";


	@Test
	public void signin() throws Throwable {
		extentTest = extent.startTest("Valid Signin scenario test");
		SignInPage usersignin = new SignInPage(driver);
		String testcase = "ValidsearchBus";
		
		HashMap<String, String> data = new HashMap<String, String>();
		data = reader.getRowTestData(sheetName, testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();

		CommonUtils.toCheckExecutionRequired(executionRequired);


		usersignin.naviSignin();
		usersignin.signinButton();
		usersignin.signIn();
		usersignin.closePopUp();

		logger.info("Signin Test Case Passed");
		

		Thread.sleep(9000);
	}

}
