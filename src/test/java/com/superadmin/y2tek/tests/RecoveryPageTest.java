package com.superadmin.y2tek.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.y2tek.base.BaseTest;



public class RecoveryPageTest extends BaseTest {
	@BeforeClass
	public void recoveryPageSetup() {
		userPage = superAdLoginPage.doSuperAdminLogin(prop.getProperty("username"), prop.getProperty("password"));
		recPage = userPage.navigateToRecoverySection();
	}

	@Test
	public void verifyRecoverBtn() {
		Assert.assertTrue(recPage.isRecoveryBtnExist());
	}
}
