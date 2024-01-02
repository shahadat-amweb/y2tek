package com.normaluser.y2tek.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.y2tek.base.BaseTest;
import com.y2tek.utils.AppConstants;

public class LoginPageTest extends BaseTest {
	public LoginPageTest() {
		PageFactory.initElements(driver,this);
	}

	@Test
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE_VALUE);
	}

	@Test
	public void loginPageUrlTest() {
		String actUrl = loginPage.getLoginPageUrl();
		Assert.assertTrue(actUrl.contains(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE));
	}
	@Test()
	public void loginTest() {
		dbPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(dbPage.isDashBoardLinkExist()); 
		// Assert.assertTrue(dbPage.getAccPageTitle().equals("My Account2"));
	}
}
