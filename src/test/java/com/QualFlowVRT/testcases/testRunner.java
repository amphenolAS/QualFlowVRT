/**
 * @author manoj.ghadei
 *
 */

package com.QualFlowVRT.testcases;

import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import org.testng.TestNG;
import com.QualFlowVRT.Listners.ExtentReporterNG;

public class testRunner {
	
	static TestNG testng;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws FileNotFoundException {		
		int option = JOptionPane.showConfirmDialog(null, "Did you launch the WinAppDriver.exe? " + "\r\n"
				+ "Continue by clicking Yes, else click No to stop the process and relaunch WinAppDriver.exe. "
				+ "\r\n" + "One can fine it at the location- C:\\\\Program Files (x86)\\\\Windows Application Driver.", "Alert!!!",
				JOptionPane.YES_NO_OPTION);
		if (option == 1) {
			System.exit(1);
		}
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
