package starter.admin.stepdefinition.menu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.menu.GetMenuByName;

public class GetMenuByNameSteps {

    @Steps
    GetMenuByName getMenuByName;

    @Given("i set API endpoint for get menu by name")
    public void setApiEndpointGetMenuByName(){
        getMenuByName.setApiEndpointGetMenuByName();
    }

    @When("i send request to get menu by name")
    public void sendRequestGetMenuByName(){
        getMenuByName.sendRequestGetMenuByName();
    }

    @And("i receive valid data menu by name")
    public void receiveValidDataMenuByName(){
        getMenuByName.receiveValidDataMenuByName();
    }
}
