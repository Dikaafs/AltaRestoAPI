package starter.user.Stepdefinition.Auth.Login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Auth.Login.LoginUser;

public class LoginUserSteps {

    @Steps
    LoginUser loginUser;

    @Given("i set API endpoint for login user")
    public void setApiEndpointLoginUser(){
        loginUser.setApiEndpointLoginUser();
    }

    @When("i send request to login user with valid email {string} and valid password {string}")
    public void sendRequestLoginUser(String email,String password){
        loginUser.sendRequestLoginUser(email,password);
    }

    @And("i receive access token from login user")
    public void receiveAccessTokenLoginUser(){
        loginUser.receiveAccessTokenLoginUser();
    }
}
