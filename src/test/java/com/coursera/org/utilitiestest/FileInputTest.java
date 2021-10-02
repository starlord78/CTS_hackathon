package com.coursera.org.utilitiestest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.coursera.org.utilities.FileInput;

public class FileInputTest {

	@Test
	public void retriveInputData() {

		try {
			FileInput fi = new FileInput();
			String F_name = fi.getData("f_name");
			String L_name = fi.getData("l_name");
			System.out.println("First name: " + F_name);
			System.out.println("Last name: " + L_name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
