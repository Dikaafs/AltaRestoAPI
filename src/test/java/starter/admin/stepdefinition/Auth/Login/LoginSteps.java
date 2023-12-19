package starter.admin.stepdefinition.Auth.Login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.Auth.Login.Login;

public class LoginSteps {

    @Steps
    Login login;

    @Given("i set API endpoint for login")
    public void SetApiEndpointForLogin(){
        login.SetApiEndpointForLogin();
    }

    @When("i send request to login with valid email{string} and valid password{string}")
    public void SendLoginRequest(String email, String password){
        login.SendLoginRequest(email,password);
    }

    @And("i receive access token from login")
    public void ReceiveAccessToken(){
        login.ReceiveAccessToken();
    }
}
