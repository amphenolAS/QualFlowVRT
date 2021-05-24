/**
 * @author ruchika.behura
 *
 */

package com.vrt.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.vrt.base.BaseClass;
import com.vrt.utility.TestUtilities;

import org.openqa.selenium.JavascriptExecutor;

public class UserManagementPage extends BaseClass {

	TestUtilities tu = new TestUtilities();
	// User Management element variable declaration definition
	WebElement UMHeaderText = null;
	WebElement PreferencesHeaderText = null;
	WebElement PoliciesHeaderText = null;
	WebElement NewUserUMBtn = null;
	WebElement UNUMField = null;
	WebElement UserIDUMField = null;
	WebElement PWUMField = null;
	WebElement ConPWUMField = null;
	WebElement TitleUMField = null;
	WebElement UserTypeUMDropDown = null;
	WebElement PhoneUMField = null;
	WebElement EmailUMField = null;
	WebElement DeleteUMBtn = null;
	WebElement UMAssetPriv = null;
	WebElement UMSetupPriv = null;
	WebElement UMQualPriv = null;
	WebElement UMCalPriv = null;
	WebElement SaveUMBtn = null;
	WebElement CancelUMBtn = null;
	WebElement AdminPriv = null;
	WebElement CreaeteEditAssetPriv = null;
	WebElement CreaeteEditSetupPriv = null;
	WebElement CreaeteEditEquipPriv = null;
	WebElement CreateReports = null;
	WebElement CreatePassFailTemplate = null;
	WebElement AuditTrail = null;
	WebElement RunQualification = null;
	WebElement DeleteAssets = null;
	WebElement DeleteSetup = null;
	WebElement DeleteEquipment = null;
	WebElement DeleteStudyFiles = null;
	WebElement EditPassFailTemplate = null;
	WebElement RunCalibration = null;
	WebElement CopyFilesReports = null;
	WebElement ArchiveData = null;
	WebElement ManualSync = null;
	WebElement CameraAccess = null;
	WebElement DeletePassFailTemplate = null;
	WebElement DisableCheckbox = null;
	WebElement UsersListButton = null;
	WebElement UMImgBtn = null;

	private void initElements() {
		// UserManagement Page Element definition
		UMHeaderText = driver.findElementByName("User Management");
		PreferencesHeaderText = driver.findElementByAccessibilityId("PreferencesButton");
		PoliciesHeaderText = driver.findElementByAccessibilityId("PoliciesButton");
		NewUserUMBtn = driver.findElementByAccessibilityId("NewUserButton");
		UNUMField = driver.findElementByAccessibilityId("NameTextBox");
		UserIDUMField = driver.findElementByAccessibilityId("UserIDTextBox");
		PWUMField = driver.findElementByAccessibilityId("PasswordTextBox");
		ConPWUMField = driver.findElementByAccessibilityId("ConfirmPasswordTextBox");
		TitleUMField = driver.findElementByAccessibilityId("EditableTextBox");
		UserTypeUMDropDown = driver.findElementByAccessibilityId("UserTypeComboBox");
		PhoneUMField = driver.findElementByAccessibilityId("PhoneTextBox");
		EmailUMField = driver.findElementByAccessibilityId("EmailTextBox");
		DeleteUMBtn = driver.findElementByName("Delete");
		UMImgBtn = driver.findElementByAccessibilityId("UserImage");
		UMAssetPriv = driver.findElementByAccessibilityId("AssetsPrivlegesCheckBox");
		UMSetupPriv = driver.findElementByAccessibilityId("SetupCreationCheckBox");
		UMQualPriv = driver.findElementByAccessibilityId("QualificationExecutionCheckBox");
		UMCalPriv = driver.findElementByAccessibilityId("CalibrationExecutionCheckBox");
		SaveUMBtn = driver.findElementByAccessibilityId("SaveButton");
		CancelUMBtn = driver.findElementByName("Cancel");

		// User Privilege element definition
		AdminPriv = driver.findElementByAccessibilityId("AdminCheckBox");
		CreaeteEditAssetPriv = driver.findElementByAccessibilityId("AssetsPrivlegesCheckBox");
		CreaeteEditSetupPriv = driver.findElementByAccessibilityId("SetupCreationCheckBox");
		CreaeteEditEquipPriv = driver.findElementByAccessibilityId("EquipmentPrivlegesCheckBox");
		CreateReports = driver.findElementByAccessibilityId("CreateReportsCheckBox");
		CreatePassFailTemplate = driver.findElementByAccessibilityId("CreateTemplateCheckBox");
		AuditTrail = driver.findElementByAccessibilityId("AuditViewPrintCheckBox");
		RunQualification = driver.findElementByAccessibilityId("QualificationExecutionCheckBox");
		DeleteAssets = driver.findElementByAccessibilityId("AssetDeleteCheckBox");
		DeleteSetup = driver.findElementByAccessibilityId("SetupDeleteCheckBox");
		DeleteEquipment = driver.findElementByAccessibilityId("EquipmentDeleteCheckBox");
		DeleteStudyFiles = driver.findElementByAccessibilityId("DeleteFilesReportsCheckBox");
		EditPassFailTemplate = driver.findElementByAccessibilityId("EditTemplateCheckBox");
		RunCalibration = driver.findElementByAccessibilityId("CalibrationExecutionCheckBox");
		CopyFilesReports = driver.findElementByAccessibilityId("CopyFilesReportsCheckBox");
		ArchiveData = driver.findElementByAccessibilityId("ArchiveDataCheckBox");
		ManualSync = driver.findElementByAccessibilityId("ManualSyncCheckBox");
		CameraAccess = driver.findElementByAccessibilityId("CamerAccessCheckbox");
		DeletePassFailTemplate = driver.findElementByAccessibilityId("DeleteTemplateCheckBox");
		DisableCheckbox = driver.findElementByAccessibilityId("DisableUserCheckBox");
		UsersListButton = driver.findElementByAccessibilityId("PrintUsersListButton");

	}

