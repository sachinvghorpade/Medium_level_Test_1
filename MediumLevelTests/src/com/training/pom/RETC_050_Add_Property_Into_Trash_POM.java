package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class RETC_050_Add_Property_Into_Trash_POM {
	private WebDriver driver;

	public RETC_050_Add_Property_Into_Trash_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Move to Trash") // Locator to locate Move to Trash link
	private WebElement linkMoveToTrash;

	@FindBy(css = ".trash") // Locator to locate Trash icon
	private WebElement linkTrash;

	@FindBy(xpath = "//table[1]/tbody[1]/tr[1]/td[1]") // Locator to locate added property details row
	private WebElement textTitle;

	public void clickLinkMoveToTrash() // Method for clicking on Move to Trash link
	{
		this.linkMoveToTrash.click();
	}

	public void clickLeaveButtonAlert() // Method for clicking on Leave button on Alert message
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void clickLinkTrash()// Method for clicking on Trash icon
	{
		this.linkTrash.click();
	}

	public String getTextTitle()// Method for for getting text for added property details
	{
		return this.textTitle.getText();
	}
}
