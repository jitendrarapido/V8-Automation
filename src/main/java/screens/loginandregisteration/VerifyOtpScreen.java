package screens.loginandregisteration;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonAction;

public class VerifyOtpScreen {

    public AppiumDriver driver;
    private CommonAction commonAction;

    public VerifyOtpScreen(AppiumDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        this.driver = driver;
        commonAction = new CommonAction(driver);
    }

    @FindBy(className = "android.widget.EditText")
    private WebElement otpScreen;

    public ProfileScreen enterOTP(String generatedOtp) {
        commonAction.waitForElementToBeVisible(otpScreen);
        otpScreen.click();
        otpScreen.sendKeys(generatedOtp);
        return new ProfileScreen(driver);
    }


}
