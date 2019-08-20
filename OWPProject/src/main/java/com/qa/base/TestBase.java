package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static Logger log;

	public TestBase()

	{
		try {
			prop = new Properties();

			FileInputStream f1 = new FileInputStream("G:\\eclipse\\OWPProject\\config.properties");
			prop.load(f1);
			log = Logger.getLogger(TestBase.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() throws InterruptedException {

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "G:\\setup\\chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Chrome Browser launched");
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "G:\\setup\\geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("FireFox Browser launched");

		}

		// driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 120);
		driver.get(prop.getProperty("url"));
		Thread.sleep(40);
	}

	public void failed() {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("G:\\eclipse\\OWPProject\\Screenshots\\testFailure.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}