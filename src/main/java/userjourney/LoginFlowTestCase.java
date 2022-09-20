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

    //Test class
    @Test
    public void verifyLoginFlow(){
        Customer customer = new CustomerPool().getValidCustomer();

        loginScreen.initiateLoginFlow();
        loginScreen.enterMobileNumberAndSubmit(customer.getMobileNumber())
                .enterOTP(commonAction.connectToDB())
                .enterProfileDetails(customer.getFirstName());

    }
}
