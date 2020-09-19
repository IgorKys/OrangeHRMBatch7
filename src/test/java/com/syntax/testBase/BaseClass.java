package com.syntax.testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.syntax.utils.ConfigsUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public static void setUp() {
		String browser = ConfigsUtility.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(ConfigsUtility.getProperty("url"));
		
	}
	
	@AfterMethod(alwaysRun = true)
	public static void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}

}
