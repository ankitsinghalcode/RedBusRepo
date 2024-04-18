package com.redbus.qa.testcases;

import com.redbus.qa.base.TestBase;
import com.redbus.qa.pages.HomePage;
import com.redbus.qa.pages.SearchBus;
import com.redbus.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchBusTest extends TestBase {

    SearchBus searchBus;
    HomePage homePage;

    String sheetName = "Journey";

    public SearchBusTest(){
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homePage= new HomePage();
        searchBus= new SearchBus();

    }

    @DataProvider
    public Object[][] getSearchBusData(){
        Object data[][]= TestUtil.getTestData(sheetName);
        return data;
    }


    @Test(dataProvider = "getSearchBusData")
    public void validateSearchBusTest(String source, String destination, String date, int month) {
        searchBus.validateSearchBus(source, destination, date, month);
    }

    @AfterMethod
	public void tearDown(){
		driver.quit();
	}



}
