package utils.retry;

import utils.retry.RetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class RetryTestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        if (result.getMethod().getRetryAnalyzer() != null) {
            RetryAnalyzer retryAnalyzer = (RetryAnalyzer) result.getMethod().getRetryAnalyzer();

            if (retryAnalyzer.isRetryAvailable()) {
                result.setStatus(ITestResult.SKIP);
            } else {
                result.setStatus(ITestResult.FAILURE);
            }
            Reporter.setCurrentTestResult(result);
        }
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
    }

    @Override
    public void onFinish(ITestContext context) {
        for (int i = 0; i < context.getAllTestMethods().length; i++) {
            if (context.getAllTestMethods()[i].getCurrentInvocationCount() > 1) {
                removeDupTestReport(context, i);
            }
        }
    }

    private void removeDupTestReport(ITestContext context, int i) {
        if (context.getFailedTests().getResults(context.getAllTestMethods()[i]).size() > 1
                || context.getPassedTests().getResults(context.getAllTestMethods()[i]).size() == 1) {
            context.getFailedTests().removeResult(context.getAllTestMethods()[i]);
        }
        if (context.getSkippedTests().getResults(context.getAllTestMethods()[i]).size() > 1
                || context.getPassedTests().getResults(context.getAllTestMethods()[i]).size() == 1) {
            context.getSkippedTests().removeResult(context.getAllTestMethods()[i]);
        }
    }
}
