package starter.admin.stepdefinition.menu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.menu.GetMenubyCategory;

public class GetMenubyCategorySteps {

    @Steps
    GetMenubyCategory getMenubyCategory;

    @Given("i set API endpoint for get menu by exist category")
    public void setAPIendpointGetMenuExistCategory(){
        getMenubyCategory.setAPIendpointGetMenuCategory();
    }

    @When("i send request to get menu by exist category")
    public void sendRequestGetMenuExistCategory(){
        getMenubyCategory.sendRequestGetMenuCategory();
    }

    @And("i receive menu by exist category")
    public void receiveMenuByExistCategory(){
        getMenubyCategory.receiveMenuByCategory();
    }
}