	UserManagementPage() throws IOException {
		super();
		initElements();
	}

	// Release memory
	public void resetWebElements() {
		UMHeaderText = null;
		PreferencesHeaderText = null;
		PoliciesHeaderText = null;
		NewUserUMBtn = null;
		UNUMField = null;
		UserIDUMField = null;
		PWUMField = null;
		ConPWUMField = null;
		TitleUMField = null;
		UserTypeUMDropDown = null;
		PhoneUMField = null;
		EmailUMField = null;
		DeleteUMBtn = null;
		UMAssetPriv = null;
		UMSetupPriv = null;
		UMQualPriv = null;
		UMCalPriv = null;
		SaveUMBtn = null;
		CancelUMBtn = null;
		AdminPriv = null;
		CreaeteEditAssetPriv = null;
		CreaeteEditSetupPriv = null;
		CreaeteEditEquipPriv = null;
		CreateReports = null;
		CreatePassFailTemplate = null;
		AuditTrail = null;
		RunQualification = null;
		DeleteAssets = null;
		DeleteSetup = null;
		DeleteEquipment = null;
		DeleteStudyFiles = null;
		EditPassFailTemplate = null;
		RunCalibration = null;
		CopyFilesReports = null;
		ArchiveData = null;
		ManualSync = null;
		CameraAccess = null;
		DeletePassFailTemplate = null;
		DisableCheckbox = null;
		UsersListButton = null;
		UMImgBtn = null;

	}

	/*----------------------
	Methods of UserManagement Page
	------------------------*/
	// Check if UserManagement page is displayed
	public boolean IsUMscreenDisplayed() {
		return IsElementEnabledStatus(UMHeaderText);
	}

	// Check if Preferences tab is Enabled
	public boolean IsPreferenceTab_Enabled() {
		return IsElementEnabledStatus(PreferencesHeaderText);
	}

	// Check if policies tab is Enabled
	public boolean IspoliciesTab_Enabled() {
		return IsElementEnabledStatus(PoliciesHeaderText);
	}

	public boolean IsNewUserBtnPresence() {
		return IsElementEnabledStatus(NewUserUMBtn);
	}

	// check if Save Button Enable
	public boolean IsSaveButtonEnable() {
		return IsElementEnabledStatus(SaveUMBtn);
	}

