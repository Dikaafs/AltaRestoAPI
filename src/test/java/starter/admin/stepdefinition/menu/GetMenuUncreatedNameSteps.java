package starter.admin.stepdefinition.menu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.menu.GetMenuUncreatedName;

public class GetMenuUncreatedNameSteps {

    @Steps
    GetMenuUncreatedName getMenuUncreatedName;

    @Given("i set API endpoint for get menu uncreated Name")
    public void setAPIendpointGetMenuUncreated(){
        getMenuUncreatedName.setAPIendpointGetMenuUncreated();
    }

    @When("i send request to get menu uncreated Name")
    public void sendRequestGetMenuUncreated(){
        getMenuUncreatedName.sendRequestGetMenuUncreated();
    }

    @Then("i receive status code 404")
    public void receiveStatusCode404(){
        getMenuUncreatedName.receiveStatusCode404();
    }
}
