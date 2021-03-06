package com.redbus.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ScreenshotJar.Screenshots;
import utilities.ExcelDataReaderFile;

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

	public static Properties prop = new Properties();

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

			reader = new utilities.ExcelDataReaderFile(".\\Resources\\ExcelData.xlsx");
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
			String screenshotPath = Screenshots.takeScreenshot(driver, result.getName());
			System.out.print(screenshotPath);
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
			extentTest.log(LogStatus.FAIL, "ERROR DESCRIPTION : " + result.getThrowable());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test case passed successfully");
		}
		extent.endTest(extentTest);
	}

	@BeforeMethod
	public static void WebdriverInitilizer() throws Exception {
		String browser = prop.getProperty("browser");
		String headless = prop.getProperty("headless");
		String docker = prop.getProperty("docker");

		// Check if parameter passed is firefox
		if (browser.equalsIgnoreCase("firefox")) {
			if (headless.equalsIgnoreCase("yes")) {
			System.setProperty(prop.getProperty("driver_firefox"), prop.getProperty("path_firefox"));
			FirefoxBinary firefoxBinary = new FirefoxBinary();
			firefoxBinary.addCommandLineOptions("-headless");
			FirefoxOptions options = new FirefoxOptions();
			options.setBinary(firefoxBinary);
			driver = new FirefoxDriver(options);
			} else if (headless.equalsIgnoreCase("no") && docker.equalsIgnoreCase("false")) {
			System.setProperty(prop.getProperty("driver_firefox"), prop.getProperty("path_firefox"));
			driver = new FirefoxDriver();
			} else if (headless.equalsIgnoreCase("no") && docker.equalsIgnoreCase("true")) {
			System.out.println("---------------------------Firefox driver started---------------------------");
			FirefoxOptions options = new FirefoxOptions();
			driver = (new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), options));
			} else {
			driver = new FirefoxDriver();
			}
		}


		// Check if parameter passed as 'chrome'
		else if (browser.equalsIgnoreCase("chrome")) {
			if (headless.equalsIgnoreCase("yes")) {
				System.setProperty(prop.getProperty("driver_chrome"), prop.getProperty("path_chrome"));
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				options.addArguments("--disable-notifications");
				options.addArguments("start-maximized");
				options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.84 Safari/537.36");
				driver = new ChromeDriver(options);

			} else if (headless.equalsIgnoreCase("no") && docker.equalsIgnoreCase("false")) {
				System.setProperty(prop.getProperty("driver_chrome"), prop.getProperty("path_chrome"));
				driver = new ChromeDriver();

			}
				else if (headless.equalsIgnoreCase("no") && docker.equalsIgnoreCase("true")) {
					System.out.println("***------------------------Chrome----------------------------------***");
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--disable-dev-shm-usage");
					driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), options);
				}else if (headless.equalsIgnoreCase("yes") && docker.equalsIgnoreCase("true")) {
					System.out.println("***------------------------Chrome----------------------------------***");
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--disable-dev-shm-usage");
					driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), options);
				}			
				
				
				
				else if (docker.equalsIgnoreCase("false")) {
					System.setProperty(prop.getProperty("driver_chrome"), prop.getProperty("path_chrome"));
					driver = new ChromeDriver();
				}
			
			}
		

		// Check if parameter passed as 'Edge'
		else if (browser.equalsIgnoreCase("edge"))

		{
			System.setProperty(prop.getProperty("driver_edge"), prop.getProperty("path_edge"));
			driver = new EdgeDriver();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		} else {
			// If no browser passed throw exception
			throw new Exception("PLEASE CHECK THE BROWSER NAME !");
		}
		logger.info("Browser  successfully opened.");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
