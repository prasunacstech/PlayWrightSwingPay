package com.qa.swingpay.tests;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.swingpay.base.BaseTest;
import com.qa.swingpay.pages.ForgotPasswordPage;
import com.qa.swingpay.pages.LoginPage;

public class ForgotPasswordPageTest extends BaseTest{
	
	@Test
	public void validForgotPasword() {
		page1  = homepage.clickLoginWindowHandle();
		loginPage = new LoginPage(page1);
		Assert.assertTrue(loginPage.isForgotPasswordLinkExsist());
		loginPage.clickForgotPassword();
		forgotPasswordPage = new ForgotPasswordPage(page1);
		forgotPasswordPage.enterEmail("prasuna.kumar186@yahoo.com");
		forgotPasswordPage.getForgotPageURL();
		
	}
	
	@Test
	public void invalidForgotPasword() {
		page1  = homepage.clickLoginWindowHandle();
		loginPage = new LoginPage(page1);
		Assert.assertTrue(loginPage.isForgotPasswordLinkExsist());
		loginPage.clickForgotPassword();
		forgotPasswordPage = new ForgotPasswordPage(page1);
		forgotPasswordPage.enterEmail("prasuna.kumar186@gmail.com");
		assertThat(loginPage.alertMessage("Email does not exists."))
	    .containsText("Email does not exists.");
		
	}

}
