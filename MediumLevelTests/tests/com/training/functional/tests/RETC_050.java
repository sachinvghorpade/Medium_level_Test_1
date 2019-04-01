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
import com.training.pom.RETC_047_Add_New_Feature_POM;
import com.training.pom.RETC_048_Add_New_Region_POM;
import com.training.pom.RETC_050_Add_Property_Into_Trash_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_050 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private RETC_046_Properties_tab_POM propertiesTabPOM;
	private RETC_047_Add_New_Feature_POM addNewFeaturePOM;
	private RETC_048_Add_New_Region_POM addNewRegionPOM;
	private RETC_050_Add_Property_Into_Trash_POM addPropertyIntoTrashPOM;
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
		addNewFeaturePOM = new RETC_047_Add_New_Feature_POM(driver);
		addNewRegionPOM = new RETC_048_Add_New_Region_POM(driver);
		addPropertyIntoTrashPOM = new RETC_050_Add_Property_Into_Trash_POM(driver);

		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		report = ExtentReportGenerator.generateReport();
		test = report.startTest("Test Case name: RETC_050");
		// open the browser
		driver.get(baseUrl);

		test.log(LogStatus.INFO, "Pre-Condition 1:", "User launched the application by entering valid URL.");
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		test.log(LogStatus.INFO, "Pre-Condition 2:", "Admin logged in.");
		screenShot.captureScreenShot("RETC_050_Pre-Condition2_Admin_Login_Success");
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void Functional_Test_RETC_050() throws Exception {
		String expectedResult = "prestige";
		propertiesTabPOM.clickOnProperties();
		test.log(LogStatus.INFO, "Test Step 1.", "Clicked on Properties tab");

		propertiesTabPOM.clickButtonAddNew();
		test.log(LogStatus.INFO, "Test Step 2.", "Clicked on Add New button");

		propertiesTabPOM.enterTitleTextBox("prestige");
		test.log(LogStatus.INFO, "Test Step 3.", "Entered valid credentials in Enter Title Here textbox");

		propertiesTabPOM.enterContentTextArea("home town");
		test.log(LogStatus.INFO, "Test Step 4.", "Entered valid credentials in textbox");

		addNewFeaturePOM.clickCheckboxInterior();
		test.log(LogStatus.INFO, "Test Step 5(i).", "Clicked on checkbox beside feature(Interior)");

		addNewFeaturePOM.clickCheckBoxBest();
		test.log(LogStatus.INFO, "Test Step 5(ii).", "Clicked on checkbox beside feature(Best)");

		addNewRegionPOM.clickCheckboxWestBangalore();
		test.log(LogStatus.INFO, "Test Step 6(i).", "Clicked on checkbox(WestBangalore) beside region");

		addNewRegionPOM.clickCheckboxElectronicCity();
		test.log(LogStatus.INFO, "Test Step 6(ii).", "Clicked on checkbox(ElectronicCity) beside region");

		addPropertyIntoTrashPOM.clickLinkMoveToTrash();
		test.log(LogStatus.INFO, "Test Step 7.", "Clicked on Move to Trash link");

		addPropertyIntoTrashPOM.clickLeaveButtonAlert();
		test.log(LogStatus.INFO, "Test Step 8.", "Clicked on Leave button");

		addPropertyIntoTrashPOM.clickLinkTrash();
		test.log(LogStatus.INFO, "Test Step 9.", " Clicked on Trash icon");

		String actualResult = addPropertyIntoTrashPOM.getTextTitle();

		if (expectedResult.equals(actualResult)) {
			test.log(LogStatus.PASS, "Test Passed", "Added property details is displayed in the Trash.");
		} else {
			test.log(LogStatus.FAIL, "Test Failed", "Added property details is not displayed in the Trash");
		}

		screenShot.captureScreenShot("RETC_050_Step9_Trash_Added_Property_Details");
		Assert.assertEquals(actualResult, expectedResult);
		report.endTest(test);
		report.flush();
	}

}
