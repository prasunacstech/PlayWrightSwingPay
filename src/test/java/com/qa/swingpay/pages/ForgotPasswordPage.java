package com.qa.swingpay.pages;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Page;

public class ForgotPasswordPage {
	private Page page;
	private String email = "//input[@name='EmailID']";
	private String submitBtn = "//input[@value='Submit']";
	
	
	
	public ForgotPasswordPage(Page page) {
		this.page = page;
	}
	
	public void enterEmail(String emailId) {
		page.fill(email, emailId);
		page.click(submitBtn);
	}
	
	public String getForgotPageURL() {
		String url = page.url();
		System.out.println(url);
		return url;
	}
	
	public void verifyAlertMessage() {
		assertThat(page.getByText("Email does not exists.")).containsText("Email does not exists.");

	}
	
	 
}
