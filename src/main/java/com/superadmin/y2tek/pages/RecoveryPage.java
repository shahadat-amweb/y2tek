package com.superadmin.y2tek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.y2tek.utils.ElementUtil;

public class RecoveryPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	@FindBy(xpath = "//button[@class='recovery-button']")
	WebElement recoverBtn;

	public RecoveryPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
		PageFactory.initElements(driver, this);
	}

	public boolean isRecoveryBtnExist() {
		return recoverBtn.isDisplayed();
	}

}