	// Click NewUser button
	public void ClickNewUser() {
		clickOn(NewUserUMBtn);
	}

	// Enter User Name text
	public void enterNewUserName(String NewUN) {
		ClearText(UNUMField);
		enterText(UNUMField, NewUN);
	}

	// Verify the User Name field presence...")
	public boolean UserNameFieldPresence() {
		return IsElementEnabledStatus(UNUMField);
	}

	// Verify the UserID Field presence...")
	public boolean UserIDFieldPresence() {
		return IsElementEnabledStatus(UserIDUMField);
	}

	// Verify the Password Field presence...")
	public boolean PassworFieldPresence() {
		return IsElementEnabledStatus(PWUMField);
	}

	// Verify the ConPassword Field presence...")
	public boolean ConPassworFieldPresence() {
		return IsElementEnabledStatus(ConPWUMField);
	}

	// Verify the Title Field presence...")
	public boolean TitleFieldPresence() {
		return IsElementEnabledStatus(TitleUMField);
	}

	// Verify the UserType Field presence...")
	public boolean UserTypeField_EnableState() {
		return IsElementEnabledStatus(UserTypeUMDropDown);
	}

	// Verify the Phone Field presence...")
	public boolean PhoneFieldPresence() {
		return IsElementEnabledStatus(PhoneUMField);
	}

	// Verify the Email Field presence...")
	public boolean EmailFieldPresence() {
		return IsElementEnabledStatus(EmailUMField);
	}

	// Verify the Email Field presence...")
	public boolean PrivillagecheckboxPresence() {
		return IsElementEnabledStatus(UMAssetPriv);
	}

	// Fetch User Name text
	public String GetUserNametext() {
		return FetchText(UNUMField);
	}

	// Enter User ID text
	public void enterNewUserID(String NewUID) {
		ClearText(UserIDUMField);
		enterText(UserIDUMField, NewUID);
	}

	// Fetch User ID text
	public String GetUserIDtext() {
		return FetchText(UserIDUMField);
	}

	// Enter PW text
	public void enterNewUserPW(String NewPW) {
		ClearText(PWUMField);
		enterText(PWUMField, NewPW);
	}

	//fetch PW text
	public String get_PWField_text() {
		return FetchText(PWUMField);
	}

	// Enter ConfirmPW text
	public void enterNewUserConfPW(String NewCPW) {
		ClearText(ConPWUMField);
		enterText(ConPWUMField, NewCPW);
	}

	// Enter Title text
	public void enterNewUserTitle(String Title) throws InterruptedException {
		ClearText(TitleUMField);
		enterText(TitleUMField, Title);
		Thread.sleep(1000);
	}

	// Fetch Title text
	public String get_UserTitle() {
		return FetchText(TitleUMField);
	}

	// Enter Title text
	public void ClickTitlefield() {
		clickOn(TitleUMField);
	}

	// Select UserType
	public void select_UserType(String Utype) throws InterruptedException {
		// System.out.println(Utype);
		clickOn(UserTypeUMDropDown);
		Thread.sleep(1000);
		WebElement UMAdministrator1 = driver.findElementByName("System Administrator");
		WebElement UMSupervisor = driver.findElementByName("Supervisor");
		WebElement UMOperator = driver.findElementByName("Operator");
		WebElement UMSelect1 = driver.findElementByName("Select");

		if (Utype.equals(UMSelect1.getText())) {
			clickOn(UMSelect1);
			Thread.sleep(500);
		} else if (Utype.equals(UMAdministrator1.getText())) {
			// SelectAdministrator();
			clickOn(UMAdministrator1);
			// Thread.sleep(500);
		} else if (Utype.equals(UMSupervisor.getText())) {
			clickOn(UMSupervisor);
			Thread.sleep(500);
		} else if (Utype.equals(UMOperator.getText())) {
			clickOn(UMOperator);
			Thread.sleep(500);
		}

	}

	// Click the UserType Drop down List
	public void ClickUserTypeDropDown() throws InterruptedException {
		clickOn(UserTypeUMDropDown);
		Thread.sleep(500);
	}

