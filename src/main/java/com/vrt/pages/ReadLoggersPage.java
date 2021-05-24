package com.vrt.pages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.vrt.base.BaseClass;

public class ReadLoggersPage extends BaseClass {

	// Calculation page element variable declaration definition

	private void initializeEelements() {

	}

	ReadLoggersPage() throws IOException {
		super();
		initializeEelements();
	}

	public void capture_screenshot(WebDriver driver, String DestinationFldrName, String screenshotName)
			throws IOException {
		// Take screen shot of whole page
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/src/test/resources/" + DestinationFldrName + "/"
				+ screenshotName + ".png";
		FileUtils.copyFile(screenShot, new File(destination));

	}

	public boolean waitForSaveBtnToEnable() {
		boolean flag = false;
		try {
			flag = driver.findElementByAccessibilityId("NextButton").isEnabled();
		} catch (Exception e) {
			System.out.println(" save not displayed");
		}
		return flag;
	}

	public boolean Click_ExcludeLoggers_Btn_TakeScreenshot() {
		boolean flag = false;
		try {
			flag = driver.findElementByAccessibilityId("Button0").isEnabled();
			if (flag == true) {
				//capture_screenshot(driver, "TestData", "Exclude");
				click_Exclude_Btn();
			}

		} catch (Exception e) {
			System.out.println("Exclude Logger(s) and Continue pop up is not displayed");
		}
		return flag;
	}
	
	// click on Exclude & Continue btn in the alert message
	public void click_Exclude_Btn() {
		WebElement Exclude_btn = driver.findElementByAccessibilityId("Button0");
		clickOn(Exclude_btn);

	}

	public void click_SaveStudybtn1() throws IOException, InterruptedException {
		while (!waitForSaveBtnToEnable()) {
			Thread.sleep(6000);
			Click_ExcludeLoggers_Btn_TakeScreenshot();
		}
		WebElement SaveButton = driver.findElementByAccessibilityId("NextButton");
		clickOn(SaveButton);
	}
	
	
	//Get the Save STudy button enable state
	public boolean SaveStudyBtnEnabled_status() {
		boolean SaveStudyBtn_state = driver.findElementByAccessibilityId("NextButton").isEnabled();
		return SaveStudyBtn_state;
	}

	//Click the Qualification button to move to Qual page  after all loggers are programmed
	public void click_SaveSTudybtn() throws IOException, InterruptedException {
		System.out.println("Save study  button enable state1: "+SaveStudyBtnEnabled_status());	
		if (SaveStudyBtnEnabled_status()==true) {
			//Click the save study button
			clickOn(driver.findElementByAccessibilityId("NextButton"));
		} else {
			while (SaveStudyBtnEnabled_status()==false) {			
				Thread.sleep(5000);
				
				//Check for Missing samples alert message for any logger and if displayed, click on the "Continue with Missing Samples"
				try {
					click_ContinuewithMissingSample();

				} catch (Exception e) {
					System.out.println("Missing Samples alert message not displayed");
				}	
				
				try {
					click_ExcludeLoggers();

				} catch (Exception e) {
					System.out.println("Exclude Loggers alert not displayed");
				} 
				
				boolean SaveSTudyBtnEnableState2=SaveStudyBtnEnabled_status();
				System.out.println("Save Study button enable state 2: "+SaveSTudyBtnEnableState2);		
				if (SaveSTudyBtnEnableState2==true) {
					clickOn(driver.findElementByAccessibilityId("NextButton"));
					break;
				}
			}
		}
	}
	
	//Click ContinuewithMissingSample_Btn in the Missing sample alert message if displayed in Read Loggers page
	public void click_ContinuewithMissingSample() throws InterruptedException {
		boolean ContinuewithMissingSamplepopup_Displayed = driver.findElementByAccessibilityId("Popup Window")
				.isEnabled();
		if (ContinuewithMissingSamplepopup_Displayed) {
			WebElement ContinuewithMissingSample_Btn = driver.findElementByAccessibilityId("Button0");
			clickOn(ContinuewithMissingSample_Btn);	
			
			//Wait for the Historical data download message to hide
			Thread.sleep(20000);
		}
	}
	
	//Click the exclude logger button in the exclude logger alert message if displayed 
	public void click_ExcludeLoggers() throws InterruptedException {
		boolean ExcludeLoggersPopup_Displayed = driver.findElementByAccessibilityId("Popup Window").isEnabled();
		if (ExcludeLoggersPopup_Displayed) {
			WebElement ExcludeLoggers = driver.findElementByAccessibilityId("Button1");
			clickOn(ExcludeLoggers);

			Thread.sleep(2000);
		}
	}


	// Get text from Error while Reading Loggers
	public String get_text_ReadingLoggers_popup() {
		WebElement Reading_popup = driver.findElementByAccessibilityId("Content_String");
		return Reading_popup.getAttribute("Name");
	}

	// click on confirmation ok btn to save study
	public MainHubPage click_okAndEnterComment(String cmntval, String UID, String PW) throws IOException, InterruptedException {
		WebElement cmnt = driver.findElementByAccessibilityId("StopQualifCalibCommentsTextBox");
		WebElement ok_btn = driver.findElementByAccessibilityId("StopQualifCalibOKButton");
		clickOn(cmnt);
		enterText(cmnt, cmntval);
		clickOn(ok_btn);
		
		try {
			while (reReadStatus()==true) {
				Thread.sleep(3000);
				boolean reReadStatusPopup_displaySTate = driver.findElementByAccessibilityId("reReadStatus").isDisplayed();
				if (reReadStatusPopup_displaySTate == false) {
					break;
				}
			}
			//click_AbortBtn(UID, PW);
			
		} catch (Exception e) {
			System.out.println("Stop Read Command Not accepted message is not displayed...");
		}
		//Thread.sleep(1200000);
		return new MainHubPage();
	}
	
	//Verify if the Stop Read Command Not accepted message displayed.
	public boolean reReadStatus() {
		boolean reReadStatus_alert = driver.findElementByAccessibilityId("reReadStatus").isEnabled();
		return reReadStatus_alert;
	}
	
	// Click Abort button if Stop Read Command Not accepted message displayed.
	public MainHubPage click_AbortBtn(String UID, String PW) throws IOException, InterruptedException {

		WebElement aborth_btn = driver.findElementByAccessibilityId("btnQuitQual");
		clickOn(aborth_btn);
		Thread.sleep(2000);
		WebElement Abort_Btn_Yes = driver.findElementByAccessibilityId("Button1");
		clickOn(Abort_Btn_Yes);
		UserLoginPopup(UID, PW);
		return new MainHubPage();
	}
	
	

}
