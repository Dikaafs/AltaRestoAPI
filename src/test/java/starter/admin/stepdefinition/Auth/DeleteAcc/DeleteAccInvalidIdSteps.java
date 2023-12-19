package starter.admin.stepdefinition.Auth.DeleteAcc;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.Auth.DeleteAcc.DeleteAccInvalidId;

public class DeleteAccInvalidIdSteps {

    @Steps
    DeleteAccInvalidId deleteAccInvalidId;

    @Given("i set API endpoint for delete account with invalid id")
    public void setApiEndpointDeleteAccInvalidId(){
        deleteAccInvalidId.setApiEndpointDeleteAccInvalidId();
    }

    @When("i send request to delete account with invalid id")
    public void sendRequestDeleteAccInvalidId(){
        deleteAccInvalidId.sendRequestDeleteAccInvalidId();
    }
}
