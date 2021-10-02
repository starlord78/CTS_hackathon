package com.coursera.org.functions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.coursera.org.base.Base;
import com.coursera.org.utilities.FileInput;
import com.coursera.org.utilities.FileOutput;
import com.coursera.org.utilities.HighlighterAndScreenshotClass;

public class LanguageLearningCoursesCount extends Base {

	HighlighterAndScreenshotClass hs = new HighlighterAndScreenshotClass();
	FileInput fi = new FileInput();
	FileOutput fo = new FileOutput();

	public void loadLanguageLearningPage() throws InterruptedException, IOException {

		WebElement searchBox = findElementByXpath("//input[@type='text' and @role='textbox']");
		hs.highlighttElements(searchBox);
		searchBox.sendKeys(fi.getData("course_name2"));
		Thread.sleep(1000);

		WebElement searchIcon = findElementByXpath(
				"//*[@id='rendered-content']/div/header/div/div/div/div[1]/div[3]/div/form/div/div/div[1]/button[2]/div");
		hs.highlighttElements(searchIcon);
		searchIcon.click();
		implicitWait(5000);

	}

	public void languageFilter() throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(
				findElementByXpath("//*[@id=\"main\"]/div/div[2]/div/div[2]/div[1]/div/div[1]/div/span")));

		WebElement dropDownIcon = findElementByXpath(
				"//*[@id=\"main\"]/div/div[2]/div/div[2]/div[1]/div/div[1]/div/span");
		hs.highlighttElements(dropDownIcon);
		dropDownIcon.click();

		WebElement showAllOpt = findElementByXpath("//button[contains(text(),'Show All')]");
		hs.highlighttElements(showAllOpt);
		showAllOpt.click();

		List<WebElement> languages_names = driver
				.findElements(By.xpath("//div[@class='c-modal-content']//div[@class='checkboxText']"));
		List<WebElement> languages_count = driver
				.findElements(By.xpath("//div[@class='c-modal-content']//div[@class='filter-count']"));

		List<String> languageNames = new ArrayList<String>();
		int i = 0;
		for (WebElement names : languages_names) {
			String name = names.getText();
			languageNames.add(i, name);
			i++;
		}

		List<String> languageCount = new ArrayList<String>();
		int j = 0;
		for (WebElement count : languages_count) {
			String cnt = count.getText().replace("(", "").replace(")", "");
			languageCount.add(j, cnt);
			j++;
		}

		for (int k = 0; k < languageCount.size(); k++) {

			int cnt = Integer.parseInt(languageCount.get(k));
			fo.printValues(k, 0, languageNames.get(k), cnt, 1);
		}

		HashMap<String, String> map = convertListToString(languageNames, languageCount);
		System.out.println("\nLanguage and its count");
		for (Map.Entry<String, String> values : map.entrySet()) {
			System.out.println(values.getKey() + "-" + values.getValue());
		}

	}

	public void closeLanguageFilter() throws InterruptedException {
		WebElement closeBtn = findElementByXpath(
				"//*[@id=\"main\"]/div/div[2]/div/div[2]/div[1]/div/div[3]/div/div[3]/div[3]/a");
		hs.highlighttElements(closeBtn);
		closeBtn.click();
	}

	public void levelFilter() throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(
				findElementByXpath("//*[@id='main']/div/div[2]/div/div[2]/div[2]/div/div[1]/div/span")));
		WebElement dropDownIcon = findElementByXpath(
				"//*[@id='main']/div/div[2]/div/div[2]/div[2]/div/div[1]/div/span");
		hs.highlighttElements(dropDownIcon);
		dropDownIcon.click();

		List<WebElement> level_names = driver.findElements(By.xpath("//div[@class='checkboxText']"));
		List<WebElement> level_count = driver.findElements(By.xpath("//div[@class='filter-count']"));

		List<String> levelNames = new ArrayList<String>();
		int i = 0;
		for (WebElement names : level_names) {
			String name = names.getText();
			levelNames.add(i, name);
			i++;
		}

		List<String> levelCount = new ArrayList<String>();
		int j = 0;
		for (WebElement count : level_count) {
			String cnt = count.getText().replace("(", "").replace(")", "");
			levelCount.add(j, cnt);
			j++;
		}

		for (int k = 0; k < levelCount.size(); k++) {

			int cnt = Integer.parseInt(levelCount.get(k));
			fo.printValues(k, 0, levelNames.get(k), cnt, 2);
		}

		System.out.println("\nLevels and its count");
		HashMap<String, String> map = convertListToString(levelNames, levelCount);
		for (Map.Entry<String, String> values : map.entrySet()) {
			System.out.println(values.getKey() + "-" + values.getValue());
		}

	}

}
