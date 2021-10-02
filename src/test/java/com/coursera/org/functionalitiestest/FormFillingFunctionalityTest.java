package com.coursera.org.functionalitiestest;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.coursera.org.base.Base;
import com.coursera.org.functions.FormFillingDataProvider;
import com.coursera.org.functions.FormFillingFunctionality;
import com.coursera.org.utilities.HighlighterAndScreenshotClass;

public class FormFillingFunctionalityTest {

	HighlighterAndScreenshotClass hs = new HighlighterAndScreenshotClass();
	FormFillingFunctionality form = new FormFillingFunctionality();
	Base base = new Base();

	@BeforeSuite
	public void setupDriver() {
		base.createDriver();
		System.out.println("Browser opened and URL loaded");
	}

	@BeforeTest
	public void testLocateForm() {

		try {
			base.returnhome();
			form.locateForm();
			base.implicitWait(10);
			base.scrollPage();
			System.out.println("Form page loaded successfully");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 0, dataProvider = "formData", dataProviderClass = FormFillingDataProvider.class)
	public void fillAllValues(String f_Name, String l_Name, String job_Func, String job_Title, String work_Email,
			String phone_No, String institute_Name, String institute_Type, String primary_Dis, String country,
			String state, String textArea, String ssName) throws IOException, InterruptedException {

		form.fillFirst_name(f_Name);
		Thread.sleep(1000);

		form.fillLast_name(l_Name);
		Thread.sleep(1000);

		form.fillJob_func(job_Func);
		Thread.sleep(1000);

		form.fillJob_title(job_Title);
		Thread.sleep(1000);

		form.fillEmail(work_Email);
		Thread.sleep(1000);

		form.fillPhone_no(phone_No);
		Thread.sleep(1000);

		form.fillInstitute_name(institute_Name);
		Thread.sleep(1000);

		form.fillInstitute_type(institute_Type);
		Thread.sleep(1000);
		form.scrollPageBy(450);

		form.fillPrimary_dis(primary_Dis);
		Thread.sleep(1000);

		form.fillCountry(country);
		Thread.sleep(1000);

		if (country.equalsIgnoreCase("Country")) {

		} else {
			form.fillState(state);
			Thread.sleep(1000);
		}
		form.fillTextArea(textArea);
		Thread.sleep(1000);

		form.clickSubmitButton();
		Thread.sleep(1000);

		try {
			Thread.sleep(1000);
			hs.takeScreenshot(ssName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		base.refresh();
		base.scrollPage();

	}

	@AfterSuite
	public void insertvalue() {

		base.quitBrowser();
	}

}
