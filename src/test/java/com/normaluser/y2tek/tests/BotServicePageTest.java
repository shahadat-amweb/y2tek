package com.normaluser.y2tek.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.y2tek.base.BaseTest;

public class BotServicePageTest extends BaseTest {
	@BeforeClass
	public void paperTradingPageSetup() {
		dbPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		botPage = dbPage.navigateToBotService();
	}

	@Test
	public void botServicePageTest() {
		Assert.assertTrue(botPage.isCreateBotBtnExist());
	}
}
