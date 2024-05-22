package com.dhruv.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTest {

    public static void main(String[] args) {
        String browser = "chrome"; // Change the browser name as per your requirement

        WebDriver driver = getDriver(browser);
        if (driver != null) {
            driver.get("https://www.rahulshettyacademy.com");
            driver.manage().window().maximize();
            System.out.println("Title: " + driver.getTitle());
            System.out.println("Current URL: " + driver.getCurrentUrl());

            // Close the browser after the test
            driver.quit();
        } else {
            System.out.println("Invalid browser specified.");
        }
    }

    public static WebDriver getDriver(String browser) {
        WebDriver driver = null;
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(options);
        }
        return driver;
    }
}
