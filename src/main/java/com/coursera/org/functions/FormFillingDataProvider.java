package com.coursera.org.functions;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.coursera.org.utilities.FileInput;

public class FormFillingDataProvider {

	static FileInput fi = new FileInput();

	@DataProvider(name = "formData")
	public static Object[][] data() {

		try {

			String fName = fi.getData("f_name");
			String lName = fi.getData("l_name");
			String jobFunc = fi.getData("job_func");
			String jobTitle = fi.getData("job_title");
			String email = fi.getData("work_email");
			String phoneNo = fi.getData("phone_no");
			String instituteName = fi.getData("institute_name");
			String instituteType = fi.getData("institute_type");
			String primaryDis = fi.getData("primary_dis");
			String country = fi.getData("country");
			String state = fi.getData("state");
			String comments = fi.getData("comments");

			return new Object[][] {
					{ "", lName, jobFunc, jobTitle, email, phoneNo, instituteName, instituteType, primaryDis, country,
							state, comments, "FirstNameErr" },
					{ fName, "", jobFunc, jobTitle, email, phoneNo, instituteName, instituteType, primaryDis, country,
							state, comments, "LastNameErr" },
					{ fName, lName, "Select...", jobTitle, email, phoneNo, instituteName, instituteType, primaryDis,
							country, state, comments, "JobFunctionErr" },
					{ fName, lName, jobFunc, "", email, phoneNo, instituteName, instituteType, primaryDis, country,
							state, comments, "JobTitleErr" },
					{ fName, lName, jobFunc, jobTitle, "", phoneNo, instituteName, instituteType, primaryDis, country,
							state, comments, "EmailErr" },
					{ fName, lName, jobFunc, jobTitle, email, "", instituteName, instituteType, primaryDis, country,
							state, comments, "PhoneNumberErr" },
					{ fName, lName, jobFunc, jobTitle, email, phoneNo, "", instituteType, primaryDis, country, state,
							comments, "InstituteNameErr" },
					{ fName, lName, jobFunc, jobTitle, email, phoneNo, instituteName, "Select...", primaryDis, country,
							state, comments, "InstituteTypeErr" },
					{ fName, lName, jobFunc, jobTitle, email, phoneNo, instituteName, instituteType, "Select...",
							country, state, comments, "PrimaryDisErr" },
					{ fName, lName, jobFunc, jobTitle, email, phoneNo, instituteName, instituteType, primaryDis,
							"Country", state, comments, "CountryErr" },
					{ fName, lName, jobFunc, jobTitle, email, phoneNo, instituteName, instituteType, primaryDis,
							country, "Select...", comments, "StateErr" },
					{ fName, lName, jobFunc, jobTitle, email, phoneNo, instituteName, instituteType, primaryDis,
							country, state, "", "FormSubmissionWithoutComments" } };
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

}
