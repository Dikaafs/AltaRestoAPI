package starter.admin.stepdefinition.menu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.menu.GetMenuInvalidId;

public class GetMenuInvalidIdSteps {

    @Steps
    GetMenuInvalidId getMenuInvalidId;

    @Given("i set API endpoint for get menu with invalid id")
    public void setAPIendpointGetMenuInvalidId(){
        getMenuInvalidId.setAPIendpointGetMenuInvalidId();
    }

    @When("i send request to get menu invalid id")
    public void sendRequestGetMenuInvalidId(){
        getMenuInvalidId.sendRequestGetMenuInvalidId();
    }

    @Then("i receive status code 400")
    public void ReceiveStatusCode400(){
        getMenuInvalidId.ReceiveStatusCode400();
    }
}
