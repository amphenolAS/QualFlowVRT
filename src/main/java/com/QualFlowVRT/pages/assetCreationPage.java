/**
* @author manoj.ghadei
*
*/

package com.QualFlowVRT.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.QualFlowVRT.base.BaseClass;
import com.QualFlowVRT.utility.TestUtilities;

public class assetCreationPage extends BaseClass {

	// Asset Details Page Element definition
	WebElement CreateAssetPageTitle = null;
	WebElement AssetNameTxtBox = null;
	WebElement AssetIDTxtBox = null;
	List<WebElement> Combobx = null;
	// List <WebElement> Combobx = null;
	List<WebElement> AssetEditBox = null;
	WebElement AssetModelTxtBox = null;
	WebElement AssetSizeTxtBox = null;
	WebElement AssetLstVldtdDate = null;
	WebElement AssetFrqBtn = null;
	WebElement AssetFrqIntrvlBtn = null;
	WebElement AssetDescTextField = null;
	WebElement AssetImgBrowseBtn = null;
	WebElement AssetImg1_Btn = null;
	WebElement AssetImg2_Btn = null;
	WebElement AssetImg3_Btn = null;
	WebElement AssetImg_Camera_Btn = null;
	WebElement AssetSaveBtn = null;
	WebElement AssetClearBtn = null;
	WebElement AssetBackBtn = null;

	private void initElements() {
		// LoginPage Page Element definition
		CreateAssetPageTitle = driver.findElementByAccessibilityId("pageTitle");
		AssetNameTxtBox = driver.findElementByAccessibilityId("NameTextBox");
		AssetIDTxtBox = driver.findElementByAccessibilityId("EqidTextBox");
		Combobx = driver.findElementsByAccessibilityId("EditableCombo");
		// List <WebElement> Combobx =
		// driver.findElementsByAccessibilityId("EditableCombo");
		AssetEditBox = driver.findElementsByAccessibilityId("EditableTextBox");
		AssetModelTxtBox = driver.findElementByAccessibilityId("ModelTextBox");
		AssetSizeTxtBox = driver.findElementByAccessibilityId("SizeTextBox");
		AssetLstVldtdDate = driver.findElementByAccessibilityId("PART_PickerButton");
		AssetFrqBtn = driver.findElementByAccessibilityId("CalibrationFrequencyComboBox");
		AssetFrqIntrvlBtn = driver.findElementByAccessibilityId("CalibrationFrequencyMeasurementComboBox");
		AssetDescTextField = driver.findElementByAccessibilityId("DescriptionTextBox");
		AssetImgBrowseBtn = driver.findElementByAccessibilityId("AssetImageButton");
		AssetImg1_Btn = driver.findElementByAccessibilityId("AssetImage1");
		AssetImg2_Btn = driver.findElementByAccessibilityId("AssetImage2");
		AssetImg3_Btn = driver.findElementByAccessibilityId("AssetImage3");
		AssetImg_Camera_Btn = driver.findElementByAccessibilityId("AssertCameraUploadButton");
		AssetSaveBtn = driver.findElementByName("Save");
		AssetClearBtn = driver.findElementByName("Clear");
		AssetBackBtn = driver.findElementByAccessibilityId("BackButton");
	}

	public assetCreationPage() throws IOException {
		super();
		initElements();
	}

	// Release memory
	public void resetWebElements() {
		CreateAssetPageTitle = null;
		AssetNameTxtBox = null;
		AssetIDTxtBox = null;
		Combobx = null;
		AssetEditBox = null;
		AssetModelTxtBox = null;
		AssetSizeTxtBox = null;
		AssetLstVldtdDate = null;
		AssetFrqBtn = null;
		AssetFrqIntrvlBtn = null;
		AssetDescTextField = null;
		AssetImgBrowseBtn = null;
		AssetImg1_Btn = null;
		AssetImg2_Btn = null;
		AssetImg3_Btn = null;
		AssetImg_Camera_Btn = null;
		AssetSaveBtn = null;
		AssetClearBtn = null;
		AssetBackBtn = null;
	}

	// Verify the presence of New Asset Creation text
	public boolean newAssetCreatePagetitle() {
		return IsElementVisibleStatus(CreateAssetPageTitle);
	}

