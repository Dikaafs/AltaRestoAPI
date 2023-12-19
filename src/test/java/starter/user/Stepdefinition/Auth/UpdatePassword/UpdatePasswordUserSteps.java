package starter.user.Stepdefinition.Auth.UpdatePassword;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Auth.UpdatePassword.UpdatePasswordUser;

public class UpdatePasswordUserSteps {

    @Steps
    UpdatePasswordUser updatePasswordUser;

    @Given("i set API endpoint for update password user")
    public void setApiEndpointUpdatePasswordUser(){
        updatePasswordUser.setApiEndpointUpdatePasswordUser();
    }

    @When("i send request to update password with valid input")
    public void sendRequestUpdatePasswordUserValidInput(){
        updatePasswordUser.sendRequestUpdatePasswordUserValidInput();
    }

    @And("password user has been changed")
    public void passwordUserChanged(){
        updatePasswordUser.passwordUserChanged();
    }
}
