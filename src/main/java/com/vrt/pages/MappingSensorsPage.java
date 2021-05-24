package com.vrt.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.vrt.base.BaseClass;

public class MappingSensorsPage extends BaseClass {

	// Calculation page element variable declaration definition
	WebElement MappingSensorsTitle = null;
	WebElement btnAutoMap_Btn = null;
	WebElement NextButton = null;

	private void initializeEelements() {
		MappingSensorsTitle = driver.findElementByAccessibilityId("tbMappingSensors");
		btnAutoMap_Btn = driver.findElementByAccessibilityId("btnAutoMap");
		NextButton = driver.findElementByAccessibilityId("NextButton");
	}

	MappingSensorsPage() throws IOException {
		super();
		initializeEelements();
	}

	// Release memory
	public void resetWebElements() {
		MappingSensorsTitle = null;
		btnAutoMap_Btn = null;
		NextButton = null;
	}

// Check the presence of Mapping Sensors Station header title

	public boolean SelectBaseStationTitle_state() {
		return IsElementVisibleStatus(MappingSensorsTitle);
	}

	// click on Auto map btn
	public void click_btnAutoMap_Btn() throws InterruptedException {
		clickOn(btnAutoMap_Btn);
		Thread.sleep(2000);
	}

	// click on Select All check box
	public void sensorAutoMao_operation() throws InterruptedException {
		WebElement SelectAll_checkbox = driver.findElementByName("Select All");
		clickOn(SelectAll_checkbox);
		Thread.sleep(2000);
		WebElement GroupSelectionOKBtn = driver.findElementByAccessibilityId("GroupSelectionOKBtn");
		clickOn(GroupSelectionOKBtn);
		Thread.sleep(2000);
	}

	// click on program loggers
	public ProgramLoggersPage click_NextButton_withUnmappedSensors() throws IOException, InterruptedException {
		clickOn(NextButton);
		Thread.sleep(3000);		
		
		//Check for the Sensor count diff. alert message popup 
		try {
			WebElement Yes_btn = driver.findElementByName("Yes");
			clickOn(Yes_btn);
			Thread.sleep(5000);	
		} catch (Exception e) {
			System.out.println("No Alert message on Sensor count difference while mapping sensors");
		}
		Thread.sleep(2000);	
		return new ProgramLoggersPage();
	}

}
