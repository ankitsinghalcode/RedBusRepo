package com.redbus.qa.util;



import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class Listeners extends TestUtil implements ITestListener {

   // ExtentReports extentLogger = new ExtentReports();

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
//        try {
//          //  takeScreenshotAtEndOfTest();
//        }
//
//        catch (IOException e) {
//            throw new RuntimeException(e);
//        }

    }

    @Override
    public void onTestFailure(ITestResult result) {

        LocalDateTime localDateTime;
    localDateTime = LocalDateTime.now();
    File appScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String destination = System.getProperty("user.dir") + "/screenshots/" +localDateTime+ ".jpg";
        try {
            FileUtils.copyFile(appScreenshot, new File(destination));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ExtentTest extentLog= new ExtentTest(result.getTestName(), result.getName());
        String abc= extentLog.addScreenCapture(destination);
        System.out.println(abc+ " My error message");


    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
