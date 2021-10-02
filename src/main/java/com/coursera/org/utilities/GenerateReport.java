package com.coursera.org.utilities;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class GenerateReport {

	public ExtentReports extentReport(String reportName) throws IOException {

		FileInput fi = new FileInput();
		// Initializing and returning ExtentReports function
		ExtentReports report = null;
		if (report == null) {
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fi.getData("report_path") + reportName + ".html");
			report = new ExtentReports();
			report.attachReporter(htmlReporter);

		}

		return report;

	}

}
