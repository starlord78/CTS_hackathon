package com.coursera.org.utilitiestest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.coursera.org.utilities.FileOutput;

public class FileOutputTest {

	FileOutput fo = new FileOutput();

	@Test
	public void addValuesToExceel() {

		try {
			fo.printValues(0, 0, "C_Name",1, 0);
			fo.printValues(1, 0, "Course 1",2, 0);
			fo.printValues(2, 0, "Course 2",3, 0);
			System.out.println("Values addedd...");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void findLastRow() {
		try {
			int lastRow = fo.findLastRow(0);
			System.out.println("Last row number - " + lastRow);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteValuesInSheet() {
		try {
			fo.deleteDataInSheet(2);
			System.out.println("Data deleted...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
