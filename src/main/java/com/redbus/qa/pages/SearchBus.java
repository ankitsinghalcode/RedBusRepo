package com.redbus.qa.pages;

import com.redbus.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;


public class SearchBus extends TestBase {

    @FindBy(xpath = "//input[@id='src']")
    WebElement busFrom;

    @FindBy(xpath = "//input[@id='dest']")
    WebElement busTo;

    @FindBy(xpath="//div[@id='onwardCal']")
    WebElement dateTab;

    @FindBy(xpath="//*[@id='onwardCal']/div/div[2]/div/div/div[1]/div[2]")
    WebElement monthYearEle;

    @FindBy(xpath="//*[@id='rb-calendar_onward_cal']")
    WebElement datePicker;

    @FindBy(xpath = "//*[@id='search_button']")
    WebElement searchBusButton;

    List<String> monthList = Arrays.asList("Jan","Feb","Mar","Apr","May","Jun","July","Aug","Sept","Oct","Nov","Dec");
//    String expDate ;
//    int expMonth;
//    int expYear;

    String calDate = null;
    int calMonth;
    int calYear;

    boolean dateNotFound;



    public SearchBus() {
        PageFactory.initElements(driver, this);

    }



    public void validateSearchBus(String source, String destination, String expDate, String expMonth) throws InterruptedException {
        busFrom.sendKeys(source);
        busTo.sendKeys(destination);

        dateTab.click();

        dateTab.click();


        dateNotFound = true;


        while(dateNotFound){

                String monthYear= monthYearEle.getText();

                String[] s = monthYear.split(" ");
                String calMonth = s[0];


                List<WebElement> list1 = driver.findElements(By.xpath("//*[@id='Layer_1']"));
            //Thread.sleep(1000);

                WebElement nextButton = list1.get(list1.size()-1);
                WebElement previousButton = list1.get(0);


                ////If current selected month and year are same as expected month and year then go Inside this condition.
                if(monthList.indexOf(calMonth)+1 == expMonth.charAt(0) -'0'){
                    selectDate(expDate);
                    dateNotFound = false;
                }

                //If current selected month and year are less than expected month and year then go Inside this condition
                else if(monthList.indexOf(calMonth)+1 <expMonth.charAt(0) -'0' ){
                    //Click on next button of date picker.
                    nextButton.click();
                }
                //If current selected month and year are greater than expected month and year then go Inside this condition.
                else if(monthList.indexOf(calMonth)+1 >expMonth.charAt(0) -'0'){
                    previousButton.click();
                }
            }

        searchBusButton.click();
    }


    public void selectDate(String date){

        List<WebElement> dates = driver.findElements(By.xpath("//*[contains(@class,'DayTiles')]"));
        for(WebElement temp:dates){
            if(temp.getText().equals(date)){
                temp.click();
                break;
            }
        }
    }




}