	// Select User image
	public void selectUserImg(String imgName) throws AWTException, IOException, InterruptedException {
		clickOn(UMImgBtn);
		WebElement ImgBrowseBtn = driver.findElementByAccessibilityId("BrowseImage");
		clickOn(ImgBrowseBtn);
		Thread.sleep(1000);
		tu.uploadDoc(imgName);
	}

	// Select Sys Admin from the UserType drop-down list
	public void SelectAdministrator() {
		WebElement UMAdministrator = driver.findElementByName("System Administrator");
		clickOn(UMAdministrator);
	}

	// Select Supervisor from the UserType drop-down list
	public void SelectSupervisor() {
		WebElement UMSupervisor = driver.findElementByName("Supervisor");
		clickOn(UMSupervisor);
	}

	// Select Operator from the UserType drop-down list
	public void SelectOperator() {
		WebElement UMOperator = driver.findElementByName("Operator");
		clickOn(UMOperator);
	}

	// Enter Phone text
	public void enterNewUserPhone(String Phone) {
		ClearText(PhoneUMField);
		enterText(PhoneUMField, Phone);
	}

	// Click Phone Filed
	public void ClickPhone() {
		clickOn(PhoneUMField);
	}

	// Enter email text
	public void enterNewUserEmail(String email) {
		ClearText(EmailUMField);
		enterText(EmailUMField, email);
	}

	// Click Save button
	public void ClickNewUserSaveButton() throws InterruptedException {
		clickOn(SaveUMBtn);
	}

	// Click Back Button to move to AdminTile
	public MainHubPage ClickBackButn() throws IOException {
		WebElement BackUMBtn = driver.findElementByAccessibilityId("BackButton");
		clickOn(BackUMBtn);
		return new MainHubPage();
	}
	
	
	// Click Userlist window of UM Page
	public void click_UsrLstBx() throws IOException {
		WebElement usrListBox = driver.findElementByAccessibilityId("UsersListBox");
		clickOn(usrListBox);
		
	}

	// Select/Click any User in the UserList Panel
	public void clickAnyUserinUserList(String UN) throws InterruptedException {
		List<WebElement> Userslist = driver.findElementByAccessibilityId("UsersListBox")
				.findElements(By.className("ListBoxItem"));
		// System.out.println("Total Number of Users created: " + Userslist.size());
		Userslist.get(0).click();

		for (int i = 0; i < Userslist.size(); i++) {

			String UNtext1 = GetUserNametext();
			// System.out.println(UNtext1);
			if (UNtext1.equalsIgnoreCase(UN)) {
				clickOn(UNUMField);
				break;
			} else {
				Actions ac = new Actions(driver);
				ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
			}
		}
	}

	// Click On All Checked boxes to customized the privileges
	public void Click_AllCheckBox() throws InterruptedException, AWTException {
		ClkscrollBar_up();
		clickOn(AdminPriv);
		clickOn(RunQualification);
		clickOn(RunCalibration);
		clickOn(CreaeteEditAssetPriv);
		clickOn(DeleteAssets);
		clickOn(CopyFilesReports);
		clickOn(CreaeteEditSetupPriv);
		clickOn(DeleteSetup);
		clickOn(ArchiveData);		
		clickOn(CreaeteEditEquipPriv);
		clickOn(DeleteEquipment);
		clickOn(ManualSync);
		clickOn(CreateReports);
		clickOn(DeleteStudyFiles);
		clickOn(CameraAccess);
		ClkscrollBar_down();
		clickOn(CreatePassFailTemplate);
		clickOn(EditPassFailTemplate);
		clickOn(DeletePassFailTemplate);
		clickOn(AuditTrail);
		// Thread.sleep(1000);
	}

	//Scroll down and click on AuditTrail user privilege checkbox
	public void ClkAuditTrail() throws InterruptedException, AWTException {

		WebElement scrollbar = driver.findElementByAccessibilityId("VerticalSmallIncrease");
		clickOn(scrollbar);
		clickOn(scrollbar);
		clickOn(scrollbar);

		clickOn(AuditTrail);
		Thread.sleep(500);

	}
	
	//Scroll Up and click 3 times
	public void ClkscrollBar_up() throws InterruptedException, AWTException {

		WebElement scrollbar = driver.findElementByAccessibilityId("VerticalSmallDecrease");
		clickOn(scrollbar);
		clickOn(scrollbar);
		clickOn(scrollbar);
	}

