package com.training.functional.tests;

import java.io.FileInputStream;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ExtentReportGenerator;
import com.training.generics.ScreenShot;

import com.training.pom.LoginPOM;

import com.training.pom.RETC_046_Properties_tab_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_046 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private RETC_046_Properties_tab_POM propertiesTabPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private ExtentTest test;
	private ExtentReports report;

	@BeforeTest
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		propertiesTabPOM = new RETC_046_Properties_tab_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		report = ExtentReportGenerator.generateReport();
		test = report.startTest("Test Case name: RETC_046");
		// open the browser
		driver.get(baseUrl);

		test.log(LogStatus.INFO, "Pre-Condition 1:", "User launched the application by entering valid URL.");
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		test.log(LogStatus.INFO, "Pre-Condition 2:", "Admin logged in.");
		screenShot.captureScreenShot("RETC_046_Pre-Condition2_Admin_Login_Success");
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void Functional_Test_RETC_046() throws Exception {
		String expectedResult = "Post published. View post";
		propertiesTabPOM.clickOnProperties();
		test.log(LogStatus.INFO, "Test Step 1.", "Clicked on Properties tab");

		propertiesTabPOM.clickButtonAddNew();
		test.log(LogStatus.INFO, "Test Step 2.", "Clicked on Add New button");

		propertiesTabPOM.enterTitleTextBox("prestige");
		test.log(LogStatus.INFO, "Test Step 3.", "Entered valid credentials in Enter Title Here textbox");

		propertiesTabPOM.enterContentTextArea("home town");
		test.log(LogStatus.INFO, "Test Step 4.", "Entered valid credentials in textbox");

		propertiesTabPOM.selectChkBoxFirstFeature();
		test.log(LogStatus.INFO, "Test Step 5.", "Clicked on checkbox beside added Feature of Features section");

		propertiesTabPOM.selectChkBoxFirstRegion();
		test.log(LogStatus.INFO, "Test Step 6.", "Clicked on checkbox beside added Region of Regions section");

		propertiesTabPOM.clickButtonPublish();
		test.log(LogStatus.INFO, "Test Step 7.", "Clicked on Publish button");

		String actualResult = propertiesTabPOM.getTextMessagePostPublished();

		if (expectedResult.equals(actualResult)) {
			test.log(LogStatus.PASS, "Test Passed", "Post published. View post message is displayed");
		} else {
			test.log(LogStatus.FAIL, "Test Failed", "Post published. View post message is not displayed");
		}

		screenShot.captureScreenShot("RETC_046_Step7_Post_published");
		Assert.assertEquals(actualResult, expectedResult);
		report.endTest(test);
		report.flush();
	}

}
