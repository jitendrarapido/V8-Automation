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
        //setRetryCount();
        if (count < maxCount) {
           /* ReporterUtil
                    .log("Running retry logic for '" + result.getName() + "' on class " + this.getClass().getName());
           */ try {
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

   /* private void setRetryCount() {
        if (RapidoProperties.RETRY_COUNT != null) {
            maxCount = Integer.parseInt(RapidoProperties.RETRY_COUNT);
        } else {
            maxCount = 0;
        }
    }*/

    public boolean isRetryAvailable() {
        return (count < maxCount);
    }
}
