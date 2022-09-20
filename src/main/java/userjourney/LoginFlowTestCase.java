package userjourney;

import com.rapido.api.data.Customer;
import com.rapido.api.utils.CustomerPool;
import org.testng.annotations.Test;
import screens.loginandregisteration.LoginScreen;
import utils.CommonAction;

public class LoginFlowTestCase extends StartingSteps {

    private LoginScreen loginScreen ;
    private CommonAction commonAction;

    public LoginFlowTestCase() {
        loginScreen = new LoginScreen(driver);
        commonAction = new CommonAction(driver);
    }
    @Test
    public void verifyRegistrationFlowWithNewUser(){
        Customer customer = new CustomerPool().getValidCustomer();

        loginScreen.initiateLoginFlow();
        loginScreen.enterMobileNumberAndSubmit(customer.getMobileNumber())
                .enterOTPForNewUser(commonAction.connectToDB())
                .enterProfileDetails(customer.getFirstName());

    }
}
