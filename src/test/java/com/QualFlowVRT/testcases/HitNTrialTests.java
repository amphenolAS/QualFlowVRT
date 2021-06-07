package com.QualFlowVRT.testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.QualFlowVRT.base.BaseClass;
import com.QualFlowVRT.pages.LoginPage;
import com.QualFlowVRT.pages.MainHubPage;
import com.QualFlowVRT.pages.MappingSensorsPage;
import com.QualFlowVRT.pages.ProgramLoggersPage;
import com.QualFlowVRT.pages.QualificationPage;
import com.QualFlowVRT.pages.RW_FileSelctionPage;
import com.QualFlowVRT.pages.ReadLoggersPage;
import com.QualFlowVRT.pages.SelectBaseStationPage;
import com.QualFlowVRT.pages.SelectLoggersPage;
import com.QualFlowVRT.pages.UserManagementPage;
import com.QualFlowVRT.pages.assetCreationPage;
import com.QualFlowVRT.pages.assetDetailsPage2;
import com.QualFlowVRT.pages.assetHubPage;
import com.QualFlowVRT.utility.QualificationUtility;
import com.QualFlowVRT.utility.TestUtilities;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HitNTrialTests extends BaseClass {

	// Refer TestUtilities Class for Data provider methods
	// Refer Test data folder>SetupTestData.xlsx sheet for test data i/p

	public HitNTrialTests() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExtentReports extent;
	public ExtentTest extentTest;

	// Initialization of the Pages
	LoginPage LoginPage;
	MainHubPage MainHubPage;
	UserManagementPage UserManagementPage;
	assetHubPage assetHubPage;
	assetCreationPage assetCreationPage;
	assetDetailsPage2 assetDetailsPage;

	SelectBaseStationPage SelectBaseStationPage;
	SelectLoggersPage SelectLoggersPage;
	MappingSensorsPage MappingSensorsPage;
	ProgramLoggersPage ProgramLoggersPage;
	QualificationPage QualificationPage;
	ReadLoggersPage ReadLoggersPage;
	RW_FileSelctionPage RWFileSelctionPage;
	TestUtilities tu = new TestUtilities();

	// Before Class -All the tests are conducted
	@BeforeClass
	public void PreSetup() throws InterruptedException, IOException, ParseException, AWTException {

		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ER_" + "QualificationProcessTest" + ".html", true);
		//extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ER_" + "QualificationStartTest" + ".html", true);
		//extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ER_" + "Qualification_STOPTest" + ".html", true);
		extent.addSystemInfo("TestSuiteName", "QualificationStartTest");
		extent.addSystemInfo("BS Version", prop.getProperty("BS_Version"));
		extent.addSystemInfo("Lgr Version", prop.getProperty("Lgr_Version"));
		extent.addSystemInfo("ScriptVersion", prop.getProperty("ScriptVersion"));
		extent.addSystemInfo("User Name", prop.getProperty("User_Name1"));
		System.out.println("Qualification Process Test is in Progress..");
		//System.out.println("Qualification START Test is in Progress..");
		//System.out.println("Qualification STOP Test is in Progress..");
		//Deleting/CLearing the log files present in the C-Drive comlog folder
        String path1 = "C:\\DataFiles\\COMMLog";
        tu.DeleteFiles(path1);
        //Deleting/Clearing the log files present in the App DataFiles folder
        String path2 = "C:\\Program Files (x86)\\Kaye\\Kaye AVS Service\\DataFiles\\Logs";
        tu.DeleteFiles(path2);		
		
	}

	// @AfterClass-All the tests are conducted
	@AfterClass
	public void endReport_releaseMomory() {
		extent.flush();
		extent.close();
	}

	// Before Method(Test) method
	@BeforeMethod(alwaysRun = true)
	public void Setup() throws InterruptedException, IOException {

		LaunchApp("Kaye.ValProbeRT_racmveb2qnwa8!App");
		Thread.sleep(500);
		LoginPage = new LoginPage();
		extent.addSystemInfo("VRT Version", LoginPage.get_SWVersion_About_Text());

	}

	// @AfterMethod TearDown of the App
	@AfterMethod(alwaysRun = true)
	public void Teardown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			// to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS # " + result.getName() + " #");
			// to add error/exception in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS # " + result.getThrowable() + " #");
			// to add screenshot in extent report
			String screenshotPath1 = TestUtilities.getFailedTCScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath1));
			// to add screencast/video in extent report
			// extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath));

		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS # " + result.getName() + " #");

		}
		extent.endTest(extentTest); // ending test and ends the current test and prepare to create html report
		driver.quit();
	}

	// Test Cases

	// QUALIFICATION START-STOP process for a 10 mnt study
	@Test(groups = {
			"Regression" }, dataProvider = "QUAL001", dataProviderClass = QualificationUtility.class, 
					description = "Qualification process flow")
	public void QUAL001(String RunNo, String UID, String PW, String Aname, String Sname, String BSIP, String SetupSOP,
			String StudyTimeInMinutes, String StudySaveComment) throws InterruptedException, IOException, AWTException {

		extentTest = extent.startTest("Qualification process flow");
		SoftAssert sa = new SoftAssert();
		System.out.println("++++++++++++Run # "+RunNo+" Started at "+tu.get_CurrentDateandTimeStamp2("dd-MM-yyyy_HH:mm:ss")+"++++++++++++");
		//tu.get_CurrentDateandTimeStamp2("dd-MM-yyyy_HH:mm:ss");
		//Create a folder in the My Documents folder for the current run to add log files and Fail snapshots if any
		//String FPath = new JFileChooser().getFileSystemView().getDefaultDirectory().toString() 
		//		+"\\" +Aname+"_"+Sname+"_"+tu.get_CurrentDateandTimeStamp2("ddMMyyyy-HHmmss");
		String FPath2 = System.getProperty("user.home") + "\\Documents"+"\\" +RunNo+"-"+Aname+"_"+Sname+"_"+tu.get_CurrentDateandTimeStamp2("ddMMyyyy-HHmmss");
		//System.out.println(Path);
		tu.create_Folder(FPath2);
				
		MainHubPage = LoginPage.Login(UID, PW);
		assetHubPage = MainHubPage.Click_AssetTile2();
		assetDetailsPage = assetHubPage.click_assetTile2(Aname);
		Thread.sleep(2000);
		assetDetailsPage.click_SetupTile();
		// assetDetailsPage.click_SetupHeaderBlockText();
		assetDetailsPage.click_SetupListPanel();
		assetDetailsPage.Click_SetupName(Sname);

		assetDetailsPage.click_InitiateQualBtn();
		SelectBaseStationPage = assetDetailsPage.Enter_SOP(SetupSOP);
		SelectBaseStationPage.Enter_BS_IPAddress(BSIP);
		SelectBaseStationPage.Enter_Add_btn();
		Thread.sleep(2000);
		SelectBaseStationPage.Select_BSListbox("Ethernet IP-- " + BSIP);
		SelectLoggersPage = SelectBaseStationPage.Click_ConnectBtn();
		System.out.println("Moved to Select Loggers Page...");
		//Conduct Force Idle Operation
		SelectLoggersPage.click_SelectAllLoggers_Btn();
		SelectLoggersPage.click_ForceIdle_Btn();
		System.out.println("Force Idle Operation completed...");
		SelectLoggersPage.click_SelectAllLoggers_Btn();
		SelectLoggersPage.clickNext_MappingSensorBtn();
		
		try {
			SelectLoggersPage.click_AddEqp();
			SelectLoggersPage.click_YesTo_BatteryAlert();
		} catch (Exception e) {
			System.out.println("No Equipment addition alert message displayed");
		}
		
		MappingSensorsPage = SelectLoggersPage.lgrStatusPopup_wait();
		System.out.println("Moved to Mapping Sensors Page...");
		Thread.sleep(2000);
		MappingSensorsPage.click_btnAutoMap_Btn();
		MappingSensorsPage.sensorAutoMao_operation();
		ProgramLoggersPage = MappingSensorsPage.click_NextButton_withUnmappedSensors();
		System.out.println("Moved to Program loggers screen...");
		QualificationPage = ProgramLoggersPage.click_nextbtn();
		System.out.println("Moved to Qualification Page...");
		QualificationPage.click_Start_qualbtn();
		UserLoginPopup(UID, PW);
		System.out.println("Qualification Study Started at "+tu.get_CurrentDateandTimeStamp2("dd-MM-yyyy_HH:mm:ss")+"++++++++++++");
		//This time depends upon how & where are we testing the code.
		//For Ex: If we run the code in HMI & Device in the same network, then its quite fast and a max of 5 sec is whta is required.
		//But if we try to connect an HMI & BS which is separate network and connect via VPN, then it takes more waiting time.
		Thread.sleep(30000);  

		QualificationPage.handle_lgrStatusPopup_QualStart();
		System.out.println("Waiting for the Qual study to run for "+StudyTimeInMinutes+" minutes...");
		// Method to Convert study wait time from String to integer and then to seconds
		// This time is the STudy time wait period
		int TimeInput = Integer.parseInt(StudyTimeInMinutes);
		Thread.sleep((TimeInput * 60000)-25000);
		
		System.out.println("Clicking the QUal Stop Button");		
		QualificationPage.click_Stop_qualbtn();
		UserLoginPopup(UID, PW);
		System.out.println("Qualification Study Stopped at "+tu.get_CurrentDateandTimeStamp2("dd-MM-yyyy_HH:mm:ss")+"++++++++++++");
		System.out.println("Check for the logger status pop and move to Read Logger Page");		
		ReadLoggersPage = QualificationPage.handle_lgrStatusPopup_QualSTop();
	
		Thread.sleep(5000);
		ReadLoggersPage.click_SaveSTudybtn();
		UserLoginPopup(UID, PW);

		MainHubPage = ReadLoggersPage.click_okAndEnterComment(StudySaveComment, UID, PW);
		System.out.println("Moved to Main Hub Page");
		assetHubPage = MainHubPage.Click_AssetTile2();
		System.out.println("Moved to Asset Hub Page");
		assetDetailsPage = assetHubPage.click_assetTile2(Aname);
		System.out.println("Moved to Targeted Asset "+Aname+" Page");
		assetDetailsPage.click_QualTile();
		System.out.println("Moved to Qual tile of the targeted Asset");
		assetDetailsPage.click_QualListPanel();
		// sa.assertEquals(assetDetailsPage.qualTile_countdata(), "1", "Fail: Qualtile
		// is not displaying the count");
		// System.out.println(assetDetailsPage.qual_StudyFile_Comments_txt());
		//sa.assertEquals(assetDetailsPage.qual_StudyFile_Comments_txt(), StudySaveComment,
		//		"Fail: comment  is not displaying in the qual studyfile");
		assetDetailsPage.Select_QualFile(StudySaveComment);
		System.out.println("Selected the Targeted Qual file under the Asset "+Aname+" details Page for report creation");
		RWFileSelctionPage = assetDetailsPage.Click_GenerateReportsBtn_RWpage();
		System.out.println("Moved to RW file selection Page");
		RWFileSelctionPage.click_ExportToExcelBtn();
		Thread.sleep(2000);
		RWFileSelctionPage.selectFolder(FPath2);
		Thread.sleep(2000);
		
		String ActMsg = RWFileSelctionPage.AlertMsg();
		//System.out.println(ActMsg);
		String Expmsg = "Spreadsheet generated successfully";
		sa.assertEquals(ActMsg, Expmsg, "Fail : Spreadsheet has not generated");
		System.out.println("Spreadsheet generated successfully for the targeted Asset "+Aname);
		//Closing the App
		RWFileSelctionPage.rightclickon_RWFSPage();
		MainHubPage = RWFileSelctionPage.clickHomeIcon();
		LoginPage = MainHubPage.UserSignOut();
		LoginPage.ClickCancelBtn();
		Thread.sleep(5000);
		try {
			if (LoginPage.Is_VRTAppLoginScreen_Displayed()) {				
				System.out.println("VRT App is Not Closed and is still visible");
			}
		} catch (Exception e) {
			System.out.println("VRT App is successfuly Closed");
		}
		System.out.println("**********************************************************");
		System.out.println("---------Run # "+RunNo+" Completed at "+tu.get_CurrentDateandTimeStamp2("dd-MM-yyyy_HH:mm:ss")+"---------");
		System.out.println("**********************************************************");
		
		//Copy the log files from the C-Drive ComLog folder to the destination folder
		tu.copyFile("C:\\DataFiles\\COMMLog", FPath2);
		//Copy the log files from the App Log files folder under DataFiles to the destination folder
		tu.copyFile("C:\\\\Program Files (x86)\\\\Kaye\\\\Kaye AVS Service\\\\DataFiles\\\\Logs", FPath2);
		
		sa.assertAll();
		
	}


