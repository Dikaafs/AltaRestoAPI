package starter.user.Stepdefinition.menu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Menu.GetAllmenu;

public class GetAllMenuSteps {

    @Steps
    GetAllmenu getAllMenu;

    @Given("i set API endpoint for get all menu with valid endpoint")
    public void setAPIendpointGetAllMenuValidEndpoint(){
        getAllMenu.setAPIendpointGetAllMenuValidEndpoint();
    }

    @When("i send request to get all menu with valid endpoint")
    public void sendRequestGetAllMenuValidEndpoint(){
        getAllMenu.sendRequestGetAllMenuValidEndpoint();
    }

    @And("i receive entire menu")
    public void ReceiveEntireMenu(){
        getAllMenu.ReceiveEntireMenu();
    }
}
