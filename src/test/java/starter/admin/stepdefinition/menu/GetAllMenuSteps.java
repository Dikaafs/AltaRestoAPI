package starter.admin.stepdefinition.menu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.menu.GetAllMenu;

public class GetAllMenuSteps {

    @Steps
    GetAllMenu getAllMenu;

    @Given("i set API endpoint for get all menu")
    public void setAPIendpointGetAllMenu(){
        getAllMenu.setAPIendpointGetAllMenu();
    }

    @When("i send request to get all menu")
    public void sendRequestGetAllMenu(){
        getAllMenu.sendRequestGetAllMenu();
    }

    @And("i receive valid data all menu")
    public void receiveValidDataAllMenu(){
        getAllMenu.receiveValidDataAllMenu();
    }
}
