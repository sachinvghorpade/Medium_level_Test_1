package com.training.functional.tests;

import java.io.FileInputStream;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
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
import com.training.pom.RETC_049_Reply_To_UserPost_By_Admin_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_049Test {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private RETC_049_Reply_To_UserPost_By_Admin_POM replyToUserByAdminPOM;
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
		replyToUserByAdminPOM = new RETC_049_Reply_To_UserPost_By_Admin_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		report = ExtentReportGenerator.generateReport();
		test = report.startTest("Test Case name: RETC_049Test");
		// open the browser
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Pre-Condition 1:", "User launched the application by entering valid URL.");
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		replyToUserByAdminPOM.clickOnPosts();
		replyToUserByAdminPOM.clickAdminPageLink("Add New");
		replyToUserByAdminPOM.enterTitleText("New Launch");
		replyToUserByAdminPOM.enterContentInTextArea("New project launch in Bangalore.");
		replyToUserByAdminPOM.clickButtonPublishOnAddNew();
		test.log(LogStatus.INFO, "Pre-Condition 2:", "admin has added New Launch Post");
		screenShot.captureScreenShot("RETC_049_Pre-Condition2_admin_added_New_Launch_Post");
		replyToUserByAdminPOM.moveMouserOverAdminIcon();
		replyToUserByAdminPOM.clickLogOutLink();

	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void Functional_Test_RETC_049() throws Exception {
		replyToUserByAdminPOM.clickBlogLink();
		test.log(LogStatus.INFO, "Test Step 1.", "Clicked on Blog Tab");

		replyToUserByAdminPOM.clickReadMoreLink();
		test.log(LogStatus.INFO, "Test Step 2.", "Clicked on Read More link of post added by admin");

		replyToUserByAdminPOM.enterUserComment("good");
		test.log(LogStatus.INFO, "Test Step 3.", "Entered valid details in Comment textbox");

		replyToUserByAdminPOM.enterUserName("Manzoor Mehadi");
		test.log(LogStatus.INFO, "Test Step 4(i).", "Entered User Name as Manzoor Mehadi ");
		replyToUserByAdminPOM.enterUserEmail("manzoormehadi26@gmail.com");
		test.log(LogStatus.INFO, "Test Step 4(ii).", "Entered User email as manzoormehadi26@gmail.com");
		replyToUserByAdminPOM.clickButtonPostCommentUser();
		test.log(LogStatus.INFO, "Test Step 4.", "Clicked on Post Comment button");
		screenShot.captureScreenShot("RETC_049_Step4_User_Post_Comment");

		replyToUserByAdminPOM.launchNewWindowAdminSite();
		test.log(LogStatus.INFO, "Test Step 5.", "Opened admin site in new window");

		loginPOM.sendUserName("admin");
		test.log(LogStatus.INFO, "Test Step 6.", "Entered valid credential in Username textbox");

		loginPOM.sendPassword("admin@123");
		test.log(LogStatus.INFO, "Test Step 7.", "Entered valid credential in Password textbox");

		loginPOM.clickLoginBtn();
		test.log(LogStatus.INFO, "Test Step 8.", "Clicked on Sign in button");

		replyToUserByAdminPOM.clickAdminCommentTab();
		test.log(LogStatus.INFO, "Test Step 9.", "Clicked on Comments tab");

		screenShot.captureScreenShot("RETC_049_Step9_Number_Of_Response_Before_Admin_Response");
		String beforeReponse = replyToUserByAdminPOM.getTextNoOfReponse();

		replyToUserByAdminPOM.mouseOverCommentRow();
		test.log(LogStatus.INFO, "Test Step 10.", "Mouse over the comment");

		replyToUserByAdminPOM.clickAdminPageLink("Reply");
		test.log(LogStatus.INFO, "Test Step 11.", "Clicked on Reply icon");

		replyToUserByAdminPOM.enterReplyContentAdmin("Ok");
		test.log(LogStatus.INFO, "Test Step 12.", "Entered valid details in comments textbox");

		replyToUserByAdminPOM.clickButtonReplyAdmin();
		test.log(LogStatus.INFO, "Test Step 13.", "Clicked on Reply button");

		replyToUserByAdminPOM.refreshWebPage();
		test.log(LogStatus.INFO, "Refresh Page.", "Refresh page to get incremented in Response icon of comment");

		String afterReponse = replyToUserByAdminPOM.getTextNoOfReponse();
		screenShot.captureScreenShot("RETC_049_Step13_Incremented_Number_Of_Response_After_Admin_Response");

		if ((afterReponse.compareToIgnoreCase(beforeReponse)) == 1) {
			test.log(LogStatus.PASS, "Test Passed", "Number is incremented in Response icon of comment");
		} else {
			test.log(LogStatus.FAIL, "Test Failed", "Number is not incremented in Response icon of comment");
		}
		Assert.assertNotSame(beforeReponse, afterReponse);

		report.endTest(test);
		report.flush();
	}

}
