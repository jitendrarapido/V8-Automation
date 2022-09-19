package screens.loginandregisteration;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonAction;

public class VerifyOtpScreen {

    public static AppiumDriver driver;

    public VerifyOtpScreen(AppiumDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(className = "android.widget.EditText")
    private WebElement otpScreen;


    @FindBy(className = "android.widget.EditText")
    private WebElement name;


    @FindBy(xpath = "//android.widget.TextView[@text=\"Next\"]")
    private WebElement nextButton;

    public void verifyOtpPage() {
        CommonAction commonAction = new CommonAction(driver);
        commonAction.waitForElementToBeVisible(otpScreen);
        otpScreen.click();
    }

    public void enterOTP(String generatedOtp) {
        CommonAction commonAction = new CommonAction(driver);
        commonAction.waitForElementToBeVisible(otpScreen);
        otpScreen.sendKeys(generatedOtp);
    }

    public void lastStepPage() {
        CommonAction commonAction = new CommonAction(driver);
        if (commonAction.waitForElementToBeVisible(name).isDisplayed()) {
            name.click();
            name.sendKeys("Testing");
            commonAction.hideKeyboard();
            commonAction.waitForElementToBeVisible(nextButton);
            nextButton.click();
        } else {
            System.out.println("Last step Page not found");
        }
    }
}
