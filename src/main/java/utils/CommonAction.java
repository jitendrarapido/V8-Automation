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
import testdata.UserData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;


public class CommonAction {

    private WebDriverWait wait;
    protected AppiumDriver driver;


    public CommonAction(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);
    }

    public void loginFlow(String consumer, String customerType) throws IOException {
        String custCsvPath = CommonAction.getPropertyValue("customer.data.file");
        String customerNumber = CommonAction.getUniqueMobileNumber(UserData.getUserDataList(customerType, custCsvPath), "customerNumber");
    }


    public static String getPropertyValue(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream inStream = new FileInputStream("testdata.properties");
        properties.load(inStream);
        return properties.getProperty(key);
    }

    public static String getUniqueMobileNumber(List<String> list, String userType) {
        for (String mobileNumber : list) {
            if (list.indexOf(mobileNumber) == 0)
                continue;
            if (createFile(mobileNumber)) {
                // ScenarioContext.putData(" ", userType, mobileNumber);
                return mobileNumber;
            } else {
                continue;
            }
        }
        return " ";
    }

    public static boolean createFile(String fileName) {
        try {
            File myObj = new File(fileName + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                return true;
            } else {
                System.out.println("File already created.");
                return false;
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return false;
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
        WebDriverWait wait = new WebDriverWait(driver, timeout);
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
