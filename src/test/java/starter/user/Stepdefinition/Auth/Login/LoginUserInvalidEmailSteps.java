package starter.user.Stepdefinition.Auth.Login;

import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.Auth.Login.LoginInvalidEmailCred;
import starter.user.Auth.Login.LoginUserInvalidEmail;

public class LoginUserInvalidEmailSteps {
    @Steps
    LoginUserInvalidEmail loginUserInvalidEmail;

    @When("i send request to login user with invalid email credentials{string} and invalid password{string}")
    public void SendRequestLoginUserInvalidEmail(String email,String password){
        loginUserInvalidEmail.SendRequestLoginUserInvalidEmail(email, password);
    }
}
