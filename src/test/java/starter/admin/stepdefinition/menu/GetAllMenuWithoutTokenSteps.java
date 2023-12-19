package starter.admin.stepdefinition.menu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import starter.admin.menu.GetAllMenuWithoutToken;

public class GetAllMenuWithoutTokenSteps {

    @Steps
    GetAllMenuWithoutToken getAllMenuWithoutToken;

    @And("i send request to get all menu without login token")
    public void sendRequestGetAllMenuWithoutToken(){
        getAllMenuWithoutToken.sendRequestGetAllMenuWithoutToken();
    }

    @Then("i receive status code 401")
    public void receiveStatusCode401(){
        getAllMenuWithoutToken.receiveStatusCode401();
    }

    @And("i receive unauthorized message {string}")
    public void receiveUnauthorizedMessage(String UnauthorizedMessage){
        getAllMenuWithoutToken.receiveUnauthorizedMessage(UnauthorizedMessage);
    }
}
