package com.dhruv.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dhruv.helper.Utility;

public class AutoSuggestiveDropdownTest {

	public static void main(String[] args) throws InterruptedException {
		Utility utility = new Utility();
		WebDriver driver = utility.getDriverInstance();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("Ind");
		List<WebElement> countryList = driver.findElements(By.xpath("//li[@class='ui-menu-item']//a"));
		Thread.sleep(2000);
		for(WebElement country: countryList) {
			if(country.getText().equalsIgnoreCase("India")) {
				country.click();
			}
		}
	}

}
