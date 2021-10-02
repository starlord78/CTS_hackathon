package com.coursera.org.test;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.coursera.org.base.Base;

public class TestSetup extends Base {

	@BeforeSuite(groups = { "Smoke Test", "Regression Test" })
	// This method is used to invoking driver
	public void initialiseSetUp() throws IOException {
		createDriver();
		pageLoadOut(10000);
		implicitWait(10000);

	}

	@AfterSuite(groups = { "Smoke Test", "Regression Test" })
	public void tearDown() {
		driver.quit();
	}

}
