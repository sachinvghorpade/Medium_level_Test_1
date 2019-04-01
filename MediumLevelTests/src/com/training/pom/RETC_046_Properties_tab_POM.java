package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;

public class RETC_046_Properties_tab_POM {
	private WebDriver driver;

	public RETC_046_Properties_tab_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Properties')]") // Locator to locate Properties link
	private WebElement Properties;

	@FindBy(xpath = "//a[@class='page-title-action']") // Locator to locate Add New Button
	private WebElement btnAddNew;

	@FindBy(id = "title") // Locator to Locate the Enter Title Text box
	private WebElement enterTitleTextBox;

	@FindBy(xpath = "//body[@id='tinymce']") // Locator to Locate the Content Text Area
	private WebElement enterCotentTextArea;

	@FindBy(css = "input[id^='in-property_feature-']") // Locator to Locate check box beside added Feature of Features
														// section
	private WebElement chkboxFirstFeature;

	@FindBy(css = "input[id^='in-region-']") // Locator to locate check box beside added Region of Regions section
	private WebElement chkboxFirstRegion;

	@FindBy(id = "publish") // Locator to locate Publish Button
	private WebElement btnPublish;

	@FindBy(xpath = "//p[contains(text(),'Post published.')]") // Locator to locate message "Post published. View post"
	private WebElement messagePostPublished;

	public void clickOnProperties() { // Method for clicking on Properties link
		this.Properties.click();
	}

	public void clickButtonAddNew() throws Exception { // Method for clicking Add New Button
		this.btnAddNew.click();

	}

	public void enterTitleTextBox(String title) // Method for Entering valid credentials in Enter Title Here text box
	{
		this.enterTitleTextBox.clear();
		this.enterTitleTextBox.sendKeys(title);
	}

	public void enterContentTextArea(String content) throws Exception // Enter valid credentials in Content text Area
	{
		driver.switchTo().frame(0);
		this.enterCotentTextArea.clear();
		this.enterCotentTextArea.sendKeys(content);
		driver.switchTo().defaultContent();
	}

	public void selectChkBoxFirstFeature() { // Method for Clicking on check box beside added Feature of Features
												// section
		this.chkboxFirstFeature.click();
	}

	public void selectChkBoxFirstRegion() throws Exception { // Method for Clicking on check box beside added Region of
																// Regions section
		this.chkboxFirstRegion.click();
		Thread.sleep(2000);

	}

	public void clickButtonPublish() { // Method for clicking Publish Button
		this.btnPublish.click();
	}

	public String getTextMessagePostPublished() { // Method to get text message "Post published. View post" message
		return this.messagePostPublished.getText();
	}

}
