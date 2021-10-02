package com.coursera.org.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import com.coursera.org.base.Base;
import com.coursera.org.functions.LanguageLearningCoursesCount;
import com.coursera.org.utilities.FileOutput;

public class LanguageLearningCourseCountTest extends Base {

	LanguageLearningCoursesCount count = new LanguageLearningCoursesCount();
	FileOutput fo = new FileOutput();

	@Test(priority = 7, groups = "Smoke Test")
	public void loadLanguageLearningPage() {
		System.out.println("*****Language Learning Course Count Test Started*****");
		try {
			Thread.sleep(2000);
			count.loadLanguageLearningPage();
			implicitWait(10);
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		assertEquals(getPageTitle(), "Top Language Learning Courses - Learn Language Learning Online | Coursera");
	}

	@Test(priority = 8, groups = "Smoke Test")
	public void applyLanguageFilter() {
		try {
			count.languageFilter();
			boolean findLastRow = fo.findLastRow(1) > 0;
			assertEquals(findLastRow, true);
			count.closeLanguageFilter();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 8, groups = "Smoke Test")
	public void applyLevelFilter() {
		try {
			count.levelFilter();
			boolean findLastRow = fo.findLastRow(2) > 0;
			assertEquals(findLastRow, true);
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		System.out.println("*****Language Learning Course Count Test Passed Successfully*****");
	}
}
