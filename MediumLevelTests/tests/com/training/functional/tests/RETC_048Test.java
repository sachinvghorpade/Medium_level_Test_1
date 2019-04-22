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
import com.training.pom.RETC_048_Add_New_Region_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_048Test {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private RETC_046_Properties_tab_POM propertiesTabPOM;
	private RETC_048_Add_New_Region_POM addNewRegionPOM;
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
		addNewRegionPOM = new RETC_048_Add_New_Region_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		report = ExtentReportGenerator.generateReport();
		test = report.startTest("Test Case name: RETC_048Test");
		// open the browser
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Pre-Condition 1:", "User launched the application by entering valid URL.");
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		test.log(LogStatus.INFO, "Pre-Condition 2:", "Admin logged in.");
		screenShot.captureScreenShot("RETC_048_Pre-Condition2_Admin_Login_Success");
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void Functional_Test_RETC_048() throws Exception {
		String expectedResult = "Post published. View post";
		propertiesTabPOM.clickOnProperties();
		test.log(LogStatus.INFO, "Test Step 1.", "Clicked on Properties tab");

		propertiesTabPOM.clickButtonAddNew();
		test.log(LogStatus.INFO, "Test Step 2.", "Clicked on Add New button");

		addNewRegionPOM.clickLinkAddNewRegion();
		test.log(LogStatus.INFO, "Test Step 3.", "Clicked on Add new Region link in Feature section");

		addNewRegionPOM.enterTextboxNewPropertyRegione("Electronic City");
		test.log(LogStatus.INFO, "Test Step 4.", "Entered valid details in Textbox");

		addNewRegionPOM.selectDropdownNewPropertyRegion();
		test.log(LogStatus.INFO, "Test Step 5.", "Selected valid details in Parent Region list box");

		addNewRegionPOM.clickButtonAddNewRegion();
		test.log(LogStatus.INFO, "Test Step 6.", "Clicked on Add New Region button");

		addNewRegionPOM.refreshPage();
		test.log(LogStatus.INFO, "Test Step 7.", "Clicked on Refresh button from keyboard");

		propertiesTabPOM.enterTitleTextBox("prestige");
		test.log(LogStatus.INFO, "Test Step 8.", " Entered valid credentials in Enter Title Here textbox");

		propertiesTabPOM.enterContentTextArea("home town");
		test.log(LogStatus.INFO, "Test Step 9.", " Entered valid credentials in textbox");

		addNewRegionPOM.clickCheckboxWestBangalore();
		test.log(LogStatus.INFO, "Test Step 10(i).", "Clicked on checkbox(WestBangalore) beside created region");

		addNewRegionPOM.clickCheckboxElectronicCity();
		test.log(LogStatus.INFO, "Test Step 10(ii).", "Clicked on checkbox(ElectronicCity) beside created region");

		propertiesTabPOM.clickButtonPublish();
		test.log(LogStatus.INFO, "Test Step 11.", "Clicked on Publish button");

		String actualResult = propertiesTabPOM.getTextMessagePostPublished();

		if (expectedResult.equals(actualResult)) {
			test.log(LogStatus.PASS, "Test Passed", "Post published. View post message is displayed");
		} else {
			test.log(LogStatus.FAIL, "Test Failed", "Post published. View post message is not displayed");
		}

		screenShot.captureScreenShot("RETC_048_Step11_Post_published");
		Assert.assertEquals(actualResult, expectedResult);
		report.endTest(test);
		report.flush();
	}

}
