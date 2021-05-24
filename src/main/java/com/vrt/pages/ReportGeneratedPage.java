/**
 * @author manoj.ghadei
 *
 */

package com.vrt.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vrt.base.BaseClass;
import com.vrt.utility.TestUtilities;

public class ReportGeneratedPage extends BaseClass {

	TestUtilities TU = new TestUtilities();
	// Asset Details element variable declaration definition
	WebElement ReportButton = null;
	
	private void initElements() {
		ReportButton = driver.findElementByAccessibilityId("ReportButton");
		
	}

	ReportGeneratedPage() throws IOException {
		super();
		initElements();
	}

	// Check the presence of ReportButton
	
	public boolean ReportButton_state() {
		return IsElementVisibleStatus(ReportButton);
	}

}
