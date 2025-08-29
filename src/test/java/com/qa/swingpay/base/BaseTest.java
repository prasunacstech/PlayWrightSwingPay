package com.qa.swingpay.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Page;
import com.qa.swingpay.PlayWrightFactory;
import com.qa.swingpay.pages.DashboardPage;
import com.qa.swingpay.pages.ForgotPasswordPage;
import com.qa.swingpay.pages.HomePage;
import com.qa.swingpay.pages.LoginPage;

public class BaseTest {
	
	PlayWrightFactory pf;
    Page page;
    protected Page page1;
    protected  Properties prop;
	 protected HomePage homepage;
	 protected LoginPage loginPage;
	 protected DashboardPage dashboardPage;
	 protected ForgotPasswordPage forgotPasswordPage;
	
	@Parameters({"browser"})
	@BeforeTest
	public void setup(String browserName) {
		pf = new PlayWrightFactory();
		prop = pf.init_prop();
		
		if(browserName != null) {
			prop.setProperty("browser", browserName);
		}
		page = pf.initBrowser(prop);
		homepage = new HomePage(page);
		
		

	}
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
