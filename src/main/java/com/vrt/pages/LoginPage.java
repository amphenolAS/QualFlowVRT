/**
 * @author manoj.ghadei
 *
 */

package com.vrt.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.vrt.base.BaseClass;
import com.vrt.utility.TestUtilities;

//import io.qameta.allure.Step;

public class LoginPage extends BaseClass {

	// Main Login Page Element definition
	WebElement ProductName = null;
	WebElement MainLoginUID = null;
	WebElement MainLoginPW = null;
	WebElement MainLoginBtn = null;
	WebElement MainLoginCnclBtn = null;
	TestUtilities tu = new TestUtilities();
	
	private void initElements() {
		// LoginPage Page Element definition
		ProductName = driver.findElementByName("ValProbe RT System");
		MainLoginUID = driver.findElementByAccessibilityId("LoginIDTextBox");
		MainLoginPW = driver.findElementByAccessibilityId("PasswordTextBox");
		MainLoginBtn = driver.findElementByAccessibilityId("LoginButton");
		MainLoginCnclBtn = driver.findElementByAccessibilityId("CancelButton");
	}

	public LoginPage() throws IOException {
		super();
		initElements();
	}

	// Release memory
	public void resetWebElements() {
		ProductName = null;
		MainLoginUID = null;
		MainLoginPW = null;
		MainLoginBtn = null;
		MainLoginCnclBtn = null;
		//System.out.println("Login Page elements memory released");
	}

	/*----------------------
	Methods of Main Login Page
	------------------------*/

	// Launch of Main App with Login page...")
	public boolean Is_VRTAppLoginScreen_Displayed() {
		return IsElementEnabledStatus(MainLoginUID);
	}

	// Check the contents of the Main Login screen")
	public String AppName() {
		return FetchText(ProductName);
	}

	// Verify the User ID field presence...")
	public boolean UserIDFieldPresence() {
		return IsElementEnabledStatus(MainLoginUID);
	}

	// Enter User ID: {0}")
	public void EnterUserID(String UID) {
		//clickOn(MainLoginUID);
		ClearText(MainLoginUID);
		enterText(MainLoginUID, UID);
	}

	// Get the User ID field data...")
	public String GetTextUserIDField() {
		return FetchText(MainLoginUID);
	}

	// Verify the User PW field presence...")
	public boolean UserPWFieldPresence() {
		return IsElementEnabledStatus(MainLoginPW);
	}

	// Enter User PW: {0}")
	public void EnterUserPW(String PW) {
		ClearText(MainLoginPW);
		enterText(MainLoginPW, PW);
	}

	// Get the User PW field data...")
	public String GetTextUserPWField() {
		return FetchText(MainLoginPW);
	}

	// Verify the change User PW field active or not...")
	public boolean ChangePWCheckBoxEnableStatus() {
		WebElement MainLoginChgPWChckBx = driver.findElementByName("Change Password");
		return IsElementEnabledStatus(MainLoginChgPWChckBx);
	}

	// Click Change PW Checkbox...")
	public void ClickChangePWCheckbox() throws InterruptedException {
		WebElement MainLoginChgPWChckBx = driver.findElementByName("Change Password");
		clickOn(MainLoginChgPWChckBx);
		Thread.sleep(1000);
	}

	// Verify the LoginBtnEnablestatus...")
	public boolean LoginBtnEnablestatus() {
		return IsElementEnabledStatus(MainLoginBtn);
	}

	// Verify the LoginBtnPresence...")
	public boolean LoginBtnPresence() {
		return MainLoginBtn.isDisplayed();
	}

	// Click Login Btn...")
	public void ClickLoginBtn() throws InterruptedException {
		clickOn(MainLoginBtn);
		Thread.sleep(1000);
	}

	// click login button to navigate to MainHubPage
	public MainHubPage ClickonLoginBtn() throws InterruptedException, IOException {
		clickOn(MainLoginBtn);
		Thread.sleep(1000);
		return new MainHubPage();
	}

	// Verify the InvalidLoginAlertmsgPresence...")
	public boolean InvalidLoginAlertmsgPresence() {
		WebElement InvalidLoginMsg = driver.findElementByAccessibilityId("displayMessageTextBlock");
		return IsElementVisibleStatus(InvalidLoginMsg);
	}

	// Verify the NewPWFieldPresence...")
	public boolean NewPWFieldPresence() {
		WebElement MainLoginNewPWfield = driver.findElementByAccessibilityId("NewPasswordTextBox");
		return IsElementVisibleStatus(MainLoginNewPWfield);
	}

	// Enter User New PW: {0}")
	public void enterNewPW(String NewPW) {
		WebElement MainLoginNewPWfield = driver.findElementByAccessibilityId("NewPasswordTextBox");
		enterText(MainLoginNewPWfield, NewPW);
	}

	// Enter User Confirm New PW: {0}")
	public void enterConfNewPW(String NewCPW) {
		WebElement MainLoginConfNewPW = driver.findElementByAccessibilityId("ConfirmPasswordTextBox");
		enterText(MainLoginConfNewPW, NewCPW);
	}

	// Click New PW Save Btn...")
	public MainHubPage ClickNewPWSaveBtn() throws InterruptedException, IOException {
		WebElement MainLoginNewPWSaveBtn = driver.findElementByName("OK");
		clickOn(MainLoginNewPWSaveBtn);
		Thread.sleep(1000);

		return new MainHubPage();
	}

