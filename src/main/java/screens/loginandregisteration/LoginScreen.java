package screens.loginandregisteration;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CommonAction;

public class LoginScreen {

    private  AppiumDriver driver;
    private CommonAction commonAction;

    public LoginScreen(AppiumDriver driver) {
        //super();
        PageFactory.initElements(driver, this);
        commonAction = new CommonAction(driver);
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
    public void initiateLoginFlow() {
        commonAction.waitForElementToBeVisible(loginFlow);
        loginFlow.click();
    }

    public VerifyOtpScreen enterMobileNumberAndSubmit(String phoneNo) {

        commonAction.waitForElementToBeClickable(enterMobileNumber);
        enterMobileNumber.click();
        enterMobileNumber.sendKeys(phoneNo);
        commonAction.hideKeyboard();
        commonAction.waitForElementToBeClickable(nextButton);
        nextButton.click();
        return new VerifyOtpScreen(driver);
    }


}
