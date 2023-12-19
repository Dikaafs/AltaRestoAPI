package starter.admin.stepdefinition.Auth.UpdatePassword;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.Auth.UpdatePassword.UpdatePassword;

public class UpdatePasswordSteps {

    @Steps
    UpdatePassword updatePassword;

    @Given("i set API endpoint for update password")
    public void setApiEndpointUpdatePassword(){
        updatePassword.setApiEndpointUpdatePassword();
    }

    @When("i send request to update password with valid id")
    public void sendRequestUpdatePassword(){
        updatePassword.sendRequestUpdatePassword();
    }

    @Then("i receive status code 200")
    public void ReceiveStatusCode200(){
        updatePassword.ReceiveStatusCode200();
    }

    @And("password has been changed")
    public void PasswordChanged(){
        updatePassword.PasswordChanged();
    }
}
