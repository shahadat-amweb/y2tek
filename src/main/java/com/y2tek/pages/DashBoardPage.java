package com.y2tek.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.y2tek.utils.AppConstants;
import com.y2tek.utils.ElementUtil;

public class DashBoardPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	@FindAll({ @FindBy(xpath = "//div[@class='card-image-text']//span[@class='card-title']") })
	List<WebElement> menuOptions;

	@FindBy(xpath = "//li[@class='profile-li']//span[text()='DashBoard']")
	WebElement dashBoardOption;

	@FindBy(xpath = "//span[@class='card-title' and text()='ACTIVE PAPER TRADE']")
	WebElement actPaperTdLink;

	@FindBy(xpath = "//span[@class='card-title' and text()='ACTIVE BOTS']")
	WebElement actBotLink;

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
		PageFactory.initElements(driver, this);
	}

	public boolean isDashBoardLinkExist() {
		return dashBoardOption.isDisplayed();

	}

	public boolean verifyDashboardMenuOptions() {
		String[] arr = { "ACTIVE BOTS", "ACTIVE BACKTESTING", "ACTIVE PAPER TRADE" };
		List<String> expList = Arrays.asList(arr);
		List<String> actList = dashBoardMenuOptionsList();
		return actList.equals(expList);
	}

	public List<String> dashBoardMenuOptionsList() {
		List<WebElement> elementsLinksList = menuOptions;
		List<String> elesTextList = new ArrayList<String>();

		for (WebElement e : elementsLinksList) {
			String text = e.getText();
			elesTextList.add(text);
		}
		return elesTextList;
	}

	public PaperTradingPage navigateToPaperTrading() {
		actPaperTdLink.click();
		return new PaperTradingPage(driver);
	}
	public BotServicePage navigateToBotService() {
		actBotLink.click();
		return new BotServicePage(driver);

	}
}