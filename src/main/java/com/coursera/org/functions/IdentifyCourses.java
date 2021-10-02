package com.coursera.org.functions;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.coursera.org.base.Base;
import com.coursera.org.utilities.HighlighterAndScreenshotClass;

public class IdentifyCourses extends Base {

	String parentWindow;
	HighlighterAndScreenshotClass hs = new HighlighterAndScreenshotClass();

	/******************
	 * Search For Course
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 ***********************/
	public void searchCourse() throws InterruptedException, IOException {
		WebElement search = driver.findElement(By.xpath(
				"//*[@id=\"rendered-content\"]/div/header/div/div/div/div[1]/div[3]/div/form/div/div/div[1]/div[1]/input"));
		// Highlight search bar
		hs.highlighttElements(search);
		search.click();
		// Enter web development courses and click enter key
		WebElement search1 = driver.findElement(By.xpath(
				"//*[@id=\"rendered-content\"]/div/header/div/div/div/div[1]/div[3]/div/form/div/div/div[1]/div[1]/input"));
		hs.highlighttElements(search1);
		search1.sendKeys("Web Development");
		Thread.sleep(1000);

		WebElement searchIcon = findElementByXpath(
				"//*[@id='rendered-content']/div/header/div/div/div/div[1]/div[3]/div/form/div/div/div[1]/button[2]/div");
		hs.highlighttElements(searchIcon);
		searchIcon.click();
		implicitWait(5000);
	}

	/******************
	 * Apply Filter For Language
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 ***********************/
	public void selectLanguage() throws InterruptedException, IOException {
		// Look for Language
		WebElement language = driver.findElement(By.xpath("//*[@id=\"react-select-2--value\"]/div[1]"));
		hs.highlighttElements(language);
		language.click();
		implicitWait(10);

		// Select English Language
		WebElement english = driver
				.findElement(By.xpath("//*[@id=\"react-select-2--option-0\"]/div/button/label/input"));
		hs.highlighttElements(findElementByXpath("//*[@id=\"react-select-2--option-0\"]/div/button"));
		english.click();
		hs.takeScreenshot("Language");
		System.out.println("English");

	}

	/******************
	 * Apply Filter For Level
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 ***********************/
	public void selectLevel() throws InterruptedException, IOException {
		// Look for Level
		WebElement level = driver.findElement(By.xpath("//*[@id='react-select-3--value']/div[1]"));
		hs.highlighttElements(level);
		level.click();
		implicitWait(10);

		// Select Beginner Language
		WebElement beginner = driver
				.findElement(By.xpath("//*[@id=\"react-select-3--option-1\"]/div/button/label/input"));
		hs.highlighttElements(findElementByXpath("//*[@id='react-select-3--option-1']/div/button"));
		beginner.click();
		hs.takeScreenshot("Select Level");
		System.out.println("Beginner");

		scrollPageBy(250);
		implicitWait(10);
	}

	/******************
	 * Extract the course names, total learning hours & rating for first course
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 ***********************/
	public void firstCourse() throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		Reporter.log(" ");
		Reporter.log("Details of First Course :");
		Reporter.log(" ");

		// Extract the name of the first course
		implicitWait(30);
		String courseName1 = driver
				.findElement(By.xpath(
						"//*[@id=\"main\"]/div/div/div[1]/div/div/div/div/div/div/ul/li[1]/div/div/a/div/div[2]/h2"))
				.getText();
		System.out.println(courseName1);
		Reporter.log("Course Name - " + courseName1);
		hs.takeScreenshot("courseName1");
		System.out.println(courseName1);

		// Extract the rating of the first course
		String courseRating1 = driver.findElement(By.xpath(
				"//*[@id=\"main\"]/div/div/div[1]/div/div/div/div/div/div/ul/li[1]/div/div/a/div/div[2]/div[3]/div[1]/div[1]/div/span[1]"))
				.getText();
		Reporter.log("Course Rating - " + courseRating1);
		System.out.println(courseRating1);
		hs.takeScreenshot("courseRating1");

