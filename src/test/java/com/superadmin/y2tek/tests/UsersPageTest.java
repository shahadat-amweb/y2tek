package com.superadmin.y2tek.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.y2tek.base.BaseTest;

public class UsersPageTest extends BaseTest {

	@BeforeClass
	public void dbPageSetup() {
		superAdLoginPage.doSuperAdminLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void test1() {
	}

}
