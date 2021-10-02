package com.coursera.org.test;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;

import com.coursera.org.base.Base;
import com.coursera.org.functions.IdentifyCourses;
import com.coursera.org.utilities.HighlighterAndScreenshotClass;

public class IdentifyCoursesTest extends Base {

	HighlighterAndScreenshotClass hs = new HighlighterAndScreenshotClass();

	public class validateIdentifyCourses extends Base {

		IdentifyCourses homepage = new IdentifyCourses();

		/****************** This method is use to Search Course ***********************/
		@Test(priority = 1, groups = "Smoke Test")
		public void validateSearchCourse() throws Exception {
			try {
				homepage.searchCourse();

			} catch (Exception e) {
				System.out.println(e);
			}
		}

		/****************** Select Language ***********************/
		@Test(priority = 2, groups = "Smoke Test")
		public void validateSelectLanguage() {
			try {
				homepage.selectLanguage();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		/****************** Select Level ***********************/
		@Test(priority = 3, groups = "Smoke Test")
		public void validateSelectLevel() {
			try {
				homepage.selectLevel();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		/****************** Validate First Course ***********************/
		@Test(priority = 4, groups = "Smoke Test")
		public void validateFirstCourse() {
			try {
				homepage.firstCourse();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		/****************** Validate Second Course ***********************/
		@Test(priority = 5, groups = "Smoke Test", dependsOnMethods = "validateFirstCourse")
		public void validateSecondCourse() {
			try {
				homepage.secondCourse();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		/****************** Screen Shot ***********************/
		@Test(priority = 6, groups = "Smoke Test")
		public void returnHome() throws InterruptedException {
			returnhome();
			assertEquals(getPageTitle(), "Coursera | Online Courses & Credentials From Top Educators. Join for Free");
			System.out.println("*****Identify Course Test Passed Successfully*****");
		}

	}
}