package starter.user.Stepdefinition.menu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Menu.GetMenuByCategory;

public class GetMenuByCategorySteps {
    @Steps
    GetMenuByCategory getMenuByCategory;

    @Given("i set API endpoint for get menu with exist category")
    public void setAPIendpointGetMenuExistCategory(){
        getMenuByCategory.setAPIendpointGetMenuExistCategory();
    }

    @When("i send request to get menu with exist category")
    public void sendRequestGetMenuExistCategory(){
        getMenuByCategory.sendRequestGetMenuExistCategory();
    }

    @And("i receive menu by category")
    public void ReceiveMenuByCategory(){
        getMenuByCategory.ReceiveMenuByCategory();
    }
}
