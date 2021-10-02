package com.coursera.org.base;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public static WebDriver driver;

	/****** Invoke Browser *********/

	public WebDriver createDriver() {

		driver = DriverSetup.setDriver();
		return driver;
	}

	/****** Open URL *********/
	public void openURL(String websiteURL) {
		driver.get(websiteURL);
	}

	/****** Refresh *********/
	public void refresh() {
		driver.navigate().refresh();
	}

	/****** Get Page Title *********/
	public String getPageTitle() {
		return driver.getTitle();
	}

	/****** Return Home *********/
	public void returnhome() {
		driver.navigate().to("https://www.coursera.org/in");
	}

	/****** Close Browser *********/
	public void tearDown() {
		driver.close();
	}

	/****** Quit Browser *********/
	public void quitBrowser() {
		driver.quit();
	}

	/****** Implicit Wait *********/
	public void implicitWait(int secs) {

		driver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);
	}

	/****** Page Loadout *********/
	public void pageLoadOut(int secs) {

		driver.manage().timeouts().pageLoadTimeout(secs, TimeUnit.SECONDS);
	}

	/****** Finding WebElement *********/
	public WebElement findElementByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	/****** Scroll Page *********/
	public void scrollPage() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}

	/****** Scroll Page By *********/
	public void scrollPageBy(int pixel) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0," + pixel + ")");

	}

	/****** Close Bot *********/

	public void closeBot() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='root']/div[1]/div/button[1]")));
		WebElement botCloseButton = findElementByXpath("//*[@id='root']/div[1]/div/button[1]");
		botCloseButton.click();

	}

	/****** List To Map Conversion *********/
	public HashMap<String, String> convertListToString(List<String> field, List<String> count) {

		HashMap<String, String> fld_cnt = new HashMap<String, String>();

		for (int i = 0; i < field.size(); i++) {

			String fld = field.get(i);
			String cnt = count.get(i);
			fld_cnt.put(fld, cnt);
		}
		return fld_cnt;
	}

}