package screens.loginandregisteration;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonAction;

public class ProfileScreen {

    private AppiumDriver driver;
    private CommonAction commonAction;
    @FindBy(className = "android.widget.EditText")
    private WebElement nameInputBox;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Next\"]")
    private WebElement nextButton;

    public ProfileScreen(AppiumDriver driver) {
        commonAction = new CommonAction(driver);
        PageFactory.initElements(driver, this);
        this.driver= driver;
    }
    public void enterProfileDetails(String name) {
            nameInputBox.sendKeys(name);
            commonAction.hideKeyboard();
            commonAction.waitForElementToBeVisible(nextButton);
            nextButton.click();

    }
}
