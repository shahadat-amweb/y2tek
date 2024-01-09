package com.superadmin.y2tek.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.y2tek.base.BaseTest;
import com.y2tek.utils.AppConstants;

public class SuperAdminLoginPageTest extends BaseTest {
	public SuperAdminLoginPageTest() {
		PageFactory.initElements(driver, this);
	}

	@Test()
	public void loginTest() {
		userPage = superAdLoginPage.doSuperAdminLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(userPage.isAddUserBtnExist());

	}
}
