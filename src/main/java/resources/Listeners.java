package resources;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import practise.Base;

import java.io.IOException;

public class Listeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        //screenshot
        String s = result.getName();
        try {
            Base.getScreenshot(s);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext result) {

    }

    @Override
    public void onFinish(ITestContext result) {

    }
}
