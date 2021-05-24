package com.vrt.testcases;

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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.vrt.base.BaseClass;
import com.vrt.pages.LoginPage;
import com.vrt.pages.MainHubPage;
import com.vrt.pages.UserManagementPage;
import com.vrt.pages.assetCreationPage;
import com.vrt.pages.assetHubPage;
import com.vrt.pages.SelectBaseStationPage;
import com.vrt.pages.SelectLoggersPage;
import com.vrt.pages.ProgramLoggersPage;
import com.vrt.pages.QualificationPage;
import com.vrt.pages.ReadLoggersPage;
import com.vrt.pages.RW_FileSelctionPage;
import com.vrt.pages.assetDetailsPage2;

import com.vrt.pages.MappingSensorsPage;
import com.vrt.utility.QualificationUtility;
import com.vrt.utility.TestUtilities;

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

		extent = new ExtentReports(
				System.getProperty("user.dir") + "/test-output/ER_" + "QualificationProcessTest" + ".html", true);
		extent.addSystemInfo("TestSuiteName", "QualificationProcessTest");
		extent.addSystemInfo("BS Version", prop.getProperty("BS_Version"));
		extent.addSystemInfo("Lgr Version", prop.getProperty("Lgr_Version"));
		extent.addSystemInfo("ScriptVersion", prop.getProperty("ScriptVersion"));
		extent.addSystemInfo("User Name", prop.getProperty("User_Name1"));
		System.out.println("Qualification Process Test is in Progress..");

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

	// QUAL001-Verify the Qualification process for a 10 mnt study
	@Test(groups = {
			"Regression" }, dataProvider = "QUAL001", dataProviderClass = QualificationUtility.class, 
					description = "Qualification process flow")
	public void QUAL001(String UID, String PW, String Aname, String Sname, String BSIP, String SetupSOP,
			String StudyTimeInMinutes, String StudySaveComment) throws InterruptedException, IOException, AWTException {

		extentTest = extent.startTest("Qualification process flow");
		SoftAssert sa = new SoftAssert();
		
		//Create a folder for the current run to add log files and Fail snapshots if any
		String FPath2 = System.getProperty("user.home") + "\\Documents"+"\\" +Aname+"_"+Sname+"_"+tu.get_CurrentDateandTimeStamp2("ddMMyyyy-HHmmss");
		//System.out.println(FPath2);
		tu.create_Folder(FPath2);
				
		MainHubPage = LoginPage.Login(UID, PW);
		assetHubPage = MainHubPage.Click_AssetTile2();
		assetDetailsPage = assetHubPage.click_assetTile2(Aname);
		Thread.sleep(2000);

		assetDetailsPage.click_QualTile();
		assetDetailsPage.Select_QualFile("fs");
		RWFileSelctionPage = assetDetailsPage.Click_GenerateReportsBtn_RWpage();
		RWFileSelctionPage.click_ExportToExcelBtn();
		Thread.sleep(2000);
		RWFileSelctionPage.selectFolder(FPath2);
		Thread.sleep(2000);

		String ActMsg = RWFileSelctionPage.AlertMsg();
		//System.out.println(ActMsg);
		String Expmsg = "Spreadsheet generated successfully";
		sa.assertEquals(ActMsg, Expmsg, "Fail : Spreadsheet has not generated");
		
		//Closing the App
		RWFileSelctionPage.rightclickon_RWFSPage();
		MainHubPage = RWFileSelctionPage.clickHomeIcon();
		LoginPage = MainHubPage.UserSignOut();
		LoginPage.ClickCancelBtn();
		Thread.sleep(5000);
		
		sa.assertAll();
		
	}
	
	
