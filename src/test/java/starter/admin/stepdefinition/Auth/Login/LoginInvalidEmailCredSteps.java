package starter.admin.stepdefinition.Auth.Login;

import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.Auth.Login.LoginInvalidEmailCred;

public class LoginInvalidEmailCredSteps {

    @Steps
    LoginInvalidEmailCred loginInvalidEmailCred;

    @When("i send request to login with invalid email credentials{string} and invalid password{string}")
    public void SendRequestLoginInvalidEmailCredentials(String email,String password){
        loginInvalidEmailCred.SendRequestLoginInvalidEmailCredentials(email, password);
    }
}
