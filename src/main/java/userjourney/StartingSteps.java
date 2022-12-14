package userjourney;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import utils.ScenarioContext;

public class StartingSteps {

    public static AppiumDriver driver;

    @BeforeMethod
    @Parameters({"Device", "platformVersion", "deviceName"})
    public void setupDriver(@Optional String device, @Optional String platformVersion, @Optional String deviceName)
            throws IOException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("automationName", "Appium");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appPackage", "com.rapido.passenger.staging");
        desiredCapabilities.setCapability("appActivity", "com.rapido.splash.presentation.ui.SplashActivity");
        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("platformVersion", platformVersion);

        desiredCapabilities.setCapability("app", new File("./app/v8-app.apk").getAbsolutePath());
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
    }

    public static void clearCaptainAndCustomerFile(String file) {
        File file1 = new File(file);
        System.out.println("its a file" + file1);
        file1.delete();
    }

    @AfterMethod(alwaysRun = true)
    public void appClose() {
        try {
           // clearCaptainAndCustomerFile(ScenarioContext.getData("captainNumber").toString() + ".txt");
           // System.out.println("Captain number Deleted");
            clearCaptainAndCustomerFile(ScenarioContext.getData("customerNumber").toString() + ".txt");
            System.out.println("Customer number Deleted");
            driver.quit();
        } catch (Exception e) {
            System.out.println("Session Not Found");
        }
    }

}
