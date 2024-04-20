package com.redbus.qa.testcases;

import com.redbus.qa.base.TestBase;
import com.redbus.qa.pages.HomePage;
import com.redbus.qa.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	String homePageWindID;
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		homePage = new HomePage();
		homePageWindID= driver.getWindowHandle();
		loginPage = homePage.naviagteToLoginPage();



	}
	
	@Test
	public void validateGoogleSignInButtonTest() throws InterruptedException {
		loginPage.validateGoogleSignInButton();
		// Validate if Google sign-In button is present or not.
	}

	@Test
	public void validateLoginClosureTest(){
		loginPage.validateLoginClosure();
		//Validate if user is able to close the Login/SignUp popup.
	}

	@Test
	public void validateGoogleSignInTest() throws InterruptedException {
		loginPage.validateGoogleSignIn();
		//Validate if user is able to Sign In using Google.
	}

	@Test
	public void validateSuccessfulSignInTest() throws InterruptedException {
		loginPage.validateSuccessfulSignIn(homePageWindID);
		//Validated the successful Sign-in by checking for the SignOut Button.
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
