/**
 * @author manoj.ghadei
 *
 */

package com.vrt.testcases;

import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import org.testng.TestNG;

import com.vrt.Listners.ExtentReporterNG;

public class testRunner {
	
	static TestNG testng;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws FileNotFoundException {		
		JOptionPane.showMessageDialog(null, "Please ensure the WinAppDriver.exe is launched present "
				+ "at the location- C:\\Program Files (x86)\\Windows Application Driver", "InfoBox: Alert!", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "For App UID & PW,which Asset & Setup Name to select, "
				+ "BaseStation IP address, SOP data, Study time in Minutes & Study save comment, "
				+ "Please update the excel sheet provided with this exe", "InfoBox: Alert!", JOptionPane.INFORMATION_MESSAGE);
		ExtentReporterNG er = new ExtentReporterNG();

		testng = new TestNG();
		//testng.setTestClasses(new Class[] {HitNTrialTests.class});
		testng.setTestClasses(new Class[] {QualificationProcessTest.class});

		testng.run();			
	}

}