	// Get the Asset Creation page title text
	public String get_newAssetCreatePagetitle() {
		return FetchText(CreateAssetPageTitle);
	}

	// Enter Asset Name
	public void enterAssetName(String AN) {
		ClearText(AssetNameTxtBox);
		enterText(AssetNameTxtBox, AN);
	}

	// Fetch the Asset Name text
	public String getAssetName() {
		return FetchText(AssetNameTxtBox);
	}

	// Enter Asset ID
	public void enterAssetID(String AID) {
		ClearText(AssetIDTxtBox);
		enterText(AssetIDTxtBox, AID);
	}

	// Fetch the Asset/Eqp ID text
	public String getEqpID() {
		return FetchText(AssetIDTxtBox);
	}

	// Fetch default Asset Type data
	public String getAssetTypetext() {
		return AssetEditBox.get(0).getText();
	}

	// Fetch list of raw Asset location data as is viewed
	public String[] getAssetLocationlist() {
		clickOn(Combobx.get(1));
		List<WebElement> Combobxlist = driver.findElementsByClassName("ComboBoxItem");

		String str[] = new String[Combobxlist.size()];

		for (int i = 0; i < Combobxlist.size(); i++) {
			str[i] = Combobxlist.get(i).getText();
		}

		String[] Obtainedlist = removeDuplicateStringinArray(str, "Select");
		System.out.println(Arrays.toString(Obtainedlist));

		clickOn(AssetModelTxtBox);
		System.out.println("---------");
		return Obtainedlist;
	}

	// Fetch list of raw Asset Type data as is viewed
	public String[] getAssetTypelist() {
		clickOn(Combobx.get(0));
		List<WebElement> Combobxlist = driver.findElementsByClassName("ComboBoxItem");

		String str[] = new String[Combobxlist.size()];

		for (int i = 0; i < Combobxlist.size(); i++) {
			str[i] = Combobxlist.get(i).getText();
		}

		String[] Obtainedlist = removeDuplicateStringinArray(str, "Select");
		System.out.println(Arrays.toString(Obtainedlist));

		clickOn(AssetModelTxtBox);
		System.out.println("---------");
		return Obtainedlist;
	}

	// Fetch list of Asset Type data in sorted order(Alphabetically)
	public String[] getAssetTypeSortedlist() {
		clickOn(Combobx.get(0));
		List<WebElement> Combobxlist = driver.findElementsByClassName("ComboBoxItem");

		String str[] = new String[Combobxlist.size()];

		for (int i = 0; i < Combobxlist.size(); i++) {
			str[i] = Combobxlist.get(i).getText();
		}

		// Remove the duplicate element from the Array list(Here Select string element
		// in our case)
		String[] Sortedlist = removeDuplicateStringinArray(str, "Select");

		// Sort method used to order the Strings
		Arrays.sort(Sortedlist);
		clickOn(AssetModelTxtBox);
		return Sortedlist;
	}

	// Select Asset Type
	public void SelectAssetType(String AType) {
		clickOn(Combobx.get(0));
		clickOn(driver.findElementByName(AType));
	}

	// Enter Asset Type
	public void enterAssetType(String Atype) {
		clickOn(AssetEditBox.get(0));
		// ClearText(AssetEditBox.get(0));
		AssetEditBox.get(0).sendKeys(Atype);
	}

	// Get Asset Type
	public String get_AssetType() {
		return FetchText(AssetEditBox.get(0));
	}

	// Enter Manufacturer Name
	public void enterManufacturerName(String AMN) throws InterruptedException {
		clickOn(AssetEditBox.get(3));
		ClearText(AssetEditBox.get(3));
		enterText(AssetEditBox.get(3), AMN);
		Thread.sleep(1000);
	}

	// Fetch default Asset Manufacturer data
	public String getAssetManufacturertext() {
		return FetchText(AssetEditBox.get(3));
	}

	// Fetch list of raw Asset Manufacturer data as is viewed
	public String[] getAssetMakerlist() {
		clickOn(Combobx.get(3));
		List<WebElement> Combobxlist = driver.findElementsByClassName("ComboBoxItem");

		String str[] = new String[Combobxlist.size()];

		for (int i = 0; i < Combobxlist.size(); i++) {
			str[i] = Combobxlist.get(i).getText();
		}

		String[] Obtainedlist = removeDuplicateStringinArray(str, "Select");
		// System.out.println(Arrays.toString(Obtainedlist));

		clickOn(AssetSizeTxtBox);
		// System.out.println("---------");
		return Obtainedlist;
	}

