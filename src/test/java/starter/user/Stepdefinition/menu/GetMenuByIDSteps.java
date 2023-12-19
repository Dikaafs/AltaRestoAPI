package starter.user.Stepdefinition.menu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Menu.GetMenuByID;

public class GetMenuByIDSteps {

    @Steps
    GetMenuByID getMenuByID;

    @Given("i set API endpoint for get menu with valid id")
    public void setAPIendpontGetMenuValidID(){
        getMenuByID.setAPIendpontGetMenuValidID();
    }

    @When("i send request to get menu with valid id")
    public void sendRequestGetMenuValidID(){
        getMenuByID.sendRequestGetMenuValidID();
    }

    @And("i receive data menu by valid id")
    public void receiveDataMenuByValidID(){
        getMenuByID.receiveDataMenuByValidID();
    }
}
