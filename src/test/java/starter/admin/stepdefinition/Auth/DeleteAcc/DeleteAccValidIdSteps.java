package starter.admin.stepdefinition.Auth.DeleteAcc;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.Auth.DeleteAcc.DeleteAccValidId;

public class DeleteAccValidIdSteps {

    @Steps
    DeleteAccValidId deleteAccValidId;

    @Given("i set API endpoint for delete account with valid id")
    public void setApiEndpointDeleteAccValidId(){
        deleteAccValidId.setApiEndpointDeleteAccValidId();
    }

    @When("i send request to delete account with valid id")
    public void SendRequestDeleteAccValidId(){
        deleteAccValidId.SendRequestDeleteAccValidId();
    }

    @And("i receive message {string}")
    public void receiveMessage(String message){
        deleteAccValidId.receiveMessage(message);
    }
}
