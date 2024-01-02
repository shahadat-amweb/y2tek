package com.normaluser.y2tek.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.y2tek.base.BaseTest;
import com.y2tek.utils.AppConstants;

public class DashBoardPageTest extends BaseTest{
	
	@BeforeClass
	public void dbPageSetup() {
		dbPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test
	public void dashBoardMenuOptionsTest() {
		
		Assert.assertTrue(dbPage.verifyDashboardMenuOptions());
	}

	

}
