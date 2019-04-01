package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;

public class RETC_047_Add_New_Feature_POM {
	private WebDriver driver;

	public RETC_047_Add_New_Feature_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "property_feature-add-toggle") // Locator to locate Add new Feature link in Feature section
	private WebElement linkAddNewFeature;

	@FindBy(id = "newproperty_feature") // Locator to locate Enter valid details in Text box in Property Feature
	private WebElement textboxNewPropertyFeature;

	@FindBy(id = "newproperty_feature_parent") // Locator to locate Select valid details in Parent Feature list box in
												// Property Feature
	private WebElement dropdownNewPropertyFeature;

	@FindBy(id = "property_feature-add-submit") // Locator to locate Add New Feature button
	private WebElement btnAddNewFeature;

	@FindBy(id = "in-property_feature-137") // Locator to locate check box beside created feature
	private WebElement chkboxBest;

	@FindBy(id = "in-property_feature-136") // Locator to locate check box beside created feature
	private WebElement chkboxInterior;

	public void clickLinkAddNewFeature() { // Method for Clicking on Add new Feature link in Feature section
		this.linkAddNewFeature.click();
	}

	public void enterTextboxNewPropertyFeature(String NewPropertyFeature) { // Method for Clicking on Add new Feature
																			// link in Feature section
		this.textboxNewPropertyFeature.sendKeys(NewPropertyFeature);
	}

	public void selectDropdownNewPropertyFeature() { // Method for Selecting valid details in Parent Feature list box
		this.dropdownNewPropertyFeature.click();
		Select sel = new Select(this.dropdownNewPropertyFeature);
		sel.selectByVisibleText("interior");
	}

	public void clickButtonAddNewFeature() { // Method for clicking on Add New Feature button
		this.btnAddNewFeature.click();
	}

	public void clickCheckboxInterior() { // Method for clicking on check box(Interior) beside created feature
		this.chkboxInterior.click();

	}

	public void clickCheckBoxBest() throws Exception { // Method for clicking on check box(Best) beside created feature
		this.chkboxBest.click();
		Thread.sleep(2000);
	}

	public void refreshPage() { // Method for refreshing web page
		driver.navigate().refresh();
	}
}
