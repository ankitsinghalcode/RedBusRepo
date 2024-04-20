package com.redbus.qa.testcases;

import com.redbus.qa.base.TestBase;
import com.redbus.qa.pages.CancelTicket;
import com.redbus.qa.pages.HomePage;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CancelTicketTest extends TestBase {

    HomePage homePage;
    CancelTicket cancelTicket;

    public CancelTicketTest(){
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homePage= new HomePage();
        cancelTicket= new CancelTicket();
    }

    @Test(enabled = true)
    public void validateCancelTicketTest(){
        boolean flag= cancelTicket.validateCancelTicket();
        Assert.assertTrue(flag);
    }

    @Test(enabled = true)
    public void validateCorrectTicketNoWarningTest(){

        String incorrectTicketNoWarning = cancelTicket.validateCorrectTicketNoWarning();
        Assert.assertEquals(incorrectTicketNoWarning,"Please enter correct ticket number (TIN from your ticket)");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
