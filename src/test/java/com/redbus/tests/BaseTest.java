package com.redbus.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utils.ExcelDataReaderFile;
import utils.TakeScreenShots;

public class BaseTest {

	protected static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static ExcelDataReaderFile reader = null;

	// Reading the config.properties and log4j.properties file
	public static Logger logger = Logger.getLogger(BaseTest.class);
	static File file = new File(".\\Resources\\conf.properties");
	static FileInputStream fis = null;

	public static String LOGFILE = ".\\Resources\\log4j.properties";
	static FileInputStream logfile = null;

	static Properties prop = new Properties();

	static {
		try {
			fis = new FileInputStream(file);
			logfile = new FileInputStream(LOGFILE);
			PropertyConfigurator.configure(logfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
			prop.load(logfile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {

			reader = new utils.ExcelDataReaderFile(".\\Resources\\ExcelData.xlsx");
		} catch (Exception e) {

			logger.error(e.getMessage());
		}

	}

	@BeforeSuite
	public void setExtent() {
		extent = new ExtentReports(".\\Reports\\reports.html");
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
		extent.close();
	}

	@AfterMethod
	public void attachScreenShot(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = TakeScreenShots.takeScreenShot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Valid scenario test case passed successfully");
		}
		extent.endTest(extentTest);
	}

	@BeforeMethod
	public static void intializeWebdriver() throws Exception {
		String browser = prop.getProperty("browser");
		String headless = prop.getProperty("headless");

		if (browser.equalsIgnoreCase("firefox")) {
			if (headless.equalsIgnoreCase("yes")) {
				System.setProperty(prop.getProperty("driver_firefox"), prop.getProperty("path_firefox"));
				FirefoxBinary firefoxBinary = new FirefoxBinary();
				firefoxBinary.addCommandLineOptions("-headless");
				FirefoxOptions options = new FirefoxOptions();
				options.setBinary(firefoxBinary);
				driver = new FirefoxDriver(options);
			} else if (headless.equalsIgnoreCase("no")) {
				System.setProperty(prop.getProperty("driver_firefox"), prop.getProperty("path_firefox"));
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			}
		}

		else if (browser.equalsIgnoreCase("chrome")) {
			if (headless.equalsIgnoreCase("yes")) {
				System.setProperty(prop.getProperty("driver_chrome"), prop.getProperty("path_chrome"));
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				driver = new ChromeDriver(options);
			} else if (headless.equalsIgnoreCase("no")) {
				System.setProperty(prop.getProperty("driver_chrome"), prop.getProperty("path_chrome"));
				driver = new ChromeDriver();
			}
		} else {
			// If no browser passed throw exception
			throw new Exception("PLEASE CHECK THE BROWSER NAME !");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public static void openBrowser() {

		driver.get(prop.getProperty("url"));
	}

	@AfterMethod
	public static void closeBrowser() throws Throwable {
		Thread.sleep(5000);
		driver.quit();
	}

}
