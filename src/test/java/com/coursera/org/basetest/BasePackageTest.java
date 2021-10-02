package com.coursera.org.basetest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.coursera.org.base.Base;

public class BasePackageTest {

	@Test
	public void testBasePackage() {

		Base base = new Base();

		base.createDriver();
		System.out.println("Page opened");
		base.refresh();
		System.out.println("Refresh Done");
		base.implicitWait(2000);
		System.out.println("Implicit wait done");
		base.quitBrowser();

	}

	@Test
	public void testListToMapFunc() {

		Base base = new Base();

		List<String> list1 = new ArrayList<String>();
		list1.add("English");
		list1.add("Hindi");
		list1.add("Japnese");

		List<String> list2 = new ArrayList<String>();
		list2.add("100");
		list2.add("50");
		list2.add("20");

		HashMap<String, String> map1 = base.convertListToString(list1, list2);

		for (Map.Entry<String, String> values : map1.entrySet()) {
			System.out.println(values.getKey() + "-" + values.getValue());
		}

	}

}
