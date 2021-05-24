package com.vrt.pages;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vrt.base.BaseClass;

public class QualificationPage extends BaseClass {

	// Qualification page element variable declaration definition

	//WebElement qualification = null;
	WebElement Start_qual = null;


	private void initializeEelements() {

		//qualification = driver.findElementByAccessibilityId("qualification");
		Start_qual = driver.findElementByAccessibilityId("btnStartQual");

	}

	QualificationPage() throws IOException {
		super();
		initializeEelements();
	}

	// Release memory
	public void resetWebElements() {
	//	qualification = null;
		Start_qual = null;

	}

// Check the presence of Mapping Sensors Station header title
	public boolean qualificationTitle_state() {
		WebElement qualification_Title = driver.findElementByAccessibilityId("qualification");
		return IsElementVisibleStatus(qualification_Title);
	}

	// fetch text from qual page

	public String qualificationTitle_Fetch() {
		WebElement qualification_Title = driver.findElementByAccessibilityId("qualification");
		return FetchText(qualification_Title);
	}

//click on Stop_qual
	public ReadLoggersPage Click_Stop_qual() throws InterruptedException, IOException {
		WebElement Stop_qual = driver.findElementByAccessibilityId("btnStopQual");
		clickOn(Stop_qual);
		UserLoginPopup(getUID("adminFull"), getPW("adminFull"));

		return new ReadLoggersPage();

	}
// Fetch Logger status text

	public String fetch_LgrStatusPopupTitle_txt() {
		WebElement loggerstatus = driver.findElementByAccessibilityId("LiveLoggerStatusPageTitle");
		return FetchText(loggerstatus);

	}

	
	public boolean LgrStatusPopup_enableStatus() {
		boolean LgrStatusPopup_enableState = driver.findElementByAccessibilityId("LiveLoggerStatusPageTitle").isEnabled();
		return LgrStatusPopup_enableState;
	}

	public void capture_screenshot(WebDriver driver, String DestinationFldrName, String screenshotName)
			throws IOException {
		// Take screen shot of whole page
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/test-output/" + DestinationFldrName + "/"
				+ screenshotName + ".png";
		FileUtils.copyFile(screenShot, new File(destination));

	}

	// click on Exclude & Continue btn in the alert message
	public void click_ExcludeContinue_Btn() throws IOException {
		//capture_screenshot(driver, "New", "exclude");
		WebElement Exclude_btn = driver.findElementByAccessibilityId("skipButton");
		clickOn(Exclude_btn);
		
	}

	public void Click_ExcludeLoggers_BtnAndTakeScreenshot() {
		WebElement exclude_alertBtn = driver.findElementByAccessibilityId("skipButton");
		clickOn(exclude_alertBtn);
	}

	//Methos to click the Qual STop button
	public void click_Stop_qualbtn() {
		WebElement Stop_qual = driver.findElementByAccessibilityId("btnStopQual");
		clickOn(Stop_qual);
		
	}
	
	//Method to dynamically handle the wait time of the logger status popup 
	public void handle_ExcludelgrPopup1() throws IOException, InterruptedException {
		Click_ExcludeLoggers_BtnAndTakeScreenshot();		
	}
	
	// Method to dynamically handle the wait time of the logger status popup to go
	// away during Qual Stop
	public ReadLoggersPage handle_lgrStatusPopup_QualSTop() throws IOException, InterruptedException {
		try {
			while (LgrStatusPopup_enableStatus()) {
				Thread.sleep(3000);
				System.out.println("Logger Status popup still displayed in the "
						+ "Qual Page during the Qual Stop process...");
				try {
					handle_ExcludelgrPopup1();
				} catch (Exception e) {
					System.out.println("Exclude Logger(s) and Continue pop up not displayed...");
				}
			}
			
		} catch (Exception e) {
			System.out.println("Logger Status popup either went away else not displayed in the "
					+ "Qual Page during the Qual start process...");
		}
		Thread.sleep(10000);
		return new ReadLoggersPage();
		
	}


	//Method to Start Qualification
	public void click_Start_qualbtn() throws InterruptedException {
		clickOn(Start_qual);
		Thread.sleep(2000);
	}
	

	//Method to dynamically handle the wait time of the logger status popup to go away
	public void handle_lgrStatusPopup_QualStart() throws IOException, InterruptedException {
		try {
			while (LgrStatusPopup_enableStatus()) {
				Thread.sleep(3000);
				System.out.println("Logger Status popup still displayed in the "
						+ "Qual Page during the Qual start process...");
				try {
					handle_ExcludelgrPopup1();
				} catch (Exception e) {
					System.out.println("Exclude Logger(s) and Continue pop up not displayed...");
				}
			}
			
		} catch (Exception e) {
			System.out.println("Logger Status popup either went away else not displayed in the "
					+ "Qual Page during the Qual start process...");
		}
		
	}

	public boolean waitForHistoricalData_AlertTo_Disapper() {
		boolean flag = false;
		try {

			flag = driver.findElementByAccessibilityId("displayMessageTextBlock").isEnabled();
		} catch (Exception e) {
			System.out.println("wait for Historical Alert to disappear");
		}
		return flag;
	}

	//
	public ReadLoggersPage clickQstop_HistoricalData() throws IOException, InterruptedException {
		WebElement Stop_qual = driver.findElementByAccessibilityId("btnStopQual");
		clickOn(Stop_qual);
		while (waitForHistoricalData_AlertTo_Disapper()) {
			Thread.sleep(2000);
		}
		// clickOn(Stop_qual);
		System.out.println("Historical data alert not displayed");
		UserLoginPopup(getUID("adminFull"), getPW("adminFull"));
		return new ReadLoggersPage();
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

}
