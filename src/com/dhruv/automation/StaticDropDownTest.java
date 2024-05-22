package com.dhruv.automation;
//If dropdown options are fixed and not changing are nothing but static dropdown.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.dhruv.helper.Utility;

public class StaticDropDownTest {
	public static WebDriver driver;
	

	public static void main(String[] args) {
		Utility d = new Utility();
		driver = d.getDriverInstance();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement staticDropdown = driver.findElement(By.xpath("//select[contains(@name, 'ctl00$mainContent$Drop')]"));
		
		Select dropdown = new Select(staticDropdown);
		
		System.out.println("Default Selected Option: "+dropdown.getFirstSelectedOption().getText());
		
		dropdown.selectByIndex(2);
		System.out.println("Option Selected By Index: "+dropdown.getFirstSelectedOption().getText());
		
		//Value is an attribute
		dropdown.selectByValue("INR");
		System.out.println("Option Selected By Value: "+dropdown.getFirstSelectedOption().getText());
		
		dropdown.selectByVisibleText("USD");
		System.out.println("Option Selected By Visible Text: "+dropdown.getFirstSelectedOption().getText());
	}

}