	// Fetch list of Asset Manufacturer data in sorted order(Alphabetically)
	public String[] getAssetMakerSortedlist() {
		clickOn(Combobx.get(3));
		List<WebElement> Combobxlist = driver.findElementsByClassName("ComboBoxItem");

		String str[] = new String[Combobxlist.size()];

		for (int i = 0; i < Combobxlist.size(); i++) {
			str[i] = Combobxlist.get(i).getText();
		}

		// Remove the duplicate element from the Array list(Here Select string element
		// in our case)
		String[] Sortedlist = removeDuplicateStringinArray(str, "Select");

		// Sort method used to order the Strings
		Arrays.sort(Sortedlist);
		clickOn(AssetSizeTxtBox);
		return Sortedlist;
	}

	// Enter Location
	public void enterLocation(String AL) throws InterruptedException {
		clickOn(AssetEditBox.get(1));
		ClearText(AssetEditBox.get(1));
		enterText(AssetEditBox.get(1), AL);
		Thread.sleep(500);
	}

	// Fetch default Asset Location data
	public String getAssetLocationtext() {
		return FetchText(AssetEditBox.get(1));
	}

	// Enter Model
	public void enterModelName(String AModel) {
		ClearText(AssetModelTxtBox);
		enterText(AssetModelTxtBox, AModel);
	}

	// Fetch default Asset Model data
	public String getAssetModeltext() {
		return FetchText(AssetModelTxtBox);
	}

	// Enter Asset Size & Unit
	public void enterSize_Unit(String ASize, String ASUnit) {
		// System.out.println("~~~"+ASize);
		ClearText(AssetSizeTxtBox);
		enterText(AssetSizeTxtBox, ASize);
		enterAssetSizeUnit(ASUnit);
	}

	// Enter Asset Size
	public void enterSize_Unit1(String ASize, String ASUnit) {
		// System.out.println("~~~"+ASize);
		clickOn(AssetSizeTxtBox);
		clickOn(AssetSizeTxtBox);
		ClearText(AssetSizeTxtBox);
		enterText(AssetSizeTxtBox, ASize);
		selectAssetSizeUnit(ASUnit);
	}

	// Fetch default Asset Size data
	public String getAssetSizetext() {
		return FetchText(AssetSizeTxtBox);
	}

	// Fetch default Asset Size Unit data
	public String getAssetSizeUnittext() {
		return AssetEditBox.get(2).getText();
	}

	// Enter Asset Size Unit data
	public void enterAssetSizeUnit(String ASizeUnit) {
		clickOn(AssetEditBox.get(2));
		ClearText(AssetEditBox.get(2));
		AssetEditBox.get(2).sendKeys(ASizeUnit);
	}

	// Select Asset Size Unit data from CuM/Ft/in
	public void selectAssetSizeUnit(String ASizeUnit) {
		clickOn(Combobx.get(2));
		List<WebElement> CombobxItemList = driver.findElementsByClassName("ComboBoxItem");
		for (WebElement unit : CombobxItemList) {
			if (unit.getText().equals(ASizeUnit)) {
				unit.click();
			}
		}
	}

	// CLick on the Asset Validation date Picker button
	public void click_AsstValidationDatePkr_Btn() {
		clickOn(AssetLstVldtdDate);
	}

	// Fetch Asset Validation date data
	public String getAsstValidationDatetext() {
		return FetchText(AssetLstVldtdDate);
	}

