package com.coursera.org.functions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.coursera.org.base.Base;
import com.coursera.org.utilities.FileInput;
import com.coursera.org.utilities.HighlighterAndScreenshotClass;

public class FormFillingFunctionality extends Base {

	HighlighterAndScreenshotClass hs = new HighlighterAndScreenshotClass();
	FileInput fi = new FileInput();

	public void locateForm() throws InterruptedException, IOException {

		Actions action = new Actions(driver);

		WebElement forEnterpriseLink = driver.findElement(By.linkText("For Enterprise"));
		hs.highlighttElements(forEnterpriseLink);
		forEnterpriseLink.click();

		WebElement productsLink = driver.findElement(By.linkText("Products"));
		hs.highlighttElements(productsLink);
		action.moveToElement(productsLink).perform();

		implicitWait(10000);

		scrollPage();
		driver.switchTo().defaultContent();
		WebElement forCampusLink = driver.findElement(By.linkText("For Campus"));
		hs.highlighttElements(forCampusLink);
		forCampusLink.click();

		implicitWait(2000);
	}

	public void fillFirst_name(String f_Name) throws IOException, InterruptedException {

		WebElement f_NameElem = driver.findElement(By.id("FirstName"));
		hs.highlighttElements(f_NameElem);
		f_NameElem.sendKeys(f_Name);
	}

	public void fillLast_name(String l_Name) throws IOException, InterruptedException {

		WebElement l_NameElem = driver.findElement(By.id("LastName"));
		hs.highlighttElements(l_NameElem);
		l_NameElem.sendKeys(l_Name);
	}

	public void fillJob_func(String job_Func) throws IOException, InterruptedException {

		WebElement job_FuncElem = driver.findElement(By.id("C4C_Job_Title__c"));
		Select select = new Select(job_FuncElem);
		hs.highlighttElements(job_FuncElem);
		select.selectByVisibleText(job_Func);
	}

	public void fillJob_title(String job_Title) throws IOException, InterruptedException {

		WebElement job_TitleElem = driver.findElement(By.id("Title"));
		hs.highlighttElements(job_TitleElem);
		job_TitleElem.sendKeys(job_Title);
	}

	public void fillEmail(String work_Email) throws IOException, InterruptedException {

		WebElement work_EmailElem = driver.findElement(By.id("Email"));
		hs.highlighttElements(work_EmailElem);
		work_EmailElem.sendKeys(work_Email);
	}

	public void fillPhone_no(String phone_No) throws IOException, InterruptedException {

		WebElement phone_NoElem = driver.findElement(By.id("Phone"));
		hs.highlighttElements(phone_NoElem);
		phone_NoElem.sendKeys(phone_No);
	}

	public void fillInstitute_name(String institute_Name) throws IOException, InterruptedException {

		WebElement institute_NameElem = driver.findElement(By.id("Company"));
		hs.highlighttElements(institute_NameElem);
		institute_NameElem.sendKeys(institute_Name);
	}

	public void fillInstitute_type(String institute_Type) throws IOException, InterruptedException {

		WebElement institute_TypeElem = driver.findElement(By.id("Institution_Type__c"));
		Select select1 = new Select(institute_TypeElem);
		hs.highlighttElements(institute_TypeElem);
		select1.selectByVisibleText(institute_Type);

	}

	public void fillPrimary_dis(String primary_Dis) throws IOException, InterruptedException {

		WebElement primary_DisElem = driver.findElement(By.id("Primary_Discipline__c"));
		Select select2 = new Select(primary_DisElem);
		hs.highlighttElements(primary_DisElem);
		select2.selectByVisibleText(primary_Dis);

	}

	public void fillCountry(String country) throws IOException, InterruptedException {

		WebElement countryElem = driver.findElement(By.id("Country"));
		Select select3 = new Select(countryElem);
		hs.highlighttElements(countryElem);
		select3.selectByVisibleText(country);

	}

	public void fillState(String state) throws IOException, InterruptedException {

		WebElement stateElem = driver.findElement(By.id("State"));
		Select select4 = new Select(stateElem);
		hs.highlighttElements(stateElem);
		select4.selectByVisibleText(state);

	}

	public void fillTextArea(String textArea) throws IOException, InterruptedException {

		WebElement textAreaElem = driver.findElement(By.id("What_the_lead_asked_for_on_the_website__c"));
		hs.highlighttElements(textAreaElem);
		textAreaElem.sendKeys(textArea);
	}

	public void clickSubmitButton() throws IOException, InterruptedException {

		WebElement submitButton = findElementByXpath("//button[contains(text(),'Submit')]");
		hs.highlighttElements(submitButton);
		submitButton.click();
	}

	public void fillAllValues() throws IOException, InterruptedException {

		String f_Name = fi.getData("f_name");
		String l_Name = fi.getData("l_name");
		String job_Func = fi.getData("job_func");
		String job_Title = fi.getData("job_title");
		String work_Email = fi.getData("work_email");
		String phone_No = fi.getData("phone_no");
		String institute_Name = fi.getData("institute_name");
		String institute_Type = fi.getData("institute_type");
		String primary_Dis = fi.getData("primary_dis");
		String country = fi.getData("country");
		String state = fi.getData("state");
		String textArea = fi.getData("comments");

		fillFirst_name(f_Name);
		Thread.sleep(1000);

		fillLast_name(l_Name);
		Thread.sleep(1000);

		fillJob_func(job_Func);
		Thread.sleep(1000);

		fillJob_title(job_Title);
		Thread.sleep(1000);

		fillEmail(work_Email);
		Thread.sleep(1000);

		fillPhone_no(phone_No);
		Thread.sleep(1000);

		fillInstitute_name(institute_Name);
		Thread.sleep(1000);

		fillInstitute_type(institute_Type);
		Thread.sleep(1000);
		scrollPageBy(450);

		fillPrimary_dis(primary_Dis);
		Thread.sleep(1000);

		fillCountry(country);
		Thread.sleep(1000);

		fillState(state);
		Thread.sleep(1000);

		fillTextArea(textArea);
		Thread.sleep(1000);

		clickSubmitButton();
		Thread.sleep(1000);

	}

}
