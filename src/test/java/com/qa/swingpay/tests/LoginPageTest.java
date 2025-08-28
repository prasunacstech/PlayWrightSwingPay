package com.qa.swingpay.tests;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.swingpay.base.BaseTest;
import com.qa.swingpay.pages.DashboardPage;
import com.qa.swingpay.pages.LoginPage;

public class LoginPageTest extends BaseTest {
	

	@Test
	public void homePageTitleTest() {
		homepage.getHomePageTitle();
		
	}
	@Test
	public void homePageURLTest() {
		String actualURL = homepage.getHomePageURL();
		Assert.assertEquals(actualURL, prop.getProperty("url").trim());
	}
	
	@Test
	public void enterLoginCredentialsTest() {
		page1  = homepage.clickLoginWindowHandle();
		loginPage = new LoginPage(page1);
		Assert.assertTrue(loginPage.isForgotPasswordLinkExsist());
		loginPage.enterCredentials(prop.getProperty("username").trim(),
                prop.getProperty("password").trim());
	}
	
	
//	@Test(dependsOnMethods = "clickHomePageLogin")
//	public void enterLoginCredentialsTet() {
//	    
//	}
	
	@DataProvider(name="dp")
	Object[][] loginData(){
		Object data[][] = {
				{"saikumar","Pass@1234"},{"admin134","Pass@123"},{"admin2","abc3s@123"}
				
		};
		return data;
	}
	
	@Test(dataProvider = "dp")
	public void enterInvalidLoginCredentials(String username, String password) {
		page1  = homepage.clickLoginWindowHandle();
		loginPage = new LoginPage(page1);
		Assert.assertTrue(loginPage.isForgotPasswordLinkExsist());
		 loginPage.enterCredentials(username, password);
		 assertThat(loginPage.alertMessage("Invalid Username or Password"))
		    .containsText("Invalid Username or Password");
	}
	
	@Test
	public void ClickLogout() {
		
		page1  = homepage.clickLoginWindowHandle();
		loginPage = new LoginPage(page1);
		Assert.assertTrue(loginPage.isForgotPasswordLinkExsist());
		loginPage.enterCredentials(prop.getProperty("username").trim(),
                prop.getProperty("password").trim());
		dashboardPage = new DashboardPage(page1);
		dashboardPage.clickLogout();
		
	}
	
	
	
	

	

}
