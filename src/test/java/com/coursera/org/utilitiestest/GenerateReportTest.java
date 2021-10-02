package com.coursera.org.utilitiestest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.coursera.org.utilities.GenerateReport;

public class GenerateReportTest {

	@Test
	public void generateHTMLReport() {
		
	GenerateReport gr = new GenerateReport();		
	
	try {
		ExtentReports report;
		report = gr.extentReport("Test_Report");
		ExtentTest logger;
		
		logger = report.createTest("Sample Test");
		logger.log(Status.PASS, "Test1");
		logger.log(Status.PASS, "Test2");
		logger.log(Status.FAIL, "Test3");
		logger.log(Status.FAIL, "Test4");
		logger.log(Status.INFO, "Test5");
		logger.log(Status.INFO, "Test6");
		report.flush();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	}
	
	
}
