package starter.admin.stepdefinition.menu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.menu.GetMenuById;

public class GetMenuByIdSteps {

    @Steps
    GetMenuById getMenuById;

    @Given("i set API endpoint for get menu valid id")
    public void setApiEndpointGetMenuValidId(){
        getMenuById.setApiEndpointGetMenuValidId();
    }

    @When("i send request to get menu valid id")
    public void sendRequestGetMenuValidId(){
        getMenuById.sendRequestGetMenuValidId();
    }

    @And("i receive valid data menu by id")
    public void receiveValidDataMenuByID(){
        getMenuById.receiveValidDataMenuByID();
    }
}