/*
	// Qual Start and log out from VRT application
	@Test(groups = {
			"Regression" }, dataProvider = "QUAL001", dataProviderClass = QualificationUtility.class, 
					description = "Starting a Qualification study")
	public void QUAL_Start(String RunNo, String UID, String PW, String Aname, String Sname, String BSIP, 
			String SetupSOP, String StudyTimeInMinutes, String StudySaveComment)
			throws InterruptedException, IOException, AWTException {
			
		extentTest = extent.startTest("Starting a Qualification study");
		SoftAssert sa = new SoftAssert();
		
		System.out.println("++++++++++++Run # "+RunNo+" Started at "+tu.get_CurrentDateandTimeStamp2("dd-MM-yyyy_HH:mm:ss")+"++++++++++++");
		//tu.get_CurrentDateandTimeStamp2("dd-MM-yyyy_HH:mm:ss");
		//Create a folder in the My Documents folder for the current run to add log files and Fail snapshots if any
		//String FPath = new JFileChooser().getFileSystemView().getDefaultDirectory().toString() 
		//		+"\\" +Aname+"_"+Sname+"_"+tu.get_CurrentDateandTimeStamp2("ddMMyyyy-HHmmss");
		String FPath2 = System.getProperty("user.home") + "\\Documents"+"\\" +RunNo+"-"+Aname+"_"+Sname+"_"+tu.get_CurrentDateandTimeStamp2("ddMMyyyy-HHmmss");
		//System.out.println(Path);
		tu.create_Folder(FPath2);
				
		MainHubPage = LoginPage.Login(UID, PW);
		assetHubPage = MainHubPage.Click_AssetTile2();
		assetDetailsPage = assetHubPage.click_assetTile2(Aname);
		Thread.sleep(2000);
		assetDetailsPage.click_SetupTile();
		// assetDetailsPage.click_SetupHeaderBlockText();
		assetDetailsPage.click_SetupListPanel();
		assetDetailsPage.Click_SetupName(Sname);

		assetDetailsPage.click_InitiateQualBtn();
		SelectBaseStationPage = assetDetailsPage.Enter_SOP(SetupSOP);
		SelectBaseStationPage.Enter_BS_IPAddress(BSIP);
		SelectBaseStationPage.Enter_Add_btn();
		Thread.sleep(2000);
		SelectBaseStationPage.Select_BSListbox("Ethernet IP-- " + BSIP);
		SelectLoggersPage = SelectBaseStationPage.Click_ConnectBtn();
		System.out.println("Moved to Select Loggers Page...");
		//Conduct Force Idle Operation
		SelectLoggersPage.click_SelectAllLoggers_Btn();
		SelectLoggersPage.click_ForceIdle_Btn();
		System.out.println("Force Idle Operation completed...");
		SelectLoggersPage.click_SelectAllLoggers_Btn();
		SelectLoggersPage.clickNext_MappingSensorBtn();
		
		try {
			SelectLoggersPage.click_AddEqp();
			SelectLoggersPage.click_YesTo_BatteryAlert();
		} catch (Exception e) {
			System.out.println("No Equipment addition alert message displayed");
		}
		
		MappingSensorsPage = SelectLoggersPage.lgrStatusPopup_wait();
		System.out.println("Moved to Mapping Sensors Page...");
		Thread.sleep(2000);
		MappingSensorsPage.click_btnAutoMap_Btn();
		MappingSensorsPage.sensorAutoMao_operation();
		ProgramLoggersPage = MappingSensorsPage.click_NextButton_withUnmappedSensors();
		System.out.println("Moved to Program loggers screen...");
		QualificationPage = ProgramLoggersPage.click_nextbtn();
		System.out.println("Moved to Qualification Page...");
		QualificationPage.click_Start_qualbtn();
		UserLoginPopup(UID, PW);
		System.out.println("Qualification Study Started at "+tu.get_CurrentDateandTimeStamp2("dd-MM-yyyy_HH:mm:ss")+"++++++++++++");
		//This time depends upon how & where are we testing the code.
		//For Ex: If we run the code in HMI & Device in the same network, then its quite fast and a max of 5 sec is whta is required.
		//But if we try to connect an HMI & BS which is separate network and connect via VPN, then it takes more waiting time.
		Thread.sleep(30000);  
		QualificationPage.handle_lgrStatusPopup_QualStart();
		
		// After Qual start, move to home page, Signout and close the app
		MainHubPage = QualificationPage.Click_Home_Icon_AppBar();
		MainHubPage.click_connectBtn();
		LoginPage = MainHubPage.UserSignOut();
		LoginPage.ClickCancelBtn();
		Thread.sleep(5000);
		try {
			if (LoginPage.Is_VRTAppLoginScreen_Displayed()) {
				System.out.println("VRT App is Not Closed");
			}
		} catch (Exception e) {
				System.out.println("VRT App is successfuly Closed");
		}
		System.out.println("**********************************************************");
		System.out.println("------------------Run # "+RunNo+" completed---------------");
		System.out.println("**********************************************************");
		sa.assertAll();
		
		//Copy the log files from the C-Drive ComLog folder to the destination folder
		tu.copyFile("C:\\DataFiles\\COMMLog", FPath2);
		//Copy the log files from the App Log files folder under DataFiles to the destination folder
		tu.copyFile("C:\\\\Program Files (x86)\\\\Kaye\\\\Kaye AVS Service\\\\DataFiles\\\\Logs", FPath2);
		
	}
	
	
*/
	
