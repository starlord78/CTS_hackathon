package com.coursera.org.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import com.coursera.org.base.Base;
import com.coursera.org.functions.FormFillingFunctionality;

public class FormFillingTestWithValidData extends Base {

	FormFillingFunctionality form = new FormFillingFunctionality();

	@Test(priority = 9, groups = "Smoke Test")
	public void locateForm() {
		System.out.println("*****Form Filling Test Started*****");
		returnhome();
		try {
			Thread.sleep(2000);
			form.locateForm();
			implicitWait(10);
			assertEquals(getPageTitle(), "Coursera for Campus | Online Learning Platform for Universities");
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		System.out.println("Form loaded successfully");
		scrollPage();

	}

	@Test(priority = 10, groups = "Smoke Test")
	public void fillValidValues() {
		try {
			form.fillAllValues();
			implicitWait(10);
			Thread.sleep(2000);
			assertEquals(getPageTitle(), "Thank you - Coursera for Campus");
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Form filled successfully");
	}

}
