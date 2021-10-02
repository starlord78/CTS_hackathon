package com.coursera.org.functionalitiestest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.coursera.org.base.Base;
import com.coursera.org.functions.LanguageLearningCoursesCount;

public class LanguageLearningCoursesCountTest {

	LanguageLearningCoursesCount langCount = new LanguageLearningCoursesCount();
	Base base = new Base();

	@Test
	public void testLoadLanguageLearningPage() {

		try {
			base.createDriver();
			System.out.println("Browser opened and URL loaded");
			langCount.loadLanguageLearningPage();
			System.out.println("Language page opened");
			langCount.languageFilter();
			System.out.println("Printed values in console & excel");
			langCount.closeLanguageFilter();
			base.tearDown();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testLoadLanguageLearningPage2() {

		try {
			base.createDriver();
			System.out.println("Browser opened and URL loaded");
			langCount.loadLanguageLearningPage();
			System.out.println("Language page opened");
			langCount.levelFilter();
			System.out.println("Printed values in console & excel");
			base.quitBrowser();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
