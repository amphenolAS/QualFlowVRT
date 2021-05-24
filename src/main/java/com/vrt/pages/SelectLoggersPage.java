package com.vrt.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.vrt.base.BaseClass;

public class SelectLoggersPage extends BaseClass {

	// Calculation page element variable declaration definition
	WebElement SelectLoggersTitle = null;
	WebElement SelectAllLoggers_Btn = null;
	WebElement ForceIdle_Btn = null;
	WebElement NextButton = null;

	private void initializeEelements() {
		SelectLoggersTitle = driver.findElementByName("Select Loggers");
		SelectAllLoggers_Btn = driver.findElementByName("Select All Loggers");
		ForceIdle_Btn = driver.findElementByName("Force Idle");
		NextButton = driver.findElementByAccessibilityId("NextButton");

	}

	SelectLoggersPage() throws IOException {
		super();
		initializeEelements();
	}

	// Release memory
	public void resetWebElements() {
		SelectLoggersTitle = null;
		SelectAllLoggers_Btn = null;
		ForceIdle_Btn = null;
		NextButton = null;
	}

	// Check the presence of Select Base Station header title
	public boolean SelectLoggersTitle_state() {
		return IsElementVisibleStatus(SelectLoggersTitle);
	}

	// click on SelectAllLoggers_Btn

	public void click_SelectAllLoggers_Btn() throws InterruptedException {
		clickOn(SelectAllLoggers_Btn);
		Thread.sleep(2000);
	}

	// click on ForceIdle_Btn

	public void click_ForceIdle_Btn() throws InterruptedException {
		clickOn(ForceIdle_Btn);
		Thread.sleep(2000);
		WebElement ForceIdle_Btn_Yes = driver.findElementByAccessibilityId("Button1");
		clickOn(ForceIdle_Btn_Yes);
		Thread.sleep(30000);
	}

	// select loggers

	public void Select_LoggersListbox(int lname) throws IOException {
		List<WebElement> LogList = driver.findElementByAccessibilityId("Set1TextTileLandingGrid")
				.findElements(By.className("GridViewItem"));
		System.out.println(LogList.size());
		for (int i = 0; i < lname; i++) {

			LogList.get(i).click();

		}
	}

	public boolean verifyTextPresent(String[] data, String test) {
		boolean flag = false;
		for (int i = 0; i < data.length; i++) {
			if (test.contains(data[i])) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public void Select_LogListbox(String lname) throws IOException {
		String data[] = lname.split(",");
		List<WebElement> LogList = driver.findElementByAccessibilityId("Set1TextTileLandingGrid")
				.findElements(By.className("GridViewItem"));

		System.out.println(LogList.size());

		for (int i = 0; i < LogList.size(); i++) {
			List<WebElement> BSTileInfoList = LogList.get(i).findElements(By.className("TextBlock"));

			for (int j = 0; j < BSTileInfoList.size(); j++) {

				if (verifyTextPresent(data, BSTileInfoList.get(j).getText())) {
					clickOn(BSTileInfoList.get(j));
					break;

				}

			}
		}
	}

	public boolean LgrStatusPopup_enableStatus() {
		boolean LgrStatusPopup_enableState = driver.findElementByAccessibilityId("LiveLoggerStatusPageTitle").isEnabled();
		return LgrStatusPopup_enableState;
	}
	
	public boolean waitForLoggerStatusTo_Disapper() {
		boolean flag = false;
		try {
			flag = driver.findElementByAccessibilityId("displayMessageTextBlock").isEnabled();
		} catch (Exception e) {
			System.out.println("Navigating to Mapping sensor page ");
		}
		return flag;
	}
	
	// Click the Mapping sensors button t0 navigate to Mapping sensors page
	public void clickNext_MappingSensorBtn() throws InterruptedException {
		clickOn(NextButton);
		Thread.sleep(2000);
	}

	// select Yes from the add equipment box
	public void add_eqp_Yes() {
		WebElement Yes_btn = driver.findElementByAccessibilityId("Button1");
		clickOn(Yes_btn);

	}

	// Check if the Equipment alert message is popped up
	public boolean isAddEqipAlertDisplayed() throws InterruptedException {
		boolean flag = driver.findElementByAccessibilityId("Popup Window").isEnabled();
		return flag;
	}
	
	//Click Yes button for adding new Equipment to the system
	public void click_AddEqp() throws InterruptedException {
		if (isAddEqipAlertDisplayed()) {
			add_eqp_Yes();
			Thread.sleep(7000);
			//clickNext_MappingSensorBtn();
		}
	}
	
	//Check if the battery Threshold message appears and if appears press ok.
	public void click_YesTo_BatteryAlert() throws InterruptedException {
		boolean Is_batteryAlert_displayed = driver.findElementByAccessibilityId("Popup Window").isEnabled();
		if (Is_batteryAlert_displayed) {
			WebElement Yes_btn = driver.findElementByAccessibilityId("Button1");
			clickOn(Yes_btn);
			//clickNext_MappingSensorBtn();
			Thread.sleep(2000);
		}
	}
	

	//click on mapping sensor btn
	public MappingSensorsPage lgrStatusPopup_wait() throws IOException, InterruptedException {
		//clickOn(NextButton);
		try {
			while (LgrStatusPopup_enableStatus()) {
				Thread.sleep(2000);
				System.out.println("Logger Status Popu still displayed in Select loggers screen...");
			}
		} catch (Exception e) {
			System.out.println("Logger Status Popu Not displayed in Select loggers screen");
		}
		return new MappingSensorsPage();
	}

}
