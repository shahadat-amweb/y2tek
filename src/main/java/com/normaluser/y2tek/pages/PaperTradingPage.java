package com.normaluser.y2tek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.y2tek.utils.ElementUtil;

public class PaperTradingPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	@FindBy(xpath = "//span[text()='Create Papertrade']")
	WebElement creatPTradeBtn;

	public PaperTradingPage(WebDriver driver) {
		eleUtil = new ElementUtil(this.driver);
		PageFactory.initElements(driver, this);

	}

	public boolean isCreatePTradeBtnExist() {
		return creatPTradeBtn.isDisplayed();
	}

}
