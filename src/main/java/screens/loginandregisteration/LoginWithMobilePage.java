package screens.loginandregisteration;

import org.openqa.selenium.support.PageFactory;
import steps.StartingSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginWithMobilePage extends StartingSteps {

    public LoginWithMobilePage(){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Launch Login Flow\"]")
    private WebElement loginFlow;

    //Pom class
    public void tapOnLoginOption(){
        loginFlow.click();
        driver.navigate().back();
    }
}
