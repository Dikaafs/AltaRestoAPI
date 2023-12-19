package starter.admin.stepdefinition.menu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.menu.CreateNewMenu;

public class CreateNewMenuSteps {

    @Steps
    CreateNewMenu createNewMenu;

    @Given("i set API endpoint for create new menu with valid input")
    public void setApiEndpointForCreateNewMenuValidInput(){
        createNewMenu.setApiEndpointForCreateNewMenuValidInput();
    }

    @When("i send request to create new menu with valid input")
    public void sendRequestCreateNewMenuValidInput(){
        createNewMenu.sendRequestCreateNewMenuValidInput();
    }
    @Then("i receive status code 201")
    public void receiveStatusCode201(){
        createNewMenu.receiveStatusCode201();
    }

    @And("i receive valid data of new menu")
    public void receiveValidDataNewMenu(){
        createNewMenu.receiveValidDataNewMenu();
    }
}
