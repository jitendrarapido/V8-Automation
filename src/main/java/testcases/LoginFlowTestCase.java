package testcases;

import org.testng.annotations.Test;
import screens.basepage.BasePage;
import screens.loginandregisteration.LoginWithMobilePage;
import steps.StartingSteps;

public class LoginFlowTestCase extends StartingSteps {

    //Test class
    @Test
    public void verifyLoginFlow() {
        LoginWithMobilePage loginWithMobilePage = new LoginWithMobilePage();
        loginWithMobilePage.tapOnLoginOption();

    }

}
