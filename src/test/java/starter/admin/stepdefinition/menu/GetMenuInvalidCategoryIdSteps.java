package starter.admin.stepdefinition.menu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.menu.GetMenuInvalidCategoryId;

public class GetMenuInvalidCategoryIdSteps {

    @Steps
    GetMenuInvalidCategoryId getMenuInvalidCategoryId;

    @Given("i set API endpoint for get menu with invalid category id")
    public void setAPIendpointGetMenuInvalidCategoryId(){
        getMenuInvalidCategoryId.setAPIendpointGetMenuInvalidCategoryId();
    }

    @When("i send request to get menu with invalid category id")
    public void sendRequestGetMenuWithInvalidId(){
        getMenuInvalidCategoryId.sendRequestGetMenuWithInvalidId();
    }

    @And("i receive {string} message")
    public void receiveResponseMessage(String message){
        getMenuInvalidCategoryId.receiveResponseMessage(message);
    }
}
