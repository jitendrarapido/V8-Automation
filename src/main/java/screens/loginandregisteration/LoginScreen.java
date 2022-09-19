package screens.loginandregisteration;

import com.rapido.api.data.Customer;
import com.rapido.api.utils.CustomerPool;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CommonAction;

public class LoginScreen {

    public static AppiumDriver driver;

    public LoginScreen(AppiumDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Launch Login Flow\"]")
    private WebElement loginFlow;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Enter phone number\"]")
    private WebElement phoneNumberText;

    @FindBy(className = "android.widget.EditText")
    private WebElement enterMobileNumber;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Next\"]")
    private WebElement nextButton;

    //Pom class
    public void tapOnLoginFlow() {
        CommonAction commonAction = new CommonAction(driver);
        commonAction.waitForElementToBeVisible(loginFlow);
        loginFlow.click();
    }

    public void enterMobileNumber() {
        Customer customer = new CustomerPool().getValidCustomer();
        String mobile = customer.getMobileNumber();
        CommonAction commonAction = new CommonAction(driver);
        commonAction.waitForElementToBeClickable(enterMobileNumber);
        enterMobileNumber.click();
        enterMobileNumber.sendKeys(mobile);
        commonAction.hideKeyboard();
        commonAction.waitForElementToBeClickable(nextButton);
        nextButton.click();
    }


}
