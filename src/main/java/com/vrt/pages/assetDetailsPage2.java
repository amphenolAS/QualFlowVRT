/**
* @author manoj.ghadei
*
*/

package com.vrt.pages;

import java.awt.AWTException;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.By;

import com.vrt.base.BaseClass;
import com.vrt.utility.TestUtilities;

public class assetDetailsPage2 extends BaseClass {

	TestUtilities tu = new TestUtilities();
	// Asset Details element variable declaration definition
	WebElement Asset_SetupTile = null;
	WebElement InitiateQual_Btn = null;
	WebElement Asset_QualTile = null;

	private void initElements() {
		Asset_SetupTile = driver.findElementByAccessibilityId("SetupsButton");
		InitiateQual_Btn = driver.findElementByAccessibilityId("StartQualificationButton");
		Asset_QualTile = driver.findElementByAccessibilityId("QualificationsButton");

	}

	assetDetailsPage2() throws IOException {
		super();
		initElements();
	}

	// Release memory
	public void resetWebElements() {
		Asset_SetupTile = null;
		InitiateQual_Btn = null;
		Asset_QualTile = null;
	}

	// click on the setup tile
	public void click_SetupTile() {
		clickOn(Asset_SetupTile);
	}
	
	//Select the target Setup file
	public void Click_SetupName(String SetupName) throws IOException, InterruptedException, AWTException {
		
		List<WebElement> SetupList = driver.findElementByClassName("ListView")
				.findElements(By.className("ListViewItem"));
		//System.out.println("Total setup created: " +SetupList.size());
		
		// Loop for the different setup tiles created
		for (int i = 0; i < SetupList.size(); i++) {
			//System.out.println("setup list: " +SetupList.get(i).getText());
			List<WebElement> SetupTileInfoList = SetupList.get(i).findElements(By.className("TextBlock"));
			// System.out.println(" setup info count: " + SetupTileInfoList.size());
			
			// Fetch all the contents of the Asset tile
			for (int j = 0; j < SetupTileInfoList.size(); j++) {
				//System.out.println("setup TileInfo: "+SetupTileInfoList.get(j).getText());
				String st = SetupTileInfoList.get(j).getText();
				if (st.equals(SetupName)) {
					SetupTileInfoList.get(j).click();	
					break;					
				}
			}
		}
	}

	/*
	public void Click_SetupName(String SetupName) throws IOException, InterruptedException, AWTException {
		Actions ac = new Actions(driver);
		
		List<WebElement> SetupList = driver.findElementByClassName("ListView")
				.findElements(By.className("ListViewItem"));
		clickOn(SetupList.get(0));
		System.out.println("Total setup created: " +SetupList.size());
		// Loop for the different setup tiles created
		for (int i = 0; i < SetupList.size(); i++) {
			//ac.click(SetupList.get(i));
			
			System.out.println("setup list: " +SetupList.get(i).getText());
			List<WebElement> SetupTileInfoList = SetupList.get(i).findElements(By.className("TextBlock"));
			// System.out.println(" setup info count: " + SetupTileInfoList.size());

			//ClkscrollBar_down();
			// Fetch all the contents of the Asset tile
			for (int j = 0; j < SetupTileInfoList.size(); j++) {
				System.out.println("setup TileInfo: "+SetupTileInfoList.get(j).getText());
				String st = SetupTileInfoList.get(j).getText();
				//System.out.println(st);
				if (st.equals(SetupName)) {
					//ac.click(SetupTileInfoList.get(j));
					//ac.click(SetupList.get(i));
					ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
					//clickOn(SetupTileInfoList.get(j));
					SetupTileInfoList.get(j).click();
					Thread.sleep(2000);

					break;							
				}	
				
				//else {
					//ac.click(SetupList.get(i));
					//ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
					//Thread.sleep(1000);
					//ac.click(SetupList.get(i));
					//clickOn(SetupList.get(i));
				//}
			}
		}

	}
*/
	
// click on Initiate Qual button under Setup tile
	public void click_InitiateQualBtn() {
		clickOn(InitiateQual_Btn);
	}
	
	// Click the Setup list panel
	public void click_SetupListPanel() throws InterruptedException {
		clickOn(driver.findElementByClassName("ListView"));
		Thread.sleep(1000);
	}
	
	// Enter Value into Sop Protocol Text Box
	public void Enter_SOPNum(String SOPNum) {
		WebElement SopNum_Field = driver.findElementByAccessibilityId("SopProtocolTextBox");
		clickOn(SopNum_Field);
		ClearText(SopNum_Field);
		enterText(SopNum_Field, SOPNum);
	}
	
	// Click on OK button for SOP/Run creation
	public void StartQual_OKButton() {
		WebElement OK_Btn_InSOPBlock = driver.findElementByAccessibilityId("StartQualificationOKButton");
		clickOn(OK_Btn_InSOPBlock);
	}

	// SOP valid value
	public SelectBaseStationPage Enter_SOP(String SNum) throws InterruptedException, IOException {
		Enter_SOPNum(SNum);
		StartQual_OKButton();
		return new SelectBaseStationPage();
	}

	// click on the Qual tile
	public void click_QualTile() {
		clickOn(Asset_QualTile);
	}

	// Comments given during saving the study for syncIn Setup
	public String qual_StudyFile_Comments_txt() {
		List<WebElement> comment = driver.findElementByClassName("ListViewItem")
				.findElements(By.className("TextBlock"));
		return FetchText(comment.get(5));
	}
	
	// Select any qual file based on study save comment and click on that
	public void Select_QualFile(String StudyComment) throws InterruptedException, IOException {

		List<WebElement> QUALList = driver.findElementByClassName("ListView")
				.findElements(By.className("ListViewItem"));
		// Loop for the different serial number created
		for (int i = 0; i < QUALList.size(); i++) {
			// System.out.println("serial number : " + IrtdList.get(i).getText());
			List<WebElement> QUALInfoList = QUALList.get(i).findElements(By.className("TextBlock"));
			// System.out.println(" IRTD tile info count: " + IRTDTileInfoList.size());

			// Fetch all the contents of the Asset tile
			for (int j = 0; j < QUALInfoList.size(); j++) {
				// System.out.println("AssetTileInfo: "+IRTDTileInfoList.get(j).getText());

				String st = QUALInfoList.get(j).getText();
				if (st.equals(StudyComment)) {
					QUALInfoList.get(j).click();

					break;
				}
			}
		}
	}
	
	// user who has access will navigate to next page
	public RW_FileSelctionPage Click_GenerateReportsBtn_RWpage() throws IOException {
		WebElement GenerateReports = driver.findElementByAccessibilityId("GenerateReportsForQualButton");
		clickOn(GenerateReports);
		return new RW_FileSelctionPage();
	}
	
}
