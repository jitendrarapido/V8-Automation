package screens.loginandregisteration;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    public void tapOnLoginOption() {
        loginFlow.click();
    }

    public void enterMobileNumber() throws InterruptedException {
        enterMobileNumber.click();
        Thread.sleep(2000);
        enterMobileNumber.sendKeys("9663806628");
        Thread.sleep(5000);
        nextButton.click();
    }
}
