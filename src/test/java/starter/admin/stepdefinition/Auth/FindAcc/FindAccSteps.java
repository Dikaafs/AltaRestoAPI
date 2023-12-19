package starter.admin.stepdefinition.Auth.FindAcc;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.Auth.FindAccount.FindAcc;

public class FindAccSteps {

    @Steps
    FindAcc findAcc;

    @Given("i set API endpoint for find acc user")
    public void setApiEndpointFindAccUser(){
        findAcc.setApiEndpointFindAccUser();
    }

    @When("i send request to find acc user")
    public void SendRequestFindAccUser(){
        findAcc.SendRequestFindAccUser();
    }

    @And("i receive valid data user acc")
    public void receiveValidDataUserAcc(){
        findAcc.receiveValidDataUserAcc();
    }
}
