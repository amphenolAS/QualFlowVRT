package com.vrt.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.vrt.base.BaseClass;

public class QualificationUtility extends BaseClass {

	public QualificationUtility() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	// Read TestData from the Excel sheet
	//Below Path will be used while executing scripts from Eclipse IDE.
	//public static String TestData_sheetPath = System.getProperty("user.dir") + "/src/test/resources/TestData/" + "QualProcessTestData.xlsx";
	
	//Below Path will be used whle creating an Jar/exe file where the config file will be 
	//placed present in the jar.exe path location.
	public static String TestData_sheetPath = System.getProperty("user.dir") + "/QualProcessTestData.xlsx";
	


	static Workbook book;
	static Sheet sheet;

	// Read TestData from the Excel sheet
	public static Object[][] getTestData(String sheetName) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(TestData_sheetPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(fis);
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(sheet.getLastRowNum() + "--------" + sheet.getRow(0).getLastCellNum());

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				// System.out.println(data[i][j]);
			}
		}
		return data;
	}

	// Data Providers

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ADMIN module related Test Data reference
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	@DataProvider(name = "QUAL001")
	public static Object[][] QUAL001() {
		String sheetName = "QUAL001";
		Object[][] data = getTestData(sheetName);
		return data;
	}

}
