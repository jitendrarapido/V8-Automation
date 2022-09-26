package utils;

import com.rapido.api.data.Customer;
import com.rapido.api.db.DbHelper;
import com.rapido.api.utils.CustomerPool;
import com.rapido.api.utils.MongoDbUtils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class CommonAction {

    private WebDriverWait wait;
    protected AppiumDriver driver;

    public CommonAction(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);
    }

    public static String getPropertyValue(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream inStream = new FileInputStream("testdata.properties");
        properties.load(inStream);
        return properties.getProperty(key);
    }

    public String connectToDB() {
        Customer customer = new CustomerPool().getValidCustomer();
        MongoDbUtils mongoDbUtils = new MongoDbUtils();
        mongoDbUtils.connect();
        String otp = DbHelper.getOtp(customer.getMobileNumber());
        return otp;
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementToBeVisible(WebElement element, int timeout) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void hideKeyboard() {
        try {
            driver.hideKeyboard();
        } catch (WebDriverException e) {
        }
    }

    public void waitForSomeTime(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {

        }
    }

    public void waitForTextToBePresentInElement(WebElement element, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

}
