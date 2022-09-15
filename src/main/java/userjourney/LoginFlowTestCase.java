package userjourney;

import org.testng.annotations.Test;
import screens.loginandregisteration.LoginScreen;

public class LoginFlowTestCase extends StartingSteps {

    //Test class
    @Test
    public void verifyLoginFlow() throws InterruptedException {
        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.tapOnLoginOption();
        loginScreen.enterMobileNumber();

    }

}
