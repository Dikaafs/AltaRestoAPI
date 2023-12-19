package starter.admin.stepdefinition.Auth.UpdatePassword;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.Auth.UpdatePassword.UpdatePasswordInvalidId;

public class UpdatePasswordInvalidIdSteps {

    @Steps
    UpdatePasswordInvalidId updatePasswordInvalidId;

    @Given("i set API endpoint for update password with invalid id")
    public void SetApiEndpointUpdatePasswordInvalidId(){
        updatePasswordInvalidId.SetApiEndpointUpdatePasswordInvalidId();
    }

    @When("i send request to update password with invalid id")
    public void SendRequestUpdatePasswordInvalidId(){
        updatePasswordInvalidId.SendRequestUpdatePasswordInvalidId();
    }

    @And("i receive error message {string}")
    public void ReceiveErrorMessage(String message){
        updatePasswordInvalidId.ReceiveErrorMessage(message);
    }
}
