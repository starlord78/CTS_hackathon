package com.coursera.org.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileOutput {

	public static File source = null;

	/**
	 * This method is used to set excel path to the source public variable
	 * 
	 * @throws IOException
	 */
	public void setFileSource() throws IOException {
		FileInput fi = new FileInput();
		source = new File(fi.getData("excel_path"));
	}

	/**
	 * This method prints the values values that we give into the excel. The path
	 * excel is fixed.
	 * 
	 * @param row
	 * @param column
	 * @param value
	 * @param sheetNumber
	 * @throws IOException
	 */
	public void printValues(int row, int column, String value1, int value2, int sheetNumber) throws IOException {

		// Opening the excel file and locating the correct sheet
		setFileSource();
		FileInputStream fis = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(sheetNumber);

		// Identifying the proper cell, entering values into it and resizing that column

		sh.createRow(row).createCell(column).setCellValue(value1);
		sh.getRow(row).createCell(column + 1).setCellValue(value2);
		sh.autoSizeColumn(column);

		// Closing the file
		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();

	}

	/**
	 * This method prints the values values that we give into the excel. The path
	 * excel is fixed.
	 * 
	 * @param row
	 * @param column
	 * @param value
	 * @param sheetNumber
	 * @throws IOException
	 */
	public void printValues(int row, int column, String value, int sheetNumber) throws IOException {

		// Opening the excel file and locating the correct sheet
		setFileSource();
		FileInputStream fis = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(sheetNumber);

		// Identifying the proper cell, entering values into it and resizing that column
		sh.createRow(row).createCell(column).setCellValue(value);
		sh.autoSizeColumn(column);

		// Closing the file
		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();

	}

	/**
	 * This method is to find the last row of the excel sheet.
	 * 
	 * @param sheetNumber
	 * @return integer
	 * @throws IOException
	 */
	public int findLastRow(int sheetNumber) throws IOException {

		// Opening the excel file and locating the correct sheet
		setFileSource();
		FileInputStream fis = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(sheetNumber);

		// Finding the last row of the sheet
		int lastRowNum = sh.getLastRowNum();

		// Closing the excel and returning the row number
		wb.close();
		return lastRowNum;
	}

	/**
	 * This method is to delete data in the excel sheet.
	 * 
	 * @param sheetNumber
	 * @return integer
	 * @throws IOException
	 */
	public void deleteDataInSheet(int sheetNumber) throws IOException {

		// Opening the excel file and locating the correct sheet
		setFileSource();
		FileInputStream fis = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(sheetNumber);

		// Deleting values of excel sheet
		for (int i = 0; i <= sh.getLastRowNum(); i++) {
			Row row = sh.getRow(i);
			sh.removeRow(row);
		}
		// Closing the excel and returning the row number
		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
	}

}
