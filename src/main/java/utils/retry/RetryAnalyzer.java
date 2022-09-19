package utils.retry;

import java.util.concurrent.TimeUnit;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private int maxCount = 1; //set your count to re-run test

    public RetryAnalyzer() {
    }

    @Override
    public boolean retry(ITestResult result) {
        if (count < maxCount) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            count++;
            return true;
        }
        return false;
    }

    public boolean isRetryAvailable() {
        return (count < maxCount);
    }
}
