package com.dhruv.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.dhruv.helper.Utility;

public class ElementStateCheck {

	public static WebDriver driver;

	public static void main(String[] args) {
		//Usually we use isEnabled() or IsDisabled() methods to check if element is enabled or disabled.
		//but, in the modern application, sometime elements looks like disabled but as soon as you click it gets enabled. 
		Utility d = new Utility();
		driver = d.getDriverInstance();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement roundTripRadioBtn = driver.findElement(By.xpath("//td//label[text()='Round Trip']/preceding-sibling::input[@value='RoundTrip']"));
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		roundTripRadioBtn.click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("It's disabled");
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
	}

}
