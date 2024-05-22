package com.dhruv.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.dhruv.helper.Utility;

public class DynamicDropdownTest {
	public static WebDriver driver;

	public static void main(String[] args) {
		Utility d = new Utility();
		driver = d.getDriverInstance();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement fromDD = driver.findElement(By.xpath("(//div[@id='marketCityPair_1']//label)[1]/parent::div/following-sibling::input/parent::div[@class='left1']"));
		fromDD.click();
		driver.findElement(By.xpath("//div[@class='left1']//ul//a[@value='AMD']")).click();
		
		WebElement toDD = driver.findElement(By.xpath("(//div[@id='marketCityPair_1']//label)[2]/parent::div/following-sibling::input/parent::div[@class='right1']"));
		toDD.click();
		driver.findElement(By.xpath("//div[@class='right1']//ul//a[text()=' Bengaluru (BLR)']")).click();
	}

}

//==> (//div[@id='marketCityPair_1']//label)[1]/parent::div/following-sibling::input/parent::div[@class='left1']
// ==> (//div[@id='marketCityPair_1']//label)[2]/parent::div/following-sibling::input/parent::div[@class='right1']