	//Scroll down and click 3 times
	public void ClkscrollBar_down() throws InterruptedException, AWTException {

		WebElement scrollbar = driver.findElementByAccessibilityId("VerticalSmallIncrease");
		clickOn(scrollbar);
		clickOn(scrollbar);
		clickOn(scrollbar);
	}

	// check/select Create/Edit Asset Privilege checkbox
	public void clickPrivCreateEditAsset() throws InterruptedException {
		clickOn(UMAssetPriv);
		Thread.sleep(1000);
	}

	// Verify if Create/Edit Asset Privilege checked/selected or not
	public boolean PrivCreateEditAssetgstatus() {
		return checkboxSelectStatus(UMAssetPriv);
	}

	// check/select Run Qual Privilege checkbox
	public void clickPrivRunQual() throws InterruptedException {
		clickOn(UMQualPriv);
		Thread.sleep(1000);
	}

	// Verify if Run Qual Privilege checked/selected or not
	public boolean PrivRunQualstatus() {
		return checkboxSelectStatus(UMQualPriv);
	}

	// check/select Create/Edit Setup Privilege checkbox
	public void clickPrivCreateEditSetup() throws InterruptedException {
		clickOn(UMSetupPriv);
		Thread.sleep(1000);
	}

	// Verify if Create/Edit Setup Privilege checked/selected or not
	public boolean PrivCreateEditSetupstatus() {
		return checkboxSelectStatus(UMSetupPriv);
	}

	// check/select Run Cal Privilege checkbox
	public void clickPrivRunCal() throws InterruptedException {
		clickOn(UMCalPriv);
		Thread.sleep(1000);
	}

	// Verify if Run Cal Privilege checked/selected or not
	public boolean PrivRunCalstatus() {
		return checkboxSelectStatus(UMCalPriv);
	}

	// Fetch the Save Alert message
	public String AlertMsg() {
		WebElement Msg = driver.findElementByAccessibilityId("displayMessageTextBlock");
		return FetchText(Msg);
	}

	// Is alert message visible
	public boolean Is_alertvisible() throws InterruptedException {
		WebElement alertMsg = driver.findElementByAccessibilityId("displayMessageTextBlock");
		return IsElementVisibleStatus(alertMsg);
	}

	// Close alert message if visible
	public void click_Close_alertmsg() throws InterruptedException {
		if (!IsElementVisibleStatus(driver.findElementByAccessibilityId("displayMessageTextBlock"))) {
			System.out.println("Buttom Appbar Alert message not displayed");
		} else {
			WebElement alertMsg_CloseBtn = driver.findElementByAccessibilityId("btnDelete");
			clickOn(alertMsg_CloseBtn);
		}
	}

	// Login Popup presence
	public boolean UserLoginPopupVisible() throws InterruptedException {
		WebElement LgInPopup = driver.findElementByName("Enter User Credentials");
		return IsElementVisibleStatus(LgInPopup);
	}

	// Click on the User Image Tile Button
	public void click_UserImageTile() throws InterruptedException {
		WebElement UserImgTileBtn = driver.findElementByAccessibilityId("UserImage");
		clickOn(UserImgTileBtn);
		// Thread.sleep(1000);
	}

	// Click the Browse button under User Image tile
	public void click_UploadBrowseBtn() throws InterruptedException {
		WebElement BrowseBtn = driver.findElementByAccessibilityId("BrowseButton");
		clickOn(BrowseBtn);
		Thread.sleep(1000);
	}

	// Click the Camera Icon under User Image tile
	public void click_CameraIcon() throws InterruptedException {
		WebElement CameraIcon = driver.findElementByAccessibilityId("CameraImage");
		clickOn(CameraIcon);
		// Thread.sleep(2000);
	}

	// Camera On Header Title is Visible ...
	public boolean IsCameracloseBtn_Enable() {
		WebElement CameraClose = driver.findElementByAccessibilityId("Close");
		return IsElementEnabledStatus(CameraClose);
	}

	// check/select Disable User CheckBox
	public void Select_DisableUserCheckBox() throws InterruptedException {
		clickOn(DisableCheckbox);
	}

