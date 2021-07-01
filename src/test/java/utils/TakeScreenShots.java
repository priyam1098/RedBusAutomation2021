package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShots {

	public static String takeScreenShot(WebDriver driver, String testCaseName) {
		String screenshotFileName = "C:\\Users\\priyam\\eclipse-workspace\\ExitTestAutomationTarining2021\\Reports\\ScreenShots"
				+ testCaseName + "TestFailed.png";

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(screenshotFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotFileName;
	}
}
