package starter.user.Stepdefinition.Auth.Login;

import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Auth.Login.LoginUserUnregistered;

public class LoginUserUnregisteredSteps {
    @Steps
    LoginUserUnregistered loginUserUnregistered;

    @When("i send request to login user with invalid email{string} and invalid password{string}")
    public void SendRequestUserUnregistered(String email,String password){
        loginUserUnregistered.SendRequestUserUnregistered(email,password);
    }
}
