package com.QualFlowVRT.pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;

import com.QualFlowVRT.base.BaseClass;
import com.QualFlowVRT.utility.TestUtilities;
import com.QualFlowVRT.pages.QualificationPage;

public class ProgramLoggersPage extends BaseClass {

	TestUtilities tu = new TestUtilities();
	// Calculation page element variable declaration definition
	WebElement ProgramLoggersTitle = null;
	WebElement NextButton = null;

	private void initializeEelements() {
		//ProgramLoggersTitle = driver.findElementByName("Program Loggers");
		NextButton = driver.findElementByAccessibilityId("NextButton");

	}

	ProgramLoggersPage() throws IOException {
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

	//Get the Qualification navigation button enable state
	public boolean QualificationBtnEnabled_status() {
		boolean QualificationBtn_state = driver.findElementByAccessibilityId("NextButton").isEnabled();
		return QualificationBtn_state;
	}

	// Handle ExcludeContinueLoggers Alert message (When sensor count is less than
	// the connected loggers) in Program Loggers page
	public void click_ExcludeLoggersandContinue() throws InterruptedException, IOException {
		boolean ExcludeLoggersandContinuePopup_Displayed = driver.findElementByAccessibilityId("Popup Window")
				.isEnabled();
		if (ExcludeLoggersandContinuePopup_Displayed) {
			Thread.sleep(2000);
			WebElement ExcludeContinueLoggers = driver.findElementByAccessibilityId("Button1");
			clickOn(ExcludeContinueLoggers);
			Thread.sleep(2000);
		}
	}
    
	//Click the Qualification button to move to Qual page  after all loggers are programmed
	public QualificationPage click_nextbtn() throws IOException, InterruptedException {
		boolean QualBtnEnableState1=driver.findElementByAccessibilityId("NextButton").isEnabled();
		System.out.println("Qualification Next button enable state1: "+QualBtnEnableState1);		
		Thread.sleep(2000);
		while (QualBtnEnableState1==false) {			
			Thread.sleep(10000);
			//Check if the Less Sensors mapped alert message appears and click the Continue with Missing Sample button
			try {
				click_ExcludeLoggersandContinue();
			} catch (Exception e) {
				System.out.println("Continue with Missing Sample alert not displayed");
			}
			
			boolean QualBtnEnableState2=driver.findElementByName("Qualification").isEnabled();
			System.out.println("Qualification Next button enable state 2: "+QualBtnEnableState2);		
			if (QualBtnEnableState2==true) {
				break;
			}				
		}
		
		clickOn(NextButton);
		Thread.sleep(5000);
		return new QualificationPage();
	}


}
