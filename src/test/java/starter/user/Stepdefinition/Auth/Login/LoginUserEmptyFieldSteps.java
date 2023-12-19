package starter.user.Stepdefinition.Auth.Login;

import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Auth.Login.LoginUserEmptyField;

public class LoginUserEmptyFieldSteps {
    @Steps
    LoginUserEmptyField loginUserEmptyField;

    @When("i send request to login user with emtpy field email {string} and valid password {string}")
    public void sendRequestUserLoginWithEmptyField(String email,String password){
        loginUserEmptyField.sendRequestUserLoginWithEmptyField(email, password);
    }
}
