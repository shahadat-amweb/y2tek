package com.superadmin.y2tek.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.y2tek.utils.ElementUtil;

public class UsersPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	@FindBy(xpath = "//div[text()='Add User']")
	WebElement addUserBtn;

	@FindBy(xpath = "//a[@data-view='recoveryManagement']/span[text()='Recovery']")
	WebElement recoveryLink;

	public UsersPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
		PageFactory.initElements(driver, this);
	}

	public boolean isAddUserBtnExist() {
		return addUserBtn.isDisplayed();
	}

	public RecoveryPage navigateToRecoverySection() {
		//WebDriverWait(driver, 20).until(EC.element_to_be_clickable((By.XPATH, "//span[@class='taLnk ulBlueLinks']"))).click()
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(recoveryLink));
		recoveryLink.click();
		return new RecoveryPage(driver);

	}
}
