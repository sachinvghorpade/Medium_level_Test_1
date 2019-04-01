package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RETC_048_Add_New_Region_POM {
	private WebDriver driver;

	public RETC_048_Add_New_Region_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "region-add-toggle") // Locator to locate Add new Region link in Feature section
	private WebElement linkAddNewRegion;

	@FindBy(id = "newregion") // Locator to locate text box to enter valid region details
	private WebElement textboxNewPropertyRegion;

	@FindBy(id = "newregion_parent") // Locator to locate Parent Region list box
	private WebElement dropdownNewPropertyRegion;

	@FindBy(id = "region-add-submit") // Locator to locate Add New Region button
	private WebElement btnAddNewRegion;

	@FindBy(id = "in-region-54") // Locator to locate check box (WestBangalore) beside created region
	private WebElement chkboxWestBangalore;

	@FindBy(id = "in-region-154") // Locator to locate check box (ElectronicCity) beside created region
	private WebElement chkboxElectronicCity;

	public void clickLinkAddNewRegion() { // Method for clicking Add new Region link in Feature section
		this.linkAddNewRegion.click();
	}

	public void enterTextboxNewPropertyRegione(String NewPropertyRegion) { // Method for entering valid region details
																			// to text box
		this.textboxNewPropertyRegion.sendKeys(NewPropertyRegion);
	}

	public void selectDropdownNewPropertyRegion() { // Method for selecting valid details in
													// Parent Region list box
		this.dropdownNewPropertyRegion.click();
		Select sel = new Select(this.dropdownNewPropertyRegion);
		sel.selectByValue("54");
	}

	public void clickButtonAddNewRegion() { // Method for clicking on Add New Region button
		this.btnAddNewRegion.click();
	}

	public void clickCheckboxWestBangalore() { // Method for clicking check box (WestBangalore) beside created region
		this.chkboxWestBangalore.click();
	}

	public void clickCheckboxElectronicCity() throws Exception { // Method for Clicking check box (ElectronicCity)
																	// beside created region
		this.chkboxElectronicCity.click();
		Thread.sleep(2000);
	}

	public void refreshPage() { // Method for Refreshing web page
		driver.navigate().refresh();
	}

}
