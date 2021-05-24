package com.vrt.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.vrt.base.BaseClass;

public class SelectBaseStationPage extends BaseClass {

	// Calculation page element variable declaration definition
	WebElement SelectBaseStationTitle = null;
	WebElement DiscoverIOBoxButton = null;
	WebElement btnIpConfigChange = null;
	WebElement Connect_Btn = null;
	WebElement BS_IPAddress = null;
	WebElement Add_btn = null;
	WebElement BackBtn = null;

	private void initializeEelements() {
		SelectBaseStationTitle = driver.findElementByName("Select Base Station");
		DiscoverIOBoxButton = driver.findElementByAccessibilityId("DiscoverIOBoxButton");
		btnIpConfigChange = driver.findElementByAccessibilityId("btnIpConfigChange");
		Connect_Btn = driver.findElementByAccessibilityId("btnConnect");
		BS_IPAddress = driver.findElementByAccessibilityId("txtIOBox");
		Add_btn = driver.findElementByAccessibilityId("btnIOIPconnect");
		BackBtn = driver.findElementByAccessibilityId("ArrowGlyph");

	}

	SelectBaseStationPage() throws IOException {
		super();
		initializeEelements();
	}

	// Release memory
	public void resetWebElements() {
		SelectBaseStationTitle = null;
		DiscoverIOBoxButton = null;
		btnIpConfigChange = null;
		Connect_Btn = null;
		BS_IPAddress = null;
		Add_btn = null;
		BackBtn = null;

	}

// Check the presence of Select Base Station header title
	public boolean SelectBaseStationTitle_state() {
		return IsElementVisibleStatus(SelectBaseStationTitle);
	}

//click on DiscoverIOBoxButton
	public void Click_DiscoverBS() throws InterruptedException {
		clickOn(DiscoverIOBoxButton);
		Thread.sleep(5000);
	}

	// BS list box is displayed
	public boolean BSListbox_Isdisplayed() {
		WebElement BSListbox = driver.findElementByName("VRT.DataObjects.DataContracts.BSBoxDetails");
		return BSListbox.isDisplayed();

	}

// click on BS listbox        

	public void Select_BSListbox(String BSName) throws IOException, InterruptedException {
		List<WebElement> BSList = driver.findElementByAccessibilityId("Set1TextTileLandingGrid")
				.findElements(By.className("GridViewItem"));

		for (int i = 0; i < BSList.size(); i++) {
			// System.out.println("BS list: " +BSList.get(i).getText());

			List<WebElement> BSTileInfoList = BSList.get(i).findElements(By.className("TextBlock"));

			for (int j = 0; j < BSTileInfoList.size(); j++) {
				// System.out.println("BS TileInfo: "+BSTileInfoList.get(j).getText());

				if (BSTileInfoList.get(j).getText().equals(BSName)) {
					clickOn(BSTileInfoList.get(j));
					Thread.sleep(2000);
					break;

				}
			}
		}

	}

	// click on btnIpConfigChange
	public void Click_ConfigBtn() {
		clickOn(btnIpConfigChange);
		WebElement BStoIdeal = driver.findElementByAccessibilityId("btnQuitQual");
		clickOn(BStoIdeal);
		WebElement Yes = driver.findElementByAccessibilityId("Button1");
		clickOn(Yes);
	}

//set BS to ideal 
	public void Click_SetBSideal() {
		WebElement BStoIdeal = driver.findElementByAccessibilityId("btnQuitQual");
		clickOn(BStoIdeal);
		WebElement Yes = driver.findElementByAccessibilityId("Button1");
		clickOn(Yes);
	}

	// click on connect btn to navigate SelectLoggersPage
	public SelectLoggersPage Click_ConnectBtn() throws IOException, InterruptedException {
		clickOn(Connect_Btn);
		Thread.sleep(3000);
		return new SelectLoggersPage();
	}

	// click on connect btn to navigate QualificationPage
	public QualificationPage ClickConnectBtn_ViaDiscovertile() throws IOException, InterruptedException {
		clickOn(Connect_Btn);
		Thread.sleep(3000);
		return new QualificationPage();
	}

	// BS_IPAddress
	public void Enter_BS_IPAddress(String IP) {
		clickOn(BS_IPAddress);
		ClearText(BS_IPAddress);
		enterText(BS_IPAddress, IP);

	}

	// click_on ADD btn

	public void Enter_Add_btn() {
		clickOn(Add_btn);
	}

	// click on backbtn

	public MainHubPage clickBackBtn() throws IOException {
		clickOn(BackBtn);
		return new MainHubPage();
	}
}