	// public boolean CreaeteEditAssetPrivstatus() {
	public boolean IsDisableUserCheckBox_state() {
		return IsElementEnabledStatus(DisableCheckbox);
	}

	// Does it display the Save Alert message if a user disable his own account
	public boolean DisableAlertMsgVisible() throws InterruptedException {
		WebElement Dmsg = driver.findElementByName("Sorry, you cannot delete or disable the Logged in User Account");
		return IsElementVisibleStatus(Dmsg);
	}

	// Click on ok button in Alert message box if a user disable his own account
	public void click_okBtn() {
		WebElement ok = driver.findElementByAccessibilityId("Button0");
		clickOn(ok);
	}

	// Verify if Admin Privilege checked/selected or not
	public boolean Adminstatus() {
		return checkboxSelectStatus(AdminPriv);
	}

	// Verify if Create/Edit Equipment Privilege checked/selected or not
	public boolean CreateAndEditEquipmentstatus() {
		return checkboxSelectStatus(CreaeteEditEquipPriv);
	}

	// Verify if Create Reports Privilege checked/selected or not
	public boolean CreateReportsstatus() {
		return checkboxSelectStatus(CreateReports);
	}

	// Click on CreateReports
	public void CreateReports() {
		clickOn(CreateReports);
	}

	// Verify if Create Pass/Fail template Privilege checked/selected or not
	public boolean CreatePassFailtemplatestatus() {
		return checkboxSelectStatus(CreatePassFailTemplate);
	}

	// Verify if Audit trail template Privilege checked/selected or not
	public boolean Audittrailstatus() {
		return checkboxSelectStatus(AuditTrail);
	}

	// Verify if Delete Assets Privilege checked/selected or not
	public boolean DeleteAssetsstatus() {
		return checkboxSelectStatus(DeleteAssets);
	}

	// Verify if Delete Setup Privilege checked/selected or not
	public boolean DeleteSetupstatus() {
		return checkboxSelectStatus(DeleteSetup);
	}

	// Verify if Delete Equipment Privilege checked/selected or not
	public boolean DeleteEquipmentstatus() {
		return checkboxSelectStatus(DeleteEquipment);
	}

	// Verify if Delete Study Files/Reports Privilege checked/selected or not
	public boolean DeleteStudyFilesReportsstatus() {
		return checkboxSelectStatus(DeleteStudyFiles);
	}

	// Verify if Edit Pass/Fail template Privilege checked/selected or not
	public boolean EditPassFailtemplatestatus() {
		return checkboxSelectStatus(EditPassFailTemplate);
	}

	// Verify if Copy Files/Reports Privilege checked/selected or not
	public boolean CopyFilesReportsstatus() {
		return checkboxSelectStatus(CopyFilesReports);
	}

	// Verify if Archive data Privilege checked/selected or not
	public boolean Archivedatastatus() {
		return checkboxSelectStatus(ArchiveData);
	}

	// Verify if Camera Access Privilege checked/selected or not
	public boolean CameraAccessstatus() {
		return checkboxSelectStatus(CameraAccess);
	}

	// Verify if Manual Sync Privilege checked/selected or not
	public boolean ManualSyncstatus() {
		return checkboxSelectStatus(ManualSync);
	}

	// Verify if Delete pass/fail template Privilege checked/selected or not
	public boolean Deletepassfailtemplatestatus() {
		return checkboxSelectStatus(DeletePassFailTemplate);
	}

	// Verify if Create/Edit Asset Privilege checked/selected or not
	public boolean CreaeteEditAssetPrivstatus() {
		return checkboxSelectStatus(CreaeteEditAssetPriv);
	}

	// Click on the Create/Edit Asset Privilege Check Box
	public void Click_CreaeteEditAssetCheckBox() {
		clickOn(CreaeteEditAssetPriv);
	}

	// Verify if Create/Edit setup Privilege checked/selected or not
	public boolean CreaeteEditSetupstatus() {
		return checkboxSelectStatus(CreaeteEditSetupPriv);
	}

	// Verify if Run Qualification Privilege checked/selected or not
	public boolean RunQualificationstatus() {
		return checkboxSelectStatus(RunQualification);
	}

