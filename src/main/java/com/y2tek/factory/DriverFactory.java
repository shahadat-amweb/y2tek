package com.y2tek.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.y2tek.frameworkexception.FrameWorkException;
import com.y2tek.utils.AppConstants;

public class DriverFactory {

	WebDriver driver;
	OptionsManager optionsManager;
	public static String highlightElement;
	static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public WebDriver initDriver(Properties prop) {
		String browserName = prop.getProperty("browser").trim();
		// browser will be supplied from cmd
		// String browserName = System.getProperty("browser");
		System.out.println("Browser name : " + browserName);
		optionsManager = new OptionsManager(prop);

		switch (browserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver(optionsManager.getChromeOptions());
			tlDriver.set(driver);
			break;
		case "edge":
			driver = new EdgeDriver(optionsManager.getEdgeOptions());
			tlDriver.set(driver);
			break;
		case "firefox":
			driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
			tlDriver.set(driver);
			break;
		default:
			System.out.println("Please pass the right browser -----" + browserName);
			throw new FrameWorkException("NOBROWSEREXCEPTION");
		}

		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(AppConstants.MEDIUM_DEFAULT_WAIT));
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}

	public synchronized static WebDriver getDriver() {
		return tlDriver.get();
	}

	public Properties initProp() {

		Properties prop = new Properties();
		FileInputStream ip = null;
		try {
			ip = new FileInputStream("./src/main/resources/config/superAdmin.config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

	// take screenshot
	public static String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}