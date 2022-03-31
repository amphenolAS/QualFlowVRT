package com.QualFlowVRT.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.QualFlowVRT.base.BaseClass;
import com.QualFlowVRT.utility.TestUtilities;
import com.QualFlowVRT.pages.QualificationPage;

public class ProgramLoggersPage extends BaseClass {

	// Calculation page element variable declaration definition
	WebElement ProgramLoggersTitle = null;
	WebElement NextButton = null;
	TestUtilities tu = new TestUtilities();

	private void initializeEelements() {
		// ProgramLoggersTitle = driver.findElementByName("Program Loggers");
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

	// Get the Qualification navigation button enable state
	public boolean QualificationBtnEnabled_status() {
		boolean QualificationBtn_state = driver.findElementByAccessibilityId("NextButton").isEnabled();
		return QualificationBtn_state;
	}

	// Handle ExcludeContinueLoggers Alert message (When sensor count is less than
	// the connected loggers) in Program Loggers page

	public void click_ExcludeLoggersandContinue(String destination) throws InterruptedException, IOException {
		boolean ExcludeLoggersandContinuePopup_Displayed = driver.findElementByAccessibilityId("Popup Window")
				.isEnabled();
		if (ExcludeLoggersandContinuePopup_Displayed) {
			Thread.sleep(2000);
			tu.capture_Screenshot(driver, "ExcludeLoggersandContinue_ProgramLoggersPage", destination);
			WebElement ExcludeContinueLoggers = driver.findElementByAccessibilityId("Button1");
			clickOn(ExcludeContinueLoggers);
			Thread.sleep(2000);
		}
	}

	// Click the Qualification button to move to Qual page after all loggers are
/*	// programmed
	public QualificationPage click_nextbtn(String destination) throws IOException, InterruptedException {
		boolean QualBtnEnableState1 = driver.findElementByAccessibilityId("NextButton").isEnabled();
		System.out.println("Qualification Next button enable state1: " + QualBtnEnableState1);
		Thread.sleep(3000);
		while (QualBtnEnableState1 == false) {
			Thread.sleep(30000);

			try {
				click_ExcludeLoggersandContinue(destination);

			} catch (Exception e) {
				System.out.println("Continue with Missing Sample alert not displayed");
			}

			boolean QualBtnEnableState2 = driver.findElementByAccessibilityId("NextButton").isEnabled();
			System.out.println("Qualification Next button enable state 2: " + QualBtnEnableState2);
			if (QualBtnEnableState2 == true) {
				break;
			}
		}

		clickOn(NextButton);
		Thread.sleep(10000);
		return new QualificationPage();
	}
	
	*/
    public boolean waitForElementEnabled() {
        boolean flag = false;
            try {
                        flag = driver.findElementByAccessibilityId("NextButton").isEnabled();
            } catch (Exception e) {
              System.out.println("LOGGED OUT");
            }
                        return flag;
        }


	
    public QualificationPage click_nextbtn(String destination) throws IOException, InterruptedException {

        while (!waitForElementEnabled()) {
               Thread.sleep(5000);
               System.out.println("TESTT programloggers");

               try {
            	   click_ExcludeLoggersandContinue(destination);

            	   } catch (Exception e) {
            	   System.out.println("Continue with Missing Sample alert not displayed");
            	   }
            	   
   
        }
        clickOn(NextButton);
        Thread.sleep(2000);
        return new QualificationPage();
 }
}