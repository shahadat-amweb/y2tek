package com.normaluser.y2tek.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.y2tek.utils.AppConstants;
import com.y2tek.utils.ElementUtil;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	WebElement emailId;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signBtn;

	public String getLoginPageTitle() {
		return eleUtil.waitForTitleIsAndCapture(AppConstants.LOGIN_PAGE_TITLE_VALUE, AppConstants.SHORT_DEFAULT_WAIT);
	}

	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}

	public DashBoardPage doLogin(String userName, String pwd) {
		emailId.sendKeys(userName);
		password.sendKeys(pwd);
		signBtn.click();
		doEnterOtp();
		return new DashBoardPage(driver);
	}

	public void doEnterOtp() {
		String otp = "123456";
		for (int i = 0; i < otp.length(); i++) {
			WebElement otpText = driver.findElement(By.xpath("//input[@id='" + (i + 1) + "']"));
			otpText.sendKeys(String.valueOf(otp.charAt(i)));
		}
		signBtn.click();
	}
}