	// Verify if Run Calibration Privilege checked/selected or not
	public boolean RunCalibrationstatus() {
		return checkboxSelectStatus(RunCalibration);
	}

	// Click UsersListButton button
	public void ClickUsersListButton() {
		clickOn(UsersListButton);
	}

	// To open the user list pop up presence
	public boolean UserListOpenPopupvisible() throws InterruptedException {
		driver.switchTo().activeElement();
		Thread.sleep(1000);
		WebElement UserlistopenPopup = driver.findElementByAccessibilityId("HeadText");
		return IsElementVisibleStatus(UserlistopenPopup);
	}

	// Click on Delete button
	public void ClickDeletebtn() {
		clickOn(DeleteUMBtn);
	}

	// confirmation pop-up should be displayed for Delete user
	public boolean Delete_confirmationPopupvisible() throws InterruptedException {
		WebElement DeletePopup = driver.findElementByAccessibilityId("TitleBar");
		return IsElementVisibleStatus(DeletePopup);
	}

	// Click on "Yes" button from the delete confirmation pop-up
	public void Delete_ClickYesBtn() throws InterruptedException {
		WebElement Yesbtn = driver.findElementByAccessibilityId("Button1");
		clickOn(Yesbtn);
	}

	// Click on "No" button from the delete confirmation pop-up
	public void Delete_ClickNoBtn() throws InterruptedException {
		WebElement Nobtn = driver.findElementByAccessibilityId("Button0");
		clickOn(Nobtn);
	}

	/*
	 * // Deleted alert message visible public boolean Delete_alertvisible() throws
	 * InterruptedException { WebElement Deletealert =
	 * driver.findElementByAccessibilityId("displayMessageTextBlock"); return
	 * IsElementVisibleStatus(Deletealert); }
	 */

	// Click on the Search box and enter valid user name
	public void EnterdatainSearchBox(String entrUN) throws InterruptedException {
		WebElement SrchBox = driver.findElementByAccessibilityId("SearchTextBox");
		clickOn(SrchBox);
		enterText(SrchBox, entrUN);
	}

	// User1
	public boolean IsSearchNamevisible(String UN) throws InterruptedException {
		WebElement srchname = driver.findElementByName(UN);
		return IsElementEnabledStatus(srchname);
	}

	// Click cancel button
	public void ClickCancelBtn() {
		clickOn(CancelUMBtn);
	}

	public boolean Iscancelvisible() throws InterruptedException {
		return IsElementVisibleStatus(CancelUMBtn);
	}

	// Create First User of the System
	public LoginPage FirstUserCreation(String NewUN, String NewUID, String NewPW, String NewCPW, String Title,
			String Phone, String email) throws InterruptedException, IOException {
		ClickNewUser();
		enterNewUserName(NewUN);
		enterNewUserID(NewUID);
		enterNewUserPW(NewPW);
		enterNewUserConfPW(NewCPW);
		enterNewUserTitle(Title);
		enterNewUserPhone(Phone);
		enterNewUserEmail(email);
		ClickNewUserSaveButton();

		return new LoginPage();
	}

	// Create a New Admin User
	public void CreateAdminUser(String UID, String PW, String NewUN, String NewUID, String NewPW, String Title,
			String Phone, String email) throws InterruptedException {
		ClickNewUser();
		enterNewUserName(NewUN);
		enterNewUserID(NewUID);
		enterNewUserPW(NewPW);
		enterNewUserConfPW(NewPW);
		enterNewUserTitle(Title);
		ClickUserTypeDropDown();
		SelectAdministrator();
		enterNewUserPhone(Phone);
		enterNewUserEmail(email);
		ClickNewUserSaveButton();

		UserLoginPopup(UID, PW);

	}

	// Create a New Supervisor User
	public void CreateSupervisorUser(String UID, String PW, String NewUN, String NewUID, String NewPW, String Title,
			String Phone, String email) throws InterruptedException {
		ClickNewUser();
		enterNewUserName(NewUN);
		enterNewUserID(NewUID);
		enterNewUserPW(NewPW);
		enterNewUserConfPW(NewPW);
		enterNewUserTitle(Title);
		ClickUserTypeDropDown();
		SelectSupervisor();
		enterNewUserPhone(Phone);
		enterNewUserEmail(email);
		ClickNewUserSaveButton();

		UserLoginPopup(UID, PW);

	}

