package com.redbus.qa.pages;

import com.redbus.qa.base.TestBase;
import com.redbus.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;
public class LoginPage extends TestBase{
	
	@FindBy(xpath="//div[@id='container']//span[text()='Sign in with Google'][1]")
	WebElement signInWithGoogle;
	
	@FindBy(xpath= "//i[@class='icon-close']")
	WebElement loginPopUpClose;
	
	@FindBy(xpath= "//iframe[@class='modalIframe']")
	WebElement iFrameP;
	
	@FindBy(xpath= "//iframe[@title='Sign in with Google Button']")
	WebElement iFrameS;

	@FindBy(id = "identifierId")
	WebElement emailField;

	@FindBy(xpath = "//span[text()='Next']")
	WebElement nextButton;

	@FindBy(name="Passwd")
	WebElement password;

	@FindBy(xpath = "//li[@id='user_sign_out']")
	WebElement signOut;

	@FindBy(xpath = "//li[@id='account_dd']")
	WebElement myAccount;

	@FindBy(xpath= "//img[@class='rb_logo']")
	WebElement redBusLogo;

	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateGoogleSignInButton() {

		driver.switchTo().frame(iFrameP);
		driver.switchTo().frame(iFrameS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.EXPLICIT_WAIT));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(signInWithGoogle));

		signInWithGoogle.click();
	}

	public void validateLoginClosure(){
		loginPopUpClose.click();

	}


	public void validateGoogleSignIn() throws InterruptedException {

		validateGoogleSignInButton();
		driver.switchTo().defaultContent();

		Set<String> windowIds = driver.getWindowHandles();

		for(String windowId : windowIds) {

			driver.switchTo().window(windowId);

			if(driver.getCurrentUrl().equals("https://www.redbus.in/")) {

			}else break;

		}


//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.EXPLICIT_WAIT));
//		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated((By)emailField);

		emailField.sendKeys("nagpworkshops@gmail.com");
		//emailField.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		nextButton.click();

		Thread.sleep(5000);
		//WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated((By) password));

		password.sendKeys("Nagpworkshops@12");
		//password.sendKeys(Keys.ENTER);
		nextButton.click();




	}

	public void validateSuccessfulSignIn(String windID) throws InterruptedException {

		validateGoogleSignIn();
		driver.switchTo().window(windID);
		myAccount.click();

	}
	
}
