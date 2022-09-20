package screens.home;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;

public class HomeScreen {
    private AppiumDriver driver;

    public HomeScreen(AppiumDriver driver) {
        this. driver= driver;
        PageFactory.initElements(driver,this);
    }
}
