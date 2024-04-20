package com.redbus.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.*;

import com.redbus.qa.base.TestBase;
import com.redbus.qa.pages.HelpPage;
import com.redbus.qa.pages.HomePage;
import com.redbus.qa.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class HomePageTest extends TestBase {
	private static final Logger logger = LogManager.getLogger(HomePageTest.class);
	HomePage homePage;
	HelpPage helpPage;
	LoginPage loginPage;
	//ExtentReporterNG extentLogger= new ExtentReporterNG();

	public HomePageTest() {
		super();
	}




	@BeforeMethod
	public void setUp() {
		logger.info("Setting Up Project");
		initialization();
		homePage= new HomePage();
	}
	
	@Test
	public void validateHomePageTitleTest() {
		String title= homePage.validateHomePageTitle();
		Assert.assertEquals(title, "Book Bus Tickets Online, Easy & Secure Booking, Top Operators - redBus");
	}
	
	@Test
	public void redBusLogoTest() {
		boolean flag= homePage.validateRedBusLogo();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void helpButtontest() {
		helpPage= homePage.helpButton();
	}
	
	@Test
	public void loginSignUpButtonTest() {
		loginPage= homePage.naviagteToLoginPage();
		Assert.fail();
	}

	@AfterMethod
	public void tearDown(){


		//driver.quit();
	}

@AfterTest
	public void afterTest() throws IOException {

}
}
