package com.y2tek.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.y2tek.base.BaseTest;

public class PaperTradingPageTest extends BaseTest {
	@BeforeClass
	public void paperTradingPageSetup() {
		dbPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		ptPage = dbPage.navigateToPaperTrading();
	}

	@Test
	public void paperTradingPageTest() {
		Assert.assertTrue(ptPage.isCreatePTradeBtnExist());
	}

}