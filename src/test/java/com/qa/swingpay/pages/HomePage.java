package com.qa.swingpay.pages;

import com.microsoft.playwright.Page;

public class HomePage {

	// String Locators

	private Page page;
	private String Login = "//a[text()='Login']";
	private String Signin = "//a[text()='Try It For Free']";

    //Page constructor

	public HomePage(Page page) {
		this.page = page;
	}

	// Page actions/methods
	public String getHomePageTitle() {
		String title = page.title();
		System.out.println(title);
		return title;
	}
	

	public String getHomePageURL() {
		String url = page.url();
		System.out.println(url);
		return url;
	}

	public Page clickLoginWindowHandle() {
		Page page1 = page.waitForPopup(() -> {

			page.click(Login);
		});

		page1.waitForLoadState();
		return page1;
	}

	public Page clickSigninWindowHandle() {
		Page popup = page.waitForPopup(() -> {

			page.click(Signin);
		});

		popup.waitForLoadState();
		return popup;
	}

}
