package com.normaluser.y2tek.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.superadmin.y2tek.pages.UsersPage;
import com.y2tek.utils.AppConstants;

public class Test {
	static WebDriver driver;
 //	@FindBy(name = "")
//	static WebElement emailId;
	static By emailId = By.name("username");

//	@FindBy(name = "password")
//	static WebElement password;
	static By password = By.name("password");

//	@FindBy(xpath = "//button[@type='submit']")
//	static WebElement signBtn;
	static By signBtn = By.xpath("//button[@type='submit']");

	public static void main(String[] args) {
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(AppConstants.MEDIUM_DEFAULT_WAIT));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://y2tek-ui.dev-bot.y2tek.io/");
		doSuperAdminLogin("supery2tek@gmail.com", "Y2tek@1234");

	}

	public static void doSuperAdminLogin(String userName, String pwd) {
		driver.findElement(emailId).sendKeys(userName);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signBtn).click();
		doEnterOtp();

	}

	public static void doEnterOtp() {
		String otp = "123456";
		for (int i = 0; i < otp.length(); i++) {
			WebElement otpText = driver.findElement(By.xpath("//input[@id='" + (i + 1) + "']"));
			otpText.sendKeys(String.valueOf(otp.charAt(i)));
		}
		driver.findElement(signBtn).click();
	}

}
