package starter.admin.stepdefinition.Auth.Login;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.Auth.Login.LoginEmptyField;

public class LoginEmptyFieldSteps {
    @Steps
    LoginEmptyField loginEmptyField;

    @When("i send request to login with emtpy field email {string} and valid password {string}")
    public void sendRequestLoginWithEmptyField(String email,String password){
        loginEmptyField.sendRequestLoginWithEmptyField(email, password);
    }

    @Then("i receive status code 500")
    public void receiveStatusCode500(){
        loginEmptyField.receiveStatusCode500();
    }
}
