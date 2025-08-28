package com.qa.swingpay.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.swingpay.base.BaseTest;
import com.qa.swingpay.pages.DashboardPage;
import com.qa.swingpay.pages.LoginPage;

public class DashboardPageTest extends BaseTest{
	

	@Test
	public void ClickDashboard() {
		
		page1  = homepage.clickLoginWindowHandle();
		loginPage = new LoginPage(page1);
		Assert.assertTrue(loginPage.isForgotPasswordLinkExsist());
		loginPage.enterCredentials(prop.getProperty("username").trim(),
                prop.getProperty("password").trim());
		dashboardPage = new DashboardPage(page1);
		dashboardPage.clickDashboard();
		
	}

}
