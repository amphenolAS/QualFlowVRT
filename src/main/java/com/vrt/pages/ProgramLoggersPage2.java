package com.vrt.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.vrt.base.BaseClass;

public class ProgramLoggersPage2 extends BaseClass {

	// Calculation page element variable declaration definition
	WebElement ProgramLoggersTitle = null;
	WebElement NextButton = null;

	private void initializeEelements() {
		ProgramLoggersTitle = driver.findElementByName("Program Loggers");
		NextButton = driver.findElementByAccessibilityId("NextButton");

	}

	ProgramLoggersPage2() throws IOException {
		super();
		initializeEelements();
	}

	// Release memory
	public void resetWebElements() {
		ProgramLoggersTitle = null;
		NextButton = null;

	}

// Check the presence of Mapping Sensors Station header title

	public boolean SelectBaseStationTitle_state() {
		return IsElementVisibleStatus(ProgramLoggersTitle);
	}

	public boolean waitForElementEnabled() {
		boolean flag = false;
		try {
			flag = driver.findElementByAccessibilityId("NextButton").isEnabled();
			System.out.println(flag);
		} catch (Exception e) {
			System.out.println("LOGGED OUT");
		}
		return flag;
	}

	public QualificationPage click_nextbtn() throws IOException, InterruptedException {

		while (!waitForElementEnabled()) {
			Thread.sleep(5000);
		}
		clickOn(NextButton);
		Thread.sleep(2000);
		return new QualificationPage();
	}
}