/*
	// QUAL002-Verify the Qualification record export
	@Test(groups = {
			"Regression" }, dataProvider = "QUAL001", dataProviderClass = QualificationUtility.class, description = "QUAL002-Gereating the Raw Excel report of the Qual Study generated")
	public void QUAL002(String UID, String PW, String Aname, String Sname, String BSIP, String SetupSOP,
			String StudyTimeInMinutes, String StudySaveComment) throws InterruptedException, IOException, AWTException {
		// , String lname , String BSIP
		extentTest = extent.startTest("QUAL002-Gereating the Raw Excel report of the Qual Study generated");
		SoftAssert sa = new SoftAssert();
		MainHubPage = LoginPage.Login(getUID("adminFull"), getPW("adminFull"));
		assetHubPage = MainHubPage.Click_AssetTile();
		assetDetailsPage = assetHubPage.click_assetTile2(Aname);

		assetDetailsPage.click_QualTile();
		assetDetailsPage.Select_QualFile(Sname);
		RWFileSelctionPage = assetDetailsPage.Click_GenerateReportsBtn_RWpage();
		RWFileSelctionPage.click_ExportToExcelBtn();
		Thread.sleep(2000);
		RWFileSelctionPage.selectFolder();
		Thread.sleep(2000);

		String ActMsg = RWFileSelctionPage.AlertMsg();
		// System.out.println(ActMsg);
		String Expmsg = "Spreadsheet generated successfully";
		sa.assertEquals(ActMsg, Expmsg, "Fail : Spreadsheet has not generated");
		sa.assertAll();
	}

	// Qual Start and log out from VRT application
	@Test(groups = {
			"Regression" }, dataProvider = "QUAL001", dataProviderClass = QualificationUtility.class, description = "QUAL001-Verify the Qualification process")
	public void QUAL003(String UID, String PW, String Aname, String Sname, String BSIP)
			throws InterruptedException, IOException, AWTException {
		// , String lname , String BSIP
		extentTest = extent.startTest("QUAL001-Verify the Qualification process");
		SoftAssert sa = new SoftAssert();
		MainHubPage = LoginPage.Login(UID, PW);
		assetHubPage = MainHubPage.Click_AssetTile();
		assetDetailsPage = assetHubPage.click_assetTile2(Aname);

		assetDetailsPage.Click_SetupName(Sname);

		assetDetailsPage.click_InitiateQualBtn();

		SelectBaseStationPage = assetDetailsPage.Enter_SOP("2");

		// SelectBaseStationPage.Click_DiscoverBS();
		// Thread.sleep(5000);
		// sa.assertEquals(SelectBaseStationPage.BSListbox_Isdisplayed(), true);

		SelectBaseStationPage.Enter_BS_IPAddress(BSIP);
		SelectBaseStationPage.Enter_Add_btn();
		Thread.sleep(3000);

		SelectBaseStationPage.Select_BSListbox("Ethernet IP-- " + BSIP);
		// Ethernet IP-- 192.168.99.50
		// Ethernet IP-- 10.17.18.55
		SelectLoggersPage = SelectBaseStationPage.Click_ConnectBtn();
		SelectLoggersPage.click_SelectAllLoggers_Btn();

		MappingSensorsPage = SelectLoggersPage.click_mappingsensorBtn();
		Thread.sleep(3000);

		MappingSensorsPage.click_btnAutoMap_Btn();
		MappingSensorsPage.click_SelectAll_checkbox();
		ProgramLoggersPage = MappingSensorsPage.click_NextButton_withUnmappedSensors();
		QualificationPage = ProgramLoggersPage.click_nextbtn();
		// sa.assertEquals(QualificationPage.qualificationTitle_Fetch(),"Qualification","fail:
		// qualification title is not correct");
		Thread.sleep(2000);
		QualificationPage.click_Start_qualbtn();
		Thread.sleep(2000);
		MainHubPage = QualificationPage.Click_Home_Icon_AppBar();
		MainHubPage.click_connectBtn();
		LoginPage = MainHubPage.UserSignOut();
		LoginPage.ClickCancelBtn();

		// Thread.sleep(2000);
		// QualificationPage.click_AppClose_btn();

	}

	// Qual Stop and log out from VRT application
	@Test(groups = { "Regression" }, description = "QUAL001-Verify the Qualification process")
	public void QUAL004() throws InterruptedException, IOException, AWTException {
		// , String lname , String BSIP
		extentTest = extent.startTest("QUAL001-Verify the Qualification process");
		SoftAssert sa = new SoftAssert();
		MainHubPage = LoginPage.Login(getUID("adminFull"), getPW("adminFull"));
		SelectBaseStationPage = MainHubPage.clickonDiscoverTile();
		SelectBaseStationPage.Enter_BS_IPAddress("192.168.99.50");
		SelectBaseStationPage.Enter_Add_btn();
		Thread.sleep(3000);
		SelectBaseStationPage.Select_BSListbox("Ethernet IP-- 192.168.99.50");
		// Ethernet IP-- 192.168.99.50
		// Ethernet IP-- 10.17.18.55
		QualificationPage = SelectBaseStationPage.ClickConnectBtn_ViaDiscovertile();
		// QualificationPage.click_stopQuaal();
		// Thread.sleep(4000);

		ReadLoggersPage = QualificationPage.clickQstop_HistoricalData();
		ReadLoggersPage.click_Savebtn();
		MainHubPage = ReadLoggersPage.click_okAndEnterComment("ABC");
	}*/
}