/*	// Qual Stop and log out from VRT application
	@Test(groups = { "Regression" }, dataProvider = "QUAL001", dataProviderClass = QualificationUtility.class, 
			description = "QUALIFICATION Stop process")
	public void QUAL_STOP(String RunNo, String UID, String PW, String Aname, String Sname, String BSIP, 
			String SetupSOP, String StudyTimeInMinutes, String StudySaveComment)
			throws InterruptedException, IOException, AWTException {
		extentTest = extent.startTest("QUALIFICATION Stop process");
		SoftAssert sa = new SoftAssert();
		
		System.out.println("++++++++++++Run # "+RunNo+" Started at "+tu.get_CurrentDateandTimeStamp2("dd-MM-yyyy_HH:mm:ss")+"++++++++++++");
		//tu.get_CurrentDateandTimeStamp2("dd-MM-yyyy_HH:mm:ss");
		//Create a folder in the My Documents folder for the current run to add log files and Fail snapshots if any
		//String FPath = new JFileChooser().getFileSystemView().getDefaultDirectory().toString() 
		//		+"\\" +Aname+"_"+Sname+"_"+tu.get_CurrentDateandTimeStamp2("ddMMyyyy-HHmmss");
		String FPath2 = System.getProperty("user.home") + "\\Documents"+"\\" +RunNo+"-"+Aname+"_"+Sname+"_"+tu.get_CurrentDateandTimeStamp2("ddMMyyyy-HHmmss");
		//System.out.println(Path);
		tu.create_Folder(FPath2);
		
		MainHubPage = LoginPage.Login(UID, PW);
		SelectBaseStationPage = MainHubPage.clickonDiscoverTile();
		SelectBaseStationPage.Enter_BS_IPAddress(BSIP);
		SelectBaseStationPage.Enter_Add_btn();
		Thread.sleep(2000);
		SelectBaseStationPage.Select_BSListbox("Ethernet IP-- " + BSIP);
		QualificationPage = SelectBaseStationPage.ClickConnectBtn_ViaDiscovertile();
		System.out.println("Moved to Qualification Page...");

		QualificationPage.clickQstop_ToGetRidOfHistoricalData_AlertMsg();
		QualificationPage.click_Stop_qualbtn();
		UserLoginPopup(UID, PW);
		System.out.println("Qualification Study Stopped at "+tu.get_CurrentDateandTimeStamp2("dd-MM-yyyy_HH:mm:ss")+"++++++++++++");
		System.out.println("Check for the logger status pop and move to Read Logger Page");		
		ReadLoggersPage = QualificationPage.handle_lgrStatusPopup_QualSTop();
	
		Thread.sleep(5000);
		ReadLoggersPage.click_SaveSTudybtn();
		UserLoginPopup(UID, PW);

		MainHubPage = ReadLoggersPage.click_okAndEnterComment(StudySaveComment, UID, PW);
		System.out.println("Moved to Main Hub Page");
		assetHubPage = MainHubPage.Click_AssetTile2();
		System.out.println("Moved to Asset Hub Page");
		assetDetailsPage = assetHubPage.click_assetTile2(Aname);
		System.out.println("Moved to Targeted Asset "+Aname+" Page");
		assetDetailsPage.click_QualTile();
		System.out.println("Moved to Qual tile of the targeted Asset");
		assetDetailsPage.click_QualListPanel();
		// sa.assertEquals(assetDetailsPage.qualTile_countdata(), "1", "Fail: Qualtile
		// is not displaying the count");
		// System.out.println(assetDetailsPage.qual_StudyFile_Comments_txt());
		//sa.assertEquals(assetDetailsPage.qual_StudyFile_Comments_txt(), StudySaveComment,
		//		"Fail: comment  is not displaying in the qual studyfile");
		assetDetailsPage.Select_QualFile(StudySaveComment);
		System.out.println("Selected the Targeted Qual file under the Asset "+Aname+" details Page for report creation");
		RWFileSelctionPage = assetDetailsPage.Click_GenerateReportsBtn_RWpage();
		System.out.println("Moved to RW file selection Page");
		RWFileSelctionPage.click_ExportToExcelBtn();
		Thread.sleep(2000);
		RWFileSelctionPage.selectFolder(FPath2);
		Thread.sleep(2000);
		
		String ActMsg = RWFileSelctionPage.AlertMsg();
		//System.out.println(ActMsg);
		String Expmsg = "Spreadsheet generated successfully";
		sa.assertEquals(ActMsg, Expmsg, "Fail : Spreadsheet has not generated");
		System.out.println("Spreadsheet generated successfully for the targeted Asset "+Aname);
		//Closing the App
		RWFileSelctionPage.rightclickon_RWFSPage();
		MainHubPage = RWFileSelctionPage.clickHomeIcon();
		LoginPage = MainHubPage.UserSignOut();
		LoginPage.ClickCancelBtn();
		Thread.sleep(5000);
		try {
			if (LoginPage.Is_VRTAppLoginScreen_Displayed()) {				
				System.out.println("VRT App is Not Closed and is still visible");
			}
		} catch (Exception e) {
			System.out.println("VRT App is successfuly Closed");
		}
		System.out.println("**********************************************************");
		System.out.println("---------Run # "+RunNo+" Completed at "+tu.get_CurrentDateandTimeStamp2("dd-MM-yyyy_HH:mm:ss")+"---------");
		System.out.println("**********************************************************");
		
		//Copy the log files from the C-Drive ComLog folder to the destination folder
		tu.copyFile("C:\\DataFiles\\COMMLog", FPath2);
		//Copy the log files from the App Log files folder under DataFiles to the destination folder
		tu.copyFile("C:\\\\Program Files (x86)\\\\Kaye\\\\Kaye AVS Service\\\\DataFiles\\\\Logs", FPath2);
		
		sa.assertAll();
		
	}*/
	
}
