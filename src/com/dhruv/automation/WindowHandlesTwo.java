package com.dhruv.automation;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dhruv.helper.Utility;

public class WindowHandlesTwo {
    private static WebDriver driver;

    public static void main(String[] args) {
        Utility util = new Utility();
        driver = util.getDriverInstance();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        
        // Click on the link that opens a new window
        driver.findElement(By.cssSelector(".blinkingText")).click();
        
        // Wait for the new window to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Set<String> windows = driver.getWindowHandles();
        
        // Store parent window ID
        String parentWindow = driver.getWindowHandle();

        // Iterate through window handles
        for (String windowHandle : windows) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
                // Wait until the email element is visible
                WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='mentor@rahulshettyacademy.com']")));
                String actualText = emailElement.getText();
                System.out.println(actualText);
                // Close the child window
                driver.close();
            }
        }

        // Switch back to parent window
        driver.switchTo().window(parentWindow);
        
        // Additional code if required
        
        // Close the driver
        driver.quit();
    }
}
