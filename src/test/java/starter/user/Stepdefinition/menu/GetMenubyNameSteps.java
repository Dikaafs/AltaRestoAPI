package starter.user.Stepdefinition.menu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Menu.GetMenuByname;

public class GetMenubyNameSteps {
    @Steps
    GetMenuByname getMenuByname;

    @Given("i set API endpoint for get menu with exist name")
    public void setAPIendpointGetMenuExistName(){
        getMenuByname.setAPIendpointGetMenuExistName();
    }

    @When("i send request to get menu with exist name")
    public void sendRequestGetMenuWithExistName(){
        getMenuByname.sendRequestGetMenuWithExistName();
    }

    @And("i receive valid data for get menu by name")
    public void receiveValidDataGetMenuByName(){
        getMenuByname.receiveValidDataGetMenuByName();
    }
}