		parentWindow = driver.getWindowHandle();
		WebElement firstCourse = driver.findElement(
				By.xpath("//*[@id=\"main\"]/div/div/div[1]/div/div/div/div/div/div/ul/li[1]/div/div/a/div/div[2]/h2"));
		wait.until(ExpectedConditions.elementToBeClickable(firstCourse));
		hs.highlighttElements(firstCourse);
		firstCourse.click();
		Thread.sleep(3000);
		hs.takeScreenshot("firstCourseweb");
		System.out.println(firstCourse);

		Set<String> handles1 = driver.getWindowHandles();

		for (String childWindow1 : handles1) {
			if (!childWindow1.contentEquals(parentWindow)) {
				// Navigate to child window
				driver.switchTo().window(childWindow1);

				// Extract the duration of the first course
				implicitWait(30);

				if (driver
						.findElement(
								By.xpath("//*[@id=\"main\"]/div/div[1]/div[1]/div[1]/div[1]/div/div/div[1]/div[2]/h1"))
						.isDisplayed()) {
					String courseDuration1 = driver.findElement(By
							.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div/div[2]/div/div/div[5]/div[2]/div[1]/span"))
							.getText();
					System.out.println(courseDuration1);
					Reporter.log("Course Duration - " + courseDuration1);
					System.out.println(courseDuration1);
				} else /*
						 * if(driver.findElement(By.xpath(
						 * "/html/body/div[3]/div/div/main/div/div[2]/div/div/div/div[2]/div/div/div[5]/div[2]/div[1]/span"
						 * )).isDisplayed())
						 */ {
					String courseDuration1 = driver.findElement(By
							.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div/div[2]/div/div/div[5]/div[2]/div[2]/span"))
							.getText();
					System.out.println(courseDuration1);
					Reporter.log("Course Duration - " + courseDuration1);
				}

				driver.close();

			}

			// Get back to Parent window
			driver.switchTo().window(parentWindow);
		}
	}

	/******************
	 * Extract the course names, total learning hours & rating for Second course
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 ***********************/
	public void secondCourse() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement secondCourse = driver.findElement(
				By.xpath("//*[@id=\"main\"]/div/div/div[1]/div/div/div/div/div/div/ul/li[2]/div/div/a/div/div[2]/h2"));
		hs.highlighttElements(secondCourse);
		secondCourse.click();
		Thread.sleep(3000);
		hs.takeScreenshot("secondcourse");
		System.out.println(secondCourse);
		parentWindow = driver.getWindowHandle();

		Reporter.log(" ");
		Reporter.log("Details of Second Course :");
		Reporter.log(" ");

		// Extract the name of the second course
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Reporter.log("Course Name - " + secondCourse.getText());
		System.out.println(secondCourse);

		// Extract the rating of the second course
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String courseRating2 = driver.findElement(By.xpath(
				"//*[@id=\"main\"]/div/div/div[1]/div/div/div/div/div/div/ul/li[2]/div/div/a/div/div[2]/div[3]/div[1]/div[1]/div/span[1]"))
				.getText();
		System.out.println(courseRating2);
		Reporter.log("Course Rating - " + courseRating2);
		hs.takeScreenshot("courseRating2");
		System.out.println(courseRating2);

		Set<String> handles2 = driver.getWindowHandles();

		for (String childWindow2 : handles2) {
			if (!childWindow2.contentEquals(parentWindow)) {

				// Navigate to child window
				driver.switchTo().window(childWindow2);

				// Extract the duration of the second course
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				String courseDuration2 = driver
						.findElement(By
								.xpath("//*[@id='main']/div/div[2]/div/div/div/div[2]/div/div/div[5]/div[2]/div/span"))
						.getText();
				System.out.println(courseDuration2);
				Reporter.log("Course Duration - " + courseDuration2);

				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.close();
			}
		}

		System.out.println("");

		// Get back to Parent window
		driver.switchTo().window(parentWindow);

	}

}