package testcomponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.ExtentReportsNG;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {

    ExtentReports extent = ExtentReportsNG.getReportObject();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        String filePath = null;
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try{
            filePath = getScreenShot(result.getMethod().getMethodName(), driver);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
        test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }



}
