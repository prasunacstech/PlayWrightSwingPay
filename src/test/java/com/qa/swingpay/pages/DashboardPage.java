package com.qa.swingpay.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.options.WaitForSelectorState;

public class DashboardPage {
	
	private Page page;
	private String dashboard = "//span/b[text()='Dashboard']";
	private String addtimesheets = "//a[text()='Add Summary Timesheet']";
	private String image = "//i[@class='fa fa-user']";
	private String logoutBtn = "//a[@data-toggle='modal']";
	private String logoutPageBtn = "//a[text()='Logout']";
	
	public DashboardPage(Page page) {
		this.page = page;
	}
	
	public void clickLogout() {
		try {
	        // Wait for the username element to be visible and click
	        page.waitForSelector(image, new Page.WaitForSelectorOptions()
	            .setState(WaitForSelectorState.ATTACHED)
	            .setTimeout(30000));
	        page.waitForTimeout(500);  
	        page.click(image, new Page.ClickOptions().setForce(true));

	        
	        page.click(logoutBtn);
	        page.click(logoutPageBtn);
	        System.out.println("Logout successful!");

	    } catch (TimeoutError e) {
	        System.out.println("Element not clickable or took too long to appear: " + e.getMessage());
	        // Optional: take a screenshot or retry
	    }
	}
	
	
	public void clickDashboard() {
		page.click(dashboard);
		page.waitForTimeout(2000);
		page.click(addtimesheets);
	}

}
