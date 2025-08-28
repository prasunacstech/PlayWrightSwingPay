package com.qa.swingpay.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
	
	private Page page;
	private String username = "#LoginUser";
	private String password = "#password-field";
	private String Login =  "#Login";
	private String forgotPasswordLink = "//a[@href='/Account/ForgotPassword']//small[text()='Forgot Password?']";
	private String createNewLink = "//a/button[text()='Create new']";
	private String dashboardPage = "//h1[text()='Dashboard']";
	
	public LoginPage(Page page) {
//		 if (page == null) {
//		        throw new IllegalArgumentException("Page object is null. Did you forget to capture the popup?");
//		    }
		    this.page = page;
		}

	
	

	public String getLoginPageURL() {
		String url = page.url();
		System.out.println(url);
		return url;
	}
	
	public boolean enterCredentials(String UserName, String Password) {
		page.fill(username, UserName);
		page.fill(password, Password);
		page.click(Login);
		page.waitForTimeout(5000);
		if(page.isVisible(dashboardPage)) {
			System.out.println("User is logged in successfully");
			return true;
		}
		return false;
	}
	
	public void clickForgotPassword() {
		page.click(forgotPasswordLink);
	}
	
	public boolean  isForgotPasswordLinkExsist() {
		System.out.println("Current page URL: " + page.url());
	    //System.out.println("Page content snippet: " + page.content().substring(0, 500));
	    return page.isVisible(forgotPasswordLink);
	}
	
	public void clickCreateNewLink() {
		page.click(createNewLink);
	}
	
	 public Locator alertMessage(String text) {
	        return page.getByText(text);
	    }


}
