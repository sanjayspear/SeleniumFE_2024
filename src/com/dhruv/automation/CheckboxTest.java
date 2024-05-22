package com.dhruv.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.dhruv.helper.Utility;

public class CheckboxTest {

	public static void main(String[] args) throws InterruptedException {
		Utility utility = new Utility();
		WebDriver driver = utility.getDriverInstance();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");

		int count = driver.findElements(By.xpath("//input[contains(@id, 'ctl00_mainContent_chk')]")).size();

		for (int i = 2; i <= count; i++) {
			String checkBoxName = driver
					.findElement(By.xpath(
							"(//input[contains(@id, 'ctl00_mainContent_chk')]/following-sibling::label)[" + i + "]"))
					.getText();
			if (checkBoxName.equalsIgnoreCase(" Family and Friends")) {
				System.out.println("Checkbox Name: " + checkBoxName);
				driver.findElement(By.xpath("//label[text()=' Family and Friends']/preceding-sibling::input")).click();
				Thread.sleep(2000);
				break;
			}
		}

	}

}