	// Select Asset Last Validate Day data other than current Day
	public void selectAssetLastVldtDay(String Day) throws InterruptedException {

		// click_AsstValidationDatePkr_Btn();
		Actions ac = new Actions(driver);

		for (int i = 1; i <= 31; i++) {
			String Date = getAsstValidationDatetext();
			// System.out.println(Date);

			// The below splitting code is defined, because the date format varies
			// system to system where its displayed as mm-dd-yyyy or mm/dd/yyyy
			if (Date.contains("-")) {
				String[] expDate = Date.split("-");
				// System.out.println(expDate[1]);

				if (expDate[1].equals(Day)) {
					break;
				} else {
					click_AsstValidationDatePkr_Btn();
					ac.sendKeys(Keys.ARROW_UP).sendKeys(Keys.RETURN).build().perform();
					Thread.sleep(500);
				}

			} else {
				String[] expDate = Date.split("/");
				// System.out.println(expDate[1]);

				if (expDate[1].equals(Day)) {
					break;
				} else {
					click_AsstValidationDatePkr_Btn();
					ac.sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_UP).sendKeys(Keys.RETURN).build().perform();
					Thread.sleep(500);
				}
			}
		}
	}

	// Select Asset Last Validate Month data other than current Month
	public void selectAssetLastVldt_Mnth(String Month) throws InterruptedException {

		// click_AsstValidationDatePkr_Btn();
		Actions ac = new Actions(driver);

		for (int i = 1; i <= 12; i++) {
			String Date = getAsstValidationDatetext();

			// The below splitting code is defined, because the date format varies
			// system to system where its displayed as mm-dd-yyyy or mm/dd/yyyy
			if (Date.contains("-")) {
				String[] expDate = Date.split("-");
				// System.out.println(expDate[0]);

				if (expDate[0].equals(Month)) {
					break;
				} else {
					click_AsstValidationDatePkr_Btn();
					ac.sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_UP).sendKeys(Keys.RETURN).build().perform();
					Thread.sleep(500);
				}

			} else {
				String[] expDate = Date.split("/");
				// System.out.println(expDate[0]);

				if (expDate[0].equals(Month)) {
					break;
				} else {
					click_AsstValidationDatePkr_Btn();
					ac.sendKeys(Keys.ARROW_UP).sendKeys(Keys.RETURN).build().perform();
					Thread.sleep(500);
				}
			}
		}
	}

	// Select Asset Last Validate Year data other than current Month
	public void selectAssetLastVldt_Yr(String Yr) throws InterruptedException {

		// click_AsstValidationDatePkr_Btn();
		Actions ac = new Actions(driver);
		String Date = getAsstValidationDatetext();
		String expDate = Date.substring(Date.length() - 4);
		// String[] expDate = Date.split("/");
		// System.out.println(expDate);

		while (!expDate.equals(Yr)) {
			click_AsstValidationDatePkr_Btn();
			Thread.sleep(500);
			ac.sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_UP).sendKeys(Keys.RETURN)
					.build().perform();
			Thread.sleep(500);
			Date = getAsstValidationDatetext();
			expDate = Date.substring(Date.length() - 4);
			// System.out.println(expDate);
		}
	}

	public void selectAssetLastVldDate(String Day, String Month, String Year) throws InterruptedException {
		selectAssetLastVldt_Yr(Year);
		selectAssetLastVldt_Mnth(Month);
		selectAssetLastVldtDay(Day);
	}

	// Fetch list of raw Asset Frequency data as is viewed
	public String[] getAssetFreqlist() {
		clickOn(AssetFrqBtn);
		List<WebElement> Combobxlist = driver.findElementsByClassName("ComboBoxItem");

		String str[] = new String[Combobxlist.size()];
		// System.out.println(Combobxlist.size());

		for (int i = 0; i < Combobxlist.size(); i++) {
			Actions ac = new Actions(driver);
			ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
			str[i] = FetchText(AssetFrqBtn);
		}

		String[] Obtainedlist = removeDuplicateStringinArray(str, "Select");
		// System.out.println(Arrays.toString(Obtainedlist));

		clickOn(AssetIDTxtBox);
		// System.out.println("---------");
		return Obtainedlist;
	}

	// Select Asset Frequency
	public void selectAssetFreq(String AF) {
		clickOn(AssetFrqBtn);
		// System.out.println("---"+AF);
		List<WebElement> Combobxlist = driver.findElementsByClassName("ComboBoxItem");
		// System.out.println(Combobxlist.size());
		Actions ac = new Actions(driver);

		for (int i = 0; i < Combobxlist.size(); i++) {
			ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
			if (FetchText(AssetFrqBtn).contains(AF)) {
				// ac.sendKeys(Keys.TAB).sendKeys(Keys.RETURN).build().perform();
				break;
			}
		}
		ac.sendKeys(Keys.TAB).sendKeys(Keys.RETURN).build().perform();
		ac.sendKeys(Keys.TAB).sendKeys(Keys.RETURN).build().perform();
	}

	// Fetch the Asset Frequency text
	public String getAssetFreqtext() {
		return FetchText(AssetFrqBtn);
	}

	// Select Asset Frequency Interval
	public void selectAssetFreqIntrvl(String FI) throws InterruptedException {
		clickOn(AssetFrqIntrvlBtn);
		Thread.sleep(500);
		List<WebElement> Combobxlist = driver.findElementsByClassName("ComboBoxItem");
		// System.out.println(Combobxlist.size());
		Actions ac = new Actions(driver);

		for (int i = 0; i < Combobxlist.size(); i++) {
			ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
			if (FetchText(AssetFrqIntrvlBtn).contains(FI)) {
				break;
			}
		}
		ac.sendKeys(Keys.TAB).sendKeys(Keys.RETURN).build().perform();
	}

	// Fetch the Asset Frequency Interval text
	public String getAssetFreqIntrvltext() {
		return FetchText(AssetFrqIntrvlBtn);
	}

	// Fetch list of raw Asset Manufacturer data as is viewed
	public String[] getAssetFreqIntrvllist() {
		ArrayList<String> Alist = new ArrayList<String>();
		clickOn(AssetFrqIntrvlBtn);
		List<WebElement> Combobxlist = driver.findElementsByClassName("ComboBoxItem");

		String str[] = new String[Combobxlist.size()];

		for (int i = 0; i < Combobxlist.size(); i++) {
			str[i] = Combobxlist.get(i).getText();
		}

		String[] Obtainedlist = removeDuplicateStringinArray(str, "Select");
		// System.out.println(Arrays.toString(Obtainedlist));

		clickOn(AssetSizeTxtBox);
		// System.out.println("---------");
		return Obtainedlist;
	}

	// Fetch Asset Description data
	public String get_Asset_LastValidatedtext() {
		return FetchText(AssetLstVldtdDate);
	}

	// Enter Description
	public void enterAstDescription(String ADesc) {
		ClearText(AssetDescTextField);
		enterText(AssetDescTextField, ADesc);
	}

	// Fetch Asset Description data
	public String getAssetDescriptiontext() {
		return FetchText(AssetDescTextField);
	}

	// Click Browse Image button
	public void click_ImgBrws_Btn() throws InterruptedException {
		clickOn(AssetImgBrowseBtn);
		Thread.sleep(500);
	}

	// Click Camera Image button
	public void click_Img_Camera_Btn() throws InterruptedException {
		clickOn(AssetImg_Camera_Btn);
		Thread.sleep(5000);
	}

	// Click Image1 Placeholder button
	public void click_Img1_Placeholder_Btn() throws InterruptedException {
		clickOn(AssetImg1_Btn);
		Thread.sleep(500);
	}

	// Click Image Placeholder Edit button
	public void click_Img_Placeholder_Edit_Btn() throws InterruptedException {
		WebElement AssetImgEditBtn = driver.findElementByAccessibilityId("ChangeImage");
		clickOn(AssetImgEditBtn);
		Thread.sleep(500);
	}

	// Click Image Placeholder Delete button
	public void click_Img_Placeholder_Delete_Btn() throws InterruptedException {
		WebElement AssetImgDeleteBtn = driver.findElementByAccessibilityId("RemoveButton");
		clickOn(AssetImgDeleteBtn);
		Thread.sleep(500);
	}

	public void capture_Camera_Img() throws InterruptedException {
		click_Img_Camera_Btn();

		WebElement Click_Camera_Wdw_capture_Btn = driver.findElementByName("Take Photo");
		clickOn(Click_Camera_Wdw_capture_Btn);
		Thread.sleep(500);
		WebElement Click_Camera_Wdw_Accept_Btn = driver.findElementByName("Accept");
		clickOn(Click_Camera_Wdw_Accept_Btn);
		Thread.sleep(500);
	}

	public void Capture_AsstImg1(String Img_Name) throws IOException {

		TestUtilities tu = new TestUtilities();
		tu.capture_element_screenshot(driver, AssetImg1_Btn, "TestData", Img_Name);

	}

	public void Capture_AsstImg2(String Img_Name) throws IOException {

		TestUtilities tu = new TestUtilities();
		tu.capture_element_screenshot(driver, AssetImg2_Btn, "TestData", Img_Name);

	}

	// verify Save button presence
	public boolean SaveBtn() {
		return IsElementVisibleStatus(AssetSaveBtn);
	}

	// Click Save button
	public void clickSaveBtn() throws InterruptedException {
		clickOn(AssetSaveBtn);
		Thread.sleep(1000);
	}

	// Verify the Save Alert message displayed
	public boolean saveAlertMsg() {
		WebElement Msg = driver.findElementByAccessibilityId("displayMessageTextBlock");
		return IsElementVisibleStatus(Msg);
	}

	// Fetch the Save Alert message
	public String AlertMsg() {
		WebElement Msg = driver.findElementByAccessibilityId("displayMessageTextBlock");
		return FetchText(Msg);
	}

	// Close the Alert message method
	public void CloseAlertMsg() {
		WebElement AlertCloseBtn = driver.findElementByAccessibilityId("btnDelete");
		clickOn(AlertCloseBtn);
	}

	// Click Clear button
	public void clickClearBtn() throws InterruptedException {
		clickOn(AssetClearBtn);
		Thread.sleep(500);
	}

	// click Back button to move to assetHub Page in case new Asset is created
	public assetHubPage clickBackBtn() throws InterruptedException, IOException {
		clickOn(AssetBackBtn);
		Thread.sleep(500);
		return new assetHubPage();
	}

	// click Back button to move to assetDetails Page in case Asset is in edit mode
	public assetDetailsPage2 click_BackBtn() throws InterruptedException, IOException {
		clickOn(AssetBackBtn);
		Thread.sleep(500);
		return new assetDetailsPage2();
	}

	// click Back button to get the Discard message
	public void clickBkBtn() throws InterruptedException {
		clickOn(AssetBackBtn);
		Thread.sleep(500);
	}

	// Discard alert message presence
	public boolean discardAlert() throws InterruptedException {
		clickOn(AssetBackBtn);
		Thread.sleep(500);
		return IsElementVisibleStatus(driver.findElementByAccessibilityId("Popup Window"));
	}

	// Discard alert message- No option
	public void discardAlertNoBtn() throws InterruptedException {
		clickOn(AssetBackBtn);
		Thread.sleep(500);
		if (IsElementVisibleStatus(driver.findElementByAccessibilityId("Popup Window"))) {
			clickOn(driver.findElementByName("No"));
		}
	}

	// Move to AssetHub page by Discarding the changes made to Asset creationpage
	public assetHubPage discardAlertYesBtn() throws InterruptedException, IOException {
		clickOn(AssetBackBtn);
		Thread.sleep(500);
		if (IsElementVisibleStatus(driver.findElementByAccessibilityId("Popup Window"))) {
			clickOn(driver.findElementByName("Yes"));
		}
		return new assetHubPage();
	}

	// Asset Creation with Mandatory fields
	public void assetCreation(String AName, String AID, String AType, String AManufaturer, String ALocation)
			throws InterruptedException {
		enterAssetName(AName);
		enterAssetID(AID);
		SelectAssetType(AType);
		enterManufacturerName(AManufaturer);
		enterLocation(ALocation);

		clickSaveBtn();
	}

	// Asset Creation with all Data entry
	public void assetCreationWithAllFieldEntry(String AName, String AID, String AType, String AManufacturer,
			String ALocation, String AModel, String ASize, String AUnit, String ALVDate, String AFreq, String AFreqInt,
			String ADesc) throws InterruptedException {

		String[] AstLstVldDate = ALVDate.split("/");
		// System.out.println(AstLstVldDate[1]);
		// System.out.println(AstLstVldDate[0]);
		// System.out.println(AstLstVldDate[2]);

		if (IsElementVisibleStatus(CreateAssetPageTitle)) {
			enterAssetName(AName);
			enterAssetID(AID);
			SelectAssetType(AType);
			enterManufacturerName(AManufacturer);
			enterLocation(ALocation);
			enterModelName(AModel);
			enterSize_Unit(ASize, AUnit);
			selectAssetLastVldDate(AstLstVldDate[1], AstLstVldDate[0], AstLstVldDate[2]);
			selectAssetFreq(AFreq);
			selectAssetFreqIntrvl(AFreqInt);
			enterAstDescription(ADesc);

			clickSaveBtn();

		}

	}

	// Asset Creation with Type
	public void assetCreationWithType(String AName, String AID, String AType, String AManufaturer, String ALocation)
			throws InterruptedException {
		enterAssetName(AName);
		enterAssetID(AID);
		enterAssetType(AType);
		enterManufacturerName(AManufaturer);
		enterLocation(ALocation);

		clickSaveBtn();
	}

	// Asset Creation with model data
	public void assetCreationWithModel(String AName, String AID, String AType, String AManufaturer, String ALocation,
			String AModel) throws InterruptedException {
		enterAssetName(AName);
		enterAssetID(AID);
		SelectAssetType(AType);
		enterManufacturerName(AManufaturer);
		enterLocation(ALocation);
		enterModelName(AModel);

		clickSaveBtn();
	}

	// Asset Creation with Size data
	public void assetCreationWithSize(String AName, String AID, String AType, String AManufaturer, String ALocation,
			String ASize, String AUnit) throws InterruptedException {
		enterAssetName(AName);
		enterAssetID(AID);
		SelectAssetType(AType);
		enterManufacturerName(AManufaturer);
		enterLocation(ALocation);
		enterSize_Unit(ASize, AUnit);

		clickSaveBtn();
	}

	// Asset Creation with Size Unit data
	public void assetCreationWithSizeUnit(String AName, String AID, String AType, String AManufaturer, String ALocation,
			String ASize, String AUnit) throws InterruptedException {

		enterAssetName(AName);
		enterAssetID(AID);
		SelectAssetType(AType);
		enterManufacturerName(AManufaturer);
		enterLocation(ALocation);
		enterSize_Unit(ASize, AUnit);

		clickSaveBtn();
	}

	// Fetch list of Asset Size Unit data as is viewed
	public String[] getAssetSizeUnitlist() {
		clickOn(Combobx.get(2));
		List<WebElement> Combobxlist = driver.findElementsByClassName("ComboBoxItem");

		String str[] = new String[Combobxlist.size()];

		for (int i = 0; i < Combobxlist.size(); i++) {
			str[i] = Combobxlist.get(i).getText();
		}

		String[] Obtainedlist = removeDuplicateStringinArray(str, "Select");
		// System.out.println(Arrays.toString(Obtainedlist));

		clickOn(AssetModelTxtBox);
		// System.out.println("---------");
		return Obtainedlist;
	}

	// Asset Creation with Description data
	public void assetCreationWithDesc(String AName, String AID, String AType, String AManufaturer, String ALocation,
			String ADescp) throws InterruptedException {
		enterAssetName(AName);
		enterAssetID(AID);
		SelectAssetType(AType);
		enterManufacturerName(AManufaturer);
		enterLocation(ALocation);
		enterAstDescription(ADescp);

		clickSaveBtn();
	}

	// Login Popup presence
	public boolean UserLoginPopupVisible() throws InterruptedException {
		WebElement LgInPopup = driver.findElementByName("Enter User Credentials");
		return IsElementVisibleStatus(LgInPopup);
	}

	// Close Login Popup
	public void UserLoginPopupClose() throws InterruptedException {
		WebElement LgInPopupCancel = driver.findElementByName("Cancel");
		clickOn(LgInPopupCancel);
	}

	// Get the Asset info in Asset details page
	public String[] get_assetCreationinfo() {
		String[] asstCreationinfo = new String[5];
		asstCreationinfo[0] = getEqpID();
		asstCreationinfo[1] = getAssetModeltext();
		asstCreationinfo[2] = getAssetManufacturertext();
		asstCreationinfo[3] = get_AssetType();
		asstCreationinfo[4] = get_Asset_LastValidatedtext();

		return asstCreationinfo;
	}

	// Right click on the Asset Creation page to invoke the bottom apps bar
	public void Rt_Click_AstCreation_Buttom_AppBar() {
		Actions ac = new Actions(driver);
		ac.contextClick().build().perform();
	}

	// Verify the presence of Home button in the bottom apps bar
	public boolean check_Home_Buttom_AppBar_Presence() {
		WebElement bottomMenu_Home_Icon = driver.findElementByAccessibilityId("HomeAppBarButton");
		return IsElementVisibleStatus(bottomMenu_Home_Icon);
	}

	// Verify the presence of Apps Help icon/button in the bottom apps bar
	public boolean check_Help_Buttom_AppBar_Presence() {
		WebElement bottomMenu_AppHelp_Icon = driver.findElementByAccessibilityId("HelpAppBarButton");
		return IsElementVisibleStatus(bottomMenu_AppHelp_Icon);
	}

	// Verify the presence of WndsHelp Help icon/button in the bottom apps bar
	public boolean check_WndsHelp_Buttom_AppBar_Presence() {
		WebElement bottomMenu_WndsHelp_Icon = driver.findElementByAccessibilityId("WindowsHelpAppBarButton");
		return IsElementVisibleStatus(bottomMenu_WndsHelp_Icon);
	}

	// Verify the presence of About Help icon/button in the bottom apps bar
	public boolean check_About_Buttom_AppBar_Presence() {
		WebElement bottomMenu_About_Icon = driver.findElementByAccessibilityId("AboutAppBarButton");
		return IsElementVisibleStatus(bottomMenu_About_Icon);
	}

	// Click on the Home icon of the bottom apps bar to move to Main Hub page
	public MainHubPage Click_Home_Icon_AppBar() throws InterruptedException, IOException {
		Actions ac = new Actions(driver);
		ac.contextClick().build().perform();

		WebElement bottomMenu_Home_Icon = driver.findElementByAccessibilityId("HomeAppBarButton");
		clickOn(bottomMenu_Home_Icon);
		Thread.sleep(500);
		return new MainHubPage();
	}

	// Click on the Help icon of the bottom apps bar to move to Main Hub page
	public void Click_Help_Icon_AppBar() throws InterruptedException {
		Actions ac = new Actions(driver);
		ac.contextClick().build().perform();

		WebElement bottomMenu_AppHelp_Icon = driver.findElementByAccessibilityId("HelpAppBarButton");
		clickOn(bottomMenu_AppHelp_Icon);
		Thread.sleep(500);
	}

	// Click on the WndsHelp icon of the bottom apps bar
	public void Click_WndsHelp_Icon_AppBar() throws InterruptedException {
		Actions ac = new Actions(driver);
		ac.contextClick().build().perform();

		WebElement bottomMenu_WndsHelp_Icon = driver.findElementByAccessibilityId("WindowsHelpAppBarButton");
		clickOn(bottomMenu_WndsHelp_Icon);
		Thread.sleep(500);
	}

	// Click on the About icon of the bottom apps bar to invoke the ABout window
	public void Click_About_Icon_AppBar() throws InterruptedException {
		Actions ac = new Actions(driver);
		ac.contextClick().build().perform();

		WebElement bottomMenu_About_Icon = driver.findElementByAccessibilityId("AboutAppBarButton");
		clickOn(bottomMenu_About_Icon);
		Thread.sleep(500);
	}

	// Get the Asset Creation Help context header text on clicking Help icon of the
	// bottom apps bar
	public String get_AsstCreation_HelpMenu_HdrText() {
		WebElement AsstCreation_HelpMenu = driver.findElementByAccessibilityId("helpHeader");
		return FetchText(AsstCreation_HelpMenu);
	}

	// Verify the presence of About window on clicking the ABout icon in the bottom
	// apps bar
	public boolean check_About_wndw_Presence() {
		WebElement About_Wndw = driver.findElementByName("About");
		return IsElementVisibleStatus(About_Wndw);
	}

	// Get the Sw version info from the About window on clicking About icon of the
	// bottom apps bar
	public String get_SWVersion_About_Text() {
		WebElement SWVersion_About_info = driver.findElementByAccessibilityId("SoftwareVersion");
		return FetchText(SWVersion_About_info);
	}

	// Edit Asset header Title is displaying..
	public boolean IsEditAssetscreenDisplayed() {
		WebElement EAHeaderText = driver.findElementByName("Edit Asset");
		return IsElementEnabledStatus(EAHeaderText);
	}

	// Click on Camera Icon for Asset Image
	public void click_CameraIcon() throws InterruptedException {
		WebElement CameraIcon = driver.findElementByAccessibilityId("CameraImage");
		clickOn(CameraIcon);

	}

	// Camera On Header Title is Visible ...
	public boolean CameraOnTitleVisible() {
		WebElement IsCameraOn = driver.findElementByName("Camera");
		return IsElementVisibleStatus(IsCameraOn);
	}

}
