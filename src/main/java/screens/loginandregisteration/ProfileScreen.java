package screens.loginandregisteration;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import screens.home.HomeScreen;
import utils.CommonAction;
import utils.ScenarioContext;

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
    public HomeScreen enterProfileDetails(String name) {
            nameInputBox.sendKeys(name);
            ScenarioContext.putData("userName", name);
            commonAction.hideKeyboard();
            commonAction.waitForElementToBeVisible(nextButton,30);
            nextButton.click();
            return new HomeScreen(driver);
    }
}
