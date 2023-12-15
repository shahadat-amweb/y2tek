package com.y2tek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.y2tek.utils.ElementUtil;

public class BotServicePage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	@FindBy(xpath = "//span[text()='Create Bot']")
	WebElement creatBotBtn;

	public BotServicePage(WebDriver driver) {
		eleUtil = new ElementUtil(this.driver);
		PageFactory.initElements(driver, this);

	}

	public boolean isCreateBotBtnExist() {
		return creatBotBtn.isDisplayed();
	}

}
