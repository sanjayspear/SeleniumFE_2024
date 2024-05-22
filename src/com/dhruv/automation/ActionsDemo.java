package com.dhruv.automation;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dhruv.helper.Utility;

public class ActionsDemo {
	public static WebDriver driver;

	public static void main(String[] args) {
		Utility util = new Utility();
		driver = util.getDriverInstance();
		driver.get("https://www.flipkart.com/");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		Actions action = new Actions(driver);

		// Close the login popup if present
		try {
			WebElement closeLoginPopup = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'✕')]")));
			closeLoginPopup.click();
		} catch (Exception e) {
			System.out.println("Popup not present, do nothing");
		}

		WebElement fashionThumbnail = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Fashion']")));
		action.moveToElement(fashionThumbnail).perform();

		WebElement menFootwear = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Men Footwear']")));
		action.moveToElement(menFootwear).perform();

		WebElement mensFormalShoes = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\"Men's Formal Shoes\"]")));
		action.moveToElement(mensFormalShoes).perform();
		mensFormalShoes.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Men’s Formal Shoes']")));
		String actumensFormalShoesLandingPagealText = driver.findElement(By.xpath("//h1[text()='Men’s Formal Shoes']"))
				.getText();
		if (actumensFormalShoesLandingPagealText.equals("Men’s Formal Shoes")) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
		
		//Composite Actions
		driver.navigate().to("https://www.google.com");
		WebElement searchArea =  driver.findElement(By.xpath("//textarea[@title='Search']"));
		action.moveToElement(searchArea).click().keyDown(Keys.SHIFT).sendKeys("Hello World!").build().perform();
		//driver.quit();
	}
}
