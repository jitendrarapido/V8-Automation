package userjourney;

import org.testng.annotations.Test;
import screens.loginandregisteration.LoginScreen;
import screens.loginandregisteration.VerifyOtpScreen;
import utils.CommonAction;

public class LoginFlowTestCase extends StartingSteps {

    //Test class
    @Test
    public void verifyLoginFlow(){
        LoginScreen loginScreen = new LoginScreen(driver);
        CommonAction commonAction = new CommonAction(driver);
        loginScreen.tapOnLoginFlow();
        loginScreen.enterMobileNumber();
        VerifyOtpScreen verifyOtpScreen = new VerifyOtpScreen(driver);
        verifyOtpScreen.verifyOtpPage();
        verifyOtpScreen.enterOTP(commonAction.connectToDB());
        verifyOtpScreen.lastStepPage();
    }
}
