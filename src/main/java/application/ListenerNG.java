package application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class ListenerNG implements ITestListener {

    Logger logger = LoggerFactory.getLogger(ListenerNG.class);

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        logger.info(result.getName() + " test started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        logger.info("The test " + result.getName() + " passed in success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        logger.info("The test " + result.getName() + " is failed");
        logger.info(result.getThrowable().fillInStackTrace().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        logger.info("The test " + result.getName() + " is skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        ITestNGMethod[] allTestMethods = context.getAllTestMethods();
        for(int i = 0; i < allTestMethods.length; i++){
            logger.info("Method " + allTestMethods[i].getMethodName() + " is started");
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        ITestNGMethod[] allTestMethods = context.getAllTestMethods();
        for(int i = 0; i < allTestMethods.length; i++){
            logger.info("Method " + allTestMethods[i].getMethodName() + "is finished");
        }
    }
}
