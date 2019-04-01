package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_049_Reply_To_UserPost_By_Admin_POM {
	private WebDriver driver;

	public RETC_049_Reply_To_UserPost_By_Admin_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Posts')]") // Locator to locate Posts link
	private WebElement posts;

	@FindBy(id = "title") // Locator to locate 'title here' text box
	private WebElement enterTitleText;

	@FindBy(id = "tinymce") // Locator to locate 'body text box' text box
	private WebElement enterContentInTextArea;

	@FindBy(id = "publish") // Locator to locate 'Publish' button
	private WebElement btnPublish;

	@FindBy(xpath = "//a[contains(text(),'Howdy,')]") // Locator to locate Admin icon before logout
	private WebElement adminIcon;

	@FindBy(xpath = "//a[@class='ab-item'][contains(text(),'Log Out')]") // Locator to locate logout link
	private WebElement linkLogOut;

	@FindBy(id = "menu-item-617") // Locator to locate Blog Tab
	private WebElement linkBlog;

	@FindBy(css = "div[id^='post-'] a.read-more") // Locator to locate Read More link of post added by admin
	private WebElement readMoreLink;

	@FindBy(id = "comment") // Locator to locate comment text box
	private WebElement userCommentTextArea;

	@FindBy(id = "author") // Locator to locate author of the post
	private WebElement userNameTextBox;

	@FindBy(id = "email") // Locator to locate email text box
	private WebElement userEmailTextBox;

	@FindBy(id = "submit") // Locator to locate post Comment button
	private WebElement btnPostUserComment;

	@FindBy(xpath = "//div[contains(text(),'Comments')]") // Locator to locate comments tab
	private WebElement tabAdminComment;

	@FindBy(id = "replycontent") // Locator to locate comments text box by admin
	private WebElement textareaReplyContentAdmin;

	@FindBy(id = "replybtn") // Locator to locate reply icon by admin
	private WebElement btnReplyAdmin;

	@FindBy(xpath = "//table[1]/tbody[1]/tr[1]") // Locator to locate to reply user's comments
	private WebElement mouseOverIdentifiedRow;

	@FindBy(xpath = "//table[1]/tbody[1]/tr[1]/td[3]/div[1]/span[1]/a[1]/span[1]") // Locator to locate Response icon of
																					// comment
	private WebElement textNoOfReponse;

	@FindBy(tagName = "body") // Locator for opening new window
	private WebElement openNewWindow;

	public void clickOnPosts() { // Method for clicking on Posts link
		this.posts.click();
	}

	public void clickAdminPageLink(String adminPageLinkText) { // Method for clicking any hyper link on admin page
		driver.findElement(By.linkText(adminPageLinkText)).click();
	}

	public void clickUserPageLinkText(String userPageLinkText) { // Method for clicking any hyper link on user page
		driver.findElement(By.linkText(userPageLinkText)).click();
	}

	public void enterTitleText(String textToEnter) { // Method for entering credentials in Enter title here text box
		this.enterTitleText.clear();
		this.enterTitleText.sendKeys(textToEnter);
	}

	public void enterContentInTextArea(String contentToEnter) throws Exception { // Method for entering credentials in
		driver.switchTo().frame(0); // body text box
		this.enterContentInTextArea.clear();
		this.enterContentInTextArea.sendKeys(contentToEnter);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);

	}

	public void clickButtonPublishOnAddNew() throws Exception { // Method for clicking on Publish button
		this.btnPublish.click();
		Thread.sleep(4000);
	}

	public void moveMouserOverAdminIcon() throws Exception {// Method for mouse over to admin icon
		Actions act = new Actions(driver);
		act.moveToElement(this.adminIcon).build().perform();

	}

	public void clickLogOutLink() { // Method for clicking on logout link for admin
		this.linkLogOut.click();
	}

	public void clickBlogLink() { // Method for clicking on Blog link
		this.linkBlog.click();
	}

	public void clickReadMoreLink() { // Method for clicking on Read More link for usern
		this.readMoreLink.click();
	}

	public void enterUserComment(String textToEnter) { // Method for entering user comments in User Comments text area
		this.userCommentTextArea.clear();
		this.userCommentTextArea.sendKeys(textToEnter);
	}

	public void enterUserName(String textToEnter) { // Method for entering User name in UserName text box
		this.userNameTextBox.clear();
		this.userNameTextBox.sendKeys(textToEnter);
	}

	public void enterUserEmail(String textToEnter) { // Method for entering email id in email
		this.userEmailTextBox.clear();
		this.userEmailTextBox.sendKeys(textToEnter);
	}

	public void clickButtonPostCommentUser() throws Exception { // Method for clicking the Post User comments button
		this.btnPostUserComment.click();
	}

	public void launchNewWindowAdminSite() throws Exception { // Method for opening new browser for admin
		this.openNewWindow.sendKeys(Keys.chord(Keys.CONTROL, "n"));
		driver.get("http://realestate.upskills.in/wp-admin/");

	}

	public void clickAdminCommentTab() { // Method for entering comments by admin in comments text box
		this.tabAdminComment.click();
	}

	public void enterReplyContentAdmin(String textToEnter) { // Method for entering reply by admin in the Reply Content
																// text box
		this.textareaReplyContentAdmin.clear();
		this.textareaReplyContentAdmin.sendKeys(textToEnter);
	}

	public void mouseOverCommentRow() {// Method to mouse over to enter by admin
		Actions act = new Actions(driver);
		act.moveToElement(mouseOverIdentifiedRow).build().perform();
	}

	public void clickButtonReplyAdmin() throws Exception { // Method for clicking Reply button by admin
		this.btnReplyAdmin.click();
		Thread.sleep(4000);
	}

	public String getTextNoOfReponse() { // Method for getting no. of response
		return this.textNoOfReponse.getText();
	}

	public void refreshWebPage() // Method to refresh web page in order to get updated no. of response for post
	{
		driver.navigate().refresh();
	}

}
