package com.y2tek.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	static By username = By.name("username");

	static By password = By.name("password");
	static By signBtn = By.xpath("//button[@type='submit']");

	static int i = 1;
	static By otpText1 = By.xpath("//input[@id='" + i + "']");

	public static void main(String[] args) {

		// WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("http://y2tek-ui.dev-bot.y2tek.io/");
		driver.get("http://www.amazon.com"
				+ "");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(username).sendKeys("us3ry2tek@gmail.com");
		driver.findElement(password).sendKeys("Y2tek@1234");
		driver.findElement(signBtn).click();

		String otp = "123456";
		for (int i = 0; i < otp.length(); i++) {
			WebElement otpText = driver.findElement(By.xpath("//input[@id='" + (i + 1) + "']"));
			otpText.sendKeys(String.valueOf(otp.charAt(i)));
		}
		driver.findElement(signBtn).click();
	}

}
