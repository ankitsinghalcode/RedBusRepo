package com.redbus.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.redbus.qa.base.TestBase;
import com.redbus.qa.pages.HelpPage;
import com.redbus.qa.pages.HomePage;
import com.redbus.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	HomePage homePage;
	HelpPage helpPage;
	LoginPage loginPage;
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage= new HomePage();	
	}
	
	@Test(priority=1)
	public void validateHomePageTitleTest() {
		String title= homePage.validateHomePageTitle();
		Assert.assertEquals(title, "Book Bus Tickets Online, Easy & Secure Booking, Top Operators - redBus");
	}
	
	@Test(priority=2)
	public void redBusLogoTest() {
		boolean flag= homePage.validateRedBusLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void helpButtontest() {
		helpPage= homePage.helpButton();
	}
	
	@Test(priority=4)
	public void loginSignUpButtonTest() {
		loginPage= homePage.naviagteToLoginPage();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
