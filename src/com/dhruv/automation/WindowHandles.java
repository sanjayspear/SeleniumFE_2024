package com.dhruv.automation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dhruv.helper.Utility;

public class WindowHandles {
	private static WebDriver driver;
	public static void main(String[] args) {
		Utility util = new Utility();
		driver = util.getDriverInstance();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windows = driver.getWindowHandles(); //parent id, child id, and sub child id
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		String actualText = driver.findElement(By.xpath("//a[text()='mentor@rahulshettyacademy.com']")).getText();
		System.out.println(actualText);
		driver.switchTo().window(parentId);
		
	}

}
