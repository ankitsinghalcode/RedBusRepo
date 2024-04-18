package com.redbus.qa.pages;

import com.redbus.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class CancelTicket extends TestBase {


    @FindBy(xpath = "//li[@id='account_dd']")
    WebElement account;

    @FindBy(xpath = "//*[@id='cancel_ticket']")
    WebElement cancelTicket;

    @FindBy(xpath = "//*[text()='Select Passengers']")
    WebElement selectPassengerButton;

    @FindBy(xpath = "//*[text()='Please enter ticket number (TIN from your ticket)']")
    WebElement enterTicketNoWarning;

    @FindBy(xpath = "//*[text()='Please enter correct ticket number (TIN from your ticket)']")
    WebElement enterCorrectTicketNoWarning;

    @FindBy(xpath = "//input[@placeholder='Enter Ticket No']")
    WebElement enterTicketNo;


    public CancelTicket() {
        PageFactory.initElements(driver, this);
    }

    public void openCancelPage(){
        account.click();
        cancelTicket.click();

        Set<String> windowIds = driver.getWindowHandles();
        for(String windowId : windowIds) {

            driver.switchTo().window(windowId);

            if(driver.getCurrentUrl().equals("https://www.redbus.in/")) {

            }else break;

        }
    }

    public boolean validateCancelTicket(){
        openCancelPage();
        selectPassengerButton.click();

        return enterTicketNoWarning.isDisplayed();

    }

    public String validateCorrectTicketNoWarning(){

        openCancelPage();
        enterTicketNo.sendKeys("435435434");
        selectPassengerButton.click();

        return enterCorrectTicketNoWarning.getText();

    }



}
