package com.dhruv.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.dhruv.helper.Utility;

public class Locators {
	// Locators: ID, Xpath, CSS Selector, name, class Name, Tag Name, Link Text
	public static WebDriver driver;

	public static void main(String[] args) {
		Utility d = new Utility();
		driver = d.getDriverInstance();
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
		String erroMessageText = driver.findElement(By.className("error")).getText();
		System.out.println("The Error Message Is: "+erroMessageText);
		driver.findElement(By.linkText("Forgot your password?")).click();
		//String text = driver.findElement(By.tagName("h2")).getText();
		//Assert.assertEquals(text, "Forgot password", "Text is not equal");
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("test@test.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9446723988");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='Reset Login']"))));
		driver.findElement(By.xpath("//button[text()='Reset Login']")).click();
		driver.findElement(By.xpath("//button[text()='Go to Login']")).click();
		driver.quit();

	}

}
