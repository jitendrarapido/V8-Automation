package userjourney;

import com.rapido.api.data.Customer;
import org.testng.annotations.Test;
import screens.loginandregisteration.LoginScreen;
import testdata.UserData;
import utils.CommonAction;
import java.io.IOException;

public class LoginFlowTestCase extends StartingSteps {

    private UserData userData;
    private Customer customer;

    public LoginFlowTestCase(){
        customer = new Customer();
        userData = new UserData();
    }
    @Test
    public void verifyRegistrationFlowWithNewUser() throws IOException {
        LoginScreen   loginScreen = new LoginScreen(driver);
        CommonAction commonAction = new CommonAction(driver);

     loginScreen.enterMobileNumberAndSubmit(userData.getCustData("alreadyLoggedIn"))
                .enterOTPForNewUser(commonAction.connectToDB())
                .enterProfileDetails(customer.getFirstName());
    }

    /*@Test
    public void verifyRegistrationFlowWithNewUser(){
        LoginScreen loginScreen = new LoginScreen(driver);
        CommonAction commonAction = new CommonAction(driver);

        loginScreen.initiateLoginFlow();
        loginScreen.enterMobileNumberAndSubmit(customer.getMobileNumber())
                .enterOTPForExistingUser(commonAction.connectToDB());

    }*/
}

