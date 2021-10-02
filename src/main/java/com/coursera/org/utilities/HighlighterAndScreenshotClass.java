package com.coursera.org.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.coursera.org.base.Base;

public class HighlighterAndScreenshotClass extends Base {

	FileInput fi = new FileInput();

	/**
	 * This method is used to highlight the web elements that we need to focus on
	 * 
	 * @param element
	 * @throws InterruptedException
	 */
	public void highlighttElements(WebElement element) throws InterruptedException {

		// Initialize Java Script Executor and highlighting elements
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		// Giving a 0.5 seconds sleep timer and removes the highlighted element
		Thread.sleep(500);
		jse.executeScript("arguments[0].setAttribute('style', 'border: 2px white red;');", element);

	}

	/**
	 * This method is used to take screen shot of the page in our website and to
	 * save that in our java project.
	 * 
	 * @param filename
	 * @throws IOException
	 */
	public void takeScreenshot(String filename) throws IOException {

		// Take screen shot and saving it in the desired position
		TakesScreenshot ss = (TakesScreenshot) driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(fi.getData("screenshot_path") + filename + ".png"));

	}

}
