package com.redbus.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.redbus.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(id= "bus_tickets_vertical")
	WebElement busTickets;
	
	@FindBy(id= "rail_tickets_vertical")
	WebElement trainTickets;
	
	@FindBy(xpath= "//img[@class='rb_logo']")
	WebElement redBusLogo;
	
	@FindBy(id="help_redcare")
	WebElement help;
	
	@FindBy(id="account_dd")
	WebElement account;
	
	@FindBy(id= "user_sign_in_sign_up")
	WebElement login_signUp;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateRedBusLogo() {
		return redBusLogo.isDisplayed();
	}
	
	public HelpPage helpButton() {
		help.click();
		return new HelpPage();
	}
	
	public HomePage busTickets() {
		busTickets.click();
		return new HomePage();
	}
	
	public LoginPage naviagteToLoginPage() {
		account.click();
		login_signUp.click();
		return new LoginPage();

	}
}
