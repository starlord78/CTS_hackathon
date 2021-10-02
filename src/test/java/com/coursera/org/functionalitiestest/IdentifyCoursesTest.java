package com.coursera.org.functionalitiestest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.coursera.org.base.Base;
import com.coursera.org.functions.IdentifyCourses;

public class IdentifyCoursesTest {

	Base base = new Base();
	IdentifyCourses course = new IdentifyCourses();

	@Test
	public void testIdentifyCouerses() {

		try {
			course.searchCourse();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}

		base.quitBrowser();

	}

}
