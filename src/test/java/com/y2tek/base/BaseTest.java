package com.y2tek.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.normaluser.y2tek.pages.BotServicePage;
import com.normaluser.y2tek.pages.DashBoardPage;
import com.normaluser.y2tek.pages.LoginPage;
import com.normaluser.y2tek.pages.PaperTradingPage;
import com.superadmin.y2tek.pages.RecoveryPage;
import com.superadmin.y2tek.pages.SuperAdminLoginPage;
import com.superadmin.y2tek.pages.UsersPage;
import com.y2tek.factory.DriverFactory;

public class BaseTest {

	protected WebDriver driver;
	protected LoginPage loginPage;
	protected DashBoardPage dbPage;
	protected PaperTradingPage ptPage;
	protected BotServicePage botPage;
	
	protected SuperAdminLoginPage superAdLoginPage; 
	protected UsersPage userPage;
	protected RecoveryPage recPage;
	
	protected DriverFactory df;
	protected Properties prop;
	protected SoftAssert softAssert;

	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
		superAdLoginPage = new SuperAdminLoginPage(driver);
		softAssert = new SoftAssert();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