	// Verify the CancelBtnPresence...")
	public boolean CancelBtnPresence() {
		return IsElementEnabledStatus(MainLoginCnclBtn);
	}

	// Click Cancel Btn...")
	public void ClickCancelBtn() {
		clickOn(MainLoginCnclBtn);
	}

	// ChangeNewPW Operation...")
	public MainHubPage ChangeNewPW(String UID, String PW, String NPW) throws InterruptedException, IOException {
		EnterUserID(UID);
		EnterUserPW(PW);
		ClickChangePWCheckbox();
		ClickLoginBtn();
		Thread.sleep(1000);

		enterNewPW(NPW);
		enterConfNewPW(NPW);
		ClickNewPWSaveBtn();

		return new MainHubPage();
	}

	// ChangeNewPWwithoutPWCheckBox Operation...")
	public MainHubPage ChangeNewPWwithoutPWCheckBox(String UID, String PW, String NPW)
			throws InterruptedException, IOException {
		EnterUserID(UID);
		EnterUserPW(PW);
		// ClickChangePWCheckbox();
		ClickLoginBtn();
		Thread.sleep(1000);

		enterNewPW(NPW);
		enterConfNewPW(NPW);
		ClickNewPWSaveBtn();

		return new MainHubPage();
	}

//Login method for User OTHER THAN Kaye/411...")
	public MainHubPage Login(String UID, String PW) throws InterruptedException, IOException {
		EnterUserID(UID);
		EnterUserPW(PW);
		ClickLoginBtn();
		Thread.sleep(1000);

		return new MainHubPage();
	}

//Login method for invalid user
	public void InvalidLogin(String UID, String PW) throws InterruptedException {
		EnterUserID(UID);
		EnterUserPW(PW);
		ClickLoginBtn();
		Thread.sleep(1000);
	}

	// Login method for User OTHER THAN Kaye/411... to verify authentication
	// failures")
	public void AlertLogin(String UID, String PW) throws InterruptedException {
		EnterUserID(UID);
		EnterUserPW(PW);
		ClickLoginBtn();
		// Thread.sleep(1000);
	}

	// Login method using Kaye/411")
	public UserManagementPage DefaultLogin() throws InterruptedException, IOException {
		MainLoginUID.click();
		MainLoginUID.click();
		MainLoginUID.sendKeys("Kaye");
		MainLoginPW.sendKeys("411");
		MainLoginBtn.click();
		Thread.sleep(1000);

		return new UserManagementPage();
	}

	// Login method for User OTHER THAN Kaye/411...")
	public void LoginEntry(String UID, String PW) throws InterruptedException {
		
		EnterUserID(UID);
		EnterUserPW(PW);
	}

	// EnterNewPWtext operation...")
	public MainHubPage EnterNewPWtext(String NPW) throws InterruptedException, IOException {
		enterNewPW(NPW);
		enterConfNewPW(NPW);
		ClickNewPWSaveBtn();
		//tu.click_Close_alertmsg();
		return new MainHubPage();
	}

	// Login For Disable User accounts
	public void DisableUserLogin() throws InterruptedException {
		MainLoginUID.sendKeys("95");
		MainLoginPW.sendKeys("13");
		MainLoginBtn.click();
	}

	// ADMN196-Verify Reset pwd functionality for 1st AdminTest user
	public void FirstTest_AdminLogin() throws InterruptedException {
		MainLoginUID.sendKeys("202");
		MainLoginPW.sendKeys("2");
		MainLoginBtn.click();
		Thread.sleep(2000);
	}

	public void AfterReset_AdminLogin() throws InterruptedException {
		MainLoginUID.sendKeys("202");
		MainLoginPW.sendKeys("6");
		MainLoginBtn.click();
		Thread.sleep(2000);
	}

//For Deleted user Login 
	public void DeletedUserLogin() throws InterruptedException {
		MainLoginUID.sendKeys("38am");
		MainLoginPW.sendKeys("3");
		MainLoginBtn.click();
	}

	// Alert message for entering deleted users credentials
	public String Deleteduser_AlertMsg() {
		WebElement LogMsg = driver.findElementByAccessibilityId("displayMessageTextBlock");
		return FetchText(LogMsg);
	}

	public String AlertMsg() {
		WebElement LogMsg = driver.findElementByAccessibilityId("displayMessageTextBlock");
		return FetchText(LogMsg);
	}

	public String UserBlocked_PopUp_Msg() {
		WebElement LogMsg = driver.findElementByAccessibilityId("Content_String");
		return LogMsg.getAttribute("Name");
	}

	// Get the Sw version info from the About window on clicking About icon of the
	// bottom apps bar
	public String get_SWVersion_About_Text() throws InterruptedException {
		clickOn(ProductName);
		Actions ac = new Actions(driver);
		ac.contextClick().build().perform();
		// ac.contextClick().build().perform();

		WebElement bottomMenu_About_Icon = driver.findElementByAccessibilityId("AboutAppBarButton");
		clickOn(bottomMenu_About_Icon);
		Thread.sleep(500);
		WebElement SWVersion_About_info = driver.findElementByAccessibilityId("SoftwareVersion");

		String[] SWVer = FetchText(SWVersion_About_info).split(":");
		clickOn(ProductName);
		clickOn(ProductName);
		return SWVer[1];
	}

}
