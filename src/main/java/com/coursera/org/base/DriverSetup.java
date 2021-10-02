package com.coursera.org.base;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSetup {

	public static WebDriver driver;

	static Base base = new Base();

	public static WebDriver setDriver() {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println(
					"Which browser would you like to execute the script on? \n" + "1.Google Chrome \n" + "2.Firefox");
			int browserChoice = scan.nextInt();
			scan.close();

			if (browserChoice == 1) {
				driver = setChromeDriver();
				return driver;
			}

			else if (browserChoice == 2) {
				driver = setFirefoxDriver();
				return driver;
			} else {
				System.out.println("Invalid data...");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;

	}

	public static WebDriver setChromeDriver() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");

		// WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		String baseUrl = "https://www.coursera.org/in";
		driver.get(baseUrl);
		return driver;

	}

	public static WebDriver setFirefoxDriver() {

		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//drivers//geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		// WebDriverManager.firefoxdriver().setup();

		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new FirefoxDriver(options);

		driver.manage().window().maximize();
		String baseUrl = "https://www.coursera.org/in";
		driver.get(baseUrl);
		return driver;
	}

}