	// Create a New Operator User
	public void CreateOperatorUser(String UID, String PW, String NewUN, String NewUID, String NewPW, String Title,
			String Phone, String email) throws InterruptedException {
		ClickNewUser();
		enterNewUserName(NewUN);
		enterNewUserID(NewUID);
		enterNewUserPW(NewPW);
		enterNewUserConfPW(NewPW);
		enterNewUserTitle(Title);
		ClickUserTypeDropDown();
		SelectOperator();
		enterNewUserPhone(Phone);
		enterNewUserEmail(email);
		ClickNewUserSaveButton();

		UserLoginPopup(UID, PW);

	}

	// User Management Creation with Mandatory fields
	public void UMCreation_MandatoryFields(String UName, String UID, String Pwd, String Titl, String Utype)
			throws InterruptedException {
		enterNewUserName(UName);
		enterNewUserID(UID);
		enterNewUserPW(Pwd);
		enterNewUserConfPW(Pwd);
		enterNewUserTitle(Titl);
		select_UserType(Utype);
		Thread.sleep(1000);
		ClickNewUserSaveButton();
	}

	// Checking Admin Privileges Without saving the data
	public void UMPrivilages(String UName, String UID, String Pwd, String Cpwd, String Titl, String Utype)
			throws InterruptedException {
		enterNewUserName(UName);
		enterNewUserID(UID);
		enterNewUserPW(Pwd);
		enterNewUserConfPW(Cpwd);
		enterNewUserTitle(Titl);
		select_UserType(Utype);
		Thread.sleep(1000);
	}

	// User Management Creation with Non Mandatory fields
	public void UMCreation_NonmandatoryFields(String UName, String UID, String Pwd, String Cpwd, String Titl,
			String Utype, String phno, String Emil) throws InterruptedException {
		enterNewUserName(UName);
		enterNewUserID(UID);
		enterNewUserPW(Pwd);
		enterNewUserConfPW(Cpwd);
		enterNewUserTitle(Titl);
		select_UserType(Utype);
		enterNewUserPhone(phno);
		enterNewUserEmail(Emil);
		Thread.sleep(1000);
		ClickNewUserSaveButton();
	}

	// Checking save button is Disable before entering password field in
	// UserManagement Creation screen
	public void UM_SaveBtnVerification(String UName, String UID, String pwd, String Cpwd, String Titl, String Utype)
			throws InterruptedException {
		enterNewUserName(UName);
		enterNewUserID(UID);
		enterNewUserPW(pwd);
		enterNewUserConfPW(Cpwd);
		enterNewUserTitle(Titl);
		select_UserType(Utype);
		ClickNewUserSaveButton();

	}

	// User Management Creation with ALL fields
	public void UMCreation_AllFields(String UName, String UID, String Pwd, String Title, String Utype, String phno,
			String Email, String ImageName) throws InterruptedException, AWTException, IOException {
		enterNewUserName(UName);
		enterNewUserID(UID);
		enterNewUserPW(Pwd);
		enterNewUserConfPW(Pwd);
		enterNewUserTitle(Title);
		select_UserType(Utype);
		enterNewUserPhone(phno);
		enterNewUserEmail(Email);
		selectUserImg(ImageName);
		Thread.sleep(500);
		ClickNewUserSaveButton();
	}
	
	// User Management Creation with ALL fields
	public void UMCreation_mxUsers(String UName, String UID, String Pwd, String Title, String Utype, String phno,
			String Email, String ImageName) throws InterruptedException, AWTException, IOException {
		enterNewUserName(UName);
		enterNewUserID(UID);
		enterNewUserPW(Pwd);
		enterNewUserConfPW(Pwd);
		enterNewUserTitle(Title);
		select_UserType(Utype);
		//enterNewUserPhone(phno);
		//enterNewUserEmail(Email);
		//selectUserImg(ImageName);
		Thread.sleep(500);
		ClickNewUserSaveButton();
	}